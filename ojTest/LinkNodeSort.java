package ojTest;

public class LinkNodeSort {

	public static ListNode sortList(ListNode head) {
		
		ListNode start , temp , prenode;
		boolean flag = true;
		while(true)
		{   
			flag = true;
			if(head.val>head.next.val)
			{
				start = head.next;
				prenode = head.next;
				temp = head.next.next;
				head.next.next = head;
				head.next = temp;
			}else{
				prenode = head;
				start = head;
				head = head.next;
			}
			while(head.next != null)
			{
				if(head.val>head.next.val)
				{
					temp = head.next.next;
					prenode.next = head.next;
					head.next.next = head;
					head.next = temp;
					prenode = prenode.next;
					flag = false;
				}else{
					prenode = head.next;
					head = head.next;
				}
			}
			if(flag == true)break;
			head = start;
			
		}
		System.out.print(start.toString());
		return start;
    }
	public static void main(String args[]){
		ListNode l = new ListNode(5);
		ListNode ll = new ListNode(2);
		ListNode lll = new ListNode(4);
		
		l.next = ll;
		ll.next = lll;
		
		sortList(l);
		
	}
}
