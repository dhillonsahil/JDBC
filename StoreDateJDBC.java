import java.sql.*;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class StoreDateJDBC {
    public static void main(String[] args) throws  Exception{
        Connection connection=null;
        PreparedStatement pstm= null;

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name : ");
        String name = scan.next();
        System.out.println();
        System.out.print("Enter the dob (dd-mm-yyyy) :");
        String dt = scan.next();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = sdf.parse(dt);

        long uDate = date.getTime();
        java.sql.Date SqlDate = new java.sql.Date(uDate);

        // System.out.println("string date is :: "+ dt);
        // System.out.println("Util date :: "+date);
        // System.out.println("parsed date is :: "+uDate);
        // System.out.println("SQL DATE IS :: "+SqlDate);


        String sqlInsertQuery = "Insert into studentnew(`name`,`dob`) values (?,?)";
        try{
            connection = GetConnection.connection();
            if(connection!=null){
                pstm = connection.prepareStatement(sqlInsertQuery);
                    pstm.setString(1,name);
                    pstm.setDate(2,SqlDate);
                    int rowAffected = pstm.executeUpdate();
                    System.out.println("Rows affected are "+ rowAffected);

                pstm.close();;
            }
            connection.close();
            scan.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}

