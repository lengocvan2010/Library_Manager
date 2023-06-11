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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

public class chitiettlController implements Initializable {
	public Text tfMatailieu;
	public Text tfTentailieu;
    public Text tfLoaitailieu;
	public Text tfSoluongcon;
	public Text tfTailieudacbiet;
	public model_TaiLieu tailieu =new model_TaiLieu();



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if(LoginController.current.getDoiTuong().equals("thuthu")) {
		
		
	    tfTentailieu.setText(TimtailieuController.textTentl);
	    tfMatailieu.setText(String.valueOf(TimtailieuController.textMatl));
	    tfLoaitailieu.setText(TimtailieuController.textLoaitl);
	    tfSoluongcon.setText(String.valueOf(TimtailieuController.textSoluongcon));
	    tfTailieudacbiet.setText(String.valueOf(TimtailieuController.textTldb));
		}
		else {
	    tfTentailieu.setText(UserTKTaiLieuController.textTentl);
	    tfMatailieu.setText(String.valueOf(UserTKTaiLieuController.textMatl));
	    tfLoaitailieu.setText(UserTKTaiLieuController.textLoaitl);
	    tfSoluongcon.setText(String.valueOf(UserTKTaiLieuController.textSoluongcon));
		tfTailieudacbiet.setText(String.valueOf(UserTKTaiLieuController.textTldb));
		}
	    
	        
		
	}




	
}