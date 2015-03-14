package ojTest;

public class MergeSort2 {
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

		ListNode tmp;
		if(L1 == null)
			{return L2;}
		if(L2 == null)
			{return L1;}
		if(L1.val<L2.val)
		{
			tmp = L1;
			L1 = L1.next;
		}else{
			tmp = L2;
			L2 = L2.next;
		}
		tmp.next = merge(L1,L2);
		return tmp;
	}
	
	public static ListNode mergeSortList(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode a,b;
		b = divide(head);
		a = head;

		ListNode r = merge(mergeSortList(a),mergeSortList(b));

		return r;
	}
	
	public static void main(String args[]){
		ListNode l = new ListNode(5);
		ListNode ll = new ListNode(3);
		ListNode lll = new ListNode(6);
		ListNode llll = new ListNode(2);
		ListNode lllll = new ListNode(8);
		ListNode llllll = new ListNode(1);
		
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
