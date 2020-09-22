package streamAPI;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

public class CountFrequencySort {

	public static void main(String[] args) {
		
		String str="abc@gmail@com";
		
		Map<String, Integer> s=Pattern.compile("@")
				.splitAsStream(str.toUpperCase())
				.collect(Collectors.toMap(Function.identity(),name-> name.length()));;
		
		System.out.println(s);

	}

}
