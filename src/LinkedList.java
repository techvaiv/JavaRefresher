public class LinkedList {
    public Node head;

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.head = null;
        insertNode(linkedList, new Node(10));
        insertNode(linkedList, new Node(60));
        insertNode(linkedList, new Node(50));
        insertNode(linkedList, new Node(100));
        
        displayList(linkedList);

        removeNode(linkedList, 100);

        displayList(linkedList);
        
    }
    
    private static void removeNode(LinkedList linkedList, int i) {
        Node currentNode = linkedList.head;
        Node previousNode = null;

        while(currentNode!=null)
        {
            if(currentNode.data == i && previousNode == null){
                linkedList.head = currentNode.next;
                break;
            }
            else if(currentNode.data == i && previousNode != null){
                previousNode.next = currentNode.next;
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    private static void insertNode(LinkedList linkedList, Node node2) {
        if(linkedList.head == null)
        linkedList.head = node2;
        else{
            Node last = linkedList.head;
            while(last.next != null)
            {
                last = last.next;
            }
            last.next = node2;
        }

    }

    private static void displayList(LinkedList linkedList) {
        System.out.println(linkedList.toString());

        Node current = linkedList.head;

        while(current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node [data=" + data + ", next=" + next + "]";
        }

    }

    @Override
    public String toString() {
        return "LinkedList [node=" + head.toString() + "]";
    }
}
