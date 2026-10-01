class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        next = null;
    }
}
class MyLinkedList {
    Node head;
    Node tail;
    public MyLinkedList() {
        head = null;
        tail = head;
    }
    
    public int get(int index) {
        if(index == 0){
            if(head == null) return -1;
            return head.data;
        }
        int c = 0;
        Node temp = head;
        while(temp != null && c < index){
            temp = temp.next;
            c++;
        }
        if(temp != null) return temp.data;
        return -1;

    }
    
    public void addAtHead(int val) {
        Node nn = new Node(val);
        if(head == null){
            head = nn;
            tail = nn;
            
        }
        else{
            nn.next = head;
            head = nn;
        }
    }
    
    public void addAtTail(int val) {
        Node nn = new Node(val);
        if(head == null){
            head = nn;
            tail = nn;
        }
        else{
            tail.next = nn;
            tail = nn;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
            return;
        }
        Node nn = new Node(val);
        int c = 0;
        Node temp = head;
        while(temp != null && c < index - 1){
            temp = temp.next;
            c++;
        }
        if(temp == tail){
            tail.next = nn;
            tail = nn;
        }
        else if(temp != null){
            nn.next = temp.next;
            temp.next = nn;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index == 0){
            if(head == null) return;
            head = head.next;
            if(head == null) tail = null;
            return;
        }
        int c = 0;
        Node temp = head;
        while(temp != null && c < index - 1){
            c++;
            temp = temp.next;
        }
        if(temp != null){
            if(temp.next == null) return;
            if(temp.next == tail) tail = temp;
            temp.next = temp.next.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */