package net.thumbtack.lessons;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {

		String str = "({[(a*{b+c})*[c+d]]})";

		boolean error = false;

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length() && !error; i++) {
			char sym = str.charAt(i);
			switch (sym) {
			case '(':
			case '[':
			case '{':
				stack.push(sym);
				break;
			case ')':
				if (stack.isEmpty() || stack.pop() != '(') {
					System.out.println("Unexpected )");
					error = true;
				}
				break;
			case ']':
				if (stack.isEmpty() || stack.pop() != '[') {
					System.out.println("Unexpected ]");
					error = true;
				}
				break;
			case '}':
				if (stack.isEmpty() || stack.pop() != '{') {
					System.out.println("Unexpected }");
					error = true;
				}
				break;
			default:
				break;
			}
		}

		if (!error) {
			if (stack.isEmpty()) {
				System.out.println("OK");
			} else {
				System.out.print("Unclosed brackets : ");
				while(!stack.isEmpty())
					System.out.print(stack.pop());
			}
		}

	}

}
