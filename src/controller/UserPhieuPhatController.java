package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
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


public class UserPhieuPhatController implements Initializable {

    static ObservableList<model_PhieuPhat> phieuphatListController = FXCollections.observableArrayList();
    public TableView <model_PhieuPhat> tableDanhsach;
	@FXML
	private TableColumn<model_PhieuPhat,String> colMaphieuphat;
    @FXML
    private TableColumn<model_PhieuPhat,String> colMaphieumuon;
    @FXML
    
    private TableColumn<model_PhieuPhat,Integer> colMatl ;
    @FXML
    private TableColumn<model_PhieuPhat,String> colManv;
    
    @FXML
    private TableColumn<model_PhieuPhat,String> colNgaylap;
    @FXML
    private TableColumn<model_PhieuPhat,String> colTienphat;
    
	 public TextField tfFromNgay;
	 public TextField tfFromThang;
	 public TextField tfFromNam;
	 public TextField tfToNgay;
	 public TextField tfToThang;
	 public TextField tfToNam;
	 public int  madocgia;


	public void initialize(URL arg0, ResourceBundle arg1) {
		tfFromNgay.setText("");
		tfFromThang.setText("");
		tfFromNam.setText("");
		tfToNgay.setText("");
		tfToThang.setText("");
		tfToNam.setText("");
	
		for(model_PhieuPhat y : manager_PhieuPhat.PhieuphatList()){ 
			if(y.getMaDocGia()==LoginController.docgiadangnhap.getMaDocGia()) {
				phieuphatListController.add(y);
			}
				}
		
		colMaphieuphat.setCellValueFactory(new PropertyValueFactory<model_PhieuPhat,String>("maPhieuPhat") );
		colMaphieumuon.setCellValueFactory(new PropertyValueFactory<model_PhieuPhat,String>("maPhieuMuon"));

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
		 
		madocgia = LoginController.docgiadangnhap.getMaDocGia();
		
		for(model_PhieuPhat x : manager_PhieuPhat.PhieuphatList()){ 
			
	         if( x.getMaDocGia()==madocgia){
	        	 if(CheckNgay(x.getNgayLapPhieuPhat()))
	        	 phieuphatListController.add(x);
	              
	         }}
		
	 }
	
     public boolean CheckNgay(String s) {
    	Calendar from;
    	from=Calendar.getInstance();
    	from.set(Integer.parseInt(tfFromNam.getText()),Integer.parseInt(tfFromThang.getText()),Integer.parseInt(tfFromNgay.getText()));
    	
    	Calendar to;
    	to=Calendar.getInstance();
    	to.set(Integer.parseInt(tfToNam.getText()),Integer.parseInt(tfToThang.getText()),Integer.parseInt(tfToNgay.getText()));
    	
    	String thanhphan;
    	int c[] = new int[3],k=0;
    	s=s+'-';
    	int index =0;
    	for(int i=0;i<=s.length()-1;i++){
    	
    		if(s.charAt(i)=='-') {
    			thanhphan="";
    			for(int j=index;j<i;j++) {
    				thanhphan+=s.charAt(j);
    				
    				
    			}
    			index=i+1;
    			c[k]=Integer.parseInt(thanhphan);
    			k++;

    		}
    		
    	}
    	Calendar cngaytao;
    	cngaytao=Calendar.getInstance();
    	cngaytao.set(c[0], c[1], c[2]);
    	if (cngaytao.getTimeInMillis()>=from.getTimeInMillis()&&cngaytao.getTimeInMillis()<=to.getTimeInMillis())
    		return true;
    	else
    	return false;
     }

}
