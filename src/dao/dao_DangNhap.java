package dao;
import jdbcutil.JDBCUtil;
import model.model_DangNhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dao_DangNhap {

    public static int insert(model_DangNhap dangnhap) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO `dang nhap nv`(TenDangNhap,MatKhau,DoiTuong)"
                    +" VALUES(?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,dangnhap.getUsername());
            st.setString(2, dangnhap.getPassword());
            st.setString(3,dangnhap.getDoiTuong());
            
            ans=st.executeUpdate();
            System.out.println("Bạn đã thực thi: "+sql);
            System.out.println("Có "+ans+" dòng bị thay đổi");
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return ans;
    }

    public static int update(model_DangNhap dangnhap) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="UPDATE `dang nhap nv` "+"SET MatKhau ="+"'"+dangnhap.getPassword()+"'"
                    + "WHERE TenDangNhap="+"'"+dangnhap.getUsername()+"'";
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

    public static int delete(model_DangNhap dangnhap) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="DELETE from `dang nhap nv` "+"WHERE TenDangNhap=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,dangnhap.getUsername());
            ans=st.executeUpdate();
            System.out.println("Bạn đã thực thi: "+sql);
            System.out.println("Có "+ans+" dòng bị thay đổi");
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }

    public  ArrayList<model_DangNhap> importAll() {
       ArrayList<model_DangNhap> ans=new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `dang nhap nv`";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
             
            while(rs.next()){
                model_DangNhap dangnhap= new model_DangNhap();
                dangnhap.setUsername(rs.getString("TenDangNhap"));
                dangnhap.setPassword(rs.getString("MatKhau"));
                dangnhap.setDoiTuong(rs.getString("DoiTuong"));
                
                ans.add(dangnhap);
               
            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }

	
}
