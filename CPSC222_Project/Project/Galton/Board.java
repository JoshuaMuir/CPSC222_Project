package Galton;

public class Board {


    private int bigSize;
    private int modCount = 0;
    private Node startMarker;
    private Node endMarker;

    public Board() {

        clearOut();
    }

    private void clearOut() {
        //Creates new list with sentinel nodes.
        startMarker = new Node(null, null);
        endMarker = new Node(null, null);
        startMarker.next = endMarker;
        bigSize = 0;
        modCount++;

    }

    public int size() {

        return bigSize;
    }

    public void add(Peg x) {
        //Adds a node
        Node tempNode;
        Node prev = startMarker;
        tempNode = startMarker.next;

        Node newNode = new Node(x, null);
        if (size() == 0) {
            //If part doesnt exist, create it.
            startMarker.next = newNode;
            newNode.next = endMarker;

        } else {

            Peg temp;
            endMarker.next = newNode;
            temp = endMarker.data;
            endMarker.data = newNode.data;
            endMarker = newNode;
            endMarker.data = temp;
            newNode.data = temp;

        }

        ++bigSize;
    }

    public void printList() {

        LinkedListIterator LLI1 = iterator();
        LinkedListIterator LLI2 = iterator();
        try {

            for (int i = 0; i < size(); i++) {

                System.out.print(" " + LLI1.next() + "/" + LLI2.next2());
                if (i == 0) {
                    System.out.print("		");

                } else ;
            }

            System.out.println();


        } catch (Exception e) {
        }
    }

    public void search(Peg tata) {

        Node temp;
        Node kemp;
        Node prev = startMarker;
        temp = startMarker.next;


        prev = temp;
        temp = temp.next;


        System.out.println("Data not found");

    }

    public LinkedListIterator iterator() {

        return new LinkedListIterator();

    }

    /*************************************************


     im still unsure about what data structure we should use for this,
     personally I would like a more complex ADT due to the fact taht this
     is a higher level course and I think it would be cool to use
     something other than an array, despite the fact that arrray is
     certainly the easiest and most efficient.

     The current implementation is a Linked List, this certainly
     can be changed!!!.

     I like Linked List/Q/Stack or even a graph/tree.

     Notes:

     Captain disillusions video(which is what im basing most of my stuff on)
     is a good place to see a galton board.

     ***************************************************/

    private static class Node {

        public Peg data;
        public Node next;
        public Node(Peg d, Node next) {

            data = d;
            next = next;

        }

    }

    private class LinkedListIterator {

        private Node current = startMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;


        public Peg next() {
            //Next is for getting data
            if (modCount != expectedModCount) throw new java.util.ConcurrentModificationException();
            Peg nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;

        }

        public Peg next2() {
            //Next2 is for geting quantity
            if (modCount != expectedModCount) throw new java.util.ConcurrentModificationException();
            Peg nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;

        }

    }
}

/*************************************************


 im still unsure about what data structure we should use for this,
 personally I would like a more complex ADT due to the fact taht this
 is a higher level course and I think it would be cool to use
 something other than an array, despite the fact that arrray is
 certainly the easiest and most efficient.

 The current implementation is a Linked List, this certainly
 can be changed!!!.

 **************************************************/
	



