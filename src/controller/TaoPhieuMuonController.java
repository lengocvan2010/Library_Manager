package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
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
import manager.manager_TaiLieu;
import model.model_DocGia;
import model.model_LoaiDocGia;
import model.model_PhieuMuon;
import model.model_TaiLieu;

public class TaoPhieuMuonController implements Initializable {
	public Text tfMaphieumuon;
	public  TextField tfMadocgia;
	public Text tfHoten;
	public Text tfNgaysinh;
	Calendar ngaythang; 
	public int tldb;
	public Text tfNgaytra;
	public Text tfNgaymuon;
	public Text tfSongaytoida;
	public TextField tfMatl;
	public model_TaiLieu tailieumuon=new model_TaiLieu();
	public model_LoaiDocGia loaidocgiamuon= new model_LoaiDocGia();
	public int soluong;
	public model_DocGia docgiamuon= new model_DocGia();
	public boolean check;



	
	//table
	public TableView <model_PhieuMuon> tableDanhsach;
	@FXML
	private TableColumn<model_PhieuMuon,String> colMatl;
    @FXML
    private TableColumn<model_DocGia,String> colTentl;
    @FXML
    private TableColumn<model_DocGia,Integer> colSoluong;
    
    //list
    static ObservableList<model_PhieuMuon> phieumuonList = FXCollections.observableArrayList();

	
	String ngaymuon="";
	String ngaytra="";
	


public void initialize(URL arg0, ResourceBundle arg1) {
	
	
	phieumuonList.clear();
	
	
	colMatl.setCellValueFactory(new PropertyValueFactory<model_PhieuMuon,String>("maTaiLieu"));
    colTentl.setCellValueFactory(new PropertyValueFactory<model_DocGia,String>("tentl"));
    
    tableDanhsach.setItems(phieumuonList);
    
	
    if(		TimdocgiaController.madocgiatk !=0) {
    	tfMadocgia.setText(String.valueOf(TimdocgiaController.madocgiatk));
    
    }
    if(		TimPhieuMuonController.madocgia1 !=0) {
    	tfMadocgia.setText(String.valueOf(TimdocgiaController.madocgiatk));
    
    }
    
//xu ly maphieumuon
	if(manager_PhieuMuon.PhieumuonList().size()==0) {
		tfMaphieumuon.setText("MP1" );
	}
	else
        tfMaphieumuon.setText(xoankytudau(manager_PhieuMuon.PhieumuonList().get(manager_PhieuMuon.PhieumuonList().size()-1).getMaPhieuMuon(),2) );	
	
	
// xu ly ngay muon, tra
	
	ngaythang = Calendar.getInstance();
	ngaymuon+=ngaythang.get(Calendar.YEAR)+"/"+(ngaythang.get(Calendar.MONTH)+1)+"/"+ngaythang.get(Calendar.DATE);
	tfNgaymuon.setText(ngaymuon);
	
	



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
	phieumuonList.clear();
	docgiamuon=null;
	loaidocgiamuon=null;
	tfNgaytra.setText("");
	tfSongaytoida.setText("");
	tfNgaysinh.setText("");
    tfHoten.setText("");
    tfMatl.setText("");
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
          
          docgiamuon=docgia;
          
         }
         JDBCUtil.closeConnection(con);
     } catch(SQLException e){
         e.printStackTrace();
     }
	 	if(docgiamuon==null) {
	 		Alert alert = new Alert(AlertType.WARNING, "Mã độc giả không tồn tại, vui lòng kiểm tra lại!", ButtonType.OK);
		    alert.setHeaderText(null);
		    alert.showAndWait();
		    return;}
	 	try{
	 		 
	         Connection con=JDBCUtil.getConnection();
	         String sql="SELECT * FROM `loai doc gia` where TenLoaiDG="+"'"+docgiamuon.getLoai()+"'";
	         PreparedStatement st=con.prepareStatement(sql);
	         ResultSet rs = st.executeQuery();
	         while(rs.next()){
	          model_LoaiDocGia loaidocgia= new model_LoaiDocGia();

	          loaidocgia.setPhiThuongNien(rs.getInt("PhiThuongNien"));
              loaidocgia.setSoNgayMuonToiDa(rs.getInt("SoNgayMuonToiDa"));
              loaidocgia.setSoSachMuonToiDa(rs.getInt("SoSachMuonToiDa"));
              loaidocgia.setTaiLieuDB(rs.getInt("TaiLieuDB"));
              loaidocgia.setTenLoaiDG(rs.getString("TenLoaiDG"));
              loaidocgiamuon=loaidocgia;
	         }
	         JDBCUtil.closeConnection(con);
	     } catch(SQLException e){
	         e.printStackTrace();
	     }
	 	
	 	 {
	 		tfNgaysinh.setText(docgiamuon.getNgaySinh());
	        tfHoten.setText(docgiamuon.getTenDocGia());
			ngaythang.add(Calendar.DATE, loaidocgiamuon.getSoNgayMuonToiDa());
			ngaytra+=ngaythang.get(Calendar.YEAR)+"-"+(ngaythang.get(Calendar.MONTH)+1)+"-"+ngaythang.get(Calendar.DATE);
			tfNgaytra.setText(ngaytra);
			tfSongaytoida.setText(String.valueOf(loaidocgiamuon.getSoNgayMuonToiDa()));
			ngaythang.add(Calendar.DATE, -loaidocgiamuon.getSoNgayMuonToiDa());;
			ngaytra="";
			}
			
	

		}
public void add (ActionEvent event) throws IOException {
	tailieumuon=null;
	if(tfMatl.getText()=="") {

 		Alert alert = new Alert(AlertType.WARNING, "Vui điền mã tài liệu!", ButtonType.OK);
	    alert.setHeaderText(null);
	    alert.showAndWait();
	    return;
		
	}
	else {
		check=true;
		 for(model_PhieuMuon x : phieumuonList){ 
				
	            if( x.getMaTaiLieu()==Integer.parseInt(tfMatl.getText())){
	            	check=false;
	            	break;
	                 
	            }}
	}
	
	
	
	if (check==false) {
		Alert alert = new Alert(AlertType.WARNING, "Tài liệu đã có trong danh sách. Vui lòng kiểm tra lại!", ButtonType.OK);
	    alert.setHeaderText(null);
	    alert.showAndWait();
	    return;
	}
	
	else {
		 try{
	 		 
	         Connection con=JDBCUtil.getConnection();
	         String sql="SELECT * FROM `tai lieu` where MaTaiLieu="+tfMatl.getText();
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
	                
	                tailieumuon=tailieu;
	         
	         }
	         JDBCUtil.closeConnection(con);
	     } catch(SQLException e){
	         e.printStackTrace();
	     }
		if(tailieumuon==null) {
			Alert alert = new Alert(AlertType.WARNING, "Mã tài liệu không tồn tại", ButtonType.OK);
		    alert.setHeaderText(null);
		    alert.showAndWait();
		    return;
		}
		else {
			if(loaidocgiamuon.getTaiLieuDB()==0&&tailieumuon.getTldb()==1){
				Alert alert = new Alert(AlertType.WARNING, "Độc giả không được mượn tài liệu đặc biệt, vui lòng kiểm tra lại", ButtonType.OK);
			    alert.setHeaderText(null);
			    alert.showAndWait();
			    return;
			}
			else{
			{
				soluong+= 1;
				if(soluong>(loaidocgiamuon.getSoSachMuonToiDa()-docgiamuon.getSachdangmuon())) {
					Alert alert = new Alert(AlertType.WARNING, "Số lượng mượn vượt quá số lượng được phép mượn ("+loaidocgiamuon.getSoSachMuonToiDa()+"),\nVui lòng kiểm tra lại", ButtonType.OK);
				    alert.setHeaderText(null);
				    alert.showAndWait();
				    return;
					
				}
				else {
					if(1>tailieumuon.getSoluongcon()) {
						Alert alert = new Alert(AlertType.WARNING, "Số lượng sách còn lại ko đủ, vui lòng kiểm tra lại", ButtonType.OK);
					    alert.setHeaderText(null);
					    alert.showAndWait();
					    return;
						
					}
					else {
						model_PhieuMuon phieumuon= new model_PhieuMuon();
						phieumuon.setMaTaiLieu(tailieumuon.getMatl());
						phieumuon.setTentl(tailieumuon.getTentl());
						phieumuonList.add(phieumuon);
						
					}
					
				}
				
			}
			
		}}
	}
}


public void delete (ActionEvent event) throws IOException {
	int index= tableDanhsach.getSelectionModel().getSelectedIndex();
	 if(index==-1) {
			Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn tài liệu.Vui lòng kiểm tra lại!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
	 }
	phieumuonList.remove(index);
    
    
   }

public void taophieu (ActionEvent event) throws IOException {
	for(int i=0; i<=phieumuonList.size()-1;i++){ 
		model_PhieuMuon phieumuon= new model_PhieuMuon();
		phieumuon=phieumuonList.get(i);
		phieumuon.setHanTra(tfNgaytra.getText());
		phieumuon.setHoTen(tfHoten.getText());
		phieumuon.setMaDocGia(Integer.parseInt(tfMadocgia.getText()));
		phieumuon.setMaPhieuMuon(tfMaphieumuon.getText());
		phieumuon.setNgayLapPhieu(tfNgaymuon.getText());
		phieumuon.setNgaySinh(tfNgaysinh.getText());
		phieumuon.setTrangThai("Đang mượn");
		phieumuon.setMaNhanVienLap(LoginController.thuthudangnhap.getManv());
		manager_PhieuMuon.insert(phieumuon);
		try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `tai lieu` where MaTaiLieu="+phieumuon.getMaTaiLieu();
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
                tailieumuon=tailieu;
            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
		tailieumuon.setSldangmuon(tailieumuon.getSldangmuon()+1);
		tailieumuon.setSoluongcon(tailieumuon.getSoluongcon()-1);
		manager_TaiLieu.update(tailieumuon);
             
        }
	    docgiamuon.setSachdangmuon(docgiamuon.getSachdangmuon()+soluong);
	    manager_DocGia.update(docgiamuon);
	    {
			Alert alert = new Alert(AlertType.INFORMATION, "Tạo phiếu mượn thành công!", ButtonType.OK);
		    alert.setHeaderText(null);
		    alert.showAndWait();
		    return;
			
		}
    
   }

			 
}

