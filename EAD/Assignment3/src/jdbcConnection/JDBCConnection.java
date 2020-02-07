package jdbcConnection;
import java.sql.*; // load the driver
public class JDBCConnection {

    public static Connection initializeDatabase() throws SQLException,ClassNotFoundException {
        String url="jdbc:mysql://localhost:3306/student"; // database name
        String userName="root";
        String pass = "kunal";
        String query = "select * from studentDetails";
        Class.forName("com.mysql.cj.jdbc.Driver"); // register the driver com.mysql.jdbc.Driver <----depricated
        Connection connection = DriverManager.getConnection(url,userName,pass);
        return connection;
    }
    /*
    public static void main(String argv[]) throws ClassNotFoundException, SQLException{
        String url="jdbc:mysql://localhost:3306/student"; // database name
        String userName="root";
        String pass = "kunal";
        String query = "select * from studentDetails";
        Class.forName("com.mysql.cj.jdbc.Driver"); // register the driver com.mysql.jdbc.Driver <----depricated
        Connection connection = DriverManager.getConnection(url,userName,pass);
        Statement statement = connection.createStatement();
        ResultSet resultList = statement.executeQuery(query);
        
        while(resultList.next()){
            String firstName = resultList.getString("firstName");
            System.out.println(firstName);
                
        }
        statement.close();
        connection.close();
        
    }*/
}
