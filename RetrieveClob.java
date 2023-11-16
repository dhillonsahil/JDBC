import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetrieveClob {
    public static void main(String[] args) {
        Connection connection = null;
        try{
            connection=GetConnection.connection();
            String query = "select s_namae , filedata from clobData where s_namae=?";
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1,"hisar");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                Reader fr= rs.getCharacterStream(2);
                File file = new File("newHistory.txt");
                FileWriter fw = new FileWriter(file);
                IOUtils.copy(fr,fw);
                fw.flush();

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
