package webprog.ukesoppgare.datastrukogrek.oppgave3;

public class Rekursjon2 {
    public static void main(String[] args) {
        System.out.println(iterativSum(3,4));
        System.out.println(rekSum(3,4));
    }

    static int iterativSum(int a, int b) {
        for(int i = 1; i <= b; i++) {
            a++;
        }
        return a;
    }

    static int rekSum(int a, int b) {
        if(b==0) return a;
        a++;
        return rekSum(a, b-1);
    }


}
