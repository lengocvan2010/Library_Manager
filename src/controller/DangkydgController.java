package controller;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.DatePicker;
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
import manager.manager_DocGia;
import manager.manager_TaiLieu;
import manager.manager_Yeucautl;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_TaiLieu;
import model.model_Yeucautl;

public class DangkydgController implements Initializable {
	public ComboBox<String> cbLoai;
	public ComboBox<String> cbMa;
	public Text tfMadocgia;
	public TextField tfTendangnhap; 
	public TextField tfMatkhau;
	public TextField tfMatkhau1;
	public TextField tfHoten;
	public DatePicker dtNgaysinh;
	public TextField tfEmail;
	public TextField tfCMND;
	public TextField tfMS;
	public TextField tfSdt;
	public TextField tfDiachi;
	public model_DangNhap dangnhap= new model_DangNhap();
	public model_DocGia docgia= new model_DocGia();
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<String> listComboBox1 = FXCollections.observableArrayList("MSSV", "MCB","MSSV/MCB");
		cbMa.setValue("MSSV/MCB");
		cbMa.setItems(listComboBox1);
		
		ObservableList<String> listComboBox2 = FXCollections.observableArrayList("Cán bộ", "Sinh viên", "Khách");
		cbLoai.setValue("Loại Độc Giả");
		cbLoai.setItems(listComboBox2);
		
		if(manager_DocGia.DocgiaList().size()==0) {
			tfMadocgia.setText("1" );
		}
		else
	tfMadocgia.setText(String.valueOf(manager_DocGia.DocgiaList().get(manager_DocGia.DocgiaList().size()-1).getMaDocGia()+1) );	
	
	
	}
	
	public void checkloai (ActionEvent event) throws IOException {
		if (cbLoai.getValue().equals("Khách")) {
			cbMa.setValue("MSSV/MCB");
		}else 
			if (cbLoai.getValue().equals("Sinh viên")) {
			cbMa.setValue("MSSV");
		}else
			if (cbLoai.getValue().equals("Cán bộ")) {
			cbMa.setValue("MCB");
		}
		
	}
public void dangky (ActionEvent event) throws IOException {
	System.out.print(100);

	boolean check =true;
	dangnhap.setUsername(tfTendangnhap.getText());
	if(tfTendangnhap.getText().equals("")) {
		check=false;
		
	}
	dangnhap.setDoiTuong("user");
	dangnhap.setPassword(tfMatkhau.getText());
	if(tfMatkhau.getText().equals("")) {
		check=false;
		
	}
	
	
	
	docgia.setCMND(tfCMND.getText());
	if(tfCMND.getText().equals("")) {
		check=false;
		
	}
	docgia.setDiaChi(tfDiachi.getText());
	if(tfDiachi.getText().equals("")) {
		check=false;
		
	}
	docgia.setEmail(tfEmail.getText());
	if(tfEmail.getText().equals("")) {
		check=false;
		
	}
	docgia.setLoai(cbLoai.getValue());
	if(cbLoai.getValue().equals("")) {
		check=false;
		
	}
	docgia.setMaDocGia(Integer.parseInt(tfMadocgia.getText()));
	
	
	if(cbMa.getValue().equals("MSSV")) {
		docgia.setMSSV(tfMS.getText());
		docgia.setMCB("");
	}
	else {
		if(cbMa.getValue().equals("MCB")) {
			docgia.setMCB(tfMS.getText());
			docgia.setMSSV("");
		}
	}
	docgia.setNgaySinh(String.valueOf(dtNgaysinh.getValue()));
	if(dtNgaysinh==null) {
		check=false;
		
	}
	System.out.print(dtNgaysinh);
	docgia.setSachdangmuon(0);
	
	docgia.setSachquahan(0);
	
	docgia.setSDT(tfSdt.getText());
	if(tfSdt.getText().equals("")) {
		check=false;
		
	}
	docgia.setTenDocGia(tfHoten.getText());
	if(tfHoten.getText().equals("")) {
		check=false;
		
	}
	docgia.setUserName(tfTendangnhap.getText());
	if(tfTendangnhap.getText().equals("")) {
		check=false;
		
	}
	if(check==false) {
		System.out.print(10);
		Alert alert = new Alert(AlertType.WARNING, "Vui lòng nhập đầy đủ thông tin!", ButtonType.OK);
	    alert.setHeaderText(null);
	    alert.showAndWait();
	    return;
	}
	else {
		if(tfCMND.getText().length()!=12) {
			Alert alert = new Alert(AlertType.WARNING, "CCCD phải gồm 12 số!", ButtonType.OK);
		    alert.setHeaderText(null);
		    alert.showAndWait();
		    return;
		}else {
			if(tfMatkhau.getText().length()<8) {
				Alert alert = new Alert(AlertType.WARNING, "Mật khẩu phải có ít nhất 8 ký tự!", ButtonType.OK);
			    alert.setHeaderText(null);
			    alert.showAndWait();
			    return;
			}else {
	manager_DangNhap.Insert(dangnhap);
	manager_DocGia.Insert(docgia);
	Alert alert = new Alert(AlertType.INFORMATION, "Đăng ký độc giả thành công!", ButtonType.OK);
    alert.setHeaderText(null);
    alert.showAndWait();
    return;}}}
		
	}




	
}











