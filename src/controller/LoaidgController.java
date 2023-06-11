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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.manager_DangNhap;
import manager.manager_DocGia;
import manager.manager_LoaiDocGia;
import manager.manager_TaiLieu;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_LoaiDocGia;
import model.model_TaiLieu;

public class LoaidgController implements Initializable {
	public static model_LoaiDocGia loaidocgia =new model_LoaiDocGia();
	

	
   
   
	
	
	 
	static ObservableList<model_LoaiDocGia> loaidocgiaListController = FXCollections.observableArrayList();
	  
	   public TableView <model_LoaiDocGia> tableloaidocgia;
	   
	    @FXML
	    private TableColumn<model_DocGia,Integer> colPhiThuongNien ;
	    @FXML
	    private TableColumn<model_DocGia,Integer> colSoSachMuonToiDa;
	    @FXML
	    private TableColumn<model_DocGia,Integer> colSoNgayMuonToiDa;
	    @FXML
	    private TableColumn<model_DocGia,String> colTenLoaiDG;
	    @FXML
	    private TableColumn<model_DocGia,Integer> colTaiLieuDB;
	    
	    
	    

	

	   

	public void initialize(URL location, ResourceBundle resources) {
	
		 loaidocgiaListController.clear();
		loaidocgiaListController.addAll(manager_LoaiDocGia.LoaidocgiaList());
		
		
		colPhiThuongNien.setCellValueFactory(new PropertyValueFactory<model_DocGia,Integer>("phiThuongNien"));
        
        colTenLoaiDG.setCellValueFactory(new PropertyValueFactory<model_DocGia,String>("tenLoaiDG"));
        colSoSachMuonToiDa.setCellValueFactory(new PropertyValueFactory<model_DocGia, Integer>("soSachMuonToiDa"));
        colSoNgayMuonToiDa.setCellValueFactory(new PropertyValueFactory<model_DocGia,Integer>("soNgayMuonToiDa"));
        colTaiLieuDB.setCellValueFactory(new PropertyValueFactory<model_DocGia,Integer>("taiLieuDB"));

         tableloaidocgia.setItems(loaidocgiaListController);
        
		
	}

	
	 public void lammoi (ActionEvent event) throws IOException {
			
		 initialize(null, null);
			
		 }
	
	    
	 static int index;
	 
	 public void update (ActionEvent event) throws IOException {
		 
     index= tableloaidocgia.getSelectionModel().getSelectedIndex();
     if(index==-1) {
			Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn loại độc giả.Vui lòng kiểm tra lại!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
	 }
     
    	 for(model_LoaiDocGia x : manager_LoaiDocGia.LoaidocgiaList()){ 
 			
             if( x.getTenLoaiDG().equals(colTenLoaiDG.getCellData(index))){
            	loaidocgia=x;
                  
             }}
		 
		
	    Parent home = FXMLLoader.load(getClass().getResource("/views/sualoaidg.fxml"));
		Stage stage= new Stage();
        stage.setScene(new Scene(home));
        stage.setResizable(false);
        stage.show();
        
        
	        
     
     
			
	 }

	

	
}
