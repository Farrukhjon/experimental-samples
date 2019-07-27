public class SingleLinkedList<T> implements LinkedList<T> {

    private Node<T> head;

    private int n;

    class Node<T> {
        T data;
        Node<T> next;
        public Node (T data) {
            this.data = data;
        }
    }

    @Override
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null) {
            head = newNode;
        }
        else {
            newNode.next = head; 
            head = newNode;
        }
        n++;
    }

    @Override
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null) {
            head = newNode;
        }
        else {
            Node<T> tmp = head;
            while(tmp.next != null)
                tmp = tmp.next;
           tmp.next = newNode; 
        }
        n++;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void removeFirst() {
        if (head != null) {
            Node<T> tmp = head.next;
            head = tmp;
            n--;
        }
    }

    @Override
    public void removeLast() {
        head = removeLastItem();
    }

    private Node<T> removeLastItem() {
       if(head != null) {
           Node<T> tmp = head;
           while(tmp.next.next != null) // loop until second last node is reached ..next.next != null
               tmp = tmp.next;
           tmp.next = null;
       } 
       return head;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void printList() {
        System.out.print("List: ");
        if(head == null)
            return;
        Node<T> tmp = head;
        while(tmp != null) {
            System.out.printf(" %s ", tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }

}


