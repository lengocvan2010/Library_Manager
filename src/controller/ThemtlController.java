package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import manager.manager_DocGia;
import manager.manager_TaiLieu;
import model.model_TaiLieu;

public class ThemtlController implements Initializable{
	public Text tfMatl;
	public ComboBox<String> cbTailieudb;
	public model_TaiLieu tailieu= new model_TaiLieu();
	public TextField tfLoaitailieu;
	public TextField tfTentailieu;
	public TextField tfSoluong;

	


	public void initialize(URL arg0, ResourceBundle arg1) { 
		//xu ly combobox
		
		ObservableList<String> listComboBox1 = FXCollections.observableArrayList("Có", "Không");
		cbTailieudb.setValue("Không");
		cbTailieudb.setItems(listComboBox1);
		
		//xu ly ma tl
		if(manager_TaiLieu.TailieuList().size()==0) {
			tfMatl.setText("1" );
		}
		else
	tfMatl.setText(String.valueOf(manager_TaiLieu.TailieuList().get(manager_TaiLieu.TailieuList().size()-1).getMatl()+1) );
		
		
	}
	
	public void them (ActionEvent event) throws IOException {
		if(tfLoaitailieu.getText().equals("")||tfMatl.getText().equals("")||tfSoluong.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING, "Bạn chưa nhập đủ thông tin. Vui lòng kiểm tra lại!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		} else {
		tailieu.setLoaitl(tfLoaitailieu.getText());
		tailieu.setMatl(Integer.parseInt(tfMatl.getText()));
		tailieu.setSldangmuon(0);
		tailieu.setSoluongcon(Integer.parseInt(tfSoluong.getText()));
		tailieu.setTentl(tfTentailieu.getText());
		if(cbTailieudb.getValue().equals("Có")) {
		tailieu.setTldb(1);
		}
		else 		tailieu.setTldb(0);
		
		manager_TaiLieu.insert(tailieu);

		 }
		
		Alert alert = new Alert(AlertType.INFORMATION, "Thêm tài liệu thành công!", ButtonType.OK);
	    alert.setHeaderText(null);
	    alert.showAndWait();
	    return;}

	
}
