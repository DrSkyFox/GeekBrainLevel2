package lessoneight;


public class SinglyLinkedList {
    private Node head;

    public void add(String o) {
        if (head == null) {
            head = new Node(o);
            return;
        }

        add(head, o);
    }

    private void add(Node current, String o) {
        if (current.next == null) {
            current.next = new Node(o);
            return;
        }
        add(current.next, o);
    }


    public void remove(String o) {
        if (head == null) {
            return;
        } else {
            if (head.val.equals(o)) {
                head = head.next;
                return;
            }
        }

        remove(head, head.next, o);
    }

    private void remove(Node prev, Node current, String o) {
        if (current == null) {
            return;
        }

        if (current.val.equals(o)) {
            prev.next = current.next;
            return;
        }

        remove(current, current.next, o);
    }

    private static class Node {
        private String val;
        private Node next;

        public Node(String val) {
            this(val, null);
        }

        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                   "val='" + val + '\'' +
                   ", next=" + next +
                   '}';
        }
    }

    MyIter<String> iterator() {
        return new ItrList();
    }

    class ItrList implements MyIter<String> {
        private Node current;
        private Node next;

        public ItrList() {
            current = head;
            next = current.next;
        }

        @Override
        public void add(String o) {
            SinglyLinkedList.this.add(o);
        }

        @Override
        public void remove(String o) {
            SinglyLinkedList.this.remove(o);
        }

        @Override
        public String next() {
            current = next;
            next = current.next;
            return current.val;
        }

        @Override
        public boolean hasNext() {
            return current.next == null ? false : true;
        }

        @Override
        public void set(String s) {
            current.val = s;
        }

        @Override
        public String get() {
            return current.val;
        }
    }


    @Override
    public String toString() {
        return "{" +
               head +
               '}';
    }


}
