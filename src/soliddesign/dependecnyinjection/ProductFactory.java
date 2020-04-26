package soliddesign.dependecnyinjection;

public class ProductFactory {

	public static ProductRepository create() {
		return new SqlRepo();
	}
}
