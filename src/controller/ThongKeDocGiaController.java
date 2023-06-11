package controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import manager.manager_DangNhap;
import manager.manager_DocGia;
import manager.manager_TaiLieu;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_TaiLieu;

public class ThongKeDocGiaController implements Initializable {
	
  
    public PieChart piechartdocgia;
    public int soLuongSinhVien,soLuongCanBo,soLuongKhach;
   
	public Text tfSinhvien;
	public Text tfCanbo;
	public Text tfKhach;
	public String sinhVien;
	public String canBo;
	public String khach;
	public float phantramsinhvien;
	public float phantramkhach;
	public float phantramcanbo;

	
	 
	
	  
	   public TableView <model_DocGia> tabledocgia;
	   
	  
	    
	    

	

	   

	public void initialize(URL location, ResourceBundle resources) {
	
		
		soLuongSinhVien=0;
		soLuongCanBo=0;
		soLuongKhach=0;
		sinhVien="";
		khach="";
		canBo="";
		for(model_DocGia x:		manager_DocGia.DocgiaList()) {
			if(x.getLoai().equals("Sinh viên")) {
				soLuongSinhVien++;
			}
			else {
				if(x.getLoai().equals("Cán bộ")) {
					soLuongCanBo++;
				}
				else soLuongKhach++;
			}
		}
		phantramsinhvien=(float)((int)((float)soLuongSinhVien/(soLuongSinhVien+soLuongCanBo+soLuongKhach)*10000))/100;
		phantramcanbo=(float)((int)((float)soLuongCanBo/(soLuongSinhVien+soLuongCanBo+soLuongKhach)*10000))/100;
		phantramkhach=100-phantramsinhvien-phantramcanbo;
		sinhVien="Sinh Viên: "+soLuongSinhVien+"("+phantramsinhvien+"%)";
		tfSinhvien.setText(sinhVien);
		khach="Khách: "+soLuongKhach+" ("+phantramkhach+"%)";
		tfKhach.setText(khach);
		canBo="Cán Bộ: "+soLuongCanBo+" ("+phantramcanbo+"%)";
		tfCanbo.setText(canBo);
		
		PieChart.Data sinhvien = new PieChart.Data("Sinh Viên", soLuongSinhVien);
		PieChart.Data canbo = new PieChart.Data("Cán Bộ", soLuongCanBo);
		PieChart.Data khach = new PieChart.Data("Khách", soLuongKhach);
		piechartdocgia.getData().clear();
		piechartdocgia.getData().addAll(sinhvien,canbo,khach);

		
        
		
	}

	 

	
}
