package string;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

static int minimumNumber(int n, String password) {
        
        int mintry = 0;
        int l=0,m=0,sp=0;
        if(n<6){
            mintry=6-n;
            return mintry;
        }
        if (!password.matches(".*\\d.*")) {
        	mintry+=1;
        }
        for(char ch:password.toCharArray()) {
        	if(Character.isLowerCase(ch)) {
        		l=1;
        	}
        	else if (Character.isUpperCase(ch)) {
        		m=1;
        	}
        	else if ("!@#$%^&*()-+".indexOf(ch)!=-1) {
        		sp=1;
        	}
        }
        if(l==0) {
        	mintry+=1;
        }
        if(m==0) {
        	mintry+=1;
        }
        if(sp==0) {
        	mintry+=1;
        }
       
        
        return mintry;
    }


	public static void main(String[] args) throws IOException {

        int result = minimumNumber(3,"Ab1");

        System.out.println(result);
    }
}
