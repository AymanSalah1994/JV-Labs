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
        root.idField.setText(rsToGui.getString("ID")  );
        root.idField.setEditable(false);
        root.fNameField.setText(rsToGui.getString("F_Name")  );
        root.mNameField.setText(rsToGui.getString("M_Name")  );
        root.lNameField.setText(rsToGui.getString("L_Name")  );
        root.emailField.setText(rsToGui.getString("Email")  );
        root.phoneField.setText(rsToGui.getString("Phone")  );
        // END of Initialization 
        
       root.button.setOnAction((event) -> {
            root.idField.setText("");
            root.idField.setEditable(true);
            root.fNameField.setText("");
            root.mNameField.setText("");
            root.lNameField.setText("");
            root.emailField.setText("");
            root.phoneField.setText("");
            updateFlag = false  ; 
            
            // All What We Need in New Is To Raise "NEW" Flag And Make the Fields Empty 
            // All the Heavy Work is in Update !! We Will Check All Cases  ; 
        }); // button Event END  == New 
        
        root.updateButton.setOnAction((event) -> {
            System.out.println("Yoy Clicked Button 0 ");
            System.out.println("The State of Update Flag is : " + updateFlag);
            // After Insert NEW , Switch update Flag again to true !!!
            
            if (updateFlag)
            {
            try {
                rsToGui.updateString("ID", root.idField.getText());
                rsToGui.updateString("F_Name", root.fNameField.getText());
                rsToGui.updateString("M_Name", root.mNameField.getText());
                rsToGui.updateString("L_Name", root.lNameField.getText());
                rsToGui.updateString("Email", root.emailField.getText());
                rsToGui.updateString("Phone", root.phoneField.getText());
                rsToGui.updateRow();
                } catch (SQLException e) {
                }
            }
            else 
            {
                try {
                rsToGui.moveToInsertRow();
                rsToGui.updateString("ID", root.idField.getText());
                rsToGui.updateString("F_Name", root.fNameField.getText());
                rsToGui.updateString("M_Name", root.mNameField.getText());
                rsToGui.updateString("L_Name", root.lNameField.getText());
                rsToGui.updateString("Email", root.emailField.getText());
                rsToGui.updateString("Phone", root.phoneField.getText());
                rsToGui.insertRow();
                root.idField.setEditable(false);
                updateFlag = true  ; // So that No New Insertion 
                } catch (SQLException e) {
                }
            }
            
            
                  
        }); // updateButton Event END  == Update
        
       root.deleteButton.setOnAction((event) -> {
        System.out.println("Yoy Clicked Button 1 ");
        // In Delete We Will First Make If Condition To Check Where to Put the Cursor 
        // Then After Putting the Cursor , We will Show the Data "Anyways Shown'
        
            try {

            rsToGui.deleteRow(); // So First We Delete the Row 
            root.idField.setText("");
            root.fNameField.setText("");
            root.mNameField.setText("");
            root.lNameField.setText("");
            root.emailField.setText("");
            root.phoneField.setText("");
            
            
            if (rsToGui.isAfterLast())
            {
            rsToGui.previous() ; 
            root.idField.setText(rsToGui.getString("ID")  );
            root.fNameField.setText(rsToGui.getString("F_Name")  );
            root.mNameField.setText(rsToGui.getString("M_Name")  );
            root.lNameField.setText(rsToGui.getString("L_Name")  );
            root.emailField.setText(rsToGui.getString("Email")  );
            root.phoneField.setText(rsToGui.getString("Phone")  );
            }
            else  if (rsToGui.isBeforeFirst())
            {
            rsToGui.next(); 
            root.idField.setText(rsToGui.getString("ID")  );
            root.fNameField.setText(rsToGui.getString("F_Name")  );
            root.mNameField.setText(rsToGui.getString("M_Name")  );
            root.lNameField.setText(rsToGui.getString("L_Name")  );
            root.emailField.setText(rsToGui.getString("Email")  );
            root.phoneField.setText(rsToGui.getString("Phone")  );
            }
            else {
            rsToGui.next() ; 
            root.idField.setText(rsToGui.getString("ID")  );
            root.fNameField.setText(rsToGui.getString("F_Name")  );
            root.mNameField.setText(rsToGui.getString("M_Name")  );
            root.lNameField.setText(rsToGui.getString("L_Name")  );
            root.emailField.setText(rsToGui.getString("Email")  );
            root.phoneField.setText(rsToGui.getString("Phone")  );
            }
            
            } catch (SQLException e) {
            }
       
        }); // updateButton Event END  == DELETE
        
        
         root.firstButton.setOnAction((event) -> {
        System.out.println("Yoy Clicked Button 2");
            try {
            rsToGui.first() ;  // Supposed to Be on First Row 
          root.nextButton.setDisable(false);
          root.prevButton.setDisable(true);
            root.idField.setText(rsToGui.getString("ID")  );
            root.fNameField.setText(rsToGui.getString("F_Name")  );
            root.mNameField.setText(rsToGui.getString("M_Name")  );
            root.lNameField.setText(rsToGui.getString("L_Name")  );
            root.emailField.setText(rsToGui.getString("Email")  );
            root.phoneField.setText(rsToGui.getString("Phone")  );
            } catch (SQLException e) {
            }
        }); // updateButton Event END  == FIRST 
        
        
          root.prevButton.setOnAction((event) -> {
        System.out.println("Yoy Clicked Button 3 ");
            try {
        rsToGui.previous(); 
        root.nextButton.setDisable(false);
        if (rsToGui.isBeforeFirst())
        {
            rsToGui.next() ; 
            root.prevButton.setDisable(true);
        }
        root.idField.setText(rsToGui.getString("ID")  );
        root.fNameField.setText(rsToGui.getString("F_Name")  );
        root.mNameField.setText(rsToGui.getString("M_Name")  );
        root.lNameField.setText(rsToGui.getString("L_Name")  );
        root.emailField.setText(rsToGui.getString("Email")  );
        root.phoneField.setText(rsToGui.getString("Phone")  );
            } catch (SQLException e) {
            }
        }); // updateButton Event END  == Previous 
                 
         root.nextButton.setOnAction((event) -> {
        System.out.println("Yoy Clicked Button 4 ");
            try {
        rsToGui.next();  
        root.prevButton.setDisable(false);
        if (rsToGui.isAfterLast())
        {
            rsToGui.previous(); 
            root.nextButton.setDisable(true);
        }
        root.idField.setText(rsToGui.getString("ID")  );
        root.fNameField.setText(rsToGui.getString("F_Name")  );
        root.mNameField.setText(rsToGui.getString("M_Name")  );
        root.lNameField.setText(rsToGui.getString("L_Name")  );
        root.emailField.setText(rsToGui.getString("Email")  );
        root.phoneField.setText(rsToGui.getString("Phone")  );
        // END of Initialization 
            } catch (SQLException e) {
            }
        }); // updateButton Event END  == NEXT
         
       root.lastButton.setOnAction((event) -> {
        System.out.println("Yoy Clicked Button 5 ");
     try {
        rsToGui.last();   
        root.nextButton.setDisable(true);
        root.prevButton.setDisable(false);
        root.idField.setText(rsToGui.getString("ID")  );
        root.fNameField.setText(rsToGui.getString("F_Name")  );
        root.mNameField.setText(rsToGui.getString("M_Name")  );
        root.lNameField.setText(rsToGui.getString("L_Name")  );
        root.emailField.setText(rsToGui.getString("Email")  );
        root.phoneField.setText(rsToGui.getString("Phone")  );
            } catch (SQLException e) {
            }
        }); // updateButton Event END  == LAST
        
        
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
