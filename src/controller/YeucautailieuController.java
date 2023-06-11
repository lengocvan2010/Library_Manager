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

public class YeucautailieuController implements Initializable {



	static ObservableList<model_Yeucautl> tailieuListController = FXCollections.observableArrayList();
	  
	   public TableView <model_Yeucautl> tableyctailieu;
	    @FXML
	    public TableColumn<model_Yeucautl,Integer> colstt;
	    public TableColumn<model_Yeucautl,String> coltrangthai;
	    public TableColumn<model_Yeucautl,Integer> colnguoiyc;
	    @FXML
	    public TableColumn<model_Yeucautl,String> colTentailieu;
	    
	    public model_Yeucautl tlyeucau = new model_Yeucautl();
	    
		public ComboBox<String> cbTrangthai;

	   
	    

	

	   

	    public void initialize(URL location, ResourceBundle resources) {
	    	
	    	ObservableList<String> listComboBox = FXCollections.observableArrayList("Đã xử lý","Đang xử lý","Chưa xử lý");
			cbTrangthai.setValue("Đã xử lý");
			cbTrangthai.setItems(listComboBox);
	    	
	    tailieuListController.clear();
		tailieuListController.addAll(manager_Yeucautl.YeucauList());

		colstt.setCellValueFactory(new PropertyValueFactory<model_Yeucautl,Integer>("stt"));
        colTentailieu.setCellValueFactory(new PropertyValueFactory<model_Yeucautl,String>("Tentailieu"));
        colnguoiyc.setCellValueFactory(new PropertyValueFactory<model_Yeucautl,Integer>("doituong"));
        coltrangthai.setCellValueFactory(new PropertyValueFactory<model_Yeucautl,String>("trangthai"));
        
        
        tableyctailieu.setItems(tailieuListController);
		
	}
	    public void tkdaxuly (ActionEvent event) throws IOException {
    		tailieuListController.clear();

	    	for(model_Yeucautl x : manager_Yeucautl.YeucauList()){ 
		         if( x.getTrangthai().equals("Đã xử lý")){
		        	 tailieuListController.add(x);
		              
		         }}
			   
				 
				}  


	    public void tkchuaxuly (ActionEvent event) throws IOException {
			
	    	tailieuListController.clear();

	    	for(model_Yeucautl x : manager_Yeucautl.YeucauList()){ 
		         if( x.getTrangthai().equals("Chưa xử lý")){
		        	 tailieuListController.add(x);
		              
		         }}
			   
			   
			 
		}  
 public void tkdangxuly (ActionEvent event) throws IOException {
			
	    	tailieuListController.clear();

	    	for(model_Yeucautl x : manager_Yeucautl.YeucauList()){ 
		         if( x.getTrangthai().equals("Đang xử lý")){
		        	 tailieuListController.add(x);
		              
		         }}
			   
			   
			 
		}  
 
	    public void xemtatca (ActionEvent event) throws IOException {
			
	    	initialize(null,null);
			   
			 
		}  
	    public int index;
	    public void addtrangthai (ActionEvent event) throws IOException {
	    	index= tableyctailieu.getSelectionModel().getSelectedIndex();
			 if(index==-1) {
					Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn tài liệu.Vui lòng kiểm tra lại!", ButtonType.OK);
					alert.setHeaderText(null);
					alert.showAndWait();
					return;
			 } else {
	    	tlyeucau.setStt(colstt.getCellData(index));
	    	tlyeucau.setTentailieu(colTentailieu.getCellData(index));
	    	tlyeucau.setTrangthai(cbTrangthai.getValue());
	    	tlyeucau.setDoituong(colnguoiyc.getCellData(index));
			
		manager_Yeucautl.update(tlyeucau);	
		
		xemtatca(event);}
			 Alert alert = new Alert(AlertType.INFORMATION, "Cập nhật thành công!", ButtonType.OK);
			    alert.setHeaderText(null);
			    alert.showAndWait();
			    return;	 
		}  



		

}