package manager;

import java.util.ArrayList;

import dao.dao_DangNhap;
import dao.dao_PhieuMuon;
import dao.dao_PhieuTra;
import dao.dao_TaiLieu;
import model.model_DangNhap;
import model.model_PhieuMuon;
import model.model_PhieuTra;
import model.model_TaiLieu;

public class manager_PhieuTra {
	public static dao_PhieuTra data =new dao_PhieuTra();
    public static ArrayList<model_PhieuTra> phieutraList = new ArrayList<>();
   
    public static ArrayList<model_PhieuTra> PhieutraList () {
    	phieutraList = data.selectAll();
    	return phieutraList;
    }
    public static void insert(model_PhieuTra phieutra){
      data.insert(phieutra);
  }

//    public static void add(model_TaiLieu tailieu){
//        tailieuList.add(tailieu);
//    }
//   
//    public static void update (model_TaiLieu tailieu){
//        data.update(tailieu);
//    }
//    public static void delete (model_TaiLieu tailieu){
//        data.delete(tailieu);
//    }

}
