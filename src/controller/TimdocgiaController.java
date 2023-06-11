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
import model.model_DangNhap;
import model.model_DocGia;
import model.model_TaiLieu;

public class TimdocgiaController implements Initializable {
	public static model_DocGia docgia =new model_DocGia();
	public static model_DangNhap dangnhap =new model_DangNhap();


	public ComboBox<String> cbChooseSearch;
	public  ComboBox<String> cbPhieu;
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
    public static String update;
    public static String phieu;
    
    

	
	public String  madocgia;
	public static int  madocgiatk;
	public String  tendocgia;
	public String  CMND;
	
	
	
	 
	static ObservableList<model_DocGia> docgiaListController = FXCollections.observableArrayList();
	  
	   public TableView <model_DocGia> tabledocgia;
	   
	    @FXML
	    private TableColumn<model_DocGia,Integer> colMaDocGia;
	    @FXML
	    private TableColumn<model_DocGia,String> colHoTen;
	    @FXML
	    private TableColumn<model_DocGia,String> colCMND;
	    @FXML
	    private TableColumn<model_DocGia,String> colLoaiDocGia;
	    @FXML
	    private TableColumn<model_DocGia,Integer> colSoSachMuon;
	    @FXML
	    private TableColumn<model_DocGia,Integer> colQuaHan;
	    
	    

	

	   

	public void initialize(URL location, ResourceBundle resources) {
	
		 docgiaListController.clear();
		docgiaListController.addAll(manager_DocGia.DocgiaList());
		ObservableList<String> listComboBox1 = FXCollections.observableArrayList("Mã Độc Giả", "Tên Độc Giả", "CMND/CCCD");
		cbChooseSearch.setValue("Mã Độc Giả");
		cbChooseSearch.setItems(listComboBox1);
		
		
		
		ObservableList<String> listComboBox3 = FXCollections.observableArrayList("Phiếu Mượn","Phiếu Trả");
		cbPhieu.setValue("Phiếu Mượn");
		cbPhieu.setItems(listComboBox3);
		
		colMaDocGia.setCellValueFactory(new PropertyValueFactory<model_DocGia,Integer>("MaDocGia"));
        colHoTen.setCellValueFactory(new PropertyValueFactory<model_DocGia,String>("TenDocGia"));
        colCMND.setCellValueFactory(new PropertyValueFactory<model_DocGia,String>("CMND"));
        colLoaiDocGia.setCellValueFactory(new PropertyValueFactory<model_DocGia,String>("Loai"));
        colSoSachMuon.setCellValueFactory(new PropertyValueFactory<model_DocGia, Integer>("Sachdangmuon"));
        colQuaHan.setCellValueFactory(new PropertyValueFactory<model_DocGia,Integer>("Sachquahan"));
         tabledocgia.setItems(docgiaListController);
        
		
	}

	 public void Search (ActionEvent event) throws IOException {
		if((cbChooseSearch.getValue()).equals("Mã Độc Giả")) {
		 SearchMadg();
		 }
		else
		{
			if((cbChooseSearch.getValue()).equals("Tên Độc Giả")) {
				 SearchTendg();
				 } else {
					 SearchCMND();
				 }
		}
		
		
	 }
	 public void lammoi (ActionEvent event) throws IOException {
			
		 initialize(null, null);
			
		 }
	 public void SearchMadg() {
		docgiaListController.clear();
		madocgia = tfSearch.getText();
		int madocgia1=Integer.parseInt(madocgia);
		for(model_DocGia x : manager_DocGia.DocgiaList()){ 
			
	         if( x.getMaDocGia()==madocgia1){
	        	 docgiaListController.add(x);
	              
	         }}
		
	 }
	 public void SearchTendg() {
		 
			docgiaListController.clear();
			tendocgia = tfSearch.getText();
			
			for(model_DocGia x : manager_DocGia.DocgiaList()){ 
				
		         if( x.getTenDocGia().equals(tendocgia)){
		        	 docgiaListController.add(x);
		              
		         }}
			
		 }
	 public void SearchCMND() {
			docgiaListController.clear();
			CMND = tfSearch.getText();
			
			for(model_DocGia x : manager_DocGia.DocgiaList()){ 
				
		         if( x.getCMND().equals(CMND)){
		        	 docgiaListController.add(x);
		              
		         }}
			
		 }
	 
	    
	    
	 static int index;
	 public void select1 (ActionEvent event) throws IOException {
		 index= tabledocgia.getSelectionModel().getSelectedIndex();
		 if(index==-1) {
				Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn độc giả.Vui lòng kiểm tra lại!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
		 }
		 for(model_DocGia x : manager_DocGia.DocgiaList()){ 
				
	         if( x.getMaDocGia()==colMaDocGia.getCellData(index)){
	        	docgia=x;
	              
	         }}
		
	        
	        
		
	    Parent home = FXMLLoader.load(getClass().getResource("/views/chitietdocgia.fxml"));
		Stage stage= new Stage();
        stage.setScene(new Scene(home));
        stage.setResizable(false);
        stage.show();
        
        
	        
			
			
 }
	
			
	 

	 public void xoa (ActionEvent event) throws IOException {
		 index= tabledocgia.getSelectionModel().getSelectedIndex();
		 if(index==-1) {
				Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn độc giả.Vui lòng kiểm tra lại!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
		 }
		 for(model_DocGia x : manager_DocGia.DocgiaList()){ 
	  			
             if( x.getMaDocGia()==colMaDocGia.getCellData(index)){
            	 docgia=x;
            	
            	 for(model_DangNhap y : manager_DangNhap.DangnhapList()){ 
          			
                     if( y.getUsername().equals(x.getUserName())){
                    	dangnhap=y;
                          
                     }} 
             }}
		
	   manager_DocGia.delete(docgia);
	   manager_DangNhap.delete(dangnhap);
	   Alert alert = new Alert(AlertType.WARNING, "Xóa độc giả thành công!", ButtonType.OK);
	    alert.setHeaderText(null);
	    alert.showAndWait();
	    return;
	   
	 }
	 public void lapphieu (ActionEvent event) throws IOException {
		 index= tabledocgia.getSelectionModel().getSelectedIndex();
		 if(index==-1) {
				Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn độc giả.Vui lòng kiểm tra lại!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
		 }
          madocgiatk = colMaDocGia.getCellData(index);
		 if(cbPhieu.getValue().equals("Phiếu Mượn")) {
			 Parent home = FXMLLoader.load(getClass().getResource("/views/taophieumuon.fxml"));
		 		Stage stage= new Stage();
		         stage.setScene(new Scene(home));
		         stage.setResizable(false);
		         stage.show();	 
		 }
		 else {
			 Parent home = FXMLLoader.load(getClass().getResource("/views/taophieutra.fxml"));
		 		Stage stage= new Stage();
		         stage.setScene(new Scene(home));
		         stage.setResizable(false);
		         stage.show();	 
		 }
		 
	   
	 }


	
}
