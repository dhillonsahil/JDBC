import java.io.*;
import java.sql.*;

public class ImageUpload {
    public static void main(String[] args) {
        Connection connection=null;
        try {
            connection=GetConnection.connection();
            String insertQuery = "Insert into imageData (`s_name`,`image`) values (?,?)";
            PreparedStatement pstm =connection.prepareStatement(insertQuery);
            pstm.setString(1,"sahil");
            File file= new File("img.jpg");
            FileInputStream fis = new FileInputStream(file);
            pstm.setBlob(2,fis);

            int affectedRows=pstm.executeUpdate();
            System.out.println(affectedRows);
        }catch (Exception e){

        }
    }
}
