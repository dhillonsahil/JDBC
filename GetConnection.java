import java.sql.*;

public class GetConnection {
    public static void main(String[] args) {

    }
    public static Connection connection() throws  SQLException{
        String url="jdbc:mysql://localhost:3306/students";
        String username="root";
        String password="1492";
        Connection connection= DriverManager.getConnection(url,username,password);

        if(connection!=null){
            System.out.println("Connected to database");
            return  connection;
        }
        return  null;
    }
}

