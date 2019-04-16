import java.util.Stack;

public class RedundantParenthses {
	public static void main(String[] args) {
		
		String str = "((a+b)(/)(c))";
		System.out.println(hasRedundantParentheses(str));
	}
	
	static boolean hasRedundantParentheses (String str) {
		Stack<Character> stack = new Stack<>();
		int i=0;
		while(i<str.length()) {
			if(str.charAt(i) == ')') {
				if(stack.pop() == '(') {
					return true;
				} else {
					while(!stack.isEmpty()) {
						if(stack.pop() == '(')
							break;
					}
				}
			} else {
				stack.push(str.charAt(i));
			}
			i++;
			System.out.println(stack);
		}
		
		return false;
	}
}