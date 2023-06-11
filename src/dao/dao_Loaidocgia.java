package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbcutil.JDBCUtil;

import model.model_LoaiDocGia;

public class dao_Loaidocgia {
	public static int update(model_LoaiDocGia loaidocgia) {
      int ans=0;
      try{
          Connection con= JDBCUtil.getConnection();
//          String sql="UPDATE `loai doc gia` "+"SET TaiLieuDB="+"'"+loaidocgia.getTaiLieuDB()+"'"+",SoNgayMuonToiDa="+"'"+loaidocgia.getSoNgayMuonToiDa()+"'"+",SoSachMuonToiDa="+"'"+loaidocgia.getSoSachMuonToiDa()+"'"+",PhiThuongNien="+"'"+loaidocgia.getPhiThuongNien()+"'"
//          		
//          		 + "WHERE TenLoaiDG="+loaidocgia.getTenLoaiDG();
          
          String sql="UPDATE `loai doc gia` "+"SET TaiLieuDB=?,SoNgayMuonToiDa=?,SoSachMuonToiDa=?,PhiThuongNien=? "
                  + "WHERE TenLoaiDG=?";
          PreparedStatement st=con.prepareStatement(sql);
          
          st.setString(5,loaidocgia.getTenLoaiDG());
          st.setString(1,""+loaidocgia.getTaiLieuDB());
          st.setString(2,""+loaidocgia.getSoNgayMuonToiDa());
          st.setString(3,""+loaidocgia.getSoSachMuonToiDa());
          st.setString(4,""+loaidocgia.getPhiThuongNien());
          
          //PreparedStatement st=con.prepareStatement(sql);
          
          ans=st.executeUpdate();
          System.out.println("Bạn đã thực thi: "+sql);
          System.out.println("Có "+ans+" dòng bị thay đổi");
          JDBCUtil.closeConnection(con);
      } catch(SQLException e){
          e.printStackTrace();
      }
      return ans;
  }
	 public  ArrayList<model_LoaiDocGia> importAll() {
	       ArrayList<model_LoaiDocGia> ans=new ArrayList<>();
	        try{
	            Connection con=JDBCUtil.getConnection();
	            String sql="SELECT * FROM `loai doc gia`";
	            PreparedStatement st=con.prepareStatement(sql);
	            ResultSet rs = st.executeQuery();
	             
	            while(rs.next()){
	                model_LoaiDocGia loaidocgia= new model_LoaiDocGia();
	                loaidocgia.setPhiThuongNien(rs.getInt("PhiThuongNien"));
	                loaidocgia.setSoNgayMuonToiDa(rs.getInt("SoNgayMuonToiDa"));
	                loaidocgia.setSoSachMuonToiDa(rs.getInt("SoSachMuonToiDa"));
	                loaidocgia.setTaiLieuDB(rs.getInt("TaiLieuDB"));
	                loaidocgia.setTenLoaiDG(rs.getString("TenLoaiDG"));
	                
	                
	                ans.add(loaidocgia);
	               
	            }
	          
	            JDBCUtil.closeConnection(con);
	        } catch(SQLException e){
	            e.printStackTrace();
	        }
	        return ans;
	    }
	  
	

}
