package arrays.slidingwindows;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FirstNegativeNoInKWindow {

    // Function to find the first negative integer in every window of size k
    static List<Integer> FirstNegativeInteger(int arr[], int k) {

        int end=0,start=0;
        Deque<Integer> st = new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();

        while(end<arr.length){

            if(arr[end]<0){
                st.addLast(arr[end]);
            }

            if((end-start+1)==k){
                if (st.peekFirst() !=null) {
                    res.add(st.peek());
                } else {
                    res.add(0);
                }
                if(arr[start]<0 && arr[start]==st.peek()){
                    st.removeFirst();
                }
                start++;
            }
            end++;
        }
        return res;

    }
}
