package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class HomeController implements Initializable{
	private Stage stage;
    private Scene scene;
    private Parent root;
    public BorderPane borderPane;
	public Text tfTendangnhap;
	public Text tfDoituong;

public void gotoTailieu (ActionEvent event) throws IOException {

	

//	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//	Parent home = FXMLLoader.load(getClass().getResource("/views/tailieu.fxml"));
//    stage.setScene(new Scene(home));
//    stage.setResizable(false);
//    stage.show();
//
//			Parent home = FXMLLoader.load(getClass().getResource("/views/tailieu.fxml"));
//			Stage stage= new Stage();
//	        stage.setScene(new Scene(home));
//	        stage.setResizable(false);
//	        stage.show();
	       // stage.setCenter();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/tailieu.fxml"));
	Pane thongkePane = (Pane) loader.load();
	borderPane.setCenter(thongkePane);
  
 }
public void gotoDocgia (ActionEvent event) throws IOException {
	
	

//	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//	Parent home = FXMLLoader.load(getClass().getResource("/views/tailieu.fxml"));
//    stage.setScene(new Scene(home));
//    stage.setResizable(false);
//    stage.show();
//
//			Parent home = FXMLLoader.load(getClass().getResource("/views/tailieu.fxml"));
//			Stage stage= new Stage();
//	        stage.setScene(new Scene(home));
//	        stage.setResizable(false);
//	        stage.show();
	       // stage.setCenter();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/docgia.fxml"));
	Pane thongkePane = (Pane) loader.load();
	borderPane.setCenter(thongkePane);
  
 }
public void gotoAdmin (ActionEvent event) throws IOException {
	
	

//	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//	Parent home = FXMLLoader.load(getClass().getResource("/views/tailieu.fxml"));
//    stage.setScene(new Scene(home));
//    stage.setResizable(false);
//    stage.show();
//
//			Parent home = FXMLLoader.load(getClass().getResource("/views/tailieu.fxml"));
//			Stage stage= new Stage();
//	        stage.setScene(new Scene(home));
//	        stage.setResizable(false);
//	        stage.show();
	       // stage.setCenter();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/admin.fxml"));
	Pane thongkePane = (Pane) loader.load();
	borderPane.setCenter(thongkePane);
  
 }
public void gotoQLPhieu (ActionEvent event) throws IOException {
	
	

//	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//	Parent home = FXMLLoader.load(getClass().getResource("/views/tailieu.fxml"));
//    stage.setScene(new Scene(home));
//    stage.setResizable(false);
//    stage.show();
//
//			Parent home = FXMLLoader.load(getClass().getResource("/views/tailieu.fxml"));
//			Stage stage= new Stage();
//	        stage.setScene(new Scene(home));
//	        stage.setResizable(false);
//	        stage.show();
	       // stage.setCenter();
	TimdocgiaController.madocgiatk=0;

	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/qlphieu.fxml"));
	Pane thongkePane = (Pane) loader.load();
	borderPane.setCenter(thongkePane);
  
 }
public void gotoThongKe (ActionEvent event) throws IOException {
	
	

//	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//	Parent home = FXMLLoader.load(getClass().getResource("/views/tailieu.fxml"));
//    stage.setScene(new Scene(home));
//    stage.setResizable(false);
//    stage.show();
//
//			Parent home = FXMLLoader.load(getClass().getResource("/views/tailieu.fxml"));
//			Stage stage= new Stage();
//	        stage.setScene(new Scene(home));
//	        stage.setResizable(false);
//	        stage.show();
	       // stage.setCenter();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/thongke.fxml"));
	Pane thongkePane = (Pane) loader.load();
	borderPane.setCenter(thongkePane);
  
 }
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	tfDoituong.setText("THỦ THƯ");
	tfTendangnhap.setText("Xin chào "+LoginController.current.getUsername());
	
}
public void logout (ActionEvent event) throws IOException {
	
	

	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	Parent home = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
	stage.close();
    stage.setScene(new Scene(home));
    stage.setResizable(false);
    
    stage.show();
	
  
 }
}