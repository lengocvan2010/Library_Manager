package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdbcutil.JDBCUtil;
import manager.manager_DangNhap;
import manager.manager_TaiLieu;
import manager.manager_Yeucautl;
import model.model_DangNhap;
import model.model_PhieuMuon;
import model.model_TaiLieu;
import model.model_Yeucautl;

public class chitietphieumuonController implements Initializable {
	
	public model_PhieuMuon phieumuon1=new model_PhieuMuon();
	
	public Text tfMadocgia;
	public Text tfNgaysinh;
	public Text tfNgaylap;
	public Text tfTentailieu;
	public Text tfTrangthai;
	public Text tfHantra;
	public Text tfMatailieu;
	public Text tfManhanvienlap;

	public Text tfHoten;
	public Text tfMaphieumuon;


	



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		 try{
	            Connection con=JDBCUtil.getConnection();
	            String sql="SELECT * FROM `phieu muon` WHERE MaPhieuMuon="+"'"+TimPhieuMuonController.maphieumuonchon+"' AND MaTaiLieu= "+"'"+TimPhieuMuonController.matailieuchon+"'";
	            PreparedStatement st=con.prepareStatement(sql);
	            ResultSet rs = st.executeQuery();
	            while(rs.next()){
	                model_PhieuMuon phieumuon=new model_PhieuMuon();
	                phieumuon.setHanTra(rs.getString("HanTra"));
	                phieumuon.setHoTen(rs.getString("HoTen"));
	                phieumuon.setMaDocGia(rs.getInt("MaDocGia"));
	                phieumuon.setMaNhanVienLap(rs.getString("MaNVLapPhieuMuon"));
	                phieumuon.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
	                phieumuon.setMaTaiLieu(rs.getInt("MaTaiLieu"));
	                phieumuon.setNgayLapPhieu(rs.getString("NgayLapPhieuMuon"));
	                phieumuon.setNgaySinh(rs.getString("NgaySinh"));
	                phieumuon.setTrangThai(rs.getString("TrangThai"));
	                phieumuon.setTentl(rs.getString("TenTL"));
	                phieumuon1=phieumuon;
	            }
	            JDBCUtil.closeConnection(con);
	        } catch(SQLException e){
	            e.printStackTrace();
	        }
		 
		     tfMadocgia.setText(String.valueOf(phieumuon1.getMaDocGia()));
		     tfNgaysinh.setText(phieumuon1.getNgaySinh());
			 tfNgaylap.setText(phieumuon1.getNgayLapPhieu());
			 tfTentailieu.setText(phieumuon1.getTentl());
			 tfTrangthai.setText(phieumuon1.getTrangThai());
			 tfHantra.setText(phieumuon1.getHanTra());
			 tfMatailieu.setText(String.valueOf(phieumuon1.getMaTaiLieu()));
			 tfManhanvienlap.setText(phieumuon1.getMaNhanVienLap());

			 tfHoten.setText(phieumuon1.getHoTen());
			 tfMaphieumuon.setText(phieumuon1.getMaPhieuMuon());
		 
	        
		
	}




	
}