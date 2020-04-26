package soliddesign.dependecnyinjection;

import java.util.HashMap;

public class ProductCatalog implements ProductRepository {
	/*public void listallProducts() {
		SqlRepo sql=new SqlRepo();//very tight coupling
		sql.getallProdcuts();
	}*/// Wrong design
	public static ProductRepository repo;
	ProductCatalog(ProductRepository sql){
		this.repo=sql;// dependecy injection
	}
	@Override
	public HashMap<String, String> getallProdcuts() {
		ProductRepository prod=ProductFactory.create();
		return prod.getallProdcuts();
	}
	
}
