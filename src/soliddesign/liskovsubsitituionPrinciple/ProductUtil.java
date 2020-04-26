package soliddesign.liskovsubsitituionPrinciple;

public class ProductUtil {

	public static void main(String[] args) {
		Product[] p=new Product[3];
		p[0]=new Product();
		p[1]=new Product();
		p[2]=new InhouseProduct();
		
		for(Product yoko:p) {
			
			/*if (yoko instanceof InhouseProduct) {// wrong design and hence inhouse class needs change
				
				((InhouseProduct)yoko).applyextradiscount();
				
			}*/
			System.out.println("Dsicountis "+yoko.getdiscount());
		}
		
	}
}
