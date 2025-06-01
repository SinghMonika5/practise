package practice;

import java.util.Stack;

public class CheckBalanceParentheses {

    public static void main(String[] args) {
        char open = '(';
        char close = ')';

        String p = "(((())))";
        char[] arr = p.toCharArray();
        boolean is = true;
        Stack<Character> stack = new Stack<>();

        for(char c:arr){

            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    is=false;
                    break;
                }

                char top = stack.pop();

                if(top == open && c != close){
                    is=false;
                    break;
                }

            }

        }

        System.out.println(stack.toString());

        if(!stack.isEmpty()){
            is=false;
        }

        System.out.println(is);

    }
}
