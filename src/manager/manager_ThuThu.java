package manager;

import java.util.ArrayList;

import dao.dao_DangNhap;
import dao.dao_TaiLieu;
import dao.dao_ThuThu;
import model.model_DangNhap;
import model.model_NhanVien;
import model.model_PhieuMuon;
import model.model_TaiLieu;

public class manager_ThuThu {
	public static dao_ThuThu data =new dao_ThuThu();
    public static ArrayList<model_NhanVien> thuthuList = new ArrayList<>();
   
    public static ArrayList<model_NhanVien> ThuthuList () {
    	thuthuList = data.importAll();
    	return thuthuList;
    }
    public static void update (model_NhanVien nhanvien){
        data.update(nhanvien);
    }
    public static void delete (model_NhanVien nhanvien){
        data.delete(nhanvien);
    }
    public static void insert(model_NhanVien nhanvien){
        data.insert(nhanvien);
    }

}
