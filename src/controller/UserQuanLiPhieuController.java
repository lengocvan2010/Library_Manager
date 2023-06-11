package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;



public class UserQuanLiPhieuController {
	public BorderPane borderPane;
	public void gotoPhieuMuon (ActionEvent event) throws IOException {
			

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/userphieumuon.fxml"));
			Pane timdgPane = (Pane) loader.load();
			borderPane.setCenter(timdgPane);
		 
		}
	public void gotoPhieuTra (ActionEvent event) throws IOException {
		

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/userphieutra.fxml"));
		Pane timdgPane = (Pane) loader.load();
		borderPane.setCenter(timdgPane);
	 
	}
public  void gotoPhieuPhat (ActionEvent event) throws IOException {
		

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/userphieuphat.fxml"));
		Pane timdgPane = (Pane) loader.load();
		borderPane.setCenter(timdgPane);
	 
	}
public void gotoPhieuNhacNho (ActionEvent event) throws IOException {
	

	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/userphieunhacnho.fxml"));
	Pane timdgPane = (Pane) loader.load();
	borderPane.setCenter(timdgPane);
 
}
	
		}


