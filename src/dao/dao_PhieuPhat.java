package dao;

import jdbcutil.JDBCUtil;
import model.model_PhieuMuon;
import model.model_PhieuPhat;
import model.model_PhieuTra;
import model.model_TaiLieu;


import java.sql.*;
import java.util.ArrayList;

public class dao_PhieuPhat implements DAO<model_PhieuPhat> {
    @Override
    public  int insert(model_PhieuPhat phieuphat) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO `phieu phat`(MaPhieuPhat,MaNVLapPhieuPhat,MaPhieuMuon,NgayLapPhieuPhat,MaTaiLieu,MaDocGia,SoTienPhat)"
            		   
                    +" VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
           
            st.setString(1,phieuphat.getMaPhieuPhat());
            st.setString(2,phieuphat.getMaNVLapPhieuPhat());
            st.setString(3,phieuphat.getMaPhieuMuon());
            st.setString(4,phieuphat.getNgayLapPhieuPhat());
            st.setInt(5,phieuphat.getMaTaiLieu());
            st.setInt(6,phieuphat.getMaDocGia());
            st.setInt(7,phieuphat.getSoTienPhat());

           
           

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

    public ArrayList<model_PhieuPhat> selectAll() {
        ArrayList<model_PhieuPhat> ans=new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `phieu phat`";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                model_PhieuPhat phieuphat=new model_PhieuPhat();
                phieuphat.setMaDocGia(rs.getInt("MaDocGia"));
                phieuphat.setMaNVLapPhieuPhat(rs.getString("MaNVLapPhieuPhat"));
                phieuphat.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
                phieuphat.setMaPhieuPhat(rs.getString("MaPhieuPhat"));
                phieuphat.setMaTaiLieu(rs.getInt("MaTaiLieu"));
                phieuphat.setNgayLapPhieuPhat(rs.getString("NgayLapPhieuPhat"));
                phieuphat.setSoTienPhat(rs.getInt("SoTienPhat"));
                
                
                ans.add(phieuphat);
            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }


	@Override
	public int update(model_PhieuPhat t) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int delete(model_PhieuPhat t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	


	
	
}