package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.manager_PhieuMuon;
import manager.manager_PhieuPhat;
import manager.manager_PhieuTra;
import model.model_PhieuMuon;
import model.model_PhieuPhat;
import model.model_PhieuTra;


public class PhieuPhatController implements Initializable {

    static ObservableList<model_PhieuPhat> phieuphatListController = FXCollections.observableArrayList();
    public TableView <model_PhieuPhat> tableDanhsach;
	@FXML
	private TableColumn<model_PhieuPhat,String> colMaphieuphat;
    @FXML
    private TableColumn<model_PhieuPhat,String> colMaphieumuon;
    @FXML
    private TableColumn<model_PhieuPhat,Integer> colMadg;
    @FXML
    private TableColumn<model_PhieuPhat,Integer> colMatl ;
    @FXML
    private TableColumn<model_PhieuPhat,String> colManv;
    
    @FXML
    private TableColumn<model_PhieuPhat,String> colNgaylap;
    @FXML
    private TableColumn<model_PhieuPhat,String> colTienphat;
    
	 public TextField tfMa;
	 public String  madocgia;


	public void initialize(URL arg0, ResourceBundle arg1) {
	
		phieuphatListController.clear();
		phieuphatListController.addAll(manager_PhieuPhat.PhieuphatList());
		
		colMaphieuphat.setCellValueFactory(new PropertyValueFactory<model_PhieuPhat,String>("maPhieuPhat") );
		colMaphieumuon.setCellValueFactory(new PropertyValueFactory<model_PhieuPhat,String>("maPhieuMuon"));
		colMadg.setCellValueFactory(new PropertyValueFactory<model_PhieuPhat,Integer>("maDocGia"));
		colMatl.setCellValueFactory(new PropertyValueFactory<model_PhieuPhat,Integer>("maTaiLieu"));
		colManv.setCellValueFactory(new PropertyValueFactory<model_PhieuPhat,String>("maNVLapPhieuPhat"));
		colNgaylap.setCellValueFactory(new PropertyValueFactory<model_PhieuPhat,String>("ngayLapPhieuPhat"));
		colTienphat.setCellValueFactory(new PropertyValueFactory<model_PhieuPhat,String>("soTienPhat"));

		tableDanhsach.setItems(phieuphatListController);
	}
	public void lammoi (ActionEvent event) throws IOException {
		
		initialize(null, null);
			
		 }
	public void timkiem (ActionEvent event) throws IOException {
		
		phieuphatListController.clear();
		 
		madocgia = tfMa.getText();
		int madocgia1=Integer.parseInt(madocgia);
		for(model_PhieuPhat x : manager_PhieuPhat.PhieuphatList()){ 
			
	         if( x.getMaDocGia()==madocgia1){
	        	 phieuphatListController.add(x);
	              
	         }}
		
	 }
	


}
