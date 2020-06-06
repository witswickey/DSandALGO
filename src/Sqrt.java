
class Sqrt {
    public int mySqrt(int x) {
        
        
        if(x==0 )
            return 0;
        
        if(x==1 || x==2)
            return 1;
        
        long low=1,high=x;
        long mid=0;
        
        while(low<high){
            
            mid=low+ (high-low)/2;
            
            if((mid*mid)==x){
                return (int)(long)mid;
            }
            else if((mid*mid)<x){
                low=mid+1;
            }
            else
                high=mid;
        }
        return (int)(long)low-1;
        
    }
    
    public static void main(String[] args) {
		
    	System.out.println(new Sqrt().mySqrt(2147395599));//1073697800
	}
}
