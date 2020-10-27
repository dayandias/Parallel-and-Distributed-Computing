#include <stdio.h>
#include <mpi.h>
#include <stdlib.h>
int main()
{
  int comm_sz, my_rank,i,n,sum=0;
  int *receive_vector;
  MPI_Init(NULL, NULL);
  MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);
  MPI_Comm_size(MPI_COMM_WORLD, &comm_sz);
  if(my_rank == 0)
  {
    n = rand() % (99 + 1 - 10) + 10; //Random number between 10 and 99 inclusive
  }
  MPI_Bcast(&n, 1, MPI_INT, 0, MPI_COMM_WORLD); //Broadcasting the n for all the processes
  receive_vector = malloc(n * sizeof(int)); //All processes creates recieve_vector with the size of n
  if(my_rank == 0)
  {
    for(i = 0; i < n; i++) //Process 0 assigns random numbers to the recieve_vector
    {
      receive_vector[i] = rand() % (99 + 1 - 0) + 0; //Random number between 0 and 99 inclusive
    }
  }
  MPI_Bcast(receive_vector, n, MPI_INT, 0, MPI_COMM_WORLD); //Broadcasting the recieve_vector of process 0 to all other processes
  for(i = 0; i < n; i++) //Calculating the sum individually by all other processes
  {
    sum=sum+receive_vector[i];
  }
  printf("In process %d the sum is: %d\n", my_rank, sum);
  MPI_Finalize();
  return 0;
}
