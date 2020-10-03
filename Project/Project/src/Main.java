import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		String first_name = request.getParameter("Fname");
		String last_name = request.getParameter("Lname");
		request.getRequestDispatcher("Main.html").include(request, response);
		
		//Please Note: new JDBC version requires the url to be written as below, with Timezone init. If you are using an older version of JDBC, please follow the regular url format.
		//No database name has been specified in following statement. The queries ("USE -dbname-")fulfill the requirement of specifying in the url. 
		String url = "jdbc:mysql://localhost/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		String uname = "root"; //Username might be different from yours
		String pw = "123"; //pw enabled. Please update before use.
		
		try {
	      Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
	      Connection con = DriverManager.getConnection(url, uname, pw);
	      //Uncomment and use below connection statement for older JDBC versions. Update username and password.
	      //Connection con = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password="); 
	      
	      Statement stmt = con.createStatement(); 
	     
	      stmt.execute("CREATE DATABASE IF NOT EXISTS mydatabase"); //Check for a db named mydatabase. If existing, will not create new one.
	      stmt.execute("USE mydatabase"); 
	      stmt.execute("CREATE TABLE IF NOT EXISTS simple(firstname char(30), lastname char(30))"); //Creating new table with two columns if it doesn't exists in the db.
	     
	      String s = "insert into simple values(\"" + first_name + "\", \"" + last_name + "\")"; //Inserting values entered by client into the html page
	      if(first_name != null && last_name!=null) //checking for null inputs by client
	    	  stmt.execute(s);
	      
	      //Display names in the db. 
	      ResultSet rs = stmt.executeQuery("Select * from simple"); 
	     
	      out.println("<font color = blue>");
	      
	      //Getting results from db and printing into the html document
	      while (rs.next()) {
	    	  
	    	  out.println("<p>" + rs.getString(1)+ " " + rs.getString(2) + "</p>");
	    	  out.println("</br>");
	      }  
	      out.println("</font>");

	    } 
	    catch (Exception ex) 
	    {
	    		System.out.println(ex);
	    		System.exit(0);
	    }
	    		System.out.println("Program terminated with no error.");
	  }
}
