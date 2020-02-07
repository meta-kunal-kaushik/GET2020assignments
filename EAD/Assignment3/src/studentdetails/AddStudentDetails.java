package studentdetails;
import java.sql.*; // load the driver
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcConnection.JDBCConnection;
/**
 * This class add new students to the database 
 * @author Kunal
 *
 */
public class AddStudentDetails extends HttpServlet {
/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
 *      response)
 *      this function adds the new user to the database
 */
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        try {

            Connection connection = JDBCConnection.initializeDatabase();
            String firstName = req.getParameter("firstname");
            String lastName = req.getParameter("lastname");
            String fatherName = req.getParameter("fathername");
            String email = req.getParameter("email");
            int className = Integer.parseInt(req.getParameter("class"));
            int age = Integer.parseInt(req.getParameter("age"));
            PrintWriter out = res.getWriter();
            out.println("<h1 style='color:green;'> student added successfully </h1>");

            String query = "INSERT INTO studentDetails (studentId,firstName,lastName,email,class,age,fatherName) VALUES (studentId,?,?,?,?,?,?)";
            // create the mysql insert preparedstatement
            PreparedStatement statement = connection.prepareStatement(query);// prepared statement
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setInt(4, className);
            statement.setInt(5, age);
            statement.setString(6, fatherName);

            // execute the preparedstatement
            statement.execute();

            statement.close();
            connection.close();
            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.forward(req, res);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
