package javafxapplication5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*  ; 

public class JavaFXApplication5 extends Application {
    static boolean updateFlag = true ; 
    @Override
    public void start(Stage stage) throws Exception {
        ResultSet rsToGui = ResultSetFactory.getResultSet() ; 
        SecondLabUI root = new SecondLabUI() ;
        
        // I need to Initiate the GUI 
        rsToGui.first() ;  // Supposed to Be on First Row 
        root.textField.setText(rsToGui.getString("ID")  );
        root.textField0.setText(rsToGui.getString("F_Name")  );
        root.textField1.setText(rsToGui.getString("M_Name")  );
        root.textField2.setText(rsToGui.getString("L_Name")  );
        root.textField3.setText(rsToGui.getString("Email")  );
        root.textField4.setText(rsToGui.getString("Phone")  );
        // END of Initialization 
        
        
        
       root.button.setOnAction((event) -> {
            root.textField.setText("");
            root.textField0.setText("");
            root.textField1.setText("");
            root.textField2.setText("");
            root.textField3.setText("");
            root.textField4.setText("");
            updateFlag = false  ; 
            // All What We Need in New Is To Raise "NEW" Flag And Make the Fields Empty 
            // All the Heavy Work is in Update !! We Will Check All Cases  ; 
        }); // button Event END  == New 
        
        root.button0.setOnAction((event) -> {
            System.out.println("Yoy Clicked Button 0 ");
            System.out.println("The State of Update Flag is : " + updateFlag);
            // After Insert NEW , Switch update Flag again to true !!!
            
            if (updateFlag)
            {
            try {
                rsToGui.updateString("ID", root.textField.getText());
                rsToGui.updateString("F_Name", root.textField0.getText());
                rsToGui.updateString("M_Name", root.textField1.getText());
                rsToGui.updateString("L_Name", root.textField2.getText());
                rsToGui.updateString("Email", root.textField3.getText());
                rsToGui.updateString("Phone", root.textField4.getText());
                rsToGui.updateRow();
                } catch (SQLException e) {
                }
            }
            else 
            {
                try {
                rsToGui.moveToInsertRow();
                rsToGui.updateString("ID", root.textField.getText());
                rsToGui.updateString("F_Name", root.textField0.getText());
                rsToGui.updateString("M_Name", root.textField1.getText());
                rsToGui.updateString("L_Name", root.textField2.getText());
                rsToGui.updateString("Email", root.textField3.getText());
                rsToGui.updateString("Phone", root.textField4.getText());
                rsToGui.insertRow();
                updateFlag = true  ; // So that No New Insertion 
                } catch (SQLException e) {
                }
            }
            
            
                  
        }); // button0 Event END  == Update
        
       root.button1.setOnAction((event) -> {
        System.out.println("Yoy Clicked Button 1 ");
        // In Delete We Will First Make If Condition To Check Where to Put the Cursor 
        // Then After Putting the Cursor , We will Show the Data "Anyways Shown'
        
            try {
            rsToGui.deleteRow(); // So First We Delete the Row 
            
            root.textField.setText("");
            root.textField0.setText("");
            root.textField1.setText("");
            root.textField2.setText("");
            root.textField3.setText("");
            root.textField4.setText("");
            
            
            if (rsToGui.isAfterLast())
            {
            rsToGui.previous() ; 
            root.textField.setText(rsToGui.getString("ID")  );
            root.textField0.setText(rsToGui.getString("F_Name")  );
            root.textField1.setText(rsToGui.getString("M_Name")  );
            root.textField2.setText(rsToGui.getString("L_Name")  );
            root.textField3.setText(rsToGui.getString("Email")  );
            root.textField4.setText(rsToGui.getString("Phone")  );
            }
            else  if (rsToGui.isBeforeFirst())
            {
                rsToGui.next(); 
            root.textField.setText(rsToGui.getString("ID")  );
            root.textField0.setText(rsToGui.getString("F_Name")  );
            root.textField1.setText(rsToGui.getString("M_Name")  );
            root.textField2.setText(rsToGui.getString("L_Name")  );
            root.textField3.setText(rsToGui.getString("Email")  );
            root.textField4.setText(rsToGui.getString("Phone")  );
            }
            else {
                rsToGui.next() ; 
                // rsToGui.absolute() ;
            root.textField.setText(rsToGui.getString("ID")  );
            root.textField0.setText(rsToGui.getString("F_Name")  );
            root.textField1.setText(rsToGui.getString("M_Name")  );
            root.textField2.setText(rsToGui.getString("L_Name")  );
            root.textField3.setText(rsToGui.getString("Email")  );
            root.textField4.setText(rsToGui.getString("Phone")  );
            }
            
            } catch (SQLException e) {
            }
       
        }); // button0 Event END  == DELETE
        
        
         root.button2.setOnAction((event) -> {
        System.out.println("Yoy Clicked Button 2");
            try {
            rsToGui.first() ;  // Supposed to Be on First Row 
            root.textField.setText(rsToGui.getString("ID")  );
            root.textField0.setText(rsToGui.getString("F_Name")  );
            root.textField1.setText(rsToGui.getString("M_Name")  );
            root.textField2.setText(rsToGui.getString("L_Name")  );
            root.textField3.setText(rsToGui.getString("Email")  );
            root.textField4.setText(rsToGui.getString("Phone")  );
            } catch (SQLException e) {
            }
        }); // button0 Event END  == FIRST 
        
        
          root.button3.setOnAction((event) -> {
        System.out.println("Yoy Clicked Button 3 ");
            try {
        rsToGui.previous();  // Supposed to Be on First Row 
        root.textField.setText(rsToGui.getString("ID")  );
        root.textField0.setText(rsToGui.getString("F_Name")  );
        root.textField1.setText(rsToGui.getString("M_Name")  );
        root.textField2.setText(rsToGui.getString("L_Name")  );
        root.textField3.setText(rsToGui.getString("Email")  );
        root.textField4.setText(rsToGui.getString("Phone")  );
            } catch (SQLException e) {
            }
        }); // button0 Event END  == Previous 
                 
         root.button4.setOnAction((event) -> {
        System.out.println("Yoy Clicked Button 4 ");
            try {
        rsToGui.next();  
        root.textField.setText(rsToGui.getString("ID")  );
        root.textField0.setText(rsToGui.getString("F_Name")  );
        root.textField1.setText(rsToGui.getString("M_Name")  );
        root.textField2.setText(rsToGui.getString("L_Name")  );
        root.textField3.setText(rsToGui.getString("Email")  );
        root.textField4.setText(rsToGui.getString("Phone")  );
        // END of Initialization 
            } catch (SQLException e) {
            }
        }); // button0 Event END  == NEXT
         
       root.button5.setOnAction((event) -> {
        System.out.println("Yoy Clicked Button 5 ");
     try {
        rsToGui.last();   
        root.textField.setText(rsToGui.getString("ID")  );
        root.textField0.setText(rsToGui.getString("F_Name")  );
        root.textField1.setText(rsToGui.getString("M_Name")  );
        root.textField2.setText(rsToGui.getString("L_Name")  );
        root.textField3.setText(rsToGui.getString("Email")  );
        root.textField4.setText(rsToGui.getString("Phone")  );
            } catch (SQLException e) {
            }
        }); // button0 Event END  == LAST
        
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static void initiateGUI()
    {
        // This to Fill the GUI with the First Element  ; 
       
    }
    
}

class ResultSetFactory {
    static ResultSet rs  = null ; 
    public static ResultSet getResultSet() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb","root","");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_UPDATABLE , ResultSet.HOLD_CURSORS_OVER_COMMIT) ;
            String queryString = new String("select * from persons");
            rs = stmt.executeQuery(queryString) ;
             //stmt.close();
             //con.close();
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}