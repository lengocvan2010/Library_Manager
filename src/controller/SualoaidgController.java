package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.dao_TaiLieu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.manager_DangNhap;
import manager.manager_LoaiDocGia;
import manager.manager_TaiLieu;
import manager.manager_Yeucautl;
import model.model_DangNhap;
import model.model_LoaiDocGia;
import model.model_TaiLieu;
import model.model_Yeucautl;

public class SualoaidgController implements Initializable {
	public TextField tfSongaymuontoida;
	public TextField tfPhithuongnien;
    public TextField tfTailieudacbiet;
	public TextField tfSosachmuontoida;
	public Text tfTenLoaiDG;
	
	public model_LoaiDocGia loaidocgia1 =new model_LoaiDocGia();



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		

	        
		  tfSongaymuontoida.setText(String.valueOf(LoaidgController.loaidocgia.getSoNgayMuonToiDa()));;
		  tfPhithuongnien.setText(String.valueOf(LoaidgController.loaidocgia.getPhiThuongNien()));;
	      tfTailieudacbiet.setText(String.valueOf(LoaidgController.loaidocgia.getTaiLieuDB()));;
		 tfSosachmuontoida.setText(String.valueOf(LoaidgController.loaidocgia.getSoSachMuonToiDa()));;
	     tfTenLoaiDG.setText(LoaidgController.loaidocgia.getTenLoaiDG());;		
	}
	public void save (ActionEvent event) throws IOException {
		
  loaidocgia1.setPhiThuongNien(Integer.parseInt(tfPhithuongnien.getText()));
  loaidocgia1.setSoNgayMuonToiDa(Integer.parseInt(tfSongaymuontoida.getText()));
  loaidocgia1.setSoSachMuonToiDa(Integer.parseInt(tfSosachmuontoida.getText()));
  loaidocgia1.setTaiLieuDB(Integer.parseInt(tfTailieudacbiet.getText()));
  loaidocgia1.setTenLoaiDG(tfTenLoaiDG.getText());
  manager_LoaiDocGia.update(loaidocgia1);
	   
  {
		Alert alert = new Alert(AlertType.WARNING, "Đã lưu thay đổi loại đôc giả!", ButtonType.OK);
		alert.setHeaderText(null);
		alert.showAndWait();
		return;
	}
		 
		}



	
}