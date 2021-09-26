class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {					// Merge two in order Linked Lists
		ListNode p = l1, q = l2, head = null, s = null;
		while(p != null && q != null){
			if(p.val < q.val){
				ListNode n = new ListNode(p.val);
				if(s != null)s = s.next = n; else s = head = n;					//new node we adding (s.next = n ) move to the end of list (s = s.next)
				 p = p.next;
			}
			else{
				ListNode n = new ListNode(q.val);
				if(s != null)s = s.next = n; else s = head = n;	
				q = q.next;
			}
		}
		if(p != null){
			if(s != null)s.next = p; else head = s = p;
		}
		else {																	// q != null
			if(s != null) s.next = q; else head = s = q;
		}
		return head;
	}
	public class ListNode {														// Definition for singly-linked list.
		final int val;
		ListNode next = null;
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode prev) { this.val = val; prev.next = this; }
	}

	// ----------- TESTING ------------
	public ListNode makeList0(){												// ListNode = [] 
		return null;
	}
	public ListNode makeList1(){												// ListNode = [1]
		return new ListNode(1);
	}
	public ListNode makeList3(){												// ListNode = [2 7 8] 
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(7,a);
		ListNode c = new ListNode(8,b);
		return a;
	}
	public ListNode makeList6(){												// ListNode = [1 2 3 4 5 6] 
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2,a);
		ListNode c = new ListNode(3,b);
		ListNode d = new ListNode(4,c);
		ListNode e = new ListNode(5,d);
		ListNode f = new ListNode(6,e);
		return a;
	}
	public String print(final ListNode head){									// printing method of our singly-linked list
		String s = null;
		ListNode p = head;
		while(p != null){
			if( s == null) s = "" + p.val; else s += " " + p.val;
			p = p.next;
		}
		return s == null ? "" : s;
	}
	public static void test0(String ta){										// empty ListNode test
		Solution s = new Solution();
		ListNode l1 = s.makeList0();
		ListNode l2 = s.makeList0();
		String tb = "";
		String l1b = s.print(l1);
		String l2b = s.print(l2);
		assert(tb.equals(l1b));
		assert(tb.equals(l2b));

		ListNode r = s.mergeTwoLists(l1,l2);
		String ra = s.print(r);
		assert(ta.equals(ra));
	}
	public static void test1(String ta){										// one ListNode test
		Solution s = new Solution();
		ListNode l1 = s.makeList1();
		ListNode l2 = s.makeList0();
		String tb1 = "1";
		String tb2 = "";
		String l1b = s.print(l1);
		String l2b = s.print(l2);
		assert(tb1.equals(l1b));
		assert(tb2.equals(l2b));


		ListNode r = s.mergeTwoLists(l1,l2);
		String ra = s.print(r);
		assert(ta.equals(ra));
	}
	public static void test9(String ta){										// 9 element ListNode test
		Solution s = new Solution();
		ListNode l1 = s.makeList3();
		ListNode l2 = s.makeList6();

		String tb1 = "2 7 8";
		String tb2 = "1 2 3 4 5 6";
		String l1b = s.print(l1);
		String l2b = s.print(l2);
		assert(tb1.equals(l1b));
		assert(tb2.equals(l2b));

		ListNode r = s.mergeTwoLists(l1,l2);
		String ra = s.print(r);
		assert(ta.equals(ra));
	}
	public static void main(String[] args){										// main test for singly-linked list
		test0("");
		test1("1");
		test9("1 2 2 3 4 5 6 7 8");

	}
}