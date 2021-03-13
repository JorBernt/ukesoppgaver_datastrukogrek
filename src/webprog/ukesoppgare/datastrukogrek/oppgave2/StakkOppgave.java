package webprog.ukesoppgare.datastrukogrek.oppgave2;


class Stakk {
    private Node head, next;
    private int size;

    public Stakk() {
    }

    public void push(int item) {
        size++;
        Node node = new Node(item);
        if(head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public int peek() {
        return head.val;
    }

    public int size() {
        return size;
    }

    public boolean contains(int n) {
        Node current = head;
        while(current != null) {
            if(current.val == n) return true;
            current = current.next;
        }
        return false;
    }

    public int pop() {
        size--;
        int n = peek();
        head = head.next;
        return n;
    }
}




public class StakkOppgave {
    public static void main(String[] args) {
        Stakk stakk = new Stakk();
        stakk.push(1);
        stakk.push(2);
        stakk.push(5);
        stakk.push(8);
        System.out.println(stakk.peek());
        System.out.println(stakk.size());
        System.out.println(stakk.contains(5));
        System.out.println(stakk.pop());
        stakk.push(8);
        System.out.println(stakk.pop());
        System.out.println(stakk.size());
        System.out.println(stakk.pop());
    }
}
