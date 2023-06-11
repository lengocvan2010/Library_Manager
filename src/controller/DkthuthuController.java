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
import manager.manager_PhieuMuon;
import manager.manager_TaiLieu;
import manager.manager_ThuThu;
import manager.manager_Yeucautl;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_NhanVien;
import model.model_TaiLieu;
import model.model_Yeucautl;

public class DkthuthuController implements Initializable {
	
	public Text tfMathuthu;
	public TextField tfTendangnhap; 
	public TextField tfMatkhau;
	public TextField tfMatkhau1; 

	public TextField tfHoten;
	
	public ComboBox<String> cbCatruc;

	public model_NhanVien thuthu= new model_NhanVien();
	public model_DangNhap dangnhap= new model_DangNhap();	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(manager_ThuThu.ThuthuList().size()==0) {
			tfMathuthu.setText("NV1" );
		}
		else
	        tfMathuthu.setText(xoankytudau(manager_ThuThu.ThuthuList().get(manager_ThuThu.ThuthuList().size()-1).getManv(),2) );	
		
		ObservableList<String> listComboBox2 = FXCollections.observableArrayList("1", "2","3");
		cbCatruc.setValue("Ca Trực");
		cbCatruc.setItems(listComboBox2);
	}
		
	public String xoankytudau (String s, int n) {
		String x="";
		String y="";
		for(int i=0;i<s.length();i++) {
			if(i>=n)
			x=x+s.charAt(i);
			else
			y=y+s.charAt(i);
		}
		x = y + String.valueOf(Integer.parseInt(x)+1);
		return x;
		
	}	
	
public void dangky (ActionEvent event) throws IOException {
	if(tfTendangnhap.getText().equals("")||tfMatkhau.getText().equals("")||tfHoten.getText().equals("")||tfMatkhau1.getText().equals("")||cbCatruc.getValue().equals("Ca Trực")) {
		Alert alert = new Alert(AlertType.WARNING, "Vui lòng điền đầy đủ thông tin và kiểm tra lại!", ButtonType.OK);
		alert.setHeaderText(null);
		alert.showAndWait();
		return;
	}
	if(tfMatkhau.getText().equals(tfMatkhau1.getText())) {
		
	dangnhap.setUsername(tfTendangnhap.getText());
	dangnhap.setPassword(tfMatkhau.getText());
	dangnhap.setDoiTuong("thuthu");
	manager_DangNhap.Insert(dangnhap);
	
	thuthu.setHotennv(tfHoten.getText());
	thuthu.setManv(tfMathuthu.getText());
	thuthu.setCa(Integer.parseInt(cbCatruc.getValue()));
	thuthu.setUser(tfTendangnhap.getText());
	manager_ThuThu.insert(thuthu);
	 {
		Alert alert = new Alert(AlertType.INFORMATION, "Dang ký thành công!", ButtonType.OK);
		alert.setHeaderText(null);
		alert.showAndWait();
		return;
 }
	}
	else {
		Alert alert = new Alert(AlertType.WARNING, "Mật khẩu không trùng khớp. Vui lòng kiểm tra lại!", ButtonType.OK);
		alert.setHeaderText(null);
		alert.showAndWait();
		return;
	}
	}




	
}











