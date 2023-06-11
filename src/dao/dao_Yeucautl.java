package dao;

import jdbcutil.JDBCUtil;
import model.model_Yeucautl;


import java.sql.*;
import java.util.ArrayList;

public class dao_Yeucautl implements DAO<model_Yeucautl> {
    @Override
    public int insert(model_Yeucautl tlyeucau) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO `tai lieu yeu cau` (stt, tentailieu, trangthai,doituong)"
                    +" VALUES(?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,""+tlyeucau.getStt());
            st.setString(2,tlyeucau.getTentailieu());
            st.setString(3,tlyeucau.getTrangthai());
            st.setString(4,""+tlyeucau.getDoituong());
            
            ans=st.executeUpdate();
            System.out.println("Bạn đã thực thi: "+sql);
            System.out.println("Có "+ans+" dòng bị thay đổi");
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return ans;
    }

  
    public int update(model_Yeucautl tlyeucau) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="UPDATE `tai lieu yeu cau` "+"SET tentailieu=?,trangthai=?,doituong=?"+
                    "WHERE stt=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(4,""+tlyeucau.getStt() );

            st.setString(1, tlyeucau.getTentailieu());
            st.setString(2,tlyeucau.getTrangthai() );
            st.setString(3,""+tlyeucau.getDoituong() );
            
            ans=st.executeUpdate();
            System.out.println("Bạn đã thực thi: "+sql);
            System.out.println("Có "+ans+" dòng bị thay đổi");
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }
    @Override
    public int delete(model_Yeucautl tlyeucau) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="DELETE from `tai lieu yeu cau` "+"WHERE stt=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,""+tlyeucau.getStt());
            ans=st.executeUpdate();
            System.out.println("Bạn đã thực thi: "+sql);
            System.out.println("Có "+ans+" dòng bị thay đổi");
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }

    public ArrayList<model_Yeucautl> selectAll() {
        ArrayList<model_Yeucautl> ans=new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `tai lieu yeu cau`";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                model_Yeucautl tailieuyeucau= new model_Yeucautl();
                tailieuyeucau.setStt(rs.getInt("stt"));
                tailieuyeucau.setTentailieu(rs.getString("Tentailieu"));
                tailieuyeucau.setDoituong(rs.getInt("doituong"));
                tailieuyeucau.setTrangthai(rs.getString("trangthai"));
                
                ans.add(tailieuyeucau);
            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }



}