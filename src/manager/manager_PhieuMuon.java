package manager;

import java.util.ArrayList;

import dao.dao_DangNhap;
import dao.dao_PhieuMuon;
import dao.dao_TaiLieu;
import model.model_DangNhap;
import model.model_PhieuMuon;
import model.model_TaiLieu;

public class manager_PhieuMuon {
	public static dao_PhieuMuon data =new dao_PhieuMuon();
    public static ArrayList<model_PhieuMuon> phieumuonList = new ArrayList<>();
   
    public static ArrayList<model_PhieuMuon> PhieumuonList () {
    	phieumuonList = data.selectAll();
    	return phieumuonList;
    }
    public static void insert(model_PhieuMuon phieumuon){
      data.insert(phieumuon);
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
