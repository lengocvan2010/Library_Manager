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

public class AdminController {
	private Stage stage;
    private Scene scene;
    private Parent root;
    public ComboBox<String> cbChooseSearch;
    public BorderPane borderPane;

   

public void gotoLoaidg (ActionEvent event) throws IOException {
	
	

	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/loaidg.fxml"));
	Pane timtlPane = (Pane) loader.load();
	borderPane.setCenter(timtlPane);
 
}
public void gotoThuthu (ActionEvent event) throws IOException {
	
	

	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/thuthu.fxml"));
	Pane timtlPane = (Pane) loader.load();
	borderPane.setCenter(timtlPane);
 
}
public void gotoDkthuthu (ActionEvent event) throws IOException {
	
	

	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/dangkythuthu.fxml"));
	Pane timtlPane = (Pane) loader.load();
	borderPane.setCenter(timtlPane);
 
}




 }


