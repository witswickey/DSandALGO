package leetcode;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;



public class QueueReconstruction {

	class person{
		int h;
		int k;
		person(int h,int k) {
			this.h=h;
			this.k=k;
			}
	}
	
	public int[][] reconstructQueue(int[][] people) {
        
		List<person> plist=new LinkedList<person>();
		for(int i=0;i<people.length;i++) {
			
			person p=new person(people[i][0],people[i][1]);
			plist.add(p);	
		}
		java.util.Collections.sort(plist,new Comparator<person>() {

			@Override
			public int compare(person o1, person o2) {
				
				person p1=(person)o1;
				person p2=(person)o2;
				Integer p=p1.h;
				Integer q=p2.h;
				int hcompare=q.compareTo(p);
				
				if(hcompare==0) {
					p=p1.k;
					q=p2.k;
					return p.compareTo(q);
				}
				else
					return hcompare;
				
			}	
			
		});
		
		for(int i=0;i<people.length;i++) {
			people[i][0]=-1;
			people[i][1]=-1;
		}
		
		for(int i=0;i<plist.size();i++) {
			int h=plist.get(i).h;
			int k=plist.get(i).k;
			
			if(people[k][0]==-1) {
				people[k][0]=h;
				people[k][1]=k;
				
			}
			else {
				int len=people.length-1;
				for(int j=len;j>k;j--) {
					people[j][0]=people[j-1][0];
					people[j][1]=people[j-1][1];
				}
				people[k][0]=h;
				people[k][1]=k;
			}
		}
		
		return people;
    }
	
	public static void main(String[] args) {
		int[][] people={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		people=new QueueReconstruction().reconstructQueue(people);
		for(int i=0;i<people.length;i++) {
			System.out.println(people[i][0]+" "+people[i][1]);
		}
		}
}
