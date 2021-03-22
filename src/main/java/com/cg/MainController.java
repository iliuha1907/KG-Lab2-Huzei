package com.cg;

import com.drew.imaging.ImageProcessingException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.DirectoryChooser;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainController {

    @FXML
    private ListView<String> listImg;
    @FXML
    private Label elapsedTime;

    public MainController() {
    }

    public void chooseDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Open Resource Directory");
        File directory = directoryChooser.showDialog(MainApp.primaryStage);
        if(directory == null){
            return;
        }
        try {
            long start = System.nanoTime();
            List<String> infos = DataProvider.findImages(FileWalker.findFiles(directory));
            long end = System.nanoTime();
            long time = end - start;
            listImg.setItems(FXCollections.observableArrayList(infos));
            elapsedTime.setText(String.valueOf(TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS)));
        } catch (ImageProcessingException | IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
}
