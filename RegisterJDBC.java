import com.mysql.cj.jdbc.Driver;
import java.sql.*;
public class RegisterJDBC {
    public static void main(String[] args) {
        try {
            // register driver
            // Driver dr = new Driver();
            // DriverManager.registerDriver(dr);
            System.out.println("Driver registered Successfully");

            // establish a connection
            // JDBC URL SYNTAX  :: <mainprotocol>:<subprotocol>:<subname>
            String url="jdbc:mysql://localhost:3306/students";
            String username="root";
            String password="1492";
//             we are creating a object of class which implements Connection Interface and that class object is collected by the connection interface

            Connection connection= DriverManager.getConnection(url,username,password);
            System.out.println("Connection object is created : "+ connection);
            System.out.println("**********************");
            System.out.println(" implementation class name of connection is :: "+connection.getClass().getName());


            // create a statement Object
            Statement statement = connection.createStatement();

            // execute query
            String sqlQuery = "select sid,sname,sage,saddr from studentdata";
            ResultSet resultSet=statement.executeQuery(sqlQuery);

            // process the result
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+ " "+ resultSet.getString(2) + " "+resultSet.getInt(3) + " "+ resultSet.getString(4));
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println(" an error occurred "+e.getMessage());
        }
    }
}
