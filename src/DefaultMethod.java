interface Animal {
	public void makesound();

	default void dosuse() {
		System.out.println("I am deafulter");
	}
}

interface dog {
	public void makesound();

	default public void dosuse() {
		System.out.println("I am deafulter");
	}
}

class ABC implements Animal {

	@Override
	public void makesound() {
		System.out.println("ABC");

	}

	public void dosuse() {
		System.out.println("ABC deafulter");
	}

}

public class DefaultMethod implements Animal, dog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultMethod dp=new DefaultMethod();
		dp.makesound();
		dp.dosuse();

	}

	@Override
	public void makesound() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dosuse() {
		// TODO Auto-generated method stub
		Animal.super.dosuse();
	}

}
