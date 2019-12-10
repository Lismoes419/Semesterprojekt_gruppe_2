package fxmlseasweeperquiz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class PrimaryController implements Initializable {

    @FXML private Label label1;
    @FXML private RadioButton radiobutton1;
    @FXML private RadioButton radiobutton2;
    @FXML private RadioButton radiobutton3;
    @FXML private RadioButton radiobutton4;
    @FXML private Label label2;
    
    @FXML private Label label3;
    @FXML private RadioButton radiobutton5;
    @FXML private RadioButton radiobutton6;
    @FXML private RadioButton radiobutton7;
    @FXML private RadioButton radiobutton8;
    @FXML private Label label4;
    
    @FXML private Label label5;
    @FXML private RadioButton radiobutton9;
    @FXML private RadioButton radiobutton10;
    @FXML private RadioButton radiobutton11;
    @FXML private RadioButton radiobutton12;
    @FXML private Label label6;
    
    @FXML private Label label7;
    @FXML private RadioButton radiobutton13;
    @FXML private RadioButton radiobutton14;
    @FXML private RadioButton radiobutton15;
    @FXML private RadioButton radiobutton16;
    @FXML private Label label8;

    @FXML public void correctAnswer() {
        if (radiobutton4.isSelected())
        {
        label2.setText("Korrekt svar");
        radiobutton1.setDisable(true);
        radiobutton2.setDisable(true);
        radiobutton3.setDisable(true);
        radiobutton4.setDisable(true);
        }
        else
        {
        label2.setText("Forkert svar - prøv igen");
        }           
    }
        
        @FXML public void correctAnswer2() {
        if (radiobutton7.isSelected())
        {
        label4.setText("Korrekt svar");
        radiobutton5.setDisable(true);
        radiobutton6.setDisable(true);
        radiobutton7.setDisable(true);
        radiobutton8.setDisable(true);
        }
        else
        {
        label4.setText("Forkert svar - prøv igen");
        }           
    }

    @FXML public void correctAnswer3() {
        if (radiobutton12.isSelected())
        {
        label6.setText("Korrekt svar");
        radiobutton9.setDisable(true);
        radiobutton10.setDisable(true);
        radiobutton11.setDisable(true);
        radiobutton12.setDisable(true);
        }
        else
        {
        label6.setText("Forkert svar - prøv igen");
        }           
    }
       
    @FXML public void correctAnswer4() {
        if (radiobutton13.isSelected())
        {
        label8.setText("Korrekt svar");
        radiobutton13.setDisable(true);
        radiobutton14.setDisable(true);
        radiobutton15.setDisable(true);
        radiobutton16.setDisable(true);
        }
        else
        {
        label8.setText("Forkert svar - prøv igen");
        }           
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
    
    
    
}
