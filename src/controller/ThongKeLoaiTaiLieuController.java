package controller;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dao.dao_TaiLieu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import jdbcutil.JDBCUtil;
import manager.manager_DangNhap;
import manager.manager_DocGia;
import manager.manager_TaiLieu;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_TaiLieu;

public class ThongKeLoaiTaiLieuController implements Initializable {
	
    public  PieChart piechartloaitailieu;
    public PieChart piecharttailieudacbiet;
    public int soTaiLieuDacBiet,soTaiLieuKhongDacBiet,tongSoTaiLieu;
    public float phanTramTLDB,phanTram;
    public float phanTramTLBT;
    public BarChart<?,?> chart ;
 
	 public model_TaiLieu tailieu =new model_TaiLieu();
	 
	static ObservableList<String> loaitailieuListController = FXCollections.observableArrayList();
	static ObservableList<Integer> soluongtailieuListController = FXCollections.observableArrayList();
	
	static ObservableList<PieChart.Data> thongketailieuListController = FXCollections.observableArrayList();


	public void initialize(URL location, ResourceBundle resources) {
		
		tongSoTaiLieu=0;
		loaitailieuListController.clear();
		soluongtailieuListController.clear();

		try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT LoaiTaiLieu,COUNT(LoaiTaiLieu) AS soluong FROM `tai lieu` GROUP BY LoaiTaiLieu";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            	loaitailieuListController.add(rs.getString("LoaiTaiLieu"));
            	soluongtailieuListController.add(rs.getInt("soluong"));
            	tongSoTaiLieu+=rs.getInt("soluong");
            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }

		CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Loại tài liệu");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Số lượng (cuốn)");
        XYChart.Series dataSeries = new XYChart.Series<>();
        dataSeries.setName("Loại tài liệu");
        for(int j=0;j<=loaitailieuListController.size()-1;j++) {

			phanTram = (float)((int)((float)soluongtailieuListController.get(j)/tongSoTaiLieu*10000))/100;
			PieChart.Data y =new PieChart.Data(loaitailieuListController.get(j)+": "+ String.valueOf(phanTram)+"%", soluongtailieuListController.get(j));

			dataSeries.getData().add(new XYChart.Data<>(loaitailieuListController.get(j),soluongtailieuListController.get(j)));

		}
        
        

       
        chart.getData().add(dataSeries);
        chart.setTitle("Biểu đồ loại tài liệu");
        
		

		
		
		
	}

	 
	
}

