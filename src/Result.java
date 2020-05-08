import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        
        int i=0;
        Collections.sort(a);
        Integer[] itemsArray = new Integer[a.size()];
        System.arraycopy(a.toArray(), 0, itemsArray, 0, a.toArray().length);
        List<Integer> l=new LinkedList<>();
        int len=1;
        int c=1;
        l.add(itemsArray[0]);
        while(i<itemsArray.length && c<itemsArray.length){
            if(itemsArray[c]-itemsArray[i]<=1){
            	
                l.add(itemsArray[c]);
                System.out.println(l);
                c++;
            }
            else{
                if(l.size()>len){
                    len=l.size();
                }
                i++;
                c=i+1;
                l.clear();
                l.add(itemsArray[i]);
               // System.out.println("Clear list");
            }
            
        }
        return len;

    }

    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());*/
    	
    	List<Integer> a=new ArrayList();
    	int arr[]= {1 ,2 ,2, 3, 1, 2};
    	for(int ak:arr) {
    		a.add(ak);
    	}
    	

        int result = Result.pickingNumbers(a);
        System.out.println(result);

       

}


 }
