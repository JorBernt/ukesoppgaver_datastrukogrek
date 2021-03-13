package webprog.ukesoppgare.datastrukogrek.oppgave2;

import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        next = null;
    }
}

class SammenkjedetListe {
    private Node hode;
    private int storleik;

    public SammenkjedetListe() {
        hode = null;
        storleik = 0;
    }

    public void leggTilVerdi(int n) {
        Node node = new Node(n);
        if(hode == null) {
            hode = node;
            hode.next = hode;
            storleik++;
            return;
        }
        Node current = hode;
        while(true) {
            if(current.next == hode) {
                current.next = node;
                node.next = hode;
                storleik++;
                return;
            }
            current = current.next;
        }

    }

    public boolean inneholderVerdi(int n) {
        Node current = hode;
        while (true) {
            if(current.val == n) return true;
            if(current.next == hode) break;
            current = current.next;
        }
        return false;
    }

    public void slettVerdi(int n) {
        if(hode.val == n) {
            Node current = hode;
            while(true) {
                if(current.next == hode) {
                    current.next = hode.next;
                    hode = current.next;
                    return;
                }
                current = current.next;
            }
        }
        Node current = hode;
        while(true) {
            if(current.next.val == n) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

    }

    public int taEnTitt() {
        return hode.val;
    }

    public String skrivUtListe() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node current = hode;
        while(true) {
            sb.append(current.val + " ");
            if(current.next == hode) break;
            current = current.next;

        }
        sb.append("]");
        return sb.toString();
    }

    public int storleik() {
        return storleik;
    }
}


public class Oppgave2 {

    public static void main(String[] args) {
        SammenkjedetListe sl = new SammenkjedetListe();
        sl.leggTilVerdi(10);
        sl.leggTilVerdi(12);
        sl.leggTilVerdi(13);

        System.out.println(sl.skrivUtListe());
        System.out.println(sl.storleik());
        System.out.println(sl.taEnTitt());

        sl.slettVerdi(10);

        System.out.println(sl.skrivUtListe());

        System.out.println(sl.storleik());
        System.out.println(sl.inneholderVerdi(11));
        System.out.println(sl.taEnTitt());
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.val <= o2.val) {
                    return 0;
                }
                else return 1;
            }
        });
        pq.add(new Node(2));
        pq.add(new Node(5));
        pq.add(new Node(3));
        while(!pq.isEmpty()) {
            System.out.println(pq.poll().val);
        }



    }
}
