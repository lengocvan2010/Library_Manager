package controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TailieuController {
	private Stage stage;
    private Scene scene;
    private Parent root;
    public ComboBox<String> cbChooseSearch;
    public BorderPane borderPane;

   

public void gotoTimtailieu (ActionEvent event) throws IOException {
	
	

	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/timkiemtailieu.fxml"));
	Pane timtlPane = (Pane) loader.load();
	borderPane.setCenter(timtlPane);
 
}
public void gotoThemtailieu (ActionEvent event) throws IOException {
	
	

	

	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/themtailieu.fxml"));
	Pane themtlPane = (Pane) loader.load();
	borderPane.setCenter(themtlPane);
	 
	}
public void gotoYeucautailieu (ActionEvent event) throws IOException {
	
	
	

	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/yeucautailieu.fxml"));
	Pane yeucautlPane = (Pane) loader.load();
	borderPane.setCenter(yeucautlPane);	  
	 
	}


 }


