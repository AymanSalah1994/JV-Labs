
package secondlab;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

/**
 *
 * @author ayman
 */
public class SecondLab {

    public static void main(String[] args) {
        try {
                    RowSetFactory myRSF = RowSetProvider.newFactory();
                    WebRowSet jrs =  myRSF.createWebRowSet();
                    jrs.setCommand("SELECT * FROM users");
                    jrs.setUrl("jdbc:mysql://localhost:3306/companydb");
                    jrs.setUsername("root");
                    jrs.setPassword("");
                    jrs.execute();
                    FileOutputStream out = new FileOutputStream("usersList.xml");
                    jrs.writeXml(out); 
                    System.out.println("Done , Exported To XML file");
                    
//        Below There are Many Exceptions , I made them All Because Editor was Giving me Error to Catch the, 
        } catch (SQLException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
                catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
    
}
