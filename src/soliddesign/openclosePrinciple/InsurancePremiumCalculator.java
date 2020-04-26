package soliddesign.openclosePrinciple;

public class InsurancePremiumCalculator {

	public int getLoyalCustomerDiscount(CustomerProfile cus)//Keeping vehicle or health is bad design since we need to changes this class frequently if new added 
	{
		if(cus.isLoyal()) {
			return 20;
		}
		return 10;
	}
}
