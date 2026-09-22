class MyCircularDeque {
    int[] q;
    int front;
    int rear;
    int size;
    int capacity;
    public MyCircularDeque(int k) {
        q = new int[k];
        capacity = k;
        front = 0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(isEmpty()){
            q[front] = value;
            rear = (rear + 1) % capacity;
            size++;
            return true;
        }
        if(front == 0){
            front = capacity - 1;
            q[front] = value;
            size++;
            return true;
        }
        front = (front - 1) % capacity;
        q[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        q[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        if(rear == 0){
            rear = capacity - 1;
            size--;
            return true;
        }
        rear--;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return q[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        if(rear == 0) return q[capacity - 1];
        return q[rear - 1];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */