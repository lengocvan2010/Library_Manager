package manager;

import model.model_DangNhap;
import model.model_DocGia;
import dao.dao_DangNhap;
import dao.dao_DocGia;

import java.util.ArrayList;

public class manager_DangNhap {
	public static dao_DangNhap data =new dao_DangNhap();
    public static ArrayList<model_DangNhap> dangnhapList = new ArrayList<>();
   
    public static ArrayList<model_DangNhap> DangnhapList () {
    	dangnhapList = data.importAll();
    	return dangnhapList;
    }

    public static void add(model_DangNhap dangnhap){
        dangnhapList.add(dangnhap);
    }
    public static void delete(model_DangNhap dangnhap){
        data.delete(dangnhap);
    }
//    public static model_DangNhap getid(String id){
//        for(model_DangNhap dangnhap : dangnhapList) {
//            if (dangnhap.getUsername().compareTo(id)==0) return dangnhap;
//        }
//        return null;
//    }
    public static boolean containsId(String id){
        for(model_DangNhap dangnhap : dangnhapList){
            if(dangnhap.getUsername().compareTo(id)==0) return true;
        }
        return false;
    }
    public static void Update (model_DangNhap dangnhap){
        data.update(dangnhap);
    }
    public static void Insert (model_DangNhap dangnhap){
        data.insert(dangnhap);
    }
}