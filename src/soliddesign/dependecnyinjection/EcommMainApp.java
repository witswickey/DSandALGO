package soliddesign.dependecnyinjection;

public class EcommMainApp {

	public static void main(String[] args) {
		
		ProductRepository sql=ProductFactory.create();
		
		ProductCatalog prod=new ProductCatalog(sql);
		
		prod.getallProdcuts();

	}

}
