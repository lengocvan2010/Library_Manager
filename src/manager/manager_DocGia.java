package manager;

import java.util.ArrayList;

import dao.dao_DocGia;
import dao.dao_TaiLieu;
import model.model_DangNhap;
import model.model_DocGia;
import model.model_TaiLieu;

public class manager_DocGia {
	public static dao_DocGia data =new dao_DocGia();
    public static ArrayList<model_DocGia> docgiaList = new ArrayList<>();
   
    public static ArrayList<model_DocGia> DocgiaList () {
    	docgiaList = data.importAll();
    	return docgiaList;
    }
    public static void Insert (model_DocGia docgia){
        data.insert(docgia);
    }

    public static void update (model_DocGia docgia){
        data.update(docgia);
    }
    public static void delete(model_DocGia docgia){
        data.delete(docgia);
    }

    public static model_DocGia get(String UserName){
        for(model_DocGia docgia : DocgiaList()) {
            if (docgia.getUserName().equals(UserName)) return docgia;
        }
		return null;
        
    }
}
