package evaluate.reverse.polish.notation;

import java.util.Stack;

public class NaiveSolution {

    public static void main (String[] args){
        String[] tokens = {"1","2","+","3","*"};
        System.out.println(eRPN(tokens));
    }

    public static int eRPN(String[] elements){
        int returnValue = 0;
        String operators = "+-*/";

        Stack<String> stack = new Stack<>();
        for(String element:elements){
            if(!operators.contains(element)){
                stack.push(element);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch(element){
                    case "+":
                        stack.push(String.valueOf(a+b));
                        break;
                    case "-":
                        stack.push(String.valueOf(a-b));
                        break;
                    case "*":
                        stack.push(String.valueOf(a*b));
                        break;
                    case "/":
                        stack.push(String.valueOf(a/b));
                        break;
                }
            }
        }
        returnValue = Integer.valueOf(stack.pop());
        return returnValue;
    }
}
