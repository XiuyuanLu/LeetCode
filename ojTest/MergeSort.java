package ojTest;

public class MergeSort {
	public static ListNode divide(ListNode L){
		ListNode start, middle, temp;
		start = L;
		middle = null;
		temp = L;
		while(temp != null && temp.next != null)
		{
			temp = temp.next.next;
			middle = start;
			start = start.next;
		}

		middle.next = null;
		return start;
	}
	
	public static ListNode merge(ListNode L1, ListNode L2){
		ListNode temp1 = L1;
		ListNode temp2 = L2;
		ListNode s = null;
		ListNode lc = null;
		if(temp1.val <= temp2.val)
		{
			s = temp1;
			lc = s;
			temp1 = temp1.next;
		}else{
			s = temp2;
			lc = s;
			temp2 = temp2.next;
		}
		
		while(temp1 != null && temp2 != null)
		{
			if(temp1.val <= temp2.val)
			{
				s.next = temp1;
				temp1 = temp1.next;
				s = s.next;
			}else{
				s.next = temp2;
				temp2 = temp2.next;
				s = s.next;
			}
		}
		
		if(temp1 == null)s.next = temp2;
		else if(temp2 == null) s.next = temp1;
		
		return lc;
	}
	
	public static ListNode mergeSortList(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode a,b;
		b = divide(head);
		a = head;
		//mergeSortList(a);
		//mergeSortList(b);
		head = merge(mergeSortList(a),mergeSortList(b));
		return head;
	}
	
	public static void main(String args[]){
		ListNode l = new ListNode(5);
		ListNode ll = new ListNode(3);
		ListNode lll = new ListNode(6);
		ListNode llll = new ListNode(2);
		ListNode lllll = new ListNode(8);
		ListNode llllll = new ListNode(9);
		
		l.next = ll;
		ll.next = lll;
		lll.next = llll;
		llll.next = lllll;
		lllll.next = llllll;
		
		ListNode n = mergeSortList(l);
		//System.out.print(re.val);
		while(n != null)
		{
			System.out.print(n.val);
			n = n.next;
		}
	}
	
}
