package firstlab;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.Properties;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.RowSetFactory;

public class FirstLab {
    public static void main(String[] args) {
       class MyRowSetListener implements RowSetListener
       {
         public void cursorMoved(RowSetEvent event) 
         {
             System.out.println("Cursor Moved ");
         }
         public void rowChanged(RowSetEvent event) 
         {
             System.out.println("A Row  Changed ");
         }
         public void rowSetChanged(RowSetEvent event) 
         {
           System.out.println("The Whole Rowset Changed ");
         }
       }// end of class MyRowSetListener , inner One 
         
        MyRowSetListener rowsetListener = new MyRowSetListener ();
        try {
            RowSetFactory myRSF = RowSetProvider.newFactory();
                    JdbcRowSet jrs =  myRSF.createJdbcRowSet();
                    jrs.setCommand("SELECT * FROM users");
                    jrs.setUrl("jdbc:mysql://localhost:3306/companydb");
                    jrs.setUsername("root");
                    jrs.setPassword("");
                    jrs.execute();
                    jrs.addRowSetListener(rowsetListener);
                    jrs.first(); 
                    jrs.next(); 
                    // I can Delete Or Update Anything to Get the rowChanged Event 
                    jrs.deleteRow();
                    System.out.println("F name : "+jrs.getString(2) );
        } catch (SQLException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
}