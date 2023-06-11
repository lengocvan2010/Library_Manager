package manager;

import java.util.ArrayList;

import dao.dao_DangNhap;
import dao.dao_PhieuMuon;
import dao.dao_PhieuPhat;
import dao.dao_TaiLieu;
import model.model_DangNhap;
import model.model_PhieuMuon;
import model.model_PhieuPhat;
import model.model_TaiLieu;

public class manager_PhieuPhat {
	public static dao_PhieuPhat data =new dao_PhieuPhat();
    public static ArrayList<model_PhieuPhat> phieuphatList = new ArrayList<>();
   
    public static ArrayList<model_PhieuPhat> PhieuphatList () {
    	phieuphatList = data.selectAll();
    	return phieuphatList;
    }
    public static void insert(model_PhieuPhat phieuphat){
      data.insert(phieuphat);
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
