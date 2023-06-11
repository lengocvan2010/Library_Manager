package manager;

import java.util.ArrayList;

import dao.dao_DangNhap;
import dao.dao_TaiLieu;
import dao.dao_TaiLieuYeuThich;
import model.model_DangNhap;
import model.model_PhieuMuon;
import model.model_TaiLieu;
import model.model_TaiLieuYeuThich;

public class manager_TaiLieuYeuThich {
	public static dao_TaiLieuYeuThich data =new dao_TaiLieuYeuThich();
    public static ArrayList<model_TaiLieuYeuThich> tailieuyeuthichList = new ArrayList<>();
   
    public static ArrayList<model_TaiLieuYeuThich> TailieuyeuthichList () {
    	tailieuyeuthichList = data.selectAll();
    	return tailieuyeuthichList;
    }
    
   
    public static void delete (model_TaiLieuYeuThich tailieuyeuthich){
        data.delete(tailieuyeuthich);
    }
    public static void insert(model_TaiLieuYeuThich tailieuyeuthich){
        data.insert(tailieuyeuthich);
    }

}
