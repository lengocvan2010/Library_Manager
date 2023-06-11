package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import manager.manager_PhieuMuon;
import manager.manager_PhieuTra;
import model.model_PhieuMuon;
import model.model_PhieuTra;


public class TimPhieuTraController implements Initializable {

    static ObservableList<model_PhieuTra> phieutraListController = FXCollections.observableArrayList();
	public TableView <model_PhieuTra> tableDanhsach;
	@FXML
	private TableColumn<model_PhieuTra,String> colMaphieutra;
    @FXML
    private TableColumn<model_PhieuTra,String> colMaphieumuon;
    @FXML
    private TableColumn<model_PhieuTra,Integer> colMadg;
    @FXML
    private TableColumn<model_PhieuTra,Integer> colMatl ;
    @FXML
    private TableColumn<model_PhieuTra,String> colTentl;
    
    @FXML
    private TableColumn<model_PhieuTra,String> colNgaytra;
    
	 public TextField tfMa;
	 public String  madocgia;
	 public int index;
	 public static String maphieutrachon1;
	 public static int matailieuchon1;



	public void initialize(URL arg0, ResourceBundle arg1) {
	
		phieutraListController.clear();
		phieutraListController.addAll(manager_PhieuTra.PhieutraList());
		
		colMaphieutra.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("maPhieuTra") );
		colMaphieumuon.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("maPhieuMuon"));
		colMadg.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,Integer>("maDocGia"));
		colMatl.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,Integer>("maTaiLieu"));
		colTentl.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("tenTaiLieu"));
		colNgaytra.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("ngayTra"));
		tableDanhsach.setItems(phieutraListController);
	}
	public void lammoi (ActionEvent event) throws IOException {
		
		initialize(null, null);
			
		 }
	public void timkiem (ActionEvent event) throws IOException {
		
		phieutraListController.clear();
		 
		madocgia = tfMa.getText();
		int madocgia1=Integer.parseInt(madocgia);
		for(model_PhieuTra x : manager_PhieuTra.PhieutraList()){ 
			
	         if( x.getMaDocGia()==madocgia1){
	        	 phieutraListController.add(x);
	              
	         }}
		
	 }
	public void chitiet (ActionEvent event) throws IOException {
		
		 index= tableDanhsach.getSelectionModel().getSelectedIndex();
		 if(index==-1) {
				Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn phiếu trả.Vui lòng kiểm tra lại!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
		 }
         matailieuchon1= colMatl.getCellData(index);
         maphieutrachon1=colMaphieutra.getCellData(index);

         Parent home = FXMLLoader.load(getClass().getResource("/views/chitietphieutra.fxml"));
	 		Stage stage= new Stage();
	         stage.setScene(new Scene(home));
	         stage.setResizable(false);
	         stage.show();
		
	 }


}
