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
import javafx.stage.Stage;
import manager.manager_DangNhap;
import manager.manager_TaiLieu;
import model.model_DangNhap;
import model.model_TaiLieu;

public class SachMuonNhieuNhatController implements Initializable {
	
	public String  matl;
	public String  tentl;
	public String  loaitl;
	 private Parent root;
	 static String  textTentl;
	 static int  textMatl;
	 static String  textLoaitl;
	 static int  textSoluongcon;
	 static int  textTldb;
	 public model_TaiLieu tailieu =new model_TaiLieu();
	 
	static ObservableList<model_TaiLieu> tailieuListController = FXCollections.observableArrayList();
	  
	   public TableView <model_TaiLieu> tabletailieu;
	   
	    @FXML
	    private TableColumn<model_TaiLieu,Integer> colMaTaiLieu;
	    @FXML
	    private TableColumn<model_TaiLieu,String> colTenTaiLieu;
	    @FXML
	    private TableColumn<model_TaiLieu,String> colLoaiTaiLieu;
	    @FXML
	    private TableColumn<model_TaiLieu,Integer> colSoLuongCon;
	    @FXML
	    private TableColumn<model_TaiLieu,Integer> colTLDacBiet;
	    @FXML
	    private TableColumn<model_TaiLieu,Integer> colSoLuongMuon;

	    
	    

	

	   

	public void initialize(URL location, ResourceBundle resources) {
		 tailieuListController.clear();
		tailieuListController.addAll(manager_TaiLieu.TailieumuonnhieunhatList());

	
		colMaTaiLieu.setCellValueFactory(new PropertyValueFactory<model_TaiLieu,Integer>("matl"));
        colTenTaiLieu.setCellValueFactory(new PropertyValueFactory<model_TaiLieu,String>("tentl"));
        colLoaiTaiLieu.setCellValueFactory(new PropertyValueFactory<model_TaiLieu,String>("loaitl"));
        colSoLuongCon.setCellValueFactory(new PropertyValueFactory<model_TaiLieu, Integer>("soluongcon"));
        colTLDacBiet.setCellValueFactory(new PropertyValueFactory<model_TaiLieu,Integer>("tldb"));
        colSoLuongMuon.setCellValueFactory(new PropertyValueFactory<model_TaiLieu,Integer>("sldangmuon"));
         tabletailieu.setItems(tailieuListController);
        
		
	}

	 
	
}

