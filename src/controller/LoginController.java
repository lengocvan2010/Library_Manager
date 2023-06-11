//package controller;
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//
//import application.Main;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Button;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//import javafx.stage.Window;
//import manager.manager_DangNhap;
//import jdbcutil.JDBCUtil;
//import model.model_NhanVien;
//import model.model_DangNhap;
//import model.model_DocGia;
//
//public class LoginController implements Initializable {
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Connection conn = jdbcutil.JDBCUtil.getConnection();
//        PreparedStatement sta = null;
//        try {
//            sta = conn.prepareStatement("update employee set login = 'false' ");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            sta.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @FXML
//    private TextField UserID;
//
//    @FXML
//    private PasswordField passwordField;
//
//    @FXML
//    private Button submitButton;
//
//    @FXML
//    public void login(ActionEvent event) throws SQLException, IOException {
//
//
//        Window owner = submitButton.getScene().getWindow();
//
//        if (UserID.getText().isEmpty()) {
//            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
//                    "Please enter your email id");
//            return;
//        }
//        if (passwordField.getText().isEmpty()) {
//            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
//                    "Please enter a password");
//            return;
//        }
//
//        String username = UserID.getText();
//        String password = passwordField.getText();
//
//        boolean check = false;
//        for(model_DangNhap x : manager_DangNhap.dangnhapList){
//            if(x.getUsername().equals(username) && x.getPassword().equals(password)){
//                check = true;
//                Connection con = JDBCUtil.getConnection();
//                PreparedStatement st = con.prepareStatement("update employee set login = 'true' where id =  ?");
//                st.setString(1, x.getUsername());
//              //  Main.dangnhap= manager_DangNhap.get(x.getUsername());
//                st.executeUpdate();
//                break;
//            }
//        }
//        if(check){
//            // Chuyển cảnh
//            Node source = (Node)  event.getSource();
//            Stage stage  = (Stage) source.getScene().getWindow();
//            stage.close();
//
//            Parent root = FXMLLoader.load(this.getClass().getResource("MainController.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.setTitle("One Media");
//
//            stage.show();
//        }
//        else{
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Thông báo");
//            alert.setHeaderText("Thông báo:");
//            alert.setContentText("Thông tin đăng nhập không chính xác !");
//            alert.showAndWait();
//        }
//    }
//
//    public static void infoBox(String infoMessage, String headerText, String title) {
//        Alert alert = new Alert(AlertType.CONFIRMATION);
//        alert.setContentText(infoMessage);
//        alert.setTitle(title);
//        alert.setHeaderText(headerText);
//        alert.showAndWait();
//    }
//
//    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
//        Alert alert = new Alert(alertType);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.initOwner(owner);
//        alert.show();
//    }
//
//
//}
package controller;

import java.awt.Window;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.dao_DangNhap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import jdbcutil.JDBCUtil;
import manager.manager_DangNhap;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_NhanVien;

public class LoginController {
	@FXML
	private TextField tfUsername;

	@FXML
	private PasswordField tfPassword;
	public static String doituong="";
	
	public void selectthuthu (ActionEvent event) throws IOException {
			doituong="thuthu";
		 }
	public void selectdocgia (ActionEvent event) throws IOException {
		doituong="user";
	     }
	public void selectadmin (ActionEvent event) throws IOException {
		doituong="admin";
	     }
	public static model_DangNhap current = new model_DangNhap();
	public static model_NhanVien thuthudangnhap = new model_NhanVien();
	public static model_NhanVien admin = new model_NhanVien();

	public static model_DocGia docgiadangnhap = new model_DocGia();

	public void login(ActionEvent event) throws IOException {
		if (doituong.equals("")){
			Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn vai trò đăng nhập. Vui lòng kiểm tra lại!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}
		

		String username = tfUsername.getText();
		String password = tfPassword.getText();
		if (username.equals("")||password.equals("")){
			Alert alert = new Alert(AlertType.WARNING, "Bạn chưa đủ thông tin. Vui lòng kiểm tra lại!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}
		
		boolean check= false;
		for(model_DangNhap x : manager_DangNhap.DangnhapList()){ 
		
	         if(x.getUsername().equals(username) && x.getPassword().equals(password)&& x.getDoiTuong().equals(doituong)){
	              check = true;
	              current=x;
	             
              if (current.getDoiTuong().equals("thuthu")) {
	               	  try{
	         	            Connection con=JDBCUtil.getConnection();
	         	            String sql="SELECT * FROM `nhan vien` WHERE TenDangNhap="+"'"+current.getUsername()+"'";
	         	            PreparedStatement st=con.prepareStatement(sql);
	         	            ResultSet rs = st.executeQuery();
	         	             
	         	            while(rs.next()){
	         	                model_NhanVien thuthu= new model_NhanVien();
	         	                thuthu.setManv(rs.getString("MaNV"));
	         	                thuthu.setHotennv(rs.getString("HoTen"));
	         	                thuthu.setUser(rs.getString("TenDangNhap"));
	         	                thuthu.setCa(rs.getInt("CaTruc"));
	         	                
	         	              thuthudangnhap=thuthu;

	         	               
	         	            }
	         	            JDBCUtil.closeConnection(con);
	         	        } catch(SQLException e){
	         	            e.printStackTrace();
	         	        }
	               	  
              }
              
              
              if (current.getDoiTuong().equals("user")) {
               	  try{
         	            Connection con=JDBCUtil.getConnection();
         	            String sql="SELECT * FROM `docgia` WHERE TenDangNhap="+"'"+current.getUsername()+"'";
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
         	                
         	                
         	              docgiadangnhap=docgia;

         	               
         	            }
         	            JDBCUtil.closeConnection(con);
         	        } catch(SQLException e){
         	            e.printStackTrace();
         	        }
               	  
          }
              
              if (current.getDoiTuong().equals("admin")) {
               	  try{
         	            Connection con=JDBCUtil.getConnection();
         	            String sql="SELECT * FROM `nhan vien` WHERE TenDangNhap="+"'"+current.getUsername()+"'";
         	            PreparedStatement st=con.prepareStatement(sql);
         	            ResultSet rs = st.executeQuery();
         	             
         	            while(rs.next()){
         	                model_NhanVien thuthu= new model_NhanVien();
         	                thuthu.setManv(rs.getString("MaNV"));
         	                thuthu.setHotennv(rs.getString("HoTen"));
         	                thuthu.setUser(rs.getString("TenDangNhap"));
         	                thuthu.setCa(rs.getInt("CaTruc"));
         	                
         	              admin=thuthu;

         	               
         	            }
         	            JDBCUtil.closeConnection(con);
         	        } catch(SQLException e){
         	            e.printStackTrace();
         	        }
               	  
          }
	             
	             break;
	         }
	         }
	     
		if(check) {
			if(doituong.equals("thuthu")) {

				Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
				Parent home = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
				stage.close();
		        stage.setScene(new Scene(home));
		        stage.setResizable(false);
		        
		        stage.show();
		        //stage.setCenter();
			}
			
			if(doituong.equals("admin")) {

				Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
				Parent home = FXMLLoader.load(getClass().getResource("/views/home1.fxml"));
				stage.close();
		        stage.setScene(new Scene(home));
		        stage.setResizable(false);
		        
		        stage.show();
		        //stage.setCenter();
			}
			if(doituong.equals("user")) {

				Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
				Parent home = FXMLLoader.load(getClass().getResource("/views/home2.fxml"));
				stage.close();
		        stage.setScene(new Scene(home));
		        stage.setResizable(false);
		        
		        stage.show();
		        //stage.setCenter();
			}
			
		}
		else{
			Alert alert = new Alert(AlertType.WARNING, "Tài khoản, mật khẩu hoặc vai trò không chính xác.\nVui lòng kiểm tra lại!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
		}
		
		
	}

}
