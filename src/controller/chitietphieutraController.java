package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import jdbcutil.JDBCUtil;
import model.model_PhieuTra;

public class chitietphieutraController implements Initializable {

	public Text  tfMaphieutra;
	public Text  tfMaphieumuon;
	public Text  tfNgaylap;
	public Text  tfManhanvienlap;

	public Text  tfMatailieu;
	public Text  tfMadocgia;
	public Text  tfTinhtrangsach;
	public Text  tfTentailieu;
	public Text  tfNgaymuon;
	public Text  tfTre;
	public Text  tfHantra;
	
	public model_PhieuTra phieutra1= new model_PhieuTra();

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `phieutra` WHERE MaPhieuTra="+"'"+TimPhieuTraController.maphieutrachon1+"' AND MaTaiLieu= "+"'"+TimPhieuTraController.matailieuchon1+"'";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                model_PhieuTra phieutra=new model_PhieuTra();
                phieutra.setMaPhieuTra(rs.getString("MaPhieuTra"));
                phieutra.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                phieutra.setNgayTra(rs.getString("NgayLapPhieuTra"));
                phieutra.setMaNhanVienLapPhieuTra(rs.getString("MaNVLapPhieuTra"));
                phieutra.setMaTaiLieu(rs.getInt("MaTaiLieu"));
                phieutra.setMaDocGia(rs.getInt("MaDocGia"));
                phieutra.setTinhTrangSach(rs.getString("TinhTrangSach"));
                phieutra.setTenTaiLieu(rs.getString("TenTL"));
                phieutra.setNgayMuon(rs.getString("NgayMuon"));
                phieutra.setSoNgayTre(rs.getInt("Tre"));
                phieutra.setHanTra(rs.getString("HanTra"));
                phieutra1=phieutra;
            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
		  tfMaphieutra.setText(phieutra1.getMaPhieuTra());
		  tfMaphieumuon.setText(phieutra1.getMaPhieuMuon());
		  tfNgaylap.setText(phieutra1.getNgayTra());
		  tfManhanvienlap.setText(phieutra1.getMaNhanVienLapPhieuTra());;

		  tfMatailieu.setText(String.valueOf(phieutra1.getMaTaiLieu()));;
		  tfMadocgia.setText(String.valueOf(phieutra1.getMaDocGia()));;
		  tfTinhtrangsach.setText(phieutra1.getTinhTrangSach());;
		  tfTentailieu.setText(phieutra1.getTenTaiLieu());
		  tfNgaymuon.setText(phieutra1.getNgayMuon());
		  tfTre.setText(String.valueOf(phieutra1.getSoNgayTre()));
		  tfHantra.setText(phieutra1.getHanTra());;
		
	}

}
