package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import model.model_DocGia;
import model.model_TaiLieu;

public class chitietdgController implements Initializable {
	
	 public Text tfMadocgia;
	    public Text tfHoten;
	    public Text tfNgaysinh;
	    public Text tfDiachi;
	    public Text tfSdt;
	    public Text tfSachquahan;
	    public Text tfSachmuon;
	    public Text tfLoaidocgia;
	    public Text tfMS;
	    public Text tfCMND;
	    public Text tfEmail;
	    public Text tfTendangnhap;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		 tfMadocgia.setText(String.valueOf(TimdocgiaController.docgia.getMaDocGia()));
	        tfHoten.setText(TimdocgiaController.docgia.getTenDocGia());
	        tfNgaysinh.setText(TimdocgiaController.docgia.getNgaySinh());
	        tfDiachi.setText(TimdocgiaController.docgia.getDiaChi());
	        tfSdt.setText(TimdocgiaController.docgia.getSDT());
	        tfSachquahan.setText(String.valueOf(TimdocgiaController.docgia.getSachquahan()));
	        tfSachmuon.setText(String.valueOf(TimdocgiaController.docgia.getSachdangmuon()));
	        tfLoaidocgia.setText(TimdocgiaController.docgia.getLoai());
	        if (!TimdocgiaController.docgia.getMCB().equals("")) {
	        	tfMS.setText(TimdocgiaController.docgia.getMCB());
	        	}
	        else {
	        	if(!TimdocgiaController.docgia.getMSSV().equals("")) {
	        		tfMS.setText(TimdocgiaController.docgia.getMSSV());
	        	}
	        	else {
	        		tfMS.setText("Trống");
	        	}
	        }
	        tfCMND.setText(TimdocgiaController.docgia.getCMND());
	        tfEmail.setText(TimdocgiaController.docgia.getEmail());
	        tfTendangnhap.setText(TimdocgiaController.docgia.getUserName());
	        


	        
		
	}
	}

