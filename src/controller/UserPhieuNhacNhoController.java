package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import jdbcutil.JDBCUtil;
import manager.manager_DangNhap;
import manager.manager_DocGia;
import manager.manager_PhieuMuon;
import manager.manager_PhieuNhacNho;
import manager.manager_PhieuPhat;
import manager.manager_PhieuTra;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_PhieuMuon;
import model.model_PhieuNhacNho;
import model.model_PhieuPhat;
import model.model_PhieuTra;


public class UserPhieuNhacNhoController implements Initializable {

   static ObservableList<model_PhieuNhacNho> phieunhacnhoListController = FXCollections.observableArrayList();
    public TableView <model_PhieuNhacNho> tableDanhsach;
	@FXML
	private TableColumn<model_PhieuNhacNho,String> colMaphieunhacnho;
    @FXML
    private TableColumn<model_PhieuNhacNho,String> colMaphieumuon;
    
    @FXML
    private TableColumn<model_PhieuNhacNho,Integer> colMatl ;
    @FXML
    private TableColumn<model_PhieuNhacNho,String> colTentl;
    
    @FXML
    private TableColumn<model_PhieuNhacNho,Integer> colThoigiancon;
    @FXML
    private TableColumn<model_PhieuNhacNho,String> colNgaytao;
   
    public model_PhieuNhacNho phieunhacnho1=new model_PhieuNhacNho();
    public TextField tfFromNgay;
	 public TextField tfFromThang;
	 public TextField tfFromNam;
	 public TextField tfToNgay;
	 public TextField tfToThang;
	 public TextField tfToNam;
	 
	 public TextField tfMa;
	 public int  madocgia;
	 public model_PhieuNhacNho phieunhacnho =new model_PhieuNhacNho();
     public model_DocGia docgia1= new model_DocGia();

  

	public void initialize(URL arg0, ResourceBundle arg1) {
		   tfFromNgay.setText("");
			tfFromThang.setText("");
			tfFromNam.setText("");
			tfToNgay.setText("");
			tfToThang.setText("");
			tfToNam.setText("");
			phieunhacnhoListController.clear();
		for(model_PhieuNhacNho y : manager_PhieuNhacNho.PhieunhacnhoList()){ 
			if(y.getMaDocGia()==LoginController.docgiadangnhap.getMaDocGia()) {
				phieunhacnhoListController.add(y);
			}
				}
		
		colMaphieunhacnho.setCellValueFactory(new PropertyValueFactory<model_PhieuNhacNho,String>("maPhieuNhacNho") );
		colMaphieumuon.setCellValueFactory(new PropertyValueFactory<model_PhieuNhacNho,String>("maPhieuMuon"));
		colMatl.setCellValueFactory(new PropertyValueFactory<model_PhieuNhacNho,Integer>("maTaiLieu"));
		colTentl.setCellValueFactory(new PropertyValueFactory<model_PhieuNhacNho,String>("tenTaiLieu"));
		colThoigiancon.setCellValueFactory(new PropertyValueFactory<model_PhieuNhacNho,Integer>("thoiGianCon"));
		colNgaytao.setCellValueFactory(new PropertyValueFactory<model_PhieuNhacNho,String>("ngayTao"));


		tableDanhsach.setItems(phieunhacnhoListController);

	}
	public void lammoi (ActionEvent event) throws IOException {
		
		initialize(null, null);
			
		 }
	public void timkiem (ActionEvent event) throws IOException {
	
			
			phieunhacnhoListController.clear();
			 
			madocgia = LoginController.docgiadangnhap.getMaDocGia();
			
			for(model_PhieuNhacNho x : manager_PhieuNhacNho.PhieunhacnhoList()){ 
				
		         if( x.getMaDocGia()==madocgia){
		        	 if(CheckNgay(x.getNgayTao()))
		        	 phieunhacnhoListController.add(x);
		              
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
