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
import manager.manager_DocGia;
import manager.manager_TaiLieu;


public class UpdatettdgController implements Initializable {
	
	    public Text tfMadocgia;
	    public TextField tfHoten;
	    public TextField tfNgaysinh;
	    public TextField tfDiachi;
	    public TextField tfSdt;
	    public Text tfSachquahan;
	    public Text tfSachmuon;
	    public TextField tfLoaidocgia;
	    public TextField tfMS;
	    public TextField tfCMND;
	    public TextField tfEmail;
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
	public void save (ActionEvent event) throws IOException {
		
		LoginController.docgiadangnhap.setCMND(tfCMND.getText());
		LoginController.docgiadangnhap.setDiaChi(tfDiachi.getText());
		LoginController.docgiadangnhap.setEmail(tfCMND.getText());
		LoginController.docgiadangnhap.setLoai(tfLoaidocgia.getText());
		LoginController.docgiadangnhap.setMaDocGia(Integer.parseInt(tfMadocgia.getText()));
		LoginController.docgiadangnhap.setNgaySinh(tfNgaysinh.getText());
		LoginController.docgiadangnhap.setSachdangmuon(Integer.parseInt(tfSachmuon.getText()));
		LoginController.docgiadangnhap.setSachquahan(Integer.parseInt(tfSachquahan.getText()));
		LoginController.docgiadangnhap.setSDT(tfSdt.getText());
		LoginController.docgiadangnhap.setTenDocGia(tfHoten.getText());
		LoginController.docgiadangnhap.setUserName(tfTendangnhap.getText());
		if (!LoginController.docgiadangnhap.getMCB().equals("")) {
			LoginController.docgiadangnhap.setMCB(tfMS.getText());
        	}
        else {
        	if(!LoginController.docgiadangnhap.getMSSV().equals("")) {
        		LoginController.docgiadangnhap.setMSSV(tfMS.getText());
        	}
        	
        }
		   manager_DocGia.update(LoginController.docgiadangnhap);
		   
		   { Alert alert = new Alert(AlertType.INFORMATION, "Thay đổi thông tin độc giả thành công!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;}
			}
	}

