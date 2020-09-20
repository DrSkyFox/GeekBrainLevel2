package lessoneight;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
//        singlyLinkedList.add("Toyota");
//        singlyLinkedList.add("Honda");
//        singlyLinkedList.add("Subaru");
//        singlyLinkedList.add("Mazda");
//
//        System.out.println(singlyLinkedList);
//
//        singlyLinkedList.remove("Mazda");
//        System.out.println(singlyLinkedList);


        DoubleLinkList doubleLinkList = new DoubleLinkList();
        doubleLinkList.add("Toyota");
        doubleLinkList.add("Honda");
        doubleLinkList.add("Subaru");
        doubleLinkList.add("Mazda");

        MyIter myIter = doubleLinkList.iterator();
        System.out.println(myIter.next());
        System.out.println(myIter.next());
        myIter.set("Tsuma");
        System.out.println(myIter.get());

        System.out.println(doubleLinkList);




    }
}
