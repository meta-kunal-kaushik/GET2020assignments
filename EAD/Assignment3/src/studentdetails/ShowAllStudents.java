package studentdetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbcConnection.JDBCConnection;
/**
 * This class simply show all the students present in the database
 * @author Kunal
 *
 */
public class ShowAllStudents extends HttpServlet {
/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
 *      response)
 * 1. this function takes the request coming from servlet showAllStudent from web.xml
 * 2. it can filter students by their class
 * 3. it can update the student details
 * 4. it can display list of all students
 */
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        String query = "select * from studentDetails";
        String filter = req.getParameter("filter"); // stores the class i.e, 1st , 2nd ,11th ,etc coming from URL
        if (filter != null) { // if the user applies any filter by class to the table having all students, then
            query = "select * from studentDetails where class = " + filter; // change query according to the class selected in filter 
        }
        Statement stmt = null;
        // String "output" will we displayed on the web page
        String output = "<script>function setHref(){var value = document.getElementById('selected').value;document.getElementById('aTag').href='/EadAssignment3/ShowAllStudents?filter='+value; "
                + "}</script><table border=\"1px\"><tr><th>Firstname</th><th>Lastname</th><th>email</th><th>Class</th><th>Age</th><th>FatherName</th></tr>";
        PrintWriter out = res.getWriter();
        String id = req.getParameter("studentId"); // coming from the URL

        if (id != null) { // this "if" will run if the user wants to update student details i.e, if the studentId is passed to the 
                          // URL then this "if" will run
            Connection connection;
            try {
                connection = JDBCConnection.initializeDatabase();
                stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    if (rs.getInt("studentId") == Integer.parseInt(id)) { // finding the student from database by matching studentId
                        out.println("<h1 align='center'>Update Student</h1>"
                                + "<fieldset>"
                                + "<legend>Update Details</legend>"
                                + " <form action ='/EadAssignment3/ShowAllStudents?studentId="
                                + id
                                + "' method ='Post'>"
                                + "<tr>"
                                + "<th>First Name</th>"
                                + "<td><input id='name' type='text' name='firstName' placeholder='Enter your First Name' value="
                                + rs.getString("firstName")
                                + " required> </td></br>"
                                + "</tr>"
                                + "<tr>"
                                + "<th>Last Name</th>"
                                + "<td><input id='name' type='text' name='lastName' placeholder='Enter your Last Name' value="
                                + rs.getString("lastName")
                                + " required> </td></br>"
                                + "</tr>"
                                + "<tr>"
                                + "<th>Email</th>"
                                + "<td><input id='name' type='email' name='email' placeholder='Enter your Email' value="
                                + rs.getString("email")
                                + " required> </td></br>"
                                + "</tr>"
                                + "<tr>"
                                + "<th>class</th>"
                                + "<td><input id='name' type='text' name='className' placeholder='Enter your class from (1 to 12)' value="
                                + rs.getString("class")
                                + " required> </td></br>"
                                + "</tr>"
                                + "<tr>"
                                + "<th>age</th>"
                                + "<td><input id='name' type='integer' name='age' placeholder='Enter your age' value="
                                + rs.getString("age")
                                + " required> </td></br>"
                                + "</tr>"
                                + "<tr>"
                                + "<th>fatherName</th>"
                                + "<td><input id='name' type='text' name='fatherName' placeholder='Enter your fatherName' value="
                                + rs.getString("fatherName")
                                + " required> </td></br>"
                                + "</tr>"
                                + "<tr><th><button type='submit'>Update</button></th></tr>"
                                + " </table>" + "</form></fieldset>");
                    }
                }
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else { // this will run to display all the students present in the database

            try {
                Connection connection = JDBCConnection.initializeDatabase();
                stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    System.out.println();
                    int studentId = rs.getInt("studentId");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String email = rs.getString("email");
                    int className = Integer.parseInt(rs.getString("class"));
                    int age = Integer.parseInt(rs.getString("age"));
                    String fatherName = rs.getString("fatherName");
                    output += "<tr>" + "<td>" + firstName + "</td>" + "<td>"
                            + lastName + "</td>" + "<td>" + email + "</td>"
                            + "<td>" + className + "</td>" + "<td>" + age
                            + "</td>" + "<td>" + fatherName + "</td>"
                            + "<td><a href="
                            + "/EadAssignment3/ShowAllStudents?studentId="
                            + studentId
                            + "><button>update details</button></a></td>"
                            + "</tr>";

                }
                output += "</table><br>"
                        + "<select name='class' id='selected' onChange='setHref()'>"
                        + "<option value=1>1st</option>"
                        + "<option value=2>2nd</option>"
                        + "<option value=3>3rd</option>"
                        + "<option value=4>4th</option>"
                        + "<option value=5>5th</option>"
                        + "<option value=6>6th</option>"
                        + "<option value=7>7th</option>"
                        + "<option value=8>8th</option>"
                        + "<option value=9>9th</option>"
                        + "<option value=10>10th</option>"
                        + "<option value=11>11th</option>"
                        + "<option value=12>12th</option>"
                        + "</select><a id='aTag' href='/EadAssignment3/ShowAllStudents?filter=1'><button>ok</button></a>";
                out.println(output); // display "output" on the web page 
            } catch (Exception e) {

            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     *  this method will be called to update the user details
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        if (req.getParameter("studentId") != null) {
            try {
                PrintWriter out = res.getWriter();
                // fetching data from request body
                String firstName = req.getParameter("firstName");
                String lastName = req.getParameter("lastName");
                String email = req.getParameter("email");
                int className = Integer.parseInt(req.getParameter("className"));
                int age = Integer.parseInt(req.getParameter("age"));
                String fatherName = req.getParameter("fatherName");
                Connection connection = JDBCConnection.initializeDatabase();
                // query to update student details
                String query = "UPDATE studentDetails SET firstName=?,lastName=?,email=?,class=?,age=?,fatherName=?"
                        + "where studentId = " + req.getParameter("studentId");
                PreparedStatement statement = connection
                        .prepareStatement(query);// prepared statement
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, email);
                statement.setInt(4, className);
                statement.setInt(5, age);
                statement.setString(6, fatherName);

                // execute the prepared statement
                statement.execute();

                out.println("<html><body>Student details updated successfully</h1></body></html>");
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
