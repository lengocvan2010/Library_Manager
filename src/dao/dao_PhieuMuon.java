package dao;

import jdbcutil.JDBCUtil;
import model.model_PhieuMuon;
import model.model_TaiLieu;


import java.sql.*;
import java.util.ArrayList;

public class dao_PhieuMuon implements DAO<model_PhieuMuon> {
    @Override
    public  int insert(model_PhieuMuon phieumuon) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO `phieu muon`(MaPhieuMuon,MaNVLapPhieuMuon,MaDocGia,HoTen,NgaySinh,MaTaiLieu,"
            		    +"NgayLapPhieuMuon,HanTra,TrangThai,Tentl)"
                    +" VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
           
            st.setString(1,phieumuon.getMaPhieuMuon());
            st.setString(2,phieumuon.getMaNhanVienLap());
            st.setInt(3, phieumuon.getMaDocGia());
            st.setString(4, phieumuon.getHoTen());
            st.setString(5, phieumuon.getNgaySinh());
            st.setInt(6, phieumuon.getMaTaiLieu());
            st.setString(7, phieumuon.getNgayLapPhieu());
            st.setString(8, phieumuon.getHanTra());
           
            st.setString(9, phieumuon.getTrangThai());
            st.setString(10, phieumuon.getTentl());

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

    public ArrayList<model_PhieuMuon> selectAll() {
        ArrayList<model_PhieuMuon> ans=new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `phieu muon`";
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
                ans.add(phieumuon);
            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }

	
	


	
	@Override
	public int update(model_PhieuMuon t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(model_PhieuMuon t) {
		// TODO Auto-generated method stub
		return 0;
	}
}