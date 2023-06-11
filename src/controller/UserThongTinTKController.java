package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.manager_TaiLieuYeuThich;
import model.model_DocGia;
import model.model_TaiLieu;

public class UserThongTinTKController implements Initializable {
	
	 public Text tfMadocgia;
	    public Text tfHoten;
	    public Text tfNgaysinh;
	    public Text tfDiachi;
	    public Text tfSdt;
	    public Text tfSachquahan;
	    public Text tfSachmuon;
	    public Text tfLoaidocgia;
	    public Text tfMS;
	    public Text tfCMND;
	    public Text tfEmail;
	    public Text tfTendangnhap;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		 tfMadocgia.setText(String.valueOf(LoginController.docgiadangnhap.getMaDocGia()));
	        tfHoten.setText(LoginController.docgiadangnhap.getTenDocGia());
	        tfNgaysinh.setText(LoginController.docgiadangnhap.getNgaySinh());
	        tfDiachi.setText(LoginController.docgiadangnhap.getDiaChi());
	        tfSdt.setText(LoginController.docgiadangnhap.getSDT());
	        tfSachquahan.setText(String.valueOf(LoginController.docgiadangnhap.getSachquahan()));
	        tfSachmuon.setText(String.valueOf(LoginController.docgiadangnhap.getSachdangmuon()));
	        tfLoaidocgia.setText(LoginController.docgiadangnhap.getLoai());
	        if (!LoginController.docgiadangnhap.getMCB().equals("")) {
	        	tfMS.setText(LoginController.docgiadangnhap.getMCB());
	        	}
	        else {
	        	if(!LoginController.docgiadangnhap.getMSSV().equals("")) {
	        		tfMS.setText(LoginController.docgiadangnhap.getMSSV());
	        	}
	        	else {
	        		tfMS.setText("Trống");
	        	}
	        }
	        tfCMND.setText(LoginController.docgiadangnhap.getCMND());
	        tfEmail.setText(LoginController.docgiadangnhap.getEmail());
	        tfTendangnhap.setText(LoginController.docgiadangnhap.getUserName());
	        


	        
		
	}
	public void doimatkhau (ActionEvent event) throws IOException {
		
		 Parent home = FXMLLoader.load(getClass().getResource("/views/suataikhoan.fxml"));
			Stage stage= new Stage();
	        stage.setScene(new Scene(home));
	        stage.setResizable(false);
	        stage.show();
	        
			 }
	
	
	
	public void updatethongtin (ActionEvent event) throws IOException {
		 Parent home = FXMLLoader.load(getClass().getResource("/views/suadocgia.fxml"));
			Stage stage= new Stage();
	        stage.setScene(new Scene(home));
	        stage.setResizable(false);
	        stage.show();
	 }
	public void lammoi (ActionEvent event) throws IOException {
	initialize(null,null);
	}
	}

