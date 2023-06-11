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
import manager.manager_DocGia;
import manager.manager_TaiLieu;
import manager.manager_ThuThu;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_NhanVien;
import model.model_TaiLieu;

public class ThuthuController implements Initializable {
	


	public ComboBox<String> cbChooseSearch;
	public  ComboBox<String> cbCatruc;
	
    public TextField tfSearch;
    public Text tfMadocgia;
    public Text tfHoten;
    public Text tfNgaysinh;
    public Text tfDiachi;
    public Text tfSdt;
    public Text tfSachquahan;
    public Text tfSachmuon;
    public Text tfLoaidocgia;
    public Text tfMS;
    public Text tfCMND;
    public Text tfEmail;
    public Text tfTendangnhap;
  
    public String manv;
    public String tennv;

    

	
	
	
	
	
	
	 
	static ObservableList<model_NhanVien> thuthuListController = FXCollections.observableArrayList();
	  
	   public TableView <model_NhanVien> tablethuthu;
	   
	    @FXML
	    private TableColumn<model_NhanVien,String> colMaThuThu;
	    @FXML
	    private TableColumn<model_NhanVien,String> colTenDangNhap;
	    @FXML
	    private TableColumn<model_NhanVien,String> colHoTen;
	    @FXML
	    private TableColumn<model_NhanVien,Integer> colCaTruc;
	    
	    
	    

	

	   

	public void initialize(URL location, ResourceBundle resources) {
	
		 thuthuListController.clear();
		thuthuListController.addAll(manager_ThuThu.ThuthuList());
		
		ObservableList<String> listComboBox1 = FXCollections.observableArrayList("Mã Thủ Thư", "Họ Tên");
		cbChooseSearch.setValue("Mã Thủ Thư");
		cbChooseSearch.setItems(listComboBox1);
		
		ObservableList<String> listComboBox2 = FXCollections.observableArrayList("1", "2","3");
		cbCatruc.setValue("Ca Trực");
		cbCatruc.setItems(listComboBox2);

		colMaThuThu.setCellValueFactory(new PropertyValueFactory<model_NhanVien,String>("manv"));
        colTenDangNhap.setCellValueFactory(new PropertyValueFactory<model_NhanVien,String>("user"));
        colHoTen.setCellValueFactory(new PropertyValueFactory<model_NhanVien,String>("hotennv"));
        colCaTruc.setCellValueFactory(new PropertyValueFactory<model_NhanVien,Integer>("ca"));
        tablethuthu.setItems(thuthuListController);
        
		
	}

	 public void Search (ActionEvent event) throws IOException {
		if((cbChooseSearch.getValue()).equals("Mã Thủ Thư")) {
		 SearchManv();
		 }
		else
		{
			
				 SearchTennv();
				 
		}
		
		
	 }
	 public void lammoi (ActionEvent event) throws IOException {
			
		 initialize(null, null);
			
		 }
	 public void SearchManv() {
		thuthuListController.clear();
		manv = tfSearch.getText();
		for(model_NhanVien x : manager_ThuThu.ThuthuList()){ 
			
	         if( x.getManv().equals(manv)){
	        	 thuthuListController.add(x);
	              
	         }}
		
	 }
	 public void SearchTennv() {
		 
		 thuthuListController.clear();
			tennv = tfSearch.getText();
			for(model_NhanVien x : manager_ThuThu.ThuthuList()){ 
				
		         if( x.getHotennv().equals(tennv)){
		        	 thuthuListController.add(x);
		              
		         }}
			
		 }

 public static int index;
	 public void update (ActionEvent event) throws IOException {
		 
     index= tablethuthu.getSelectionModel().getSelectedIndex();
     if(index==-1) {
			Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn thủ thư.Vui lòng kiểm tra lại!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
	 }else {
     
    	 for(model_NhanVien x : manager_ThuThu.ThuthuList()){ 
 			
             if( x.getManv().equals(colMaThuThu.getCellData(index))){
            	x.setCa(Integer.parseInt(cbCatruc.getValue()));
            	manager_ThuThu.update(x);
            	break;
                  
             }}
		 
		
    	 {
    			Alert alert = new Alert(AlertType.INFORMATION, "Cập nhật thành công!", ButtonType.OK);
    			alert.setHeaderText(null);
    			alert.showAndWait();
    			return;
    	 }	 
        
	 }
	        
     }

	 

	 public void xoa (ActionEvent event) throws IOException {
		 
	     index= tablethuthu.getSelectionModel().getSelectedIndex();
	     if(index==-1) {
				Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn thủ thư.Vui lòng kiểm tra lại!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
		 }else {
	     
	     
	    	 for(model_NhanVien x : manager_ThuThu.ThuthuList()){ 
	 			
	             if( x.getManv().equals(colMaThuThu.getCellData(index))){
	            	manager_ThuThu.delete(x);
	            	break;
	                  
	             }}
			 
	    	 {
	    			Alert alert = new Alert(AlertType.INFORMATION, "Xóa thủ thư thành công!", ButtonType.OK);
	    			alert.setHeaderText(null);
	    			alert.showAndWait();
	    			return;
	    	 }	 
		
		 }
	   
	 }
	

	
}
