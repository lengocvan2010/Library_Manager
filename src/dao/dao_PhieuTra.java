package dao;

import jdbcutil.JDBCUtil;
import model.model_PhieuMuon;
import model.model_PhieuTra;
import model.model_TaiLieu;


import java.sql.*;
import java.util.ArrayList;

public class dao_PhieuTra implements DAO<model_PhieuTra> {
    @Override
    public  int insert(model_PhieuTra phieutra) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO `phieutra`(MaPhieuTra,MaPhieuMuon,NgayLapPhieuTra,MaNVLapPhieuTra,MaTaiLieu,MaDocGia,TinhTrangSach,TenTL,NgayMuon,Tre,HanTra)"
            		   
                    +" VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
           
            st.setString(1,phieutra.getMaPhieuTra());
            st.setString(2,phieutra.getMaPhieuMuon());
            st.setString(3,phieutra.getNgayTra());
            st.setString(4,phieutra.getMaNhanVienLapPhieuTra());
            st.setInt(5,phieutra.getMaTaiLieu());
            st.setInt(6,phieutra.getMaDocGia());
            st.setString(7,phieutra.getTinhTrangSach());
            st.setString(8,phieutra.getTenTaiLieu());
            st.setString(9,phieutra.getNgayMuon());
            st.setInt(10,phieutra.getSoNgayTre());
            st.setString(11, phieutra.getHanTra());
           

            ans=st.executeUpdate();
            System.out.println("Bạn đã thực thi: "+sql);
            System.out.println("Có "+ans+" dòng bị thay đổi");
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return ans;
    }

    
//    public int update(model_TaiLieu tailieu) {
//        int ans=0;
//        try{
//            Connection con= JDBCUtil.getConnection();
//            String sql="UPDATE `tai lieu` "+
//            		"SET   `TenTaiLieu`="+"'"+tailieu.getTentl()+"'"
//            		+",`SoLuongCon`="+"'"+tailieu.getSoluongcon()+"'"
//            		+",`LoaiTaiLieu`="+"'"+tailieu.getLoaitl()+"'"
//            		+",`TLDacbiet`="+"'"+tailieu.getTldb()+"'"
//            	    +",`SoLuongDangMuon`="+"'"+tailieu.getSldangmuon()+"'"
//                   +"WHERE `MaTaiLieu`="+"'"+tailieu.getMatl()+"'";
////            String sql="UPDATE `tai lieu` "+"SET `TenTaiLieu`='?',`SoLuongCon`='?',`LoaiTaiLieu`='?',`TLDacbiet`='?'"
////            +"WHERE `MaTaiLieu`='?'";
//           
//            PreparedStatement st=con.prepareStatement(sql);
//           
////            st.setString(1,tailieu.getTentl()+"");
//////            st.setInt(2,tailieu.getSoluongcon());
//////            st.setString(3,tailieu.getLoaitl()+"");
//////            st.setInt(4,tailieu.getTldb());
////            
////            st.setInt(5,tailieu.getMatl());
//           
//            ans=st.executeUpdate();
//            
//            System.out.println("Bạn đã thực thi: "+sql);
//            System.out.println("Có "+ans+" dòng bị thay đổi");
//            JDBCUtil.closeConnection(con);
//        } catch(SQLException e){
//            e.printStackTrace();
//        }
//        return ans;
//    }
//
//    public int delete(model_TaiLieu tailieu) {
//        int ans=0;
//        try{
//            Connection con= JDBCUtil.getConnection();
//            String sql="DELETE from `tai lieu` "+"WHERE MaTaiLieu=?";
//            PreparedStatement st=con.prepareStatement(sql);
//            st.setInt(1,tailieu.getMatl());
//            ans=st.executeUpdate();
//            System.out.println("Bạn đã thực thi: "+sql);
//            System.out.println("Có "+ans+" dòng bị thay đổi");
//            JDBCUtil.closeConnection(con);
//        } catch(SQLException e){
//            e.printStackTrace();
//        }
//        return ans;
//    }

    public ArrayList<model_PhieuTra> selectAll() {
        ArrayList<model_PhieuTra> ans=new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `phieutra`";
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
                ans.add(phieutra);
            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }


	@Override
	public int update(model_PhieuTra t) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int delete(model_PhieuTra t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	


	
	
}