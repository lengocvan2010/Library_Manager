package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PhieuTraController {
	public BorderPane borderPane;
	public void gotoThemPhieuTra (ActionEvent event) throws IOException {
            TimPhieuMuonController.madocgia1=0;

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/taophieutra.fxml"));
			Pane timdgPane = (Pane) loader.load();
			borderPane.setCenter(timdgPane);
		 
		}
	public void gotoTimPhieuTra (ActionEvent event) throws IOException {
		

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/timphieutra.fxml"));
		Pane timdgPane = (Pane) loader.load();
		borderPane.setCenter(timdgPane);
	 
	}

}
