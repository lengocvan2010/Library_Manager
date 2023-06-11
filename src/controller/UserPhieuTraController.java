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
import manager.manager_PhieuNhacNho;
import manager.manager_PhieuTra;
import model.model_PhieuMuon;
import model.model_PhieuNhacNho;
import model.model_PhieuTra;


public class UserPhieuTraController implements Initializable {

    static ObservableList<model_PhieuTra> phieutraListController = FXCollections.observableArrayList();
	public TableView <model_PhieuTra> tableDanhsach;
	@FXML
	private TableColumn<model_PhieuTra,String> colMaphieutra;
    @FXML
    private TableColumn<model_PhieuTra,String> colMaphieumuon;
    @FXML
    
    private TableColumn<model_PhieuTra,Integer> colMatl ;
    @FXML
    private TableColumn<model_PhieuTra,String> colTentl;
    
    @FXML
    private TableColumn<model_PhieuTra,String> colNgaytra;
    @FXML
    private TableColumn<model_PhieuTra,String> colHantra;
    @FXML
    private TableColumn<model_PhieuTra,Integer> colTre ;
    @FXML
    private TableColumn<model_PhieuTra,String> colTinhtrang;
    
	 public TextField tfMa;
	 public int  madocgia;
	 
	 public TextField tfFromNgay;
	 public TextField tfFromThang;
	 public TextField tfFromNam;
	 public TextField tfToNgay;
	 public TextField tfToThang;
	 public TextField tfToNam;


	public void initialize(URL arg0, ResourceBundle arg1) {
	
		 tfFromNgay.setText("");
			tfFromThang.setText("");
			tfFromNam.setText("");
			tfToNgay.setText("");
			tfToThang.setText("");
			tfToNam.setText("");
			phieutraListController.clear();
		for(model_PhieuTra y : manager_PhieuTra.PhieutraList()){ 
			if(y.getMaDocGia()==LoginController.docgiadangnhap.getMaDocGia()) {
				phieutraListController.add(y);
			}
				}
		
		colMaphieutra.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("maPhieuTra") );
		colMaphieumuon.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("maPhieuMuon"));
		colMatl.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,Integer>("maTaiLieu"));
		colTentl.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("tenTaiLieu"));
		colNgaytra.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("ngayTra"));
		colHantra.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("hanTra"));
		colTre.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,Integer>("soNgayTre"));

		colTinhtrang.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("tinhTrangSach"));

		tableDanhsach.setItems(phieutraListController);
	}
	public void lammoi (ActionEvent event) throws IOException {
		
		initialize(null, null);
			
		 }
	public void timkiem (ActionEvent event) throws IOException {
		
		
		phieutraListController.clear();
		 
		madocgia = LoginController.docgiadangnhap.getMaDocGia();
		
		for(model_PhieuTra x : manager_PhieuTra.PhieutraList()){ 
			
	         if( x.getMaDocGia()==madocgia){
	        	 if(CheckNgay(x.getNgayTra()))
	        	 phieutraListController.add(x);
	              
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
