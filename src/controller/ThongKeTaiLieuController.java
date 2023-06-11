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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jdbcutil.JDBCUtil;
import manager.manager_DangNhap;
import manager.manager_DocGia;
import manager.manager_TaiLieu;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_TaiLieu;

public class ThongKeTaiLieuController  {
	
   
	 public BorderPane borderPane;

	   

	 public void thongkeloaitailieu (ActionEvent event) throws IOException {
	 	
	 	

	 	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/thongkeloaitailieu.fxml"));
	 	Pane timtlPane = (Pane) loader.load();
	 	borderPane.setCenter(timtlPane);
	  
	 }
	 public void thongketailieudacbiet (ActionEvent event) throws IOException {
	 	
	 	

	 	

	 	FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/thongketailieudacbiet.fxml"));
	 	Pane themtlPane = (Pane) loader.load();
	 	borderPane.setCenter(themtlPane);
	 	 
	 	}
	
	 
	
}

