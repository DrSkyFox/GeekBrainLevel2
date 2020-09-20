package lessoneight;

public class DoubleLinkList {

    private Node head;
    private Node last;
    private int size;

    public void add(String o) {
        if (head == null) {
            head = new DoubleLinkList.Node(o);
            return;
        }
        add(head, o);
    }

    private void add(DoubleLinkList.Node current, String o) {
        if (current.next == null) {
            Node nodeNew = new Node(o);
            nodeNew.prev = current;
            current.next = nodeNew;
            last = nodeNew;
            size++;
            return;
        }
        add(current.next, o);
    }


    public void remove(String o) {
        if (head == null) {
            return;
        } else {
            if (head.val.equals(o)) {
                Node node = head.next;
                node.prev = null;
                head = node;
                size--;
                return;
            }
        }
        remove(head, head.next, o);
    }


    private void remove(DoubleLinkList.Node prev, DoubleLinkList.Node current, String o) {
        if (current == null) {
            return;
        }
        if (current.val.equals(o)) {
            if (current == last) {
                last = current.prev;
                current.prev.next = null;
                size--;
                return;
            }
            Node node = current.next;
            node.prev = prev;
            prev.next = node;
            size--;
            return;
        }
        remove(current, current.next, o);
    }

    SuperIter<String> iterator() {
        return new ItrList();
    }


    public class ItrList implements SuperIter<String> {
        private Node current;
        private Node next;

        public ItrList() {
            current = head;
            next = current.next;
        }

        @Override
        public void set(String s) {
            current.val = s;
        }

        @Override
        public String get() {
            return current.val;
        }

        @Override
        public String next() {
            if (hasNext()) {
                current = next;
                next = next.next;
            }
            return current.val;
        }

        @Override
        public String prev() {
            if (hasPrev()) {
                current = current.prev;
                next = current.prev;
            }
            return current.val;
        }


        @Override
        public void add(String o) {
            Node nodeNew = new Node(o);
            if(hasNext()) {
                nodeNew.next =next;
            }
            nodeNew.prev = current;

            next.prev = nodeNew;
            current.next = nodeNew;
            next = nodeNew;
            size++;

        }

        @Override
        public void remove(String o) {
            DoubleLinkList.this.remove(o);
        }

        @Override
        public boolean hasNext() {
            return current.next == null ? false : true;

        }

        @Override
        public boolean hasPrev() {
            return current.prev == null ? false : true;
        }
    }

    MyIter descIter() {
        return new DescIterator();
    }

    class DescIterator implements MyIter<String> {
        private final ItrList itrList = new ItrList();

        @Override
        public void add(String o) {
            itrList.add(o);
        }

        @Override
        public void remove(String o) {
            itrList.remove(o);
        }

        @Override
        public String next() {

            return itrList.prev();
        }

        @Override
        public boolean hasNext() {
            return itrList.hasPrev();
        }

        @Override
        public void set(String s) {
            itrList.current.val = s;
        }

        @Override
        public String get() {
            return itrList.current.val;
        }
    }


    private static class Node {
        private String val;
        private Node next;
        private Node prev;

        public Node(String val) {
            this(val, null, null);
        }

        public Node(String val, Node prev, Node next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }


        @Override
        public String toString() {
            return "Node{" +
                   "val='" + val + '\'' +
                   ", prev=" + next +
                   '}';
        }
    }



    @Override
    public String toString() {
        return "{" +
               head +
               '}';


    }


}
