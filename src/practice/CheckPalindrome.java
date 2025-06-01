package practice;

import java.util.Arrays;

public class CheckPalindrome {

    public static void main(String[] args) {
        String s = "nitin";
        boolean isPallidrome=true;
        char[] charArray=s.toCharArray();
        for(int i=0;i<charArray.length/2;i++){
            if(charArray[i]!=charArray[charArray.length-1-i]){
                isPallidrome=false;
            }
        }
        System.out.println(s+"is pallidrome: "+isPallidrome);


    }
}
