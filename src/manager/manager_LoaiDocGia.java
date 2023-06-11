package manager;

import java.util.ArrayList;

import dao.dao_DocGia;
import dao.dao_Loaidocgia;
import dao.dao_TaiLieu;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_LoaiDocGia;
import model.model_TaiLieu;

public class manager_LoaiDocGia {
	public static dao_Loaidocgia data =new dao_Loaidocgia();
    public static ArrayList<model_LoaiDocGia> loaidocgiaList = new ArrayList<>();
   
    public static ArrayList<model_LoaiDocGia> LoaidocgiaList () {
    	loaidocgiaList = data.importAll();
    	return loaidocgiaList;
    }
    
    public static void update (model_LoaiDocGia loaidocgia){
        data.update(loaidocgia);
    }
    
//    public static model_DocGia get(String UserName){
//        for(model_DocGia docgia : DocgiaList()) {
//            if (docgia.getUserName().equals(UserName)) return docgia;
//        }
//		return null;
//        
//    }
}
