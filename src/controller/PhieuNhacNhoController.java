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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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


public class PhieuNhacNhoController implements Initializable {

   static ObservableList<model_PhieuNhacNho> phieunhacnhoListController = FXCollections.observableArrayList();
    public TableView <model_PhieuNhacNho> tableDanhsach;
	@FXML
	private TableColumn<model_PhieuNhacNho,String> colMaphieunhacnho;
    @FXML
    private TableColumn<model_PhieuNhacNho,String> colMaphieumuon;
    @FXML
    private TableColumn<model_PhieuNhacNho,Integer> colMadg;
    @FXML
    private TableColumn<model_PhieuNhacNho,Integer> colMatl ;
    @FXML
    private TableColumn<model_PhieuNhacNho,String> colTentl;
    
    @FXML
    private TableColumn<model_PhieuNhacNho,Integer> colThoigiancon;
    
    @FXML
    private TableColumn<model_PhieuNhacNho,String> colNgaytao;
   
    public model_PhieuNhacNho phieunhacnho1=new model_PhieuNhacNho();

	 public TextField tfMa;
	 public String  madocgia;
	 public String ngaytao;
	 public model_PhieuNhacNho phieunhacnho =new model_PhieuNhacNho();
     public model_DocGia docgia1= new model_DocGia();
		public Calendar ngaythang; 



	public void initialize(URL arg0, ResourceBundle arg1) {
		ngaythang = Calendar.getInstance();
	
		phieunhacnhoListController.clear();
		phieunhacnhoListController.addAll(manager_PhieuNhacNho.PhieunhacnhoList());
		
		colMaphieunhacnho.setCellValueFactory(new PropertyValueFactory<model_PhieuNhacNho,String>("maPhieuNhacNho") );
		colMaphieumuon.setCellValueFactory(new PropertyValueFactory<model_PhieuNhacNho,String>("maPhieuMuon"));
		colMadg.setCellValueFactory(new PropertyValueFactory<model_PhieuNhacNho,Integer>("maDocGia"));
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
		 
		madocgia = tfMa.getText();
		int madocgia1=Integer.parseInt(madocgia);
		for(model_PhieuNhacNho x : manager_PhieuNhacNho.PhieunhacnhoList()){ 
			
	         if( x.getMaDocGia()==madocgia1){
	        	 phieunhacnhoListController.add(x);
	              
	         }}
		
	 }
public void capnhat (ActionEvent event) throws IOException {
	for(model_PhieuMuon x : manager_PhieuMuon.PhieumuonList()){ 

    if(checksongayconlai(x.getHanTra())==5) {
    	phieunhacnho1=null;
    	

    	try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `phieu nhac nho` WHERE MaTaiLieu="+"'"+x.getMaTaiLieu()+"'"+"and MaPhieuMuon="+"'"+x.getMaPhieuMuon()+"'";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                model_PhieuNhacNho phieunhacnho=new model_PhieuNhacNho();
                phieunhacnho.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                phieunhacnho1=phieunhacnho;
               
            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }	
    	if(phieunhacnho1==null) {

    		model_PhieuNhacNho phieunhacnho2 =new model_PhieuNhacNho();
    		phieunhacnho2.setMaDocGia(x.getMaDocGia());
    		phieunhacnho2.setMaPhieuMuon(x.getMaPhieuMuon());
    		phieunhacnho2.setMaTaiLieu(x.getMaTaiLieu());
    		phieunhacnho2.setTenTaiLieu(x.getTentl());
    		phieunhacnho2.setThoiGianCon(5);
    		ngaytao="";
    		ngaytao+=ngaythang.get(Calendar.YEAR)+"/"+(ngaythang.get(Calendar.MONTH)+1)+"/"+ngaythang.get(Calendar.DATE);
    		phieunhacnho2.setNgayTao(ngaytao);
    		if(manager_PhieuNhacNho.PhieunhacnhoList().size()==0) {
    			phieunhacnho2.setMaPhieuNhacNho("PNN1");
    		}
    		else
    		{ phieunhacnho2.setMaPhieuNhacNho(xoankytudau(manager_PhieuNhacNho.PhieunhacnhoList().get(manager_PhieuNhacNho.PhieunhacnhoList().size()-1).getMaPhieuNhacNho(),3));}
    	manager_PhieuNhacNho.insert(phieunhacnho2);
    	}
		}
  if(checksongayconlai(x.getHanTra())<0&&x.getTrangThai().equals("Đang mượn")) {
	  x.setTrangThai("Trễ hạn");
	  int ans=0;
    try{
        Connection con= JDBCUtil.getConnection();
        String sql="UPDATE `phieu muon` "+
        		"SET   `TrangThai`= '"+x.getTrangThai()+"'"
        		
               +"WHERE `MaTaiLieu`="+"'"+x.getMaTaiLieu()+"' and MaPhieuMuon= '"+x.getMaPhieuMuon()+"'" ;
       
       
        PreparedStatement st=con.prepareStatement(sql);
       
       
       
        ans=st.executeUpdate();
        
        System.out.println("Bạn đã thực thi: "+sql);
        System.out.println("Có "+ans+" dòng bị thay đổi");
        JDBCUtil.closeConnection(con);
    } catch(SQLException e){
        e.printStackTrace();
    }
    try{
		 
        Connection con=JDBCUtil.getConnection();
        String sql="SELECT * FROM `docgia` where MaDocGia="+x.getMaDocGia();
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
        model_DocGia docgia= new model_DocGia();

         docgia.setUserName(rs.getString("TenDangNhap"));
         docgia.setMaDocGia(rs.getInt("MaDocGia"));
         docgia.setTenDocGia(rs.getString("HoTen"));
         docgia.setNgaySinh(rs.getString("NgaySinh"));
         docgia.setDiaChi(rs.getString("DiaChi"));
         docgia.setSDT(rs.getString("Sdt"));
         docgia.setEmail(rs.getString("Email"));
         docgia.setCMND(rs.getString("CMND"));
         docgia.setMSSV(rs.getString("MSSV"+""));
         docgia.setMCB(rs.getString("MCB"+""));
         docgia.setLoai(rs.getString("LoaiDG"));
         docgia.setSachdangmuon(rs.getInt("SachDangMuon"));
         docgia.setSachquahan(rs.getInt("SachQuaHan"));
         
         docgia1=docgia;
         
        }
        JDBCUtil.closeConnection(con);
    } catch(SQLException e){
        e.printStackTrace();
    }
    docgia1.setSachquahan(docgia1.getSachquahan()+1);
    manager_DocGia.update(docgia1);
	}	
	
        }
	{
		Alert alert = new Alert(AlertType.INFORMATION, "Cập nhật hệ thống thành công!", ButtonType.OK);
		alert.setHeaderText(null);
		alert.showAndWait();
		return;
 }	
	
		 }
//xoa n ky tu dau cua 1 xau
public String xoankytudau (String s, int n) {
	String x="";
	String y="";
	for(int i=0;i<s.length();i++) {
		if(i>=n)
		x=x+s.charAt(i);
		else
		y=y+s.charAt(i);
	}
	x = y + String.valueOf(Integer.parseInt(x)+1);
	return x;
	
}
public int checksongayconlai(String s) {
	
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
	Calendar hantra;
	hantra=Calendar.getInstance();
	hantra.set(c[0], c[1], c[2]);
	ngaythang.add(Calendar.MONTH, 1);

	
	int d= (int)((hantra.getTimeInMillis()-ngaythang.getTimeInMillis())/86400000);
	ngaythang.add(Calendar.MONTH, -1);
	return d;

	
}
	


}
