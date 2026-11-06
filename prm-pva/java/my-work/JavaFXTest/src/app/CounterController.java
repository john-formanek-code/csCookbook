package app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CounterController {

    @FXML
    private Label countLabel;

    private int count = 0;

    @FXML
    private void increase() {
        count++;
        updateLabel();
    }

    @FXML
    private void decrease() {
        count--;
        updateLabel();
    }

    @FXML
    private void reset() {
        count = 0;
        updateLabel();
    }

    private void updateLabel() {
        countLabel.setText(Integer.toString(count));
    }
}
