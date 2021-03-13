package webprog.ukesoppgare.datastrukogrek.oppgave3;

import java.util.Arrays;
import java.util.Random;

public class Rekursjon3 {
    public static void main(String[] args) {
        int[] tallRekke = new int[1000];
        Random random = new Random();
        for(int i = 0; i < 1000; i++) {
            tallRekke[i] = random.nextInt(9999);
        }
        tallRekke[789] = 7896;
        Arrays.sort(tallRekke);
        int k = binerSok(tallRekke, 0, tallRekke.length-1, 7896);
        System.out.println(tallRekke[k]);
    }

    static int binerSok(int[] tallrekke, int venstre, int hoyre, int n) {
        if(hoyre >= venstre) {
            int midt = venstre+(hoyre-venstre)/2;
            if(tallrekke[midt] == n) return midt;
            if(tallrekke[midt] > n) return binerSok(tallrekke, venstre, midt-1, n);
            return binerSok(tallrekke, midt + 1, hoyre, n);
        }
        return -1;
    }
}
