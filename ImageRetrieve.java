import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ImageRetrieve {
    public static void main(String[] args) {
        Connection connection=null;

        try {
            connection=GetConnection.connection();
            if(connection!=null){
                String query="select s_name,image from imageData where  s_name=?";
                PreparedStatement pstm=connection.prepareStatement(query);
                pstm.setString(1,"sahil");
                ResultSet resultSet=pstm.executeQuery();
                if(resultSet.next()){
                    InputStream is =resultSet.getBinaryStream(2);
                    FileOutputStream fos = new FileOutputStream("downloaded.jpg");
                    // or
                  //   File file = new File("download.jpg");
                 //   FileOutputStream foos= new FileOutputStream(file);

                    byte b[]= new byte[2048];
                    while (is.read(b)>0){
                        fos.write(b);
                    }
                    fos.flush();
                }

            }
        }catch (Exception e){

        }
    }
}
