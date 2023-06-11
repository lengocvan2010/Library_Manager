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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdbcutil.JDBCUtil;
import manager.manager_DocGia;
import manager.manager_LoaiDocGia;
import manager.manager_PhieuMuon;
import manager.manager_PhieuPhat;
import manager.manager_PhieuTra;
import manager.manager_TaiLieu;
import model.model_DocGia;
import model.model_LoaiDocGia;
import model.model_PhieuMuon;
import model.model_PhieuPhat;
import model.model_PhieuTra;
import model.model_TaiLieu;

public class TaoPhieuTraController implements Initializable {
	public Text tfMaphieutra;
	Calendar ngaythang; 
	public Text tfNgaytra;
	String ngaytra="";
    static ObservableList<model_PhieuTra> phieutraList = FXCollections.observableArrayList();

    public model_DocGia docgiatra= new model_DocGia();
	public Text tfNgaysinh;
	public int soluong;
	public Text tfHoten;
	public  TextField tfMadocgia;
	public ObservableList<String> listComboBox1 = FXCollections.observableArrayList();
	public ObservableList<String> listComboBox2 = FXCollections.observableArrayList();
	public ObservableList<String> listComboBox3 = FXCollections.observableArrayList("Nguyên vẹn","Hư hỏng","Mất");

	public ComboBox<String> cbMapm;
	public ComboBox<String> cbMatl;
	public ComboBox<String> cbTinhtrang;
	
    public model_PhieuTra phieutra1 = new model_PhieuTra();
	public model_TaiLieu tailieutra=new model_TaiLieu();
	public model_PhieuPhat phieuphat=new model_PhieuPhat();


    
    
    public TableView <model_PhieuTra> tableDanhsach;
	@FXML
	private TableColumn<model_PhieuTra,String> colMapm;
	@FXML
	private TableColumn<model_PhieuTra,Integer>colMatl;
	@FXML
	private TableColumn<model_PhieuTra,String>colTentl;
	@FXML
	private TableColumn<model_PhieuTra,String>colTrangthai;
	@FXML
	private TableColumn<model_PhieuTra,String>colNgaymuon;
	@FXML
	private TableColumn<model_PhieuTra,String>colHantra;
	@FXML
	private TableColumn<model_PhieuTra,Integer>colTre;
	
	
public void initialize(URL arg0, ResourceBundle arg1) {
	
	if(TimdocgiaController.madocgiatk !=0) {
    	tfMadocgia.setText(String.valueOf(TimdocgiaController.madocgiatk));}
	if(TimPhieuMuonController.madocgia1 !=0) {
    	tfMadocgia.setText(String.valueOf(TimPhieuMuonController.madocgia1));}
	//xu ly table
	phieutraList.clear();
	
	
	colMapm.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("maPhieuMuon") );
	colMatl.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,Integer>("maTaiLieu") );
	colTentl.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("tenTaiLieu") );
	colTrangthai.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("tinhTrangSach") );
	colNgaymuon.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("ngayMuon") );
	colHantra.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,String>("hanTra") );
	colTre.setCellValueFactory(new PropertyValueFactory<model_PhieuTra,Integer>("soNgayTre") );
	tableDanhsach.setItems(phieutraList);
	//xu ly maphieutra
		if(manager_PhieuTra.PhieutraList().size()==0) {
			tfMaphieutra.setText("PT1" );
		}
		else
	        {tfMaphieutra.setText(xoankytudau(manager_PhieuTra.PhieutraList().get(manager_PhieuTra.PhieutraList().size()-1).getMaPhieuTra(),2) );	}
		
		
	// xu ly ngay muon, tra
		
		ngaythang = Calendar.getInstance();
		ngaytra+=ngaythang.get(Calendar.YEAR)+"/"+(ngaythang.get(Calendar.MONTH)+1)+"/"+ngaythang.get(Calendar.DATE);
		tfNgaytra.setText(ngaytra);
		
	//xu ly combobox
		cbMapm.setValue("Mã Phiếu Mượn");
		cbMapm.setItems(listComboBox1);
		
		cbMatl.setValue("Mã Tài Liệu");
		cbMatl.setItems(listComboBox2);
		
		cbTinhtrang.setValue("Tình trạng sách");
		cbTinhtrang.setItems(listComboBox3);
		
		
		
		

		

		}
	// xoa n ky tu dau cua 1 xau
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

	//xu ly thong tin doc gia

	public void check (ActionEvent event) throws IOException {
		if(tfMadocgia.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING, "Vui lòng nhập mã độc giả!", ButtonType.OK);
		    alert.setHeaderText(null);
		    alert.showAndWait();
		    return;
			
		}
		listComboBox1.clear();
		listComboBox2.clear();
		phieutraList.clear();
		docgiatra=null;
		
		
		
		tfNgaysinh.setText("");
	    tfHoten.setText("");
	    
	    soluong=0;
		 	 try{
		 		 
	         Connection con=JDBCUtil.getConnection();
	         String sql="SELECT * FROM `docgia` where MaDocGia="+tfMadocgia.getText();
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
	          
	          docgiatra=docgia;
	          
	         }
	         JDBCUtil.closeConnection(con);
	     } catch(SQLException e){
	         e.printStackTrace();
	     }
		 	if(docgiatra==null) {
		 		Alert alert = new Alert(AlertType.WARNING, "Mã độc giả không tồn tại, vui lòng kiểm tra lại!", ButtonType.OK);
			    alert.setHeaderText(null);
			    alert.showAndWait();
			    return;}
		 	
		 	else
		 	 {
		 		tfNgaysinh.setText(docgiatra.getNgaySinh());
		        tfHoten.setText(docgiatra.getTenDocGia());
				
				}
				
		 	try{
	            Connection con=JDBCUtil.getConnection();
	            String sql="SELECT MaPhieuMuon FROM `phieu muon` WHERE MaDocGia="+"'"+docgiatra.getMaDocGia()+"'"+
	            "and TrangThai= N'Đang mượn'"+" GROUP BY MaPhieuMuon";
	            PreparedStatement st=con.prepareStatement(sql);
	            ResultSet rs = st.executeQuery();
	            while(rs.next()){
	               
	                listComboBox1.add(rs.getString("MaPhieuMuon"));
	            }
	            JDBCUtil.closeConnection(con);
	        } catch(SQLException e){
	            e.printStackTrace();
	        }
		 	for(String x:listComboBox1) {
		 		try{
		            Connection con=JDBCUtil.getConnection();
		            String sql="SELECT MaTaiLieu FROM `phieu muon` WHERE MaPhieumuon="+"'"+x+"'"+"and TrangThai != N'Đã trả'";
		            PreparedStatement st=con.prepareStatement(sql);
		            ResultSet rs = st.executeQuery();
		            while(rs.next()){
		               
		                listComboBox2.add(rs.getString("MaTaiLieu"));
		            }
		            JDBCUtil.closeConnection(con);
		        } catch(SQLException e){
		            e.printStackTrace();
		        }
		 	}

			}


public void add (ActionEvent event) throws IOException {
	
	
	 try{
 		 
         Connection con=JDBCUtil.getConnection();
         String sql="SELECT * FROM `phieu muon` where MaPhieuMuon="+"'"+cbMapm.getValue()+"'"+"and MaTaiLieu="+"'"+cbMatl.getValue()+"'";
         PreparedStatement st=con.prepareStatement(sql);
         ResultSet rs = st.executeQuery();
         while(rs.next()){
         model_PhieuTra phieutra= new model_PhieuTra();

          phieutra.setTenTaiLieu(rs.getString("TenTL"));
          phieutra.setNgayMuon(rs.getString("NgayLapPhieuMuon"));
          phieutra.setHanTra(rs.getString("HanTra"));
           phieutra1=phieutra;
         }
         JDBCUtil.closeConnection(con);
     } catch(SQLException e){
         e.printStackTrace();
     }
	
	
	phieutra1.setMaDocGia(Integer.parseInt(tfMadocgia.getText()));
	phieutra1.setMaNhanVienLapPhieuTra(LoginController.thuthudangnhap.getManv());
	phieutra1.setMaPhieuMuon(cbMapm.getValue());
	phieutra1.setMaPhieuTra(tfMaphieutra.getText());
	phieutra1.setMaTaiLieu(Integer.parseInt(cbMatl.getValue()));
	phieutra1.setNgayTra(tfNgaytra.getText());
	phieutra1.setTinhTrangSach(cbTinhtrang.getValue());
	
	// xu li ngay tre
	String s = phieutra1.getHanTra(),thanhphan;
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
	Calendar cngaymuon;
	cngaymuon=Calendar.getInstance();
	cngaymuon.set(c[0], c[1], c[2]);
	
	ngaythang.add(Calendar.MONTH, 1);
	if((ngaythang.getTimeInMillis()-cngaymuon.getTimeInMillis())/86400000<=0) {
		phieutra1.setSoNgayTre(0);
		
	}
	else {
		int tpm=(int)((ngaythang.getTimeInMillis()-cngaymuon.getTimeInMillis())/86400000);
		phieutra1.setSoNgayTre(tpm);}
	ngaythang.add(Calendar.MONTH, -1);
	phieutraList.add(phieutra1);
    
}


public void delete (ActionEvent event) throws IOException {
	
	int index= tableDanhsach.getSelectionModel().getSelectedIndex();
	if(index==-1) {
		Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn tài liệu.Vui lòng kiểm tra lại!", ButtonType.OK);
		alert.setHeaderText(null);
		alert.showAndWait();
		return;
 }else {
	phieutraList.remove(index);}
    
   }

public void taophieu (ActionEvent event) throws IOException {
	boolean phat=false;
	for(int i=0; i<=phieutraList.size()-1;i++){ 
		model_PhieuTra phieutra2= new model_PhieuTra();
		phieutra2=phieutraList.get(i);
	manager_PhieuTra.insert(phieutra2);
	try{
        Connection con=JDBCUtil.getConnection();
        String sql="SELECT * FROM `tai lieu` where MaTaiLieu="+phieutra2.getMaTaiLieu();
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            model_TaiLieu tailieu=new model_TaiLieu();
            tailieu.setMatl(rs.getInt("MaTaiLieu"));
            tailieu.setTentl(rs.getString("TenTaiLieu"));
            tailieu.setLoaitl(rs.getString("LoaiTaiLieu"));
            tailieu.setSoluongcon(rs.getInt("SoLuongCon"));
            tailieu.setTldb(rs.getInt("TLDacbiet"));
            tailieu.setSldangmuon(rs.getInt("SoLuongDangMuon"));
            tailieutra=tailieu;
        }
        JDBCUtil.closeConnection(con);
    } catch(SQLException e){
        e.printStackTrace();
    }
	int ans=0;
	try{
		 Connection con= JDBCUtil.getConnection();

       String sql="UPDATE `phieu muon` "+"SET TrangThai='Đã trả' "
               + "WHERE MaPhieuMuon="+"'"+phieutra2.getMaPhieuMuon()+"'"
               +"and MaTaiLieu ="+"'"+phieutra2.getMaTaiLieu()+"'";
       PreparedStatement st=con.prepareStatement(sql);
       ans=st.executeUpdate();
       System.out.println("Bạn đã thực thi: "+sql);
       System.out.println("Có "+ans+" dòng bị thay đổi");
     
        JDBCUtil.closeConnection(con);
    } catch(SQLException e){
        e.printStackTrace();
    }
	tailieutra.setSldangmuon(tailieutra.getSldangmuon()-1);
	tailieutra.setSoluongcon(tailieutra.getSoluongcon()+1);
	manager_TaiLieu.update(tailieutra);
	
	 if(phieutra2.getSoNgayTre()!=0||!(phieutra2.getTinhTrangSach().equals("Nguyên vẹn")))
	    {
        phat=true;
	    	int tienphat=0;
	    	if(phieutra2.getTinhTrangSach().equals("Hư hỏng")) {
	    		tienphat+=75000;
	    	}
	    	if(phieutra2.getTinhTrangSach().equals("Mất")) {
	    		tienphat+=200000;
	    	}
	    	tienphat+=1000*phieutra2.getSoNgayTre();	
			
	    	phieuphat.setMaDocGia(phieutra2.getMaDocGia());
	    	phieuphat.setMaNVLapPhieuPhat(LoginController.thuthudangnhap.getManv());
	    	phieuphat.setMaPhieuMuon(phieutra2.getMaPhieuMuon());
	    	if(manager_PhieuPhat.PhieuphatList().size()==0) {
				phieuphat.setMaPhieuPhat("PP1");
			}
			else
				phieuphat.setMaPhieuPhat(xoankytudau(manager_PhieuPhat.PhieuphatList().get(manager_PhieuPhat.PhieuphatList().size()-1).getMaPhieuPhat(),2) );	
	    	phieuphat.setMaTaiLieu(phieutra2.getMaTaiLieu());
	    	phieuphat.setNgayLapPhieuPhat(phieutra2.getNgayTra());
	    	phieuphat.setSoTienPhat(tienphat);
	    	manager_PhieuPhat.insert(phieuphat);
		}	
	
   }
	docgiatra.setSachdangmuon(docgiatra.getSachdangmuon()-phieutraList.size());
    manager_DocGia.update(docgiatra);
    if(!phat)
    {
		Alert alert = new Alert(AlertType.WARNING, "Tạo phiếu trả thành công!", ButtonType.OK);
	    alert.setHeaderText(null);
	    alert.showAndWait();
	    return;
		
	}	
    else
    {
    	Alert alert = new Alert(AlertType.WARNING, "Tạo phiếu trả thành công!\n Đã tạo phiếu phạt kèm!", ButtonType.OK);
	    alert.setHeaderText(null);
	    alert.showAndWait();
	    return;
    	
    	
    }
}

			 
}

