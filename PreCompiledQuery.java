import java.sql.*;

public class PreCompiledQuery {
    public static void main(String[] args) {
        try {
            String url="jdbc:mysql://localhost:3306/students";
            String username="root";
            String password="1492";
            Connection connection= DriverManager.getConnection(url,username,password);
            System.out.println("Connected to database");
            if (connection!=null){
                String query = "select sid,sname,sage,saddr from studentdata where sid=?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                if(preparedStatement!=null){
                    preparedStatement.setInt(1,1);
                   ResultSet resultSet= preparedStatement.executeQuery();
                   if(resultSet!=null){
                       while(resultSet.next()){
                           System.out.println(resultSet.getString(2 ));
                       }
                   }
                }
            }
        }catch (Exception e){

        }
    }
}
