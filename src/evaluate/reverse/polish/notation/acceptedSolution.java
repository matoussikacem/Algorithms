package evaluate.reverse.polish.notation;

import java.util.Arrays;
import java.util.Stack;

public class acceptedSolution {

    public static void main(String[] args){
        String[] elements = {"2","5","*","6","+","4","/"};
        System.out.println(eRPN(elements));
    }

    public static int eRPN(String[] tokens){
        String operators = "+-*/";
        Stack<String> stack = new Stack<>();

        Arrays.stream(tokens).forEach(token ->{
            if(!operators.contains(token))
                stack.push(token);
            else{
                int a=0,b=0;
                try{
                    a = Integer.valueOf(stack.pop());
                    b = Integer.valueOf(stack.pop());
                } catch (IllegalArgumentException e){
                    e.printStackTrace();
                }
                int index = operators.indexOf(token);
                switch(index){
                    case 0:
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        stack.push(String.valueOf(a-b));
                        break;
                    case 2:
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3:
                        stack.push(String.valueOf(a/b));
                        break;
                }
            }
        });
        return Integer.valueOf(stack.pop());
    }
}
