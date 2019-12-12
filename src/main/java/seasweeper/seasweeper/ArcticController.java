package seasweeper.seasweeper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

public class ArcticController implements Initializable {

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

    private boolean q1, q2, q3, q4;
    @FXML private Pane winner;
    
    @FXML public void correctAnswer() {
        if (radiobutton4.isSelected())
        {
            label2.setText("Correct answer");
            radiobutton1.setDisable(true);
            radiobutton2.setDisable(true);
            radiobutton3.setDisable(true);
            radiobutton4.setDisable(true);
            
            q1 = true;
            checkAnswers();
        } else
        {
            label2.setText("Wrong Answer - Try Again");
            q1 = false;
        }
    }
        
    @FXML public void correctAnswer2() {
        if (radiobutton7.isSelected())
        {
            label4.setText("Correct answer");
            radiobutton5.setDisable(true);
            radiobutton6.setDisable(true);
            radiobutton7.setDisable(true);
            radiobutton8.setDisable(true);
            
            q2 = true;
            checkAnswers();
        } else
        {
            label4.setText("Wrong Answer - Try Again");
            q2 = false;
        }
    }

    @FXML public void correctAnswer3() {
        if (radiobutton12.isSelected())
        {
            label6.setText("Correct answer");
            radiobutton9.setDisable(true);
            radiobutton10.setDisable(true);
            radiobutton11.setDisable(true);
            radiobutton12.setDisable(true);
            
            q3 = true;
            checkAnswers();
        } else
        {
            label6.setText("Wrong Answer - Try Again");
            q3 = false;
        }
    }
       
    @FXML public void correctAnswer4() {
        if (radiobutton13.isSelected())
        {
            label8.setText("Correct answer");
            radiobutton13.setDisable(true);
            radiobutton14.setDisable(true);
            radiobutton15.setDisable(true);
            radiobutton16.setDisable(true);
            
            q4 = true;
            checkAnswers();
        } else
        {
            label8.setText("Wrong Answer - Try Again");
            q4 = false;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    
    }
    private void checkAnswers()
    {
        if(q1 && q2 && q3 && q4)
        {
            winner.setDisable(false);
            winner.setVisible(true);
        }
    }

    @FXML
    private void quit(ActionEvent event)
    {
        App.getGame().quit();
    }
}
