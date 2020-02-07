package studentdetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcConnection.JDBCConnection;

/**
 * Servlet implementation class SearchStudent
 * this class is used to search a student from the database if the user is there
 */
@WebServlet("/SearchStudent") // this class will be called with this Servlet name
public class SearchStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     *      this function is made to search a specific student in the database
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // parameters coming from URL
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        // search query
        String query = "Select * from studentDetails where firstName =\""
                + firstName + "\" and " + "lastName=\"" + lastName + "\"";
        Statement stmt = null;
        try {
            Connection connection;
            PrintWriter out = res.getWriter();
            connection = JDBCConnection.initializeDatabase();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
            out.println("<table border=\"1px\"><tr><th>Firstname</th><th>Lastname</th><th>email</th><th>Class</th><th>Age</th><th>FatherName</th></tr>"
                    + "<tr>"
                    + "<td>"
                    + firstName
                    + "</td>"
                    + "<td>"
                    + lastName
                    + "</td>"
                    + "<td>"
                    + rs.getString("email")
                    + "</td>"
                    + "<td>"
                    + rs.getInt("class")
                    + "</td>"
                    + "<td>"
                    + rs.getInt("age")
                    + "</td>"
                    + "<td>"
                    + rs.getString("fatherName")
                    + "</td>"
                    + "</tr>"
                    + "</table>");
            }
            else{
                res.getWriter().println("<html><body><center><h1>User Not found</h1></center></body></html>");
            }
        } catch (Exception e) {

        }
        
    }

}
