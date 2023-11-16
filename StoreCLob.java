import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class StoreCLob {
    public static void main(String[] args) {
        Connection connection = null;
        try{
            connection=GetConnection.connection();
            if(connection!=null){
                String query ="insert into clobData values(?,?)";
                PreparedStatement pstm = connection.prepareStatement(query);
                pstm.setString(1,"hisar");
                File file = new File("history.txt");
                FileReader fr = new FileReader(file);
                pstm.setCharacterStream(2,fr);

                int affectedRows =pstm.executeUpdate();
                System.out.println(affectedRows);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
