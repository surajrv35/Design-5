// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> store;
    public Node copyRandomList(Node head) {
        store = new HashMap<>();
        
        Node cursor = head;
        Node resultCursor = clone(head);
        
        while (cursor != null)
        {
            resultCursor.random=clone(cursor.random);
            resultCursor.next=clone(cursor.next);
            
            cursor=cursor.next;
            resultCursor=resultCursor.next;
        }
        
        return clone(head);
    }
    private Node clone(Node originalNode)
    {
        if(originalNode == null)
            return null;
        Node cloneNode=store.get(originalNode);
        if(cloneNode == null)
        {
            cloneNode = new Node(originalNode.val);
            store.put(originalNode, cloneNode);
        }
        return cloneNode;
    }
}
