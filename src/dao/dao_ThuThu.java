package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbcutil.JDBCUtil;
import model.model_DocGia;
import model.model_NhanVien;

public class dao_ThuThu {
	 public ArrayList<model_NhanVien> importAll() {
	       ArrayList<model_NhanVien> ans=new ArrayList<>();
	        try{
	            Connection con=JDBCUtil.getConnection();
	            String sql="SELECT * FROM `nhan vien`";
	            PreparedStatement st=con.prepareStatement(sql);
	            ResultSet rs = st.executeQuery();
	             
	            while(rs.next()){
	                model_NhanVien thuthu= new model_NhanVien();
	                thuthu.setManv(rs.getString("MaNV"));;
	                thuthu.setHotennv(rs.getString("HoTen"));
	                thuthu.setUser(rs.getString("TenDangNhap"));
	                thuthu.setCa(rs.getInt("CaTruc"));;
	                
	              
	                ans.add(thuthu);
	               
	            }
	            JDBCUtil.closeConnection(con);
	        } catch(SQLException e){
	            e.printStackTrace();
	        }
	        return ans;
	    }
	 public int update(model_NhanVien nhanvien) {
	      int ans=0;
	      try{
	          Connection con= JDBCUtil.getConnection();
	          String sql="UPDATE `nhan vien` "+"SET CaTruc="+"'"+nhanvien.getCa()+"'"+",TenDangNhap="+"'"+nhanvien.getUser()+"'"+",HoTen="+"'"+nhanvien.getHotennv()+"'"
	          		+ " WHERE MaNV="+"'"+nhanvien.getManv()+"'";
	          
	        
	          PreparedStatement st=con.prepareStatement(sql);
	          
	          ans=st.executeUpdate();
	          System.out.println("Bạn đã thực thi: "+sql);
	          System.out.println("Có "+ans+" dòng bị thay đổi");
	          JDBCUtil.closeConnection(con);
	      } catch(SQLException e){
	          e.printStackTrace();
	      }
	      return ans;
	  }
		  public int insert(model_NhanVien nhanvien) {
		        int ans=0;
		        try{
		            Connection con= JDBCUtil.getConnection();
		            String sql="INSERT INTO `nhan vien` (`MaNV`, `CaTruc`, `TenDangNhap`, `HoTen`)"
		                    +" VALUES(?,?,?,?)";
		            PreparedStatement st=con.prepareStatement(sql);
		            st.setString(1,nhanvien.getManv());
		            st.setString(2, String.valueOf(nhanvien.getCa()));
		            st.setString(3,nhanvien.getUser());
		            st.setString(4,nhanvien.getHotennv());
		            
		            
		        
		            
		            ans=st.executeUpdate();
		            System.out.println("Bạn đã thực thi: "+sql);
		            System.out.println("Có "+ans+" dòng bị thay đổi");
		            JDBCUtil.closeConnection(con);
		        } catch (SQLException ex){
		            ex.printStackTrace();
		        }
		        return ans;
		    }
		public int delete (model_NhanVien nhanvien) {
	        int ans=0;
	        try{
	            Connection con= JDBCUtil.getConnection();
	            String sql="DELETE from `nhan vien` "+"WHERE MaNV=?";
	            PreparedStatement st=con.prepareStatement(sql);
	            st.setString(1,nhanvien.getManv());
	            ans=st.executeUpdate();
	            System.out.println("Bạn đã thực thi: "+sql);
	            System.out.println("Có "+ans+" dòng bị thay đổi");
	            JDBCUtil.closeConnection(con);
	        } catch(SQLException e){
	            e.printStackTrace();
	        }
	        return ans;
	    }
}
