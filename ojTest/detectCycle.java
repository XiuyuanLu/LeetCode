package ojTest;

import java.util.ArrayList;
import java.util.List;

public class detectCycle {
	public ListNode hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        boolean flag = false;
        while(slow != null && quick != null && quick.next != null && flag == false){
        	
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick)
            {
                flag = true; 
            }
        }
        if(flag == false)return null;
        else
        return slow;
    }
	public ListNode detectCycle(ListNode head) {
		ListNode start = head;
		ListNode point = hasCycle(head);
		while(point != null && start != null)
		{
			if(point == start)break;
			point = point.next;
			start = start.next;
		}
			
		return point;
	}
	public static void main(String args[]){
		ListNode t1 = new ListNode(1);
		detectCycle d = new detectCycle();
		ListNode p = d.detectCycle(t1);
		System.out.println(p.val);
	}
}
