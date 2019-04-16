

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class LockAnalyzer {

	public static void main(String[] args) {
		List<String> events = new ArrayList<>();
//		events.add("ACQUIRE 123");
		events.add("ACQUIRE 364");
		events.add("ACQUIRE 84");
		events.add("RELEASE 84");
//		events.add("ACQUIRE 364");
		events.add("RELEASE 364");
//		events.add("ACQUIRE 789");
//		events.add("RELEASE 456");
//		events.add("RELEASE 123");
//		events.add("RELEASE 84");
		System.out.println(check_log_history(events));
	}
	
	static int check_log_history(List<String> events) {
		
		Stack<Integer> acquired = new Stack<>();
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<events.size(); i++) {
			String[] eventSplit = events.get(i).split("\\s+");
			String eventType = eventSplit[0];
			int id = Integer.parseInt(eventSplit[1]);
			if(eventType.equals("ACQUIRE")) {
				if(set.contains(id)) {
					return i+1;
				}
				acquired.push(id);
				set.add(id);
			}
			if(eventType.equals("RELEASE")) {
				if(!set.contains(id)) {
					return i+1;
				} else if(acquired.isEmpty()){
					return i+1;
				} else if(acquired.peek() != id) {
					return i+1;
				}
				acquired.pop();
				set.remove(id);
			}
		}
		if(!acquired.isEmpty()) {
			return events.size()+1;
		}
		
		return 0;
	}
}
