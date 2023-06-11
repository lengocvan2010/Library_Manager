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
import javafx.stage.Stage;
import manager.manager_DangNhap;
import manager.manager_TaiLieu;
import manager.manager_TaiLieuYeuThich;
import model.model_DangNhap;
import model.model_TaiLieu;
import model.model_TaiLieuYeuThich;

public class UserTKTaiLieuController implements Initializable {


	public ComboBox<String> cbChooseSearch;
    public TextField tfSearch;

	
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
	 public model_TaiLieuYeuThich tailieuyeuthich =new model_TaiLieuYeuThich();

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
	    
	    

	

	   

	public void initialize(URL location, ResourceBundle resources) {
		 tailieuListController.clear();
		tailieuListController.addAll(manager_TaiLieu.TailieuList());
		ObservableList<String> listComboBox = FXCollections.observableArrayList("Mã Tài Liệu", "Tên Tài Liệu", "Loại Tài Liệu");

		cbChooseSearch.setValue("Mã Tài Liệu");
		cbChooseSearch.setItems(listComboBox);
		colMaTaiLieu.setCellValueFactory(new PropertyValueFactory<model_TaiLieu,Integer>("matl"));
        colTenTaiLieu.setCellValueFactory(new PropertyValueFactory<model_TaiLieu,String>("tentl"));
        colLoaiTaiLieu.setCellValueFactory(new PropertyValueFactory<model_TaiLieu,String>("loaitl"));
        colSoLuongCon.setCellValueFactory(new PropertyValueFactory<model_TaiLieu, Integer>("soluongcon"));
        colTLDacBiet.setCellValueFactory(new PropertyValueFactory<model_TaiLieu,Integer>("tldb"));
         tabletailieu.setItems(tailieuListController);
        
		
	}

	 public void Search (ActionEvent event) throws IOException {
		if((cbChooseSearch.getValue()).equals("Mã Tài Liệu")) {
		 SearchMatl();
		 }
		else
		{
			if((cbChooseSearch.getValue()).equals("Tên Tài Liệu")) {
				 SearchTentl();
				 } else {
					 SearchLoaitl();
				 }
		}
		
		
	 }
	 public void lammoi (ActionEvent event) throws IOException {
			
		 initialize(null, null);
			
		 }
	 public void SearchMatl() {
		tailieuListController.clear();
		matl = tfSearch.getText();
		int matl1=Integer.parseInt(matl);
		for(model_TaiLieu x : manager_TaiLieu.TailieuList()){ 
			
	         if( x.getMatl()==matl1){
	        	 tailieuListController.add(x);
	              
	         }}
		
	 }
	 public void SearchTentl() {
		 
			tailieuListController.clear();
			tentl = tfSearch.getText();
			
			for(model_TaiLieu x : manager_TaiLieu.TailieuList()){ 
				
		         if( x.getTentl().equals(tentl)){
		        	 tailieuListController.add(x);
		              
		         }}
			
		 }
	 public void SearchLoaitl() {
			tailieuListController.clear();
			loaitl = tfSearch.getText();
			
			for(model_TaiLieu x : manager_TaiLieu.TailieuList()){ 
				
		         if( x.getLoaitl().equals(loaitl)){
		        	 tailieuListController.add(x);
		              
		         }}
			
		 }
	 static int index;
	 
	 public void xemchitiet (ActionEvent event) throws IOException {
		 index= tabletailieu.getSelectionModel().getSelectedIndex();
		 if(index==-1) {
				Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn tài liệu.Vui lòng kiểm tra lại!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
		 }
		 textTentl =(colTenTaiLieu.getCellData(index));
		 textMatl=(colMaTaiLieu.getCellData(index));
		 textLoaitl =(colLoaiTaiLieu.getCellData(index));
		 textSoluongcon =(colSoLuongCon.getCellData(index));
		 textTldb =(colTLDacBiet.getCellData(index));
	    Parent home = FXMLLoader.load(getClass().getResource("/views/chitiettailieu.fxml"));
		Stage stage= new Stage();
        stage.setScene(new Scene(home));
        stage.setResizable(false);
        stage.show();
	        
			
			
	 }

	 public void themyeuthich (ActionEvent event) throws IOException {
		 index= tabletailieu.getSelectionModel().getSelectedIndex();
		 if(index==-1) {
				Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn tài liệu.Vui lòng kiểm tra lại!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
		 }
	   tailieuyeuthich.setMaDocGia(LoginController.docgiadangnhap.getMaDocGia());
	   tailieuyeuthich.setMaTaiLieu(colMaTaiLieu.getCellData(index));
	   tailieuyeuthich.setTenTaiLieu(colTenTaiLieu.getCellData(index));
	  
	   
	   manager_TaiLieuYeuThich.insert(tailieuyeuthich);;
	 }

	
}

