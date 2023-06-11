package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbcutil.JDBCUtil;
import model.model_DangNhap;
import model.model_DocGia;

public class dao_DocGia {
	public static int update(model_DocGia docgia) {
      int ans=0;
      try{
          Connection con= JDBCUtil.getConnection();
          String sql="UPDATE `docgia` "+"SET TenDangNhap="+"'"+docgia.getUserName()+"'"+",HoTen="+"'"+docgia.getTenDocGia()+"'"+",NgaySinh="+"'"+docgia.getNgaySinh()+"'"+",DiaChi="+"'"+docgia.getDiaChi()+"'"+",Sdt="+"'"+docgia.getSDT()+"'"+",Email="+"'"+docgia.getEmail()+"'"+",CMND="+"'"+docgia.getCMND()+"'"
          		+",MSSV="+"'"+docgia.getMSSV()+"'" +",MCB="+"'"+docgia.getMCB()+"'" +",LoaiDG="+"'"+docgia.getLoai()+"'" +",SachDangMuon="+"'"+docgia.getSachdangmuon()+"'" +",SachQuaHan="+"'"+docgia.getSachquahan()+"'"
          		+ "WHERE MaDocGia="+docgia.getMaDocGia();
          
        
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
	  public static int insert(model_DocGia docgia) {
	        int ans=0;
	        try{
	            Connection con= JDBCUtil.getConnection();
	            String sql="INSERT INTO `docgia` (`TenDangNhap`, `MaDocGia`, `HoTen`, `NgaySinh`, `DiaChi`, `Sdt`, `Email`, `CMND`, `MSSV`, `MCB`, `LoaiDG`, `SachDangMuon`, `SachQuaHan`)"
	                    +" VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	            PreparedStatement st=con.prepareStatement(sql);
	            st.setString(1,docgia.getUserName());
	            st.setString(2, String.valueOf(docgia.getMaDocGia()));
	            st.setString(3,docgia.getTenDocGia());
	            st.setString(4,docgia.getNgaySinh());
	            st.setString(5, docgia.getDiaChi());
	            st.setString(6,docgia.getSDT());
	            st.setString(7,docgia.getEmail());
	            st.setString(8, docgia.getCMND());
	            st.setString(9,docgia.getMSSV());
	            st.setString(10,docgia.getMCB());
	            st.setString(11, docgia.getLoai());
	            st.setString(12,String.valueOf(docgia.getSachdangmuon()));
	            st.setString(13,String.valueOf(docgia.getSachquahan()));
	            
	        
	            
	            ans=st.executeUpdate();
	            System.out.println("Bạn đã thực thi: "+sql);
	            System.out.println("Có "+ans+" dòng bị thay đổi");
	            JDBCUtil.closeConnection(con);
	        } catch (SQLException ex){
	            ex.printStackTrace();
	        }
	        return ans;
	    }
	public static int delete (model_DocGia docgia) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="DELETE from `docgia` "+"WHERE TenDangNhap=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,docgia.getUserName());
            ans=st.executeUpdate();
            System.out.println("Bạn đã thực thi: "+sql);
            System.out.println("Có "+ans+" dòng bị thay đổi");
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }

    public static ArrayList<model_DocGia> importAll() {
       ArrayList<model_DocGia> ans=new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM `docgia`";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
             
            while(rs.next()){
                model_DocGia docgia= new model_DocGia();
                docgia.setUserName(rs.getString("TenDangNhap"));
                docgia.setMaDocGia(rs.getInt("MaDocGia"));
                docgia.setTenDocGia(rs.getString("HoTen"));
                docgia.setNgaySinh(rs.getString("NgaySinh"));
                docgia.setDiaChi(rs.getString("DiaChi"));
                docgia.setSDT(rs.getString("Sdt"));
                docgia.setEmail(rs.getString("Email"));
                docgia.setCMND(rs.getString("CMND"));
                docgia.setMSSV(rs.getString("MSSV"+""));
                docgia.setMCB(rs.getString("MCB"+""));
                docgia.setLoai(rs.getString("LoaiDG"));
                docgia.setSachdangmuon(rs.getInt("SachDangMuon"));
                docgia.setSachquahan(rs.getInt("SachQuaHan"));
                
              
                ans.add(docgia);
               
            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }
	

}
