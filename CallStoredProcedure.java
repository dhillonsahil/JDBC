import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class CallStoredProcedure {
    public static void main(String[] args) {
        Connection connection =null;
        CallableStatement callableStatement=null;

        try{
            connection = GetConnection.connection();
            String storedProcedure = "{call getStudents(?)}";

            callableStatement = connection.prepareCall(storedProcedure);
            callableStatement.setInt(1,2);
            callableStatement.execute();

            ResultSet rs = callableStatement.getResultSet();

            while (rs.next()){
                System.out.println(rs.getString(2 ));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
