import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.sql.*;

public class LearnConnectionPooling {
    public static void main(String[] args) throws SQLException {
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/students");
        dataSource.setUser("root");
        dataSource.setPassword("1492");
        Connection connection = dataSource.getConnection();
       // Statement statement =connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("select sid,sname,sage from studentdata");
        ResultSet resultSet =preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1) +"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3));
        }
        resultSet.close();;
        preparedStatement.close();
//         statement.close();
        connection.close();
    }
}
