package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
import jdbcutil.JDBCUtil;
import manager.manager_DangNhap;
import manager.manager_DocGia;
import manager.manager_PhieuMuon;
import manager.manager_TaiLieu;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_PhieuMuon;
import model.model_PhieuNhacNho;
import model.model_TaiLieu;

public class UserPhieuMuonController implements Initializable {
	
	public ComboBox<String> cbTimkiem;
	public ComboBox<String> cbTrangthai;
	//table
	public TableView <model_PhieuMuon> tableDanhsach;
	@FXML
	private TableColumn<model_PhieuMuon,String> colMaphieu;
    @FXML
    private TableColumn<model_PhieuMuon,Integer> colMatl;
    @FXML
    private TableColumn<model_PhieuMuon,String> colTentl;
    @FXML
    private TableColumn<model_PhieuMuon,String> colManvlap;
    @FXML
    private TableColumn<model_PhieuMuon,String> colNgaymuon;
    @FXML
    private TableColumn<model_PhieuMuon,String> colHantra ;
    @FXML
    private TableColumn<model_PhieuMuon,String> colTrangthai;
    
    
    
    static ObservableList<model_PhieuMuon> phieumuonListController = FXCollections.observableArrayList();
    
    public String  matailieu;
	public String  maphieumuon;
	public String  tentailieu;
	public String  trangthai;
	public String hanmoi;

	 public TextField tfMa;
	 

	public void initialize(URL location, ResourceBundle resources) {
		phieumuonListController.clear();
		for(model_PhieuMuon y : manager_PhieuMuon.PhieumuonList()){ 
			if(y.getMaDocGia()==LoginController.docgiadangnhap.getMaDocGia()) {
				phieumuonListController.add(y);
			}
				}
		
		ObservableList<String> listComboBox1 = FXCollections.observableArrayList("Mã Tài Liệu","Tên Tài Liệu", "Mã Phiếu Mượn");
		cbTimkiem.setValue("Mã Tài Liệu");
		cbTimkiem.setItems(listComboBox1);
		
		ObservableList<String> listComboBox2 = FXCollections.observableArrayList("Tất cả","Đã trả", "Đang mượn","Trễ hạn");
		cbTrangthai.setValue("Tất cả");
		cbTrangthai.setItems(listComboBox2);
		
		colMaphieu.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,String>("maPhieuMuon") );
	    colMatl.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,Integer>("maTaiLieu"));
		colTentl.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,String>("tentl"));
		colTrangthai.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,String>("trangThai"));
		colManvlap.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,String>("maNhanVienLap"));
		colHantra.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,String>("hanTra"));
		colNgaymuon.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,String>("ngayLapPhieu"));
		tableDanhsach.setItems(phieumuonListController);
	}

	public void timkiem (ActionEvent event) throws IOException {
		if((cbTimkiem.getValue()).equals("Mã Tài Liệu")) {
		 SearchMatl();
		 }
		else
		{
			
			if((cbTimkiem.getValue()).equals("Tên Tài Liệu")) {
				 SearchTentl();
				 }
				else
				{
					SearchMaphieumuon();
				}
				
		}
		
		
	 }
	 
	 public void SearchMatl() {
		 trangthai=cbTrangthai.getValue();
		phieumuonListController.clear();
		 
		matailieu = tfMa.getText();
		int matailieu1=Integer.parseInt(matailieu);
		for(model_PhieuMuon x : manager_PhieuMuon.PhieumuonList()){ 
			if(trangthai.equals("Tất cả")) {
				trangthai=x.getTrangThai();
			}
	         if( x.getMaTaiLieu()==matailieu1&&x.getTrangThai().equals(trangthai)&&x.getMaDocGia()==LoginController.docgiadangnhap.getMaDocGia()){
	        	 phieumuonListController.add(x);
	              
	         }
	         trangthai=cbTrangthai.getValue();
	         }
		
	 }
	 public void SearchTentl() {
		 trangthai=cbTrangthai.getValue();

		 phieumuonListController.clear();
		 
			tentailieu = tfMa.getText();
			
			for(model_PhieuMuon x : manager_PhieuMuon.PhieumuonList()){
				System.out.println(x.getTentl());
				if(trangthai.equals("Tất cả")) {
					trangthai=x.getTrangThai();
				}
				
		         if( x.getTentl().equals(tentailieu)&&x.getTrangThai().equals(trangthai)&&x.getMaDocGia()==LoginController.docgiadangnhap.getMaDocGia()){
		        	 phieumuonListController.add(x);
		              
		         }
		         trangthai=cbTrangthai.getValue();
		         }
			
		 }
	 public void SearchMaphieumuon() {
		 trangthai=cbTrangthai.getValue();

		 phieumuonListController.clear();
		 
			maphieumuon = tfMa.getText();
			
			for(model_PhieuMuon x : manager_PhieuMuon.PhieumuonList()){ 
				System.out.println(x.getTentl());

				if(trangthai.equals("Tất cả")) {
					trangthai=x.getTrangThai();
				}
		         if( x.getMaPhieuMuon().equals(maphieumuon)&&x.getTrangThai().equals(trangthai)&&x.getMaDocGia()==LoginController.docgiadangnhap.getMaDocGia()){
		        	 phieumuonListController.add(x);
		              
		         }
		         trangthai=cbTrangthai.getValue();
		         }
			
		 }
	 
	 public int index,solandagiahan,x;
	 
	 public void giahan (ActionEvent event) throws IOException {
		 index= tableDanhsach.getSelectionModel().getSelectedIndex();
	    	System.out.println(colMaphieu.getCellData(index));



			if(solandagiahan==4) {
				Alert alert = new Alert(AlertType.WARNING, "Phiếu mượn đã gian hạn số lần tối đa", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
			}
			else {

				String thanhphan,s;
				s = colHantra.getCellData(index);
		    	int c[] = new int[3],k=0;
		    	s=s+'-';
		    	int index1 =0;
		    	for(int i=0;i<=s.length()-1;i++){
		    	
		    		if(s.charAt(i)=='-') {
		    			thanhphan="";
		    			for(int j=index1;j<i;j++) {
		    				thanhphan+=s.charAt(j);
		    				
		    				
		    			}
		    			index1=i+1;
		    			c[k]=Integer.parseInt(thanhphan);
		    			k++;

		    		}
		    		
		    	}
		    	Calendar chantra;
		    	chantra=Calendar.getInstance();
		    	chantra.set(c[0], c[1], c[2]);
		    	
		    	Calendar ngaythang;
		    	ngaythang=Calendar.getInstance();
		    	ngaythang.add(Calendar.MONTH,1);

		    	if((chantra.getTimeInMillis()-ngaythang.getTimeInMillis())/86400000<0||(chantra.getTimeInMillis()-ngaythang.getTimeInMillis())/86400000>5) {
		    		Alert alert = new Alert(AlertType.WARNING, "Chưa đến thời gian được phép gia hạn!", ButtonType.OK);
					alert.setHeaderText(null);
					alert.showAndWait();
					return;
		    	} else {
			    	chantra.add(Calendar.DATE,20);

			    	hanmoi="";
			    	hanmoi+=chantra.get(Calendar.YEAR)+"-"+(chantra.get(Calendar.MONTH))+"-"+chantra.get(Calendar.DATE);
			    	System.out.println(colMaphieu.getCellData(index));

			    	System.out.println(colMatl.getCellData(index));
			    	System.out.println(index);



			    	int ans=0;
				    try{
				        Connection con= JDBCUtil.getConnection();
				        String sql="UPDATE `phieu muon` "+
				        		"SET   `HanTra`= '"+hanmoi+"'"
				        		
				               +"WHERE `MaTaiLieu`="+"'"+String.valueOf(colMatl.getCellData(index))+"' and MaPhieuMuon= '"+colMaphieu.getCellData(index)+"'" ;
				       
				       
				        PreparedStatement st=con.prepareStatement(sql);
				       
				       
				       
				        ans=st.executeUpdate();
				        
				        System.out.println("Bạn đã thực thi: "+sql);
				        System.out.println("Có "+ans+" dòng bị thay đổi");
				        JDBCUtil.closeConnection(con);
				    } catch(SQLException e){
				        e.printStackTrace();
				    }
		    	}
			}
			{
				Alert alert = new Alert(AlertType.WARNING, "Gia Hạn thành công!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
		 }
			
		 }
	 public void check (ActionEvent event) throws IOException {
		 index= tableDanhsach.getSelectionModel().getSelectedIndex();
		 solandagiahan=0;
		 
	        try{
	            Connection con=JDBCUtil.getConnection();
	            String sql="SELECT * FROM `phieu nhac nho` WHERE MaPhieuMuon="+"'"+colMaphieu.getCellData(index)+"' and MaTaiLieu= '"+String.valueOf(colMatl.getCellData(index))+"'";
	            PreparedStatement st=con.prepareStatement(sql);
	            ResultSet rs = st.executeQuery();
	            while(rs.next()){
	               
	            	solandagiahan++;
	                
	            }
	            JDBCUtil.closeConnection(con);
	        } catch(SQLException e){
	            e.printStackTrace();
	        }
	        if(checkngay(colHantra.getCellData(index))==true)
	        {
				Alert alert = new Alert(AlertType.INFORMATION, "Phiếu mượn đã gia hạn "+String.valueOf(solandagiahan-1)+" lần!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
			} 
	        else {
	        	Alert alert = new Alert(AlertType.INFORMATION, "Phiếu mượn đã gia hạn "+String.valueOf(solandagiahan)+" lần!", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
				return;
	        }
			
			
	 }
	 public boolean checkngay(String s ) {
		 String thanhphan;
			s = colHantra.getCellData(index);
	    	int c[] = new int[3],k=0;
	    	s=s+'-';
	    	int index1 =0;
	    	for(int i=0;i<=s.length()-1;i++){
	    	
	    		if(s.charAt(i)=='-') {
	    			thanhphan="";
	    			for(int j=index1;j<i;j++) {
	    				thanhphan+=s.charAt(j);
	    				
	    				
	    			}
	    			index1=i+1;
	    			c[k]=Integer.parseInt(thanhphan);
	    			k++;

	    		}
	    		
	    	}
	    	Calendar chantra;
	    	chantra=Calendar.getInstance();
	    	chantra.set(c[0], c[1], c[2]);
	    	
	    	Calendar ngaythang;
	    	ngaythang=Calendar.getInstance();
	    	ngaythang.add(Calendar.MONTH,1);

	    	if((chantra.getTimeInMillis()-ngaythang.getTimeInMillis())/86400000<0||(chantra.getTimeInMillis()-ngaythang.getTimeInMillis())/86400000>5) {
	    		return false;
	    	}
	    	else return true;
	 }
	 public void lammoi (ActionEvent event) throws IOException {
			
		 initialize(null, null);
			
		 }

	
}
