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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdbcutil.JDBCUtil;
import manager.manager_DangNhap;
import manager.manager_DocGia;
import manager.manager_TaiLieu;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_TaiLieu;

public class ThongKeTaiLieuDacBietController implements Initializable {
	
    public  PieChart piechartloaitailieu;
    public PieChart piecharttailieudacbiet;
    public int soTaiLieuDacBiet,soTaiLieuKhongDacBiet,tongSoTaiLieu;
    public float phanTramTLDB,phanTram;
    public float phanTramTLBT;
     public Text dacbiet;
     public Text binhthuong;
 
	 public model_TaiLieu tailieu =new model_TaiLieu();
	 
	
	


	public void initialize(URL location, ResourceBundle resources) {
		soTaiLieuDacBiet=0;
		soTaiLieuKhongDacBiet=0;
		
		

		for(model_TaiLieu x: manager_TaiLieu.TailieuList()) {
			if(x.getTldb()==1) {
				soTaiLieuDacBiet++;
			}
			else {
				
				soTaiLieuKhongDacBiet++;
				
				
			}
		}
		phanTramTLDB = (float)((int)((float)soTaiLieuDacBiet/(soTaiLieuDacBiet+soTaiLieuKhongDacBiet)*10000))/100;
		phanTramTLBT = (float)((int)((float)soTaiLieuKhongDacBiet/(soTaiLieuDacBiet+soTaiLieuKhongDacBiet)*10000))/100;

		PieChart.Data tldb = new PieChart.Data("Đặc biệt",soTaiLieuDacBiet );
		PieChart.Data tlbt = new PieChart.Data("Bình thường", soTaiLieuKhongDacBiet);
		piecharttailieudacbiet.getData().clear();
		piecharttailieudacbiet.getData().addAll(tldb,tlbt);
		dacbiet.setText("Đặc biệt: "+String.valueOf(soTaiLieuDacBiet)+" ("+String.valueOf(phanTramTLDB)+"%)");
		binhthuong.setText("Bình thường: "+String.valueOf(soTaiLieuKhongDacBiet)+" ("+String.valueOf(phanTramTLBT)+"%)");
		
	}

	 
	
}

