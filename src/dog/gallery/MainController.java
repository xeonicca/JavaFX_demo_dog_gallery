/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dog.gallery;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Steve
 */
public class MainController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private ImageView imageView;
    @FXML
    private ListView<String> imageList;
    private int currentIndex;
    private final String[] fileList = {"dog1.jpg", "dog2.jpg", "dog3.jpg", "dog4.jpg","dog5.jpg","dog6.jpg"};
    
    @FXML
    private void handlePrevButtonAction(ActionEvent event) {
        if( currentIndex > 0 ){
            currentIndex--;
        }else{
            currentIndex = 5;
        }
        setDisplayImage(fileList[currentIndex]);
    }
    
    @FXML
    private void handleNextButtonAction(ActionEvent event) {
        if( currentIndex < 5 ){
            currentIndex++;
        }else{
            currentIndex = 0;
        }
        setDisplayImage(fileList[currentIndex]);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentIndex = 0;
        ObservableList<String> items =FXCollections.observableArrayList (fileList);
        imageList.setItems(items);
        imageList.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    currentIndex = imageList.getSelectionModel().getSelectedIndex();
            setDisplayImage(new_val);
        });
        
        setDisplayImage(fileList[currentIndex]);
    }    
    
    private void setDisplayImage(String fileName ){
        Image image = new Image(getClass().getResourceAsStream("/dog/images/"+fileName));
        imageView.setImage( image );
        imageList.getSelectionModel().select(currentIndex);
    }
}
