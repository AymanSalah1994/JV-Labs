package javafxapplication5;

import java.lang.*;
import java.util.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SecondLabUI extends AnchorPane {

    protected final Label label;
    protected final TextField idField;
    protected final TextField fNameField;
    protected final TextField mNameField;
    protected final TextField lNameField;
    protected final TextField emailField;
    protected final TextField phoneField;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Button button;
    protected final Button updateButton;
    protected final Button deleteButton;
    protected final Button firstButton;
    protected final Button prevButton;
    protected final Button nextButton;
    protected final Button lastButton;

    public SecondLabUI() {

        label = new Label();
        idField = new TextField();
        fNameField = new TextField();
        mNameField = new TextField();
        lNameField = new TextField();
        emailField = new TextField();
        phoneField = new TextField();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        
        button = new Button();
        updateButton = new Button();
        deleteButton = new Button();
        firstButton = new Button();
        prevButton = new Button();
        nextButton = new Button();
        lastButton = new Button();

        setId("AnchorPane");
        setPrefHeight(462.0);
        setPrefWidth(617.0);

        label.setLayoutX(126);
        label.setLayoutY(120);
        label.setMinHeight(16);
        label.setMinWidth(69);

        idField.setLayoutX(182.0);
        idField.setLayoutY(60.0);

        fNameField.setLayoutX(182.0);
        fNameField.setLayoutY(105.0);
        fNameField.setPrefHeight(31.0);
        fNameField.setPrefWidth(290.0);

        mNameField.setLayoutX(182.0);
        mNameField.setLayoutY(152.0);
        mNameField.setPrefHeight(31.0);
        mNameField.setPrefWidth(290.0);

        lNameField.setLayoutX(182.0);
        lNameField.setLayoutY(205.0);
        lNameField.setPrefHeight(31.0);
        lNameField.setPrefWidth(290.0);

        emailField.setLayoutX(182.0);
        emailField.setLayoutY(253.0);
        emailField.setPrefHeight(31.0);
        emailField.setPrefWidth(290.0);

        phoneField.setLayoutX(182.0);
        phoneField.setLayoutY(303.0);
        phoneField.setPrefHeight(31.0);
        phoneField.setPrefWidth(290.0);

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

        updateButton.setLayoutX(130.0);
        updateButton.setLayoutY(381.0);
        updateButton.setMnemonicParsing(false);
        updateButton.setText("Update");

        deleteButton.setLayoutX(211.0);
        deleteButton.setLayoutY(381.0);
        deleteButton.setMnemonicParsing(false);
        deleteButton.setText("Delete");

        firstButton.setLayoutX(295.0);
        firstButton.setLayoutY(381.0);
        firstButton.setMnemonicParsing(false);
        firstButton.setText("First");

        prevButton.setLayoutX(361.0);
        prevButton.setLayoutY(381.0);
        prevButton.setMnemonicParsing(false);
        prevButton.setText("Previous");

        nextButton.setLayoutX(458.0);
        nextButton.setLayoutY(381.0);
        nextButton.setMnemonicParsing(false);
        nextButton.setText("Next");

        lastButton.setLayoutX(529.0);
        lastButton.setLayoutY(381.0);
        lastButton.setMnemonicParsing(false);
        lastButton.setText("Last");

        getChildren().add(label);
        getChildren().add(idField);
        getChildren().add(fNameField);
        getChildren().add(mNameField);
        getChildren().add(lNameField);
        getChildren().add(emailField);
        getChildren().add(phoneField);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(label4);
        getChildren().add(label5);
        getChildren().add(button);
        getChildren().add(updateButton);
        getChildren().add(deleteButton);
        getChildren().add(firstButton);
        getChildren().add(prevButton);
        getChildren().add(nextButton);
        getChildren().add(lastButton);

    }
}
