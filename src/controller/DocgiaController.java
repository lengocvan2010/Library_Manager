package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;



public class DocgiaController {
	public  BorderPane borderPane;
	public void gotoTimkiemdocgia (ActionEvent event) throws IOException {
			
			

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/timkiemdocgia.fxml"));
			Pane timdgPane = (Pane) loader.load();
			borderPane.setCenter(timdgPane);
		 
		}
	public void gotoThemdocgia (ActionEvent event) throws IOException {
		
		

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/dangkydocgia.fxml"));
		Pane timdgPane = (Pane) loader.load();
		borderPane.setCenter(timdgPane);
	 
	}
		}


