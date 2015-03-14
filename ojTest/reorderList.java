package ojTest;

public class reorderList {
	public static ListNode divide(ListNode head){
		ListNode start = head;
		ListNode middle = null;
		ListNode p = head;
		
		if(head.next != null && head.next.next == null){
			ListNode t = head.next;
			head.next = null;
			return t;
		}
		
		while(p != null && p.next != null)
		{
			p = p.next.next;
			middle = start;
			start = start.next;
		}
		ListNode r = start.next;
		start.next = null;
		return r;
		
	}
	public static void ReorderList(ListNode head) {
		if( head == null || head.next == null ){
			return;
		}
		ListNode reverse = divide(head);
		ListNode fst = reverse;
		ListNode sec = reverse.next;
		fst.next = null;
		while(sec != null)
		{
			ListNode temp = sec.next;
			sec.next = fst;
			fst = sec;
			sec = temp;
		}
		reverse = fst;
		ListNode list1 = head;
		ListNode list2 = reverse;
		while(list2 != null && list1 != null)
		{
			ListNode temp1 = list1.next;
			ListNode temp2 = list2.next;
			list1.next = list2;
			list2.next = temp1;
			list1 = temp1;
			list2 = temp2;
		}
    }
	
	public static void main(String args[]){
		ListNode l = new ListNode(5);
		ListNode ll = new ListNode(2);
		ListNode lll = new ListNode(4);
		ListNode llll = new ListNode(6);
		ListNode lllll = new ListNode(7);
		ListNode llllll = new ListNode(8);
		
		l.next = ll;
		ll.next = lll;
		lll.next = llll;
		llll.next = lllll;
		lllll.next = llllll;
		
		ReorderList(l);
		while(l != null)
		{
			System.out.println(l.val);
			l = l.next;
		}
	}
	
}
