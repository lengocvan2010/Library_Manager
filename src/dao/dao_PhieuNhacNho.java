package dao;

import jdbcutil.JDBCUtil;
import model.model_PhieuMuon;
import model.model_PhieuNhacNho;
import model.model_TaiLieu;


import java.sql.*;
import java.util.ArrayList;

public class dao_PhieuNhacNho implements DAO<model_PhieuNhacNho> {
    
    public  int insert(model_PhieuNhacNho phieunhacnho) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO `phieu nhac nho`(MaPhieuNN,MaPhieuMuon,MaTaiLieu,Thoigianconlai,TenTaiLieu,MaDocGia,NgayTao)"
            		    
                    +" VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
           
            st.setString(1,phieunhacnho.getMaPhieuNhacNho());
            st.setString(2,phieunhacnho.getMaPhieuMuon());
            st.setInt(3, phieunhacnho.getMaTaiLieu());
            st.setInt(4, phieunhacnho.getThoiGianCon());
            st.setString(5, phieunhacnho.getTenTaiLieu());
            st.setInt(6, phieunhacnho.getMaDocGia());
            st.setString(7, phieunhacnho.getNgayTao());

            

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

    public ArrayList<model_PhieuNhacNho> selectAll() {
        ArrayList<model_PhieuNhacNho> ans=new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `phieu nhac nho`";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                model_PhieuNhacNho phieunhacnho=new model_PhieuNhacNho();
                phieunhacnho.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                phieunhacnho.setMaPhieuNhacNho(rs.getString("MaPhieuNN"));
                phieunhacnho.setMaTaiLieu(rs.getInt("MaTaiLieu"));
                phieunhacnho.setTenTaiLieu(rs.getString("TenTaiLieu"));
                phieunhacnho.setThoiGianCon(rs.getInt("Thoigianconlai"));
                phieunhacnho.setMaDocGia(rs.getInt("MaDocGia"));
                phieunhacnho.setNgayTao(rs.getString("ngayTao"));
                ans.add(phieunhacnho);
            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }


	


	
	public int update(model_PhieuNhacNho t) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	public int delete(model_PhieuNhacNho t) {
		// TODO Auto-generated method stub
		return 0;
	}


	

	
	


	
	
}