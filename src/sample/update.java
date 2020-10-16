package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class update {
    @FXML
    public TextField targetUpdate;

    @FXML
    public TextField explainUpdate;

    @FXML
    public Button btUpdate;

    @FXML
    public Label messUpdate;

    public void add(ActionEvent e) {
        Word a = new Word();
        a.setWord_target(targetUpdate.getText());
        a.setWord_explain(explainUpdate.getText());
        try {
            if(!a.getWord_target().isEmpty()&&!a.getWord_explain().isEmpty()){
            Dictionary.update(a);
            messUpdate.setText("Success!!");}
            else messUpdate.setText("Try again!");
        } catch (SQLException e1) {
            e1.printStackTrace();
            messUpdate.setText("Try again!");
        }

    }
    public void back(ActionEvent e) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("sample.fxml"));
        Parent parent = Loader.load();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
