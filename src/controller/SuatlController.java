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
import manager.manager_TaiLieu;
import manager.manager_Yeucautl;
import model.model_DangNhap;
import model.model_TaiLieu;
import model.model_Yeucautl;

public class SuatlController implements Initializable {
	public TextField tfMatailieu;
	public TextField tfTentailieu;
    public TextField tfLoaitailieu;
	public TextField tfSoluongcon;
	public TextField tfTailieudacbiet;
	
	public model_TaiLieu tailieu =new model_TaiLieu();



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	    tfTentailieu.setText(TimtailieuController.textTentl);
	    tfMatailieu.setText(String.valueOf(TimtailieuController.textMatl));
	    tfLoaitailieu.setText(TimtailieuController.textLoaitl);
	    tfSoluongcon.setText(String.valueOf(TimtailieuController.textSoluongcon));
	    tfTailieudacbiet.setText(String.valueOf(TimtailieuController.textTldb));
	    
	        
		
	}
	public void save (ActionEvent event) throws IOException {
		
	   tailieu.setLoaitl(tfLoaitailieu.getText());
	   tailieu.setMatl(Integer.parseInt(tfMatailieu.getText()));
	   tailieu.setSoluongcon(Integer.parseInt(tfSoluongcon.getText()));
	   tailieu.setTentl(tfTentailieu.getText());
	   tailieu.setTldb(Integer.parseInt(tfTailieudacbiet.getText()));

	   manager_TaiLieu.update(tailieu);
	   Alert alert = new Alert(AlertType.WARNING, "Sửa tài liệu thành công!", ButtonType.OK);
	    alert.setHeaderText(null);
	    alert.showAndWait();
	    return;
		 
		}



	
}