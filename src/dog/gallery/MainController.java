/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dog.gallery;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    private int currentIndex;
    private File[] fileList;
    
    @FXML
    private void handleLeftButtonAction(ActionEvent event) {
        if( currentIndex > 0 ){
            currentIndex--;
        }else{
            currentIndex = fileList.length-1;
        }
        setDisplayImage();
    }
    
    @FXML
    private void handleRightButtonAction(ActionEvent event) {
        if( currentIndex < fileList.length-1 ){
            currentIndex++;
        }else{
            currentIndex = 0;
        }
        setDisplayImage();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File folder = new File("C:\\Users\\Steve\\Pictures");
        fileList = folder.listFiles( (File pathname) -> {
            return pathname.toURI().toString().endsWith("jpg");
        }); 
        currentIndex = 0;
        setDisplayImage();
    }    
    
    private void setDisplayImage(){
        //final Image image2 = new Image(MainController.class.getResourceAsStream(fileList[currentIndex].getAbsolutePath()));
        Image image = new Image(fileList[currentIndex].toURI().toString());
        imageView.setImage( image );
    }
}
