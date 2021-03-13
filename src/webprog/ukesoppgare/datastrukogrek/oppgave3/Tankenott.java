package webprog.ukesoppgare.datastrukogrek.oppgave3;
import java.util.*;

class Flytt {
    int ring;
    char fra, til;

    public Flytt(int ring, char fra, char til) {
        this.ring = ring;
        this.fra = fra;
        this.til = til;
    }
}

public class Tankenott {
    static List<Flytt> flyttListe;
    public static void main(String[] args) {
        int n = 3;
        //rekursjon(n, 'A', 'C', 'B');

        Stack<Integer> start = new Stack<>();
        Stack<Integer> slutt = new Stack<>();
        Stack<Integer> midt = new Stack<>();

        start.push(1);
        start.push(2);
        start.push(3);

        flyttListe = new ArrayList<>();

        stackRekursjon(n, start, slutt, midt, 'A', 'C', 'B');
        for(Flytt f:flyttListe) {
            System.out.println("Flytt ring " + f.ring + " fra stav " + f.fra + " til stav " + f.til);
        }

    }

    static void stackRekursjon(int n, Stack<Integer> start, Stack<Integer> slutt, Stack<Integer> midt,
                               char startC, char sluttC, char midtC) {
        if(n == 1) {
            Flytt flytt = new Flytt(start.pop(), startC, sluttC);
            flyttListe.add(flytt);
            slutt.push(flytt.ring);
            return;
        }
        stackRekursjon(n-1, start, midt, slutt, startC, midtC, sluttC);
        Flytt flytt = new Flytt(start.pop(), startC, sluttC);
        flyttListe.add(flytt);
        slutt.push(flytt.ring);
        stackRekursjon(n-1, midt, slutt, start,midtC, sluttC, startC);
    }

    static void rekursjon(int n, char start, char slutt, char midt) {
        if(n == 1) {
            System.out.println("Flytt ring 1 fra stav " + start + " til " + slutt);
            return;
        }
        rekursjon(n-1, start, midt, slutt);
        System.out.println("Flytt ring " + n + " fra stav " + start + " til " + slutt);
        rekursjon(n-1, midt, slutt, start);
    }


}
