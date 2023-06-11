package manager;

import java.util.ArrayList;

import dao.dao_DangNhap;
import dao.dao_TaiLieu;
import model.model_DangNhap;
import model.model_PhieuMuon;
import model.model_TaiLieu;

public class manager_TaiLieu {
	public static dao_TaiLieu data =new dao_TaiLieu();
    public static ArrayList<model_TaiLieu> tailieuList = new ArrayList<>();
   
    public static ArrayList<model_TaiLieu> TailieuList () {
    	tailieuList = data.selectAll();
    	return tailieuList;
    }
    public static ArrayList<model_TaiLieu> TailieumuonnhieunhatList () {
    	tailieuList = data.TaiLieuMuonNhieuNhat();
    	return tailieuList;
    }

    public static void add(model_TaiLieu tailieu){
        tailieuList.add(tailieu);
    }
   
    public static void update (model_TaiLieu tailieu){
        data.update(tailieu);
    }
    public static void delete (model_TaiLieu tailieu){
        data.delete(tailieu);
    }
    public static void insert(model_TaiLieu tailieu){
        data.insert(tailieu);
    }

}
