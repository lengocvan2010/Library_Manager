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
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.manager_DangNhap;
import manager.manager_DocGia;
import manager.manager_PhieuMuon;
import manager.manager_TaiLieu;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_PhieuMuon;
import model.model_TaiLieu;

public class TimPhieuMuonController implements Initializable {
	
	public ComboBox<String> cbTimkiem;
	//table
	public TableView <model_PhieuMuon> tableDanhsach;
	@FXML
	private TableColumn<model_PhieuMuon,String> colMaphieu;
    @FXML
    private TableColumn<model_PhieuMuon,Integer> colMatl;
    @FXML
    
    private TableColumn<model_PhieuMuon,Integer> colMadg ;
    @FXML
    private TableColumn<model_PhieuMuon,String> colTrangthai;
    @FXML
    private TableColumn<model_PhieuMuon,String> colTendg;
    @FXML
    private TableColumn<model_PhieuMuon,String> colNgaymuon;
    
    static ObservableList<model_PhieuMuon> phieumuonListController = FXCollections.observableArrayList();
    
    public String  madocgia;
	public String  maphieumuon;
	 public TextField tfMa;
	 public static int madocgia1;
	 
	 public static int matailieuchon;

	 public static String maphieumuonchon;

	 

	public void initialize(URL location, ResourceBundle resources) {
		phieumuonListController.clear();
		phieumuonListController.addAll(manager_PhieuMuon.PhieumuonList());
		ObservableList<String> listComboBox1 = FXCollections.observableArrayList("Mã Phiếu Mượn", "Mã Độc Giả");
		cbTimkiem.setValue("Mã Phiếu Mượn");
		cbTimkiem.setItems(listComboBox1);
		
		colMaphieu.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,String>("maPhieuMuon") );
	    colMatl.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,Integer>("maTaiLieu"));
		colMadg.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,Integer>("maDocGia"));
		colTrangthai.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,String>("trangThai"));
		colTendg.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,String>("hoTen"));
		colNgaymuon.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,String>("ngayLapPhieu"));
		tableDanhsach.setItems(phieumuonListController);
	}

	public void timkiem (ActionEvent event) throws IOException {
		if((cbTimkiem.getValue()).equals("Mã Độc Giả")) {
		 SearchMadg();
		 }
		else
		{
			
					 SearchMapm();
				
		}
		
		
	 }
	 
	 public void SearchMadg() {
		phieumuonListController.clear();
		 
		madocgia = tfMa.getText();
		int madocgia1=Integer.parseInt(madocgia);
		for(model_PhieuMuon x : manager_PhieuMuon.PhieumuonList()){ 
			
	         if( x.getMaDocGia()==madocgia1){
	        	 phieumuonListController.add(x);
	              
	         }}
		
	 }
	 public void SearchMapm() {
		 
		 phieumuonListController.clear();
		 
			maphieumuon = tfMa.getText();
			
			for(model_PhieuMuon x : manager_PhieuMuon.PhieumuonList()){ 
				
		         if( x.getMaPhieuMuon().equals(maphieumuon)){
		        	 phieumuonListController.add(x);
		              
		         }}
			
		 }
	 
	 public void lammoi (ActionEvent event) throws IOException {
			
		 initialize(null, null);
			
		 }
	 public int index;
	 public void lapphieutra (ActionEvent event) throws IOException {
			
		 index= tableDanhsach.getSelectionModel().getSelectedIndex();
		 if(index==-1) {
				Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn phiếu mượn.Vui lòng kiểm tra lại!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
		 }
         madocgia1 = colMadg.getCellData(index);

         Parent home = FXMLLoader.load(getClass().getResource("/views/taophieutra.fxml"));
	 		Stage stage= new Stage();
	         stage.setScene(new Scene(home));
	         stage.setResizable(false);
	         stage.show();
		 }
	 public void chitiet (ActionEvent event) throws IOException {
			
		 index= tableDanhsach.getSelectionModel().getSelectedIndex();
		 if(index==-1) {
				Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn phiếu mượn.Vui lòng kiểm tra lại!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
		 }
         matailieuchon= colMatl.getCellData(index);
         maphieumuonchon=colMaphieu.getCellData(index);

         Parent home = FXMLLoader.load(getClass().getResource("/views/chitietphieumuon.fxml"));
	 		Stage stage= new Stage();
	         stage.setScene(new Scene(home));
	         stage.setResizable(false);
	         stage.show();
		 }

	
}
