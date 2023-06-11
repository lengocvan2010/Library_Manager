package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import manager.manager_DangNhap;
import manager.manager_DocGia;
import manager.manager_TaiLieu;
import model.model_DangNhap;


public class UpdatetkController implements Initializable {
	
	    public TextField tfMKmoi1;
	    public TextField tfMKhientai;
	    public TextField tfMKmoi;
	    public Text tfDoituong;
	    public Text tfTendangnhap;
	    



	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		tfDoituong.setText(LoginController.current.getDoiTuong());
		tfTendangnhap.setText(LoginController.current.getUsername());
		
	}
	public void save (ActionEvent event) throws IOException {
		
		if(!tfMKhientai.getText().equals(LoginController.current.getPassword())) {
			Alert alert = new Alert(AlertType.WARNING, "Mật khẩu không chính xác. Vui lòng kiểm tra lại!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}
		if(tfMKmoi.getText().equals(tfMKhientai.getText())) {
			Alert alert = new Alert(AlertType.WARNING, "Mật khẩu mới trùng với mật khẩu cũ. Vui lòng kiểm tra lại!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}
		if(!tfMKmoi.getText().equals(tfMKmoi1.getText())) {
			Alert alert = new Alert(AlertType.WARNING, "Mật khẩu mới không trùng khớp. Vui lòng kiểm tra lại!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}
		if(tfMKmoi.getText().length()<8) {
			Alert alert = new Alert(AlertType.WARNING, "Mật khẩu phải có ít nhất 8 ký tự. Vui lòng kiểm tra lại!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}
		LoginController.current.setPassword(tfMKmoi.getText());
		manager_DangNhap.Update(LoginController.current);
		
		Alert alert = new Alert(AlertType.INFORMATION, "Bạn đã thay đổi mật khẩu thành công!", ButtonType.OK);
		alert.setHeaderText(null);
		alert.showAndWait();
		return;
		   
			 
			}
	}

