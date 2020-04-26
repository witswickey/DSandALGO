package dp;

public class uglyNumbers {

	static boolean dpa[] = new boolean[10000];

	static {
		dpa[1] = true;
		dpa[2] = true;
		dpa[3] = true;
		dpa[5] = true;
		dpa[7] = false;
	}

	public static boolean foo(int n) {
		System.out.println("n is "+n);
		if (dpa[n] != false)
			return dpa[n];
		else if (n % 2 == 0) {
			return foo(n / 2);
		} else if (n % 3 == 0) {
			return foo(n / 3);
		} else if (n % 5 == 0) {
			return foo(n / 5);
		} else {
			dpa[n] = false;
			return dpa[n];
		}
	}

	public static void main(String[] args) {
		int n = 150;
		int count = 1;
		int i = 1;
		while (count <= n) {
			System.out.println("iter and number is "+count+" "+i);
			if (foo(i)) {
				System.out.println("ugly num "+i);
				if (count == n) {
					System.out.println(String.format("%dth ugly number is %d", n, i));
					break;
				}
				count++;
			} 
			i++;

		}
	}
}
