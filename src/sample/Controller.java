package sample;

import com.gtranslate.Audio;
import com.gtranslate.Language;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javazoom.jl.decoder.JavaLayerException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;


public class Controller {
    @FXML
    public Button add;

    @FXML
    private TextField input;

    @FXML
    private Label show;
    @FXML
    private Label re;

    @FXML
    public ListView<String> view;
    ObservableList<String> viewList = FXCollections.observableArrayList();
    public void searchView(ActionEvent e) throws SQLException {
        String s = input.getText();
        List<Word> wordList = Dictionary.findAll();
        for(Word a: wordList){
            if(a.getWord_target().startsWith(s)){
                viewList.add(a.getWord_target());
            }
        }
        view.getItems().addAll(viewList);
    }
    @FXML
    public void deletelistview(MouseEvent e){
        viewList.removeAll(viewList);
    }
    @FXML
    private void showlist(MouseEvent e) throws SQLException{
        String s = view.getSelectionModel().getSelectedItem();
        List<Word> wordList = Dictionary.findAll();
        for(Word a:wordList){
            if(a.getWord_target().equals(s)){
                show.setText(a.getWord_explain());
                re.setText(a.getWord_target());
            }
        }
    }
    public void search(ActionEvent e) throws SQLException {
        Word s = new Word();
        s.setWord_target(input.getText());
        List<Word> wordList = Dictionary.findAll();
        for (Word a : wordList) {
            if (s.getWord_target().equals(a.getWord_target()))
                s.setWord_explain(a.getWord_explain());
        }
        show.setText(s.getWord_explain());
        re.setText(s.getWord_target());
    }


    public void changeSceneAdd(ActionEvent e) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("add.fxml"));
        Parent parent = Loader.load();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void changeSceneDelete(ActionEvent e) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("delete.fxml"));
        Parent parent = Loader.load();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void changeSceneUpdate(ActionEvent e) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("update.fxml"));
        Parent parent = Loader.load();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public void Voice(ActionEvent e) throws IOException, JavaLayerException {
        Audio audio = Audio.getInstance();
       InputStream sound = audio.getAudio("hello", Language.ENGLISH);
        audio.play(sound);

    }

}