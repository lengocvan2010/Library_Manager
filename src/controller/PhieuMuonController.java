package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PhieuMuonController {
	public BorderPane borderPane;
	public void gotoThemPhieuMuon (ActionEvent event) throws IOException {
		TimPhieuMuonController.madocgia1=0;


			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/taophieumuon.fxml"));
			Pane timdgPane = (Pane) loader.load();
			borderPane.setCenter(timdgPane);
		 
		}
	public void gotoTimPhieuMuon (ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/timphieumuon.fxml"));
		Pane timdgPane = (Pane) loader.load();
		borderPane.setCenter(timdgPane);
	 
	}

}
