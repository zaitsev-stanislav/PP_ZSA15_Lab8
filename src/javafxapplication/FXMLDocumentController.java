package javafxapplication;

import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button_Math;
    @FXML
    private Label label_a;
    @FXML
    private Label label_b;
    @FXML
    private Label label_x;
    @FXML
    private Label label_otvet;
    @FXML
    private TextField textField_A;
    @FXML
    private TextField textField_B;
    @FXML
    private TextField textField_X;
    @FXML
    private Button button_Clear;
    @FXML
    private Button button_Exit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void buttonMathAction(ActionEvent event) {
        double a, b, x, y;
        try {
            a = Double.parseDouble(textField_A.getText());
            b = Double.parseDouble(textField_B.getText());
            x = Double.parseDouble(textField_X.getText());
        } catch (Exception ex) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введенных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            textField_A.requestFocus();
            label_otvet.setText("В введенных значениях допущены ошибки");
            textField_A.setText("");
            textField_B.setText("");
            textField_X.setText("");
            return;
        }
        try {
            y = FXMLDocumentController.comp(a, b, x);
           label_otvet.setText("Ответ: " + String.format("%.2f", y));
        }catch  (Exception e) {
            label_otvet.setText("Нет ответа");
        }
    }
    
    public static double comp(double a, double b, double x) throws Exception {
        double y;
        if (x <= 4) {
            y = (a * a) / (x * x) + 6 * x;
        } else {
            y = b * b * (4 + x) * (4 + x);
        }
        if (!(Double.isNaN(y)) && (!Double.isInfinite(y))) {
            return y;
        } else {
            throw new Exception();
        }
    }

    @FXML
    private void buttonClearAction(ActionEvent event) {
        label_otvet.setText("Ответ: ");
        textField_A.setText("");
        textField_B.setText("");
        textField_X.setText("");
    }

    @FXML
    private void buttonExitAction(ActionEvent event) {
        System.exit(0);
    }

}
