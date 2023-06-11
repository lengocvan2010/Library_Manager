package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbcutil.JDBCUtil;
import model.model_TaiLieu;
import model.model_TaiLieuYeuThich;

public class dao_TaiLieuYeuThich {
	 public int insert(model_TaiLieuYeuThich tailieuyeuthich) {
	        int ans=0;
	        try{
	            Connection con= JDBCUtil.getConnection();
	            String sql="INSERT INTO `tai lieu yeu thich`(MaDocGia,MaTaiLieu,TenTaiLieu)"
	                    +" VALUES(?,?,?)";
	            PreparedStatement st=con.prepareStatement(sql);
	            st.setString(1,tailieuyeuthich.getMaDocGia()+"");
	            st.setString(2,tailieuyeuthich.getMaTaiLieu()+"");
	            st.setString(3,tailieuyeuthich.getTenTaiLieu());
	            
	            
	            ans=st.executeUpdate();
	            System.out.println("Bạn đã thực thi: "+sql);
	            System.out.println("Có "+ans+" dòng bị thay đổi");
	            JDBCUtil.closeConnection(con);
	        } catch (SQLException ex){
	            ex.printStackTrace();
	        }
	        return ans;
	    }
	 public int delete(model_TaiLieuYeuThich tailieuyeuthich) {
	        int ans=0;
	        try{
	            Connection con= JDBCUtil.getConnection();
	            String sql="DELETE from `tai lieu yeu thich` "+"WHERE MaTaiLieu=? AND MaDocGia=?";
	            PreparedStatement st=con.prepareStatement(sql);
	            st.setString(1,tailieuyeuthich.getMaTaiLieu()+"");
	            st.setString(2,tailieuyeuthich.getMaDocGia()+"");

	            ans=st.executeUpdate();
	            System.out.println("Bạn đã thực thi: "+sql);
	            System.out.println("Có "+ans+" dòng bị thay đổi");
	            JDBCUtil.closeConnection(con);
	        } catch(SQLException e){
	            e.printStackTrace();
	        }
	        return ans;
	    }
	 
	 public ArrayList<model_TaiLieuYeuThich> selectAll() {
	        ArrayList<model_TaiLieuYeuThich> ans=new ArrayList<>();
	        try{
	            Connection con=JDBCUtil.getConnection();
	            String sql="SELECT * FROM `tai lieu yeu thich`";
	            PreparedStatement st=con.prepareStatement(sql);
	            ResultSet rs = st.executeQuery();
	            while(rs.next()){
	            	model_TaiLieuYeuThich tailieuyeuthich=new model_TaiLieuYeuThich();
	            	tailieuyeuthich.setMaDocGia(rs.getInt("MaDocGia"));
	                tailieuyeuthich.setMaTaiLieu(rs.getInt("MaTaiLieu"));
	                tailieuyeuthich.setTenTaiLieu(rs.getString("TenTaiLieu"));
	                
	                ans.add(tailieuyeuthich);
	            }
	            JDBCUtil.closeConnection(con);
	        } catch(SQLException e){
	            e.printStackTrace();
	        }
	        return ans;
	    }


}
