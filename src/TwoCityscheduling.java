import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class TwoCityscheduling {

	static class ds {
		int index;
		int diference;

		ds(int i, int d) {
			index = i;
			diference = d;
		}
	}

	public static int twoCitySchedCost(int[][] costs) {

		ArrayList<ds> list = new ArrayList<ds>();
		int nop = costs.length;
		for (int i = 0; i < nop; i++) {

			ds d = new ds(i,Math.abs(costs[i][0] - costs[i][1]));
			list.add(d);

		}
		
		java.util.Collections.sort(list,new Comparator<ds>() {

			@Override
			public int compare(ds o1, ds o2) {
				// TODO Auto-generated method stub
				Integer p1=o1.diference;
				Integer p2=o2.diference;
				
				return p2.compareTo(p1);
				 
			}
		});
		int sum=0;
		int bcount=0,acount=0;
		int len=nop/2;
		for(ds d:list) {
			
			int in=d.index;
			if(costs[in][0]<costs[in][1]) {
				if(acount<len) {
				sum+=costs[in][0];
				acount++;
			}else if(bcount<len){
				sum+=costs[in][1];
				bcount++;
			}
			
			}
			else {
				if(bcount<len) {
					sum+=costs[in][1];
					bcount++;
				}
				else {
					sum+=costs[in][0];
					acount++;
				}
			}
			if(acount==len && bcount==len)
				return sum;
		    
			
		}

		return sum;

	}

	public static void main(String[] args) {

		int[][] cos = { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
		System.out.println(twoCitySchedCost(cos));

	}

}
