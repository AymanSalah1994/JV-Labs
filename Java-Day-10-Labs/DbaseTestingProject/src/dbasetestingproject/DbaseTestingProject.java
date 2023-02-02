package dbasetestingproject;
import java.sql.*  ; 

public class DbaseTestingProject {
    public static void main(String[] args) {
            CRUD crud  = new CRUD() ; 
//            crud.readData();
//            crud.insertData();
//            crud.updateData();
              //  crud.deleteData();

    } // End of Main   
} // End of Main Class 

class CRUD 
{
    public void readData()
    {
  try
    {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/koko_db","root","");
        Statement stmt = con.createStatement() ;
        String queryString = new String("select Email from staff");
        ResultSet rs = stmt.executeQuery(queryString) ;
        while(rs.next())
        {
        System.out.println(rs.getString(1));
        }
        stmt.close();
        con.close();
        }
  catch(SQLException ex)
          {
              ex.printStackTrace();
          }
    } // End of Read Data 
    
   public void insertData()
    {
try
    {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/koko_db","root","");
        Statement stmt = con.createStatement() ;
        String queryString = new String("INSERT INTO  staff values ('ayman@gmail.com','aymanSLH')");
        int rs = stmt.executeUpdate(queryString) ;
        System.out.println("Done Insertion");
        stmt.close();
        con.close();
        }
  catch(SQLException ex)
          {
              ex.printStackTrace();
          }
    } // End of Insert Function 
    
        public void updateData()
    {
try
    {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/koko_db","root","");
        Statement stmt = con.createStatement() ;
        String queryString = new String("UPDATE  staff set name = 'ALI' where email =  'ayman@gmail.com'");
        int rs = stmt.executeUpdate(queryString) ;
        System.out.println("Done Updating");
        stmt.close();
        con.close();
        }
  catch(SQLException ex)
          {
              ex.printStackTrace();
          }
    } // End of Update Function 
        
   public void deleteData()
    {
  try
    {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/koko_db","root","");
        Statement stmt = con.createStatement() ;
        String queryString = new String("Delete from staff where name = 'ALI' ");
        int rs = stmt.executeUpdate(queryString) ;
        System.out.println("Delete Done ");
        stmt.close();
        con.close();
        }
  catch(SQLException ex)
          {
              ex.printStackTrace();
          }
    } // End of Delete Function 
    
}
