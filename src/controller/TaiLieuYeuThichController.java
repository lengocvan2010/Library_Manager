package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import jdbcutil.JDBCUtil;
import manager.manager_TaiLieuYeuThich;
import manager.manager_Yeucautl;
import model.model_TaiLieu;
import model.model_TaiLieuYeuThich;

public class TaiLieuYeuThichController implements Initializable {
	static ObservableList<model_TaiLieu> tailieuListController = FXCollections.observableArrayList();
	
	 public TableView <model_TaiLieu> tabletailieu;
	   
	    @FXML
	    private TableColumn<model_TaiLieu,Integer> colMaTaiLieu;
	    @FXML
	    private TableColumn<model_TaiLieu,String> colTenTaiLieu;
	    @FXML
	    private TableColumn<model_TaiLieu,String> colLoaiTaiLieu;
	    @FXML
	    private TableColumn<model_TaiLieu,Integer> colSoLuongCon;
	    @FXML
	    private TableColumn<model_TaiLieu,Integer> colTLDacBiet;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tailieuListController.clear();
		for(model_TaiLieuYeuThich x: manager_TaiLieuYeuThich.TailieuyeuthichList()) {
			if(x.getMaDocGia()==LoginController.docgiadangnhap.getMaDocGia()) {
				try{
		            Connection con=JDBCUtil.getConnection();
		            String sql="SELECT * FROM `tai lieu` WHERE MaTaiLieu="+"'"+x.getMaTaiLieu()+"'";
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
		                tailieuListController.add(tailieu);
		            }
		            JDBCUtil.closeConnection(con);
		        } catch(SQLException e){
		            e.printStackTrace();
		        }
			}
			
		}
		colMaTaiLieu.setCellValueFactory(new PropertyValueFactory<model_TaiLieu,Integer>("matl"));
        colTenTaiLieu.setCellValueFactory(new PropertyValueFactory<model_TaiLieu,String>("tentl"));
        colLoaiTaiLieu.setCellValueFactory(new PropertyValueFactory<model_TaiLieu,String>("loaitl"));
        colSoLuongCon.setCellValueFactory(new PropertyValueFactory<model_TaiLieu, Integer>("soluongcon"));
        colTLDacBiet.setCellValueFactory(new PropertyValueFactory<model_TaiLieu,Integer>("tldb"));
         tabletailieu.setItems(tailieuListController);
        
		
	}
	public int index;
	public void bothich (ActionEvent event) throws IOException {
		index= tabletailieu.getSelectionModel().getSelectedIndex();
		if(index==-1) {
			Alert alert = new Alert(AlertType.WARNING, "Bạn chưa chọn tài liệu.Vui lòng kiểm tra lại!", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			return;
	 }
		model_TaiLieuYeuThich tlyeuthich =new model_TaiLieuYeuThich();
		
    	tlyeuthich.setMaTaiLieu(colMaTaiLieu.getCellData(index));
    	tlyeuthich.setMaDocGia(LoginController.docgiadangnhap.getMaDocGia());
    	
    	
		
	manager_TaiLieuYeuThich.delete(tlyeuthich);   
	    
	   }
	public void lammoi (ActionEvent event) throws IOException {
		
		initialize(null,null);
	    
	   }

}
