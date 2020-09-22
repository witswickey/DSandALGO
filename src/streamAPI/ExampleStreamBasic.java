package streamAPI;

//mport java.security.cert.PKIXRevocationChecker.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ExampleStreamBasic {

	public static void main(String[] args) {
		
	Random rand=new Random();
	List<Integer> list=new ArrayList<>();
	for(int i=1;i<=20;i++) {
		list.add(rand.nextInt(20));
	}
	
	long count=list.stream()
			.map(num -> num*2)
			.peek(num -> System.out.printf("%d ",num))
			.count();
	System.out.println();
	System.out.println(count);
	
	System.out.println("Lovely");
	
	long sec=list.stream()
			     .map(num -> (int)Math.pow(num,2))
			     .peek(num -> System.out.printf("%d ",num))
			     .count();
	
	System.out.println(sec);
	
	
	Optional<String> strstream=Optional.of("     colony     ");
	
	strstream.map(String::trim).ifPresent(System.out::println);
	
	System.out.println(strstream.map(String :: length).orElse(-1));
	System.out.println();
	List<String> listS=Arrays.asList(("This is beautiful scenary of Munnar").split(" "));
	listS.stream().distinct().sorted().forEach(System.out::println);

	}	

}
