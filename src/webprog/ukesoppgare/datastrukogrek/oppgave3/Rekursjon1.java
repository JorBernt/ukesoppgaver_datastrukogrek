package webprog.ukesoppgare.datastrukogrek.oppgave3;

public class Rekursjon1 {
    public static void main(String[] args) {
        System.out.println(fakultet(10));
    }

    static long fakultet(long n) {
        if(n==0) return 1;
        return n*fakultet(n-1);
    }
}
