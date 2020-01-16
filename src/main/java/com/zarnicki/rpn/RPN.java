package com.zarnicki.rpn;
import java.util.Stack;
import java.util.regex.*;

/**
 * Created by Kacper on 2016-06-04.
 */
public class RPN {

    public static void main(String[] args) {
        if (args.length > 0) {
            RPN rpn = new RPN();
            System.out.println(rpn.calculateRPN(args[0]));
        }else {
            System.out.println("Bad args");
        }
    }

    public String calculateRPN(String args) {
        Stack<Integer> stack = new Stack();
        //Change args to string array
        String[] arg = args.split(" ");

        //Delete " from start/end
        for (int i = 1; i < arg.length; i++ ){

            if (arg[i].equals("+") && stack.size() > 1) {
                stack.push(stack.pop() + stack.pop());
            } else if (arg[i].equals("-") && stack.size() > 1) {
                stack.push(stack.pop() - stack.pop());
            } else if (arg[i].equals("*") && stack.size() > 1) {
                stack.push(stack.pop() * stack.pop());
            } else if (arg[i].equals("/") && stack.size() > 1) {
                int a = stack.pop();
                int b = stack.pop();
                try {
                    stack.push(b / a);
                } catch (ArithmeticException e) {
                    return "Divide by 0";
                }
            } else {
                boolean b = Pattern.matches("[0-9]+$", arg[i]);
                if (b == true) {
                    stack.push(Integer.valueOf(arg[i]));
                }else {
                    System.out.println("Bad args");
                    System.out.close();
                }
            }
        }

        if (stack.size() != 1) {
            return "Too many args";
        } else {
            return String.valueOf(stack.pop());
        }
    }
}
