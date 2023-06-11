package manager;

import java.util.ArrayList;

import dao.dao_DangNhap;
import dao.dao_PhieuMuon;
import dao.dao_PhieuNhacNho;
import dao.dao_TaiLieu;
import model.model_DangNhap;
import model.model_PhieuMuon;
import model.model_PhieuNhacNho;
import model.model_TaiLieu;

public class manager_PhieuNhacNho {
	public static dao_PhieuNhacNho data =new dao_PhieuNhacNho();
    public static ArrayList<model_PhieuNhacNho> phieunhacnhoList = new ArrayList<>();
   
    public static ArrayList<model_PhieuNhacNho> PhieunhacnhoList () {
    	phieunhacnhoList = data.selectAll();
    	return phieunhacnhoList;
    }
    public static void insert(model_PhieuNhacNho phieunhacnho){
      data.insert(phieunhacnho);
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
