#include <stdio.h>
#include <stdlib.h>

void func (float (*f)(float*, int), float* a, int length);
float sum(float* a, int length);
float product(float* a, int length);
float average(float* a, int length);

void func ( float (*f)(float*, int), float* a, int length){
    float g;
    g = f(a, length);
    printf("The result is: %.2f",g);
}

float sum(float* a, int length){
    float b;
    int i;
    b=0;

    for(i=0; i<length; i++){
        b = b + *(a+i);
    }
    return b;
}

float product(float* a, int length){
    float b;
    int i;
    b=1;

    if(length==0){
        return 0;
    }
    for(i=0; i<length; i++){
        b = b * *(a+i);
    }
    return b;
}

float average(float* a, int length){
    float b, c;
    int i;
    b=0;

    if(length==0){
        return 0;
    }
    for(i=0; i<length; i++){
        b = b + *(a+i);
    }

    c = b/length;

    return c;
}


int main()
{
    float* a;
    int n, optionChosen, i;
    float finalOutput;

    printf("How many numbers? ");
    scanf("%d", &n);

    a = (int*)malloc(n*sizeof(float));

    if(a==NULL){
        printf("Memory not available");
        exit(1);
    }

    printf("Enter %d numbers: \n", n);
    for(i=0; i<n; i++){
        scanf("%f", a+i);
    }

    printf("Enter 1, 2 or 3 to calculate the sum, product or average of the numbers respectively: ");
    scanf("%d", &optionChosen);

    if(optionChosen==1){

        func(sum, a, n);
    }
    else if(optionChosen==2){
        func(product, a, n);
    }
    else if(optionChosen==3){
        func(average, a, n);
    }
    else{
        printf("Only enter 1, 2 or 3");
        exit(1);
    }

    return 0;
}
