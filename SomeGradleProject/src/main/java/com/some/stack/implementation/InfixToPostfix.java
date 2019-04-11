/**
 * 
 */
package com.some.stack.implementation;

/**
 * @author Arun Ramachandran
 *
 */
public class InfixToPostfix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		String input = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixToPostfix.convert(input));
		System.out.println(infixToPostfix.infixToPostfix(input));
	}

	private String convert(String input) {
		String result = "";
		CharacterStack stack = new CharacterStack();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			if (Character.isLetterOrDigit(ch)) {
				result = result + ch;
			} else if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				while (!stack.isEmpty() && stack.peep().data != '(') {
					result = result + stack.pop().data;
				}

				if (!stack.isEmpty() && stack.peep().data != '(')
					return "Invalid Expression";
				else
					stack.pop();
			} else {
				while (!stack.isEmpty() && (comparer(ch) >= comparer(stack.peep().data))) {
					result = result + stack.pop().data;
				}
				stack.push(ch);
			}
		}
		while (!stack.isEmpty()) {
			result = result + stack.pop().data;
		}
		return result;
	}
	
	String infixToPostfix(String exp) 
    { 
        // initializing empty String for result 
        String result = new String(""); 
          
        // initializing empty stack 
        CharacterStack stack = new CharacterStack(); 
          
        for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i); 
              
             // If the scanned character is an operand, add it to output. 
            if (Character.isLetterOrDigit(c)) 
                result += c; 
               
            // If the scanned character is an '(', push it to the stack. 
            else if (c == '(') 
                stack.push(c); 
              
            //  If the scanned character is an ')', pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')') 
            { 
                while (!stack.isEmpty() && stack.peep().data != '(') 
                    result += stack.pop().data; 
                  
                if (!stack.isEmpty() && stack.peep().data != '(') 
                    return "Invalid Expression"; // invalid expression                 
                else
                    stack.pop(); 
            } 
            else // an operator is encountered 
            { 
                while (!stack.isEmpty() && comparer(c) <= comparer(stack.peep().data)) 
                    result += stack.pop().data; 
                stack.push(c); 
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.isEmpty()) 
            result += stack.pop().data; 
       
        return result; 
    } 

	private int comparer(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}
}
