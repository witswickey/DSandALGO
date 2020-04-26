package soliddesign.liskovsubsitituionPrinciple;

public class InhouseProduct extends Product {
	
	
	public double getdiscount() {// Liskov design improvement
		this.applyextradiscount();
		return discount;
	}
	public void applyextradiscount() {
		discount= discount*1.5;
	}
	
}
