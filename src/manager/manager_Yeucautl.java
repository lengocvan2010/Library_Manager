package manager;

import model.model_TaiLieu;
import model.model_Yeucautl;
import dao.dao_Yeucautl;

import java.util.ArrayList;

public class manager_Yeucautl {
	public static dao_Yeucautl data =new dao_Yeucautl();
    public static ArrayList<model_Yeucautl> yeucauList = new ArrayList<>();
   
    public static ArrayList<model_Yeucautl> YeucauList () {
    	yeucauList = data.selectAll();
    	return yeucauList;
    }
    public static void update (model_Yeucautl tlyeucau){
        data.update(tlyeucau);
    }
    public static void yeucau(model_Yeucautl yeucautl){
        yeucauList.add(yeucautl);
    }
    public static void xoa(model_Yeucautl yeucautl){
        yeucauList.remove(yeucautl);
    }
    public static void delete (model_Yeucautl yeucautl){
        data.delete(yeucautl);
    }
    public static void insert(model_Yeucautl yeucautl){
        data.insert(yeucautl);
    }    
}
