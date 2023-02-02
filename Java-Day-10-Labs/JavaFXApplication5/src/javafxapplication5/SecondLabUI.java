package javafxapplication5;

import java.lang.*;
import java.util.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SecondLabUI extends AnchorPane {

    protected final Label label;
    protected final TextField textField;
    protected final TextField textField0;
    protected final TextField textField1;
    protected final TextField textField2;
    protected final TextField textField3;
    protected final TextField textField4;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;

    public SecondLabUI() {

        label = new Label();
        textField = new TextField();
        textField0 = new TextField();
        textField1 = new TextField();
        textField2 = new TextField();
        textField3 = new TextField();
        textField4 = new TextField();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();

        setId("AnchorPane");
        setPrefHeight(462.0);
        setPrefWidth(617.0);

        label.setLayoutX(126);
        label.setLayoutY(120);
        label.setMinHeight(16);
        label.setMinWidth(69);

        textField.setLayoutX(182.0);
        textField.setLayoutY(60.0);

        textField0.setLayoutX(182.0);
        textField0.setLayoutY(105.0);
        textField0.setPrefHeight(31.0);
        textField0.setPrefWidth(290.0);

        textField1.setLayoutX(182.0);
        textField1.setLayoutY(152.0);
        textField1.setPrefHeight(31.0);
        textField1.setPrefWidth(290.0);

        textField2.setLayoutX(182.0);
        textField2.setLayoutY(205.0);
        textField2.setPrefHeight(31.0);
        textField2.setPrefWidth(290.0);

        textField3.setLayoutX(182.0);
        textField3.setLayoutY(253.0);
        textField3.setPrefHeight(31.0);
        textField3.setPrefWidth(290.0);

        textField4.setLayoutX(182.0);
        textField4.setLayoutY(303.0);
        textField4.setPrefHeight(31.0);
        textField4.setPrefWidth(290.0);

        label0.setLayoutX(38.0);
        label0.setLayoutY(65.0);
        label0.setText("ID");

        label1.setLayoutX(38.0);
        label1.setLayoutY(110.0);
        label1.setText("First Name");

        label2.setLayoutX(38.0);
        label2.setLayoutY(157.0);
        label2.setText("Middle Name");

        label3.setLayoutX(38.0);
        label3.setLayoutY(210.0);
        label3.setText("Last Name");

        label4.setLayoutX(38.0);
        label4.setLayoutY(258.0);
        label4.setText("Email");

        label5.setLayoutX(35.0);
        label5.setLayoutY(308.0);
        label5.setText("Phone");

        button.setLayoutX(51.0);
        button.setLayoutY(381.0);
        button.setMnemonicParsing(false);
        button.setText("New..");

        button0.setLayoutX(130.0);
        button0.setLayoutY(381.0);
        button0.setMnemonicParsing(false);
        button0.setText("Update");

        button1.setLayoutX(211.0);
        button1.setLayoutY(381.0);
        button1.setMnemonicParsing(false);
        button1.setText("Delete");

        button2.setLayoutX(295.0);
        button2.setLayoutY(381.0);
        button2.setMnemonicParsing(false);
        button2.setText("First");

        button3.setLayoutX(361.0);
        button3.setLayoutY(381.0);
        button3.setMnemonicParsing(false);
        button3.setText("Previous");

        button4.setLayoutX(458.0);
        button4.setLayoutY(381.0);
        button4.setMnemonicParsing(false);
        button4.setText("Next");

        button5.setLayoutX(529.0);
        button5.setLayoutY(381.0);
        button5.setMnemonicParsing(false);
        button5.setText("Last");

        getChildren().add(label);
        getChildren().add(textField);
        getChildren().add(textField0);
        getChildren().add(textField1);
        getChildren().add(textField2);
        getChildren().add(textField3);
        getChildren().add(textField4);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(label4);
        getChildren().add(label5);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);
        getChildren().add(button2);
        getChildren().add(button3);
        getChildren().add(button4);
        getChildren().add(button5);

    }
}
