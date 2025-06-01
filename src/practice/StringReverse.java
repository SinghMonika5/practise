package practice;

import java.util.Arrays;

public class StringReverse {

    public static void main(String[] args) {
        String s = "hello0";
        char[] sArr = s.toCharArray();
        for(int i=0;i<sArr.length/2;i++){
            char temp = sArr[i];
            sArr[i] = sArr[sArr.length-i-1];
            sArr[sArr.length-i-1] = temp;
        }
        System.out.println(new String(sArr));
    }

}
