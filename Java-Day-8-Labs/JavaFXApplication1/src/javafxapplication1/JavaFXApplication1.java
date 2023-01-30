/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
            Text myText = new Text() ; 
            myText.setText("Hello World ");
            myText.setFont(new Font(40));
            myText.setFill(Color.RED);
            StackPane root = new StackPane();
            //LinearGradient linear = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);  
            //background: linear-gradient(0turn, #000000, #ebf8e1, #000000); 
            root.getChildren().add(myText);
            root.setId("scene");
            Reflection reflection = new Reflection(); 
            reflection.setBottomOpacity(0.0); 
            reflection.setTopOpacity(0.5); 
            reflection.setTopOffset(0.0);
            reflection.setFraction(0.7); 
            myText.setEffect(reflection); 
            Scene scene = new Scene(root, 500, 550);
            scene.getStylesheets().add(getClass().getResource("bgstyle.css").toString()) ; 
            root.getStyleClass().add("scene") ; 
//            scene.setFill(new LinearGradient(
//            0, 0, 1, 1, true,                      
//            CycleMethod.NO_CYCLE,                 
//            new Stop(0, Color.web("#000000")),    
//            new Stop(1, Color.web("#ffffff")))
//    );
//          scene.getClass()
            primaryStage.setTitle("Hello JavaFX!");
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
