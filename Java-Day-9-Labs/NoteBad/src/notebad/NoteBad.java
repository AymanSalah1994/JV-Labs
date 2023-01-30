package notebad;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.* ; 
import javafx.scene.control.ButtonBar;
import javafx.scene.input.KeyEvent;

public class NoteBad extends Application {
    boolean fileNotSaved = false  ; 
    public void toggleSaveToFalse()
    {
       fileNotSaved = false ; 
    }
    public void toggleSaveTrue()
    {
       fileNotSaved = true ; 
    }
    public boolean flagSave()
    {
        return fileNotSaved ; 
    }
    @Override
    public void start(Stage primaryStage) {
             
             
            MenuBar bar = new MenuBar();
            TextArea textArea = new TextArea() ; 
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "A NotePad that is Not-Bad , Created By Ayman Salah ", ButtonType.CLOSE);
            alert.setTitle("About this Application");
            alert.setHeaderText("Thanks for Choosing our app , Not Bad Editor Version 1.4");
            
            Menu file = new Menu("File") ;
            
            MenuItem newItem = new MenuItem("New") ; 
            newItem.setAccelerator(KeyCombination.keyCombination("CTRL+N"));
            newItem.setOnAction(((event) -> {
               boolean notSaved = flagSave() ; 
               if (notSaved)
               {
                   // prompt 
                    Alert alertExit = new Alert(Alert.AlertType.CONFIRMATION);
                    alertExit.setTitle("Alert , File Not Daved");
                    alertExit.setContentText("Are you Sure you want to Create new one?");
                    ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                    ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                    alertExit.getButtonTypes().setAll(okButton, cancelButton);
                    alertExit.showAndWait().ifPresent(type -> {
                    if (type == okButton) {
                        textArea.clear();
                    } else if (type == cancelButton) {
                    } else {
                    }
            });
               }
               else 
               {
                    textArea.clear();
               }
            }));
            
            MenuItem openItem = new MenuItem("Open") ; 
            openItem.setAccelerator(KeyCombination.keyCombination("CTRL+O"));
            openItem.setOnAction(((event) -> {
                System.out.println("Open File"); // tracing only , i will delete it .:)
                FileChooser fileChooser = new FileChooser();
                File myFile = fileChooser.showOpenDialog(primaryStage);
                System.out.println("File :" + myFile.toString());
                try {
                    FileInputStream fInputStr = new FileInputStream(myFile) ;
                    int size =  fInputStr.available() ; 
                    byte[] b = new byte[size] ; 
                    fInputStr.read(b) ; 
                    System.out.println(new String (b));
                    textArea.clear();
                    textArea.setText(new String (b));
                    fInputStr.close();
                }
                catch (IOException e) {
                    System.out.println("Can't read this File !");
                }
            }));
            
            MenuItem saveItem = new MenuItem("Save") ; 
            saveItem.setAccelerator(KeyCombination.keyCombination("CTRL+S"));
            saveItem.setOnAction(((event) -> {
                System.out.println("Save File");
                
                FileChooser fileChooser = new FileChooser();
                File myFile = fileChooser.showSaveDialog(primaryStage);
                try {
                   FileOutputStream fInputStr = new FileOutputStream(myFile) ;
                   String txtAreaContet  = textArea.getText()  ; 
                   byte[] newData = txtAreaContet.getBytes() ; 
                   fInputStr.write(newData) ;
                   fInputStr.close();
                   toggleSaveToFalse(); // At the End 
                }
                catch (IOException e) {
                    System.out.println("Can't save to this File !");
                }
            }));
            
            
            MenuItem exitItem = new MenuItem("Exit") ; 
            exitItem.setAccelerator(KeyCombination.keyCombination("CTRL+E"));
            exitItem.setOnAction(((event) -> {
              
               boolean notSaved = flagSave() ; 
               if (notSaved)
               {
                   // prompt 
                    Alert alertExit = new Alert(Alert.AlertType.CONFIRMATION);
                    alertExit.setTitle("Alert , File Not Daved");
                    alertExit.setContentText("Are you Sure you want to Exit ?");
                    ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                    ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                    alertExit.getButtonTypes().setAll(okButton, cancelButton);
                    alertExit.showAndWait().ifPresent(type -> {
                    if (type == okButton) {
                        Platform.exit();
                    } else if (type == cancelButton) {
                    } else {
                    }
            });
               }
               else 
               {
                    Platform.exit();
               }
            }));
            
            file.getItems().addAll(newItem,openItem,saveItem,exitItem);
            
            
        Menu edit = new Menu("Edit") ;
        
            MenuItem cutItem = new MenuItem("Cut") ; 
            cutItem.setOnAction(((event) -> {
               textArea.cut();
               textArea.replaceSelection("");
            }));
            
            MenuItem copyItem = new MenuItem("Copy") ; 
            copyItem.setOnAction(((event) -> {
                textArea.copy();
            }));
            
            MenuItem pasteItem = new MenuItem("Paste") ; 
              pasteItem.setOnAction(((event) -> {
               textArea.paste();
            }));
              
            MenuItem deleteItem = new MenuItem("Delete") ;
             deleteItem.setOnAction(((event) -> {
            textArea.replaceSelection("");
            }));
             
            MenuItem selectAllItem = new MenuItem("Select All") ;
             selectAllItem.setOnAction(((event) -> {
               textArea.selectAll();
            }));
             
            edit.getItems().addAll(cutItem,copyItem,pasteItem,deleteItem,selectAllItem);
            
        Menu help = new Menu("Help") ;
            MenuItem aboutItem = new MenuItem("About") ;
            aboutItem.setAccelerator(KeyCombination.keyCombination("CTRL+U"));
            aboutItem.setOnAction(((event) -> {
               alert.showAndWait() ; 
            }));
            
            help.getItems().add(aboutItem);
        
        
        bar.getMenus().addAll(file,edit,help) ;
        
        BorderPane pan = new BorderPane() ; 
        pan.setTop(bar);
        pan.setCenter(textArea);
        Scene scene = new Scene(pan, 600, 600);
        
        primaryStage.setTitle("A NotePad Not-Bad");
        textArea.setOnKeyTyped(((event) -> {
               primaryStage.setTitle("A NotePad Not-Bad (Unsaved)");
               toggleSaveTrue();
            }));
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
