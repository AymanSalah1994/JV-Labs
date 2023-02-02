package firstlab;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.io.SQLException  ; 
import java.util.Properties;
import javax.sql.DataSource;

public class FirstLab {
    public static void main(String[] args) {
        new DbPropertyFile();
        // This Will Make the Object and Hence Make the Proprty File
        DataSourceTestCRUD.testDataSourceREAD();

    }
}

class DbPropertyFile {
    // All What this Class Do "and Its CTOR" Is to Create the File that we will User
    // Later ;
    // 1 / ONE
    public DbPropertyFile() {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("db.properties");
            // set the properties value
            prop.setProperty("MYSQL_DB_URL", "jdbc:mysql://localhost:3306/companydb");
            prop.setProperty("MYSQL_DB_USERNAME", "root");
            prop.setProperty("MYSQL_DB_PASSWORD", "");
            // save properties to project folder
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyDataSourceFactory {
    // This is the Facotry Class (Although it has nothing to do With Factory Design
    // Patterns , But same Idea)
    // It will use the Propery File and Create [a Data Source Object from it with ,
    // and This Object has File data ]
    // 2 / TWO
    public static DataSource getMySQLDataSource() {
        Properties props = new Properties();
        FileInputStream fis = null;
        MysqlDataSource mysqlDS = null;
        try {
            fis = new FileInputStream("db.properties");
            props.load(fis);
            mysqlDS = new MysqlDataSource();
            // get the properties value
            mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mysqlDS;
    }
}

class DataSourceTestCRUD {
    // This is the Class That will Use the Factory and
    // Here we Should Make All Methods related to the CRUD operations ;
    // 3 / THREE
    public static void testDataSourceREAD() {
        DataSource ds = null;
        ds = MyDataSourceFactory.getMySQLDataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from users");
            while (rs.next()) {
                // System.out.println("City ID=" + rs.getInt("city_id") + ",City=" +
                // rs.getString("city"));
                System.out.println("ID=" + rs.getInt(1) + ",First Name=" + rs.getString(2));
                // Those are related to my Table , you Can Change them ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
