package com.aceprogrammer.basics.utilities;

import java.util.Stack;

/**
 * @author Salman Shaikh
 * Class to check given expression for
 * balanced paranthesis
 */
public class BalancedParan {
	
	// the different types of paranthesis to be checked
    private static final char L_PAREN    = '(';
    private static final char R_PAREN    = ')';
    private static final char L_BRACE    = '{';
    private static final char R_BRACE    = '}';
    private static final char L_BRACKET  = '[';
    private static final char R_BRACKET  = ']';

    /**
     * @param expression the string to be checked
     * @return true or false i.e. whether the given expression
     * is balanced or not
     */
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {

            if      (expression.charAt(i) == L_PAREN)
            {
            	stack.push(L_PAREN);
            }

            else 
            	if (expression.charAt(i) == L_BRACE)
            	{
            		stack.push(L_BRACE);
            	}

            else 
            	if (expression.charAt(i) == L_BRACKET)
            	{
            		stack.push(L_BRACKET);
            	}

            else if (expression.charAt(i) == R_PAREN) {
                if (stack.isEmpty())
                {
                	return false;
                }
                if (stack.pop() != L_PAREN)
                {
                	return false;
                }
            }

            else if (expression.charAt(i) == R_BRACE) {
                if (stack.isEmpty())      
                {
                	return false;
                }
                if (stack.pop() != L_BRACE)
                {
                	return false;
                }
            }

            else if (expression.charAt(i) == R_BRACKET) {
                if (stack.isEmpty())   
                	{
                	return false;
                	}
                if (stack.pop() != L_BRACKET) 
                	{
                	return false;
                	}
            }

            // ignore all other characters

        }
        return stack.isEmpty();
    }

}
