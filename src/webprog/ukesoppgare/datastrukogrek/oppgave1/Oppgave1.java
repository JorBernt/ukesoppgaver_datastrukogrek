package webprog.ukesoppgare.datastrukogrek.oppgave1;

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
        storleik++;
        Node node = new Node(n);
        if(hode == null) {
            hode = node;
        }
        else {
            Node nn = hode;
            while(nn!=null) {
                if(nn.next == null) {
                    nn.next = node;
                    return;
                }
                nn = nn.next;
            }
        }
    }

    public boolean inneholderVerdi(int n) {
        Node node = hode;
        while(node!=null) {
            if(node.val == n) return true;
            node = node.next;
        }
        return false;
    }

    public void slettVerdi(int n) {
        Node node = hode;
        if(node.val == n) {
            hode = node.next;
            storleik--;
            return;
        }
        while(node.next != null) {
            if(node.next.val == n) {
                node.next = node.next.next;
                storleik--;
                return;
            }
            node = node.next;
        }
    }

    public int taEnTitt() {
        return hode.val;
    }

    public String skrivUtListe() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node node = hode;
        while(node != null) {
            sb.append(node.val+" ");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public int storleik() {
        return storleik;
    }
}


public class Oppgave1 {

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

    }
}
