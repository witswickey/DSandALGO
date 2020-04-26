package arrays;

import java.util.*;
import java.util.Map.Entry;

public class KthNumbersInFrequency {

	public static void main(String[] args) {
		
		int arr[]= {3, 1, 4, 4, 5, 2, 8, 1};
		
		int k=2;
		
		printkth(arr,arr.length,k);
	}

	private static void printkth(int[] arr, int length, int k) {
		
		HashMap<Integer, Integer> fre=new LinkedHashMap<Integer, Integer>();
		
		for (int i:arr) {
			if (fre.get(i)==null) {
				fre.put(i,1);
			}
			else {
				Integer count=fre.get(i);
				fre.put(i, count+1);
			}
		}
		System.out.println(fre);
		fre=sorthashmaponvalues(fre);
		int count=0;

		Set s=fre.keySet();
		Object [] arr1=s.toArray();
		while(count<k) {
			System.out.println(arr1[count++]);
		}
		
		
		
	}

	private static LinkedHashMap<Integer, Integer> sorthashmaponvalues(HashMap<Integer, Integer> fre) {
		
		List<Map.Entry<Integer,Integer>> list=new LinkedList<Map.Entry<Integer,Integer>>(fre.entrySet());
		
		Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}
			
		});
		
		//System.out.println(list);
		LinkedHashMap<Integer, Integer> hm=new LinkedHashMap<Integer, Integer>();
		
		for(Map.Entry<Integer, Integer> aa:list) {
			hm.put(aa.getKey(), aa.getValue());
		}
		// print the sorted hashmap 
        for (Entry<Integer, Integer> en : hm.entrySet()) { 
            System.out.println("Key = " + en.getKey() +  
                          ", Value = " + en.getValue()); 
        } 
		return hm;
		
	}
	
}
