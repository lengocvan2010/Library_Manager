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
import javafx.stage.Stage;
import manager.manager_DangNhap;
import manager.manager_DocGia;
import manager.manager_TaiLieu;
import manager.manager_Yeucautl;
import model.model_DangNhap;
import model.model_TaiLieu;
import model.model_Yeucautl;

public class UserYeucautailieuController implements Initializable {



	static ObservableList<model_Yeucautl> tailieuListController = FXCollections.observableArrayList();
	  
	   public TableView <model_Yeucautl> tableyctailieu;
	    @FXML
	    public TableColumn<model_Yeucautl,Integer> colstt;
	    public TableColumn<model_Yeucautl,String> coltrangthai;
	   
	    @FXML
	    public TableColumn<model_Yeucautl,String> colTentailieu;
	    
	    public model_Yeucautl tlyeucau = new model_Yeucautl();
	    
		
	    public TextField tfTentailieu;

	   
	    

	

	   

	    public void initialize(URL location, ResourceBundle resources) {
	    	
	    	
	    tailieuListController.clear();
	    for(model_Yeucautl x:manager_Yeucautl.YeucauList()) {
	    	if(x.getDoituong()==LoginController.docgiadangnhap.getMaDocGia()) {
	    		tailieuListController.add(x);
	    	}
	    }

		colstt.setCellValueFactory(new PropertyValueFactory<model_Yeucautl,Integer>("stt"));
        colTentailieu.setCellValueFactory(new PropertyValueFactory<model_Yeucautl,String>("Tentailieu"));
        coltrangthai.setCellValueFactory(new PropertyValueFactory<model_Yeucautl,String>("trangthai"));
        
        
        tableyctailieu.setItems(tailieuListController);
		
	}
	    public void tkdaxuly (ActionEvent event) throws IOException {
    		tailieuListController.clear();

	    	for(model_Yeucautl x : manager_Yeucautl.YeucauList()){ 
		         if( x.getTrangthai().equals("Đã xử lý")&& x.getDoituong()==LoginController.docgiadangnhap.getMaDocGia()){
		        	 tailieuListController.add(x);
		              
		         }}
			   
				 
				}  


	    public void tkchuaxuly (ActionEvent event) throws IOException {
			
	    	tailieuListController.clear();

	    	for(model_Yeucautl x : manager_Yeucautl.YeucauList() ){ 
		         if( x.getTrangthai().equals("Chưa xử lý")&& x.getDoituong()==LoginController.docgiadangnhap.getMaDocGia()){
		        	 tailieuListController.add(x);
		              
		         }}
			   
			   
			 
		}  
public void tkdangxuly (ActionEvent event) throws IOException {
			
	    	tailieuListController.clear();

	    	for(model_Yeucautl x : manager_Yeucautl.YeucauList()){ 
		         if( x.getTrangthai().equals("Đang xử lý")&& x.getDoituong()==LoginController.docgiadangnhap.getMaDocGia()){
		        	 tailieuListController.add(x);
		              
		         }}
			   
			   
			 
		}  
	    public void xemtatca (ActionEvent event) throws IOException {
			
	    	initialize(null,null);
			   
			 
		}  
	    public int index;
	    public void xoa (ActionEvent event) throws IOException {
	    	
	    	index= tableyctailieu.getSelectionModel().getSelectedIndex();
	    	if(index==-1) {
				Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn tài liệu.Vui lòng kiểm tra lại!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
		 }
	    	if(coltrangthai.getCellData(index).equals("Chưa xử lý")) {

	    	tlyeucau.setStt(colstt.getCellData(index));
	    	
			
		manager_Yeucautl.delete(tlyeucau);	  
		}
	    	else {
	    		Alert alert = new Alert(AlertType.WARNING, "Bạn chỉ có thể xóa yêu cầu chưa được xử lý!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
	    	}
			xemtatca(event);
 
		}  
	    public void yeucau (ActionEvent event) throws IOException {

			if(manager_Yeucautl.YeucauList().size()==0) {
				tlyeucau.setStt(1);
				}
			else
				tlyeucau.setStt(manager_Yeucautl.YeucauList().get(manager_Yeucautl.YeucauList().size()-1).getStt()+1);
	    	
	    	tlyeucau.setTentailieu(tfTentailieu.getText());
	    	tlyeucau.setTrangthai("Chưa xử lý");
	    	tlyeucau.setDoituong(LoginController.docgiadangnhap.getMaDocGia());	
	    	manager_Yeucautl.insert(tlyeucau);
			xemtatca(event);
 
		}  



		

}