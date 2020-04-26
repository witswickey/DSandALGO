package soliddesign.dependecnyinjection;

import java.util.HashMap;

public class SqlRepo implements ProductRepository {

	public HashMap<String,String> getallProdcuts(){
		 
		HashMap map=new HashMap<String,String>();
		map.put("sopa", "tooth");
		return map;
	}
	
}
