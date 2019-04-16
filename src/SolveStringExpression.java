import java.util.Stack;

public class SolveStringExpression {

	public static void main(String[] args) {

		String str = "2 4- 5*5/1 +4";
		str = str.replaceAll("\\s+","");
		System.out.println(str);
		Stack<String> stack = new Stack<>();
		StringBuilder s = new StringBuilder();
		int i=0;
		while(i<str.length()) {
			System.out.println(i);
			if(str.charAt(i) == '+' || str.charAt(i) == '-'){
				stack.push(s.toString());
				stack.push(""+str.charAt(i));
				s.setLength(0);
				i++;
				continue;
			} else if(str.charAt(i) == '/' || str.charAt(i) == '*') {
				stack.push(s.toString());
				s.setLength(0);
				int op1 = Integer.parseInt(stack.pop());
				int temp = i+1;
				while(temp<str.length()){
					if(str.charAt(temp) == '+' || str.charAt(temp) == '-' || str.charAt(temp) == '/' || str.charAt(temp) == '*') {
						break;
					}
					temp++;
				}
				int op2 = Integer.parseInt(str.substring(i+1, temp));
				System.out.println(op1+" "+op2);
				if(str.charAt(i) == '*') {
					int res = op1*op2;
					s.append(res);
				} else {
					int res = op1/op2;
					s.append(res);
				}
				i=temp;
				continue;
			}
			s.append(""+str.charAt(i));
			i++;
		}
		if(s.length()!=0)
			stack.push(s.toString());
		s.setLength(0);
		System.out.println(stack);
		Stack<String> st2 = new Stack<>();
		while(!stack.isEmpty()) {
			st2.push(stack.pop());
		}
		
		while(st2.size() != 1) {
			int op1 = Integer.parseInt(st2.pop());
			String sym = st2.pop();
			int op2 = Integer.parseInt(st2.pop());
			System.out.println(op2+" "+sym+" "+op1);
			if(sym.equals("+")) {
				int res = op1+op2;
				st2.push(""+res);
			} else {
				int res = op1-op2;
				st2.push(""+res);
			}
		}
		System.out.println(st2.peek());
		
		
	}
}
