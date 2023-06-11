package dao;

import jdbcutil.JDBCUtil;
import model.model_TaiLieu;


import java.sql.*;
import java.util.ArrayList;

public class dao_TaiLieu implements DAO<model_TaiLieu> {
    
    public int insert(model_TaiLieu tailieu) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO `tai lieu`(MaTaiLieu,TenTaiLieu,SoLuongCon,LoaiTaiLieu,TLDacbiet,SoLuongDangMuon)"
                    +" VALUES(?,?,?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,tailieu.getMatl());
            st.setString(2,tailieu.getTentl());
            st.setInt(3,tailieu.getSoluongcon());
            st.setString(4,tailieu.getLoaitl());
            st.setInt(5,tailieu.getTldb());
            st.setInt(6,tailieu.getSldangmuon());
            
            ans=st.executeUpdate();
            System.out.println("Bạn đã thực thi: "+sql);
            System.out.println("Có "+ans+" dòng bị thay đổi");
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return ans;
    }

    
    public int update(model_TaiLieu tailieu) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="UPDATE `tai lieu` "+
            		"SET   `TenTaiLieu`="+"'"+tailieu.getTentl()+"'"
            		+",`SoLuongCon`="+"'"+tailieu.getSoluongcon()+"'"
            		+",`LoaiTaiLieu`="+"'"+tailieu.getLoaitl()+"'"
            		+",`TLDacbiet`="+"'"+tailieu.getTldb()+"'"
            	    +",`SoLuongDangMuon`="+"'"+tailieu.getSldangmuon()+"'"
                   +"WHERE `MaTaiLieu`="+"'"+tailieu.getMatl()+"'";
//            String sql="UPDATE `tai lieu` "+"SET `TenTaiLieu`='?',`SoLuongCon`='?',`LoaiTaiLieu`='?',`TLDacbiet`='?'"
//            +"WHERE `MaTaiLieu`='?'";
           
            PreparedStatement st=con.prepareStatement(sql);
           
//            st.setString(1,tailieu.getTentl()+"");
////            st.setInt(2,tailieu.getSoluongcon());
////            st.setString(3,tailieu.getLoaitl()+"");
////            st.setInt(4,tailieu.getTldb());
//            
//            st.setInt(5,tailieu.getMatl());
           
            ans=st.executeUpdate();
            
            System.out.println("Bạn đã thực thi: "+sql);
            System.out.println("Có "+ans+" dòng bị thay đổi");
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }

    public int delete(model_TaiLieu tailieu) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="DELETE from `tai lieu` "+"WHERE MaTaiLieu=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,tailieu.getMatl());
            ans=st.executeUpdate();
            System.out.println("Bạn đã thực thi: "+sql);
            System.out.println("Có "+ans+" dòng bị thay đổi");
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }

    public ArrayList<model_TaiLieu> selectAll() {
        ArrayList<model_TaiLieu> ans=new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `tai lieu`";
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
                ans.add(tailieu);
            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }
    public ArrayList<model_TaiLieu> TaiLieuMuonNhieuNhat() {
        ArrayList<model_TaiLieu> ans=new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `tai lieu` WHERE 1 ORDER BY SoLuongDangMuon DESC ";
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
                ans.add(tailieu);
            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }

	
	


}