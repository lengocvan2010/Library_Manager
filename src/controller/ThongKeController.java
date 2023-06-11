package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ThongKeController {
	public  BorderPane borderPane;

public void gotoSachMuonNhieuNhat (ActionEvent event) throws IOException {
		
		

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/tksachmuonnhieunhat.fxml"));
		Pane timdgPane = (Pane) loader.load();
		borderPane.setCenter(timdgPane);
	 
	}
public void gotoThongKeTaiLieu (ActionEvent event) throws IOException {
	
	
//ThongKeTaiLieuController.piechartloaidocgia.getData().clear();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/thongketailieu.fxml"));
	Pane timdgPane = (Pane) loader.load();
	borderPane.setCenter(timdgPane);
 
}
public void gotoThongKeDocGia (ActionEvent event) throws IOException {
	
	

	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/thongkedocgia.fxml"));
	Pane timdgPane = (Pane) loader.load();
	borderPane.setCenter(timdgPane);
 
}
}
