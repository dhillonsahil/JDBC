import java.sql.*;
import java.text.SimpleDateFormat;

public class RetrieveDate {
    public static void main(String[] args) {
        try {
            Connection connection = GetConnection.connection();
            String InsertQuery = "select name,dob from studentnew  where name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(InsertQuery);
            preparedStatement.setString(1,"sahil");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                java.sql.Date sdt= rs.getDate(2);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String date = sdf.format(sdt);
                System.out.println(rs.getString(1) + " "+date);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
