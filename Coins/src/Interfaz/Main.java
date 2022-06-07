package Interfaz;

import gfutria.SearchStateSpaces;
import Mundo.Coins;
import java.util.ArrayList;
import static Mundo.Coins.*;

public class Main {

    public static void main(String[] args) {
        int[] array = {4, 8, 2, 7, 0, 9};
        int n = 6;
        int m = 10;
        int a;
        boolean c;
        a = suma2(array, n);
        if (a % m == 0) {
            c = true;
        } else {
            c = false;
        }

        Coins pilas = new Coins(n, m, array);
        ArrayList<String> lst;
        SearchStateSpaces sss;
        if (suma(array, n, m)) {
            if (!comprobar(array, n, m)) {
                sss = new SearchStateSpaces("Okay", pilas, n * (n - 1));
                lst = sss.solve();

                System.out.println("Número de pasos: " + lst.size());
                if (lst.size() > 0) {
                    for (int i = 0; i < lst.size(); i++) {
                        System.out.println(lst.get(i));
                    }
                }
            } else {
                System.out.println("Número de pasos: " + "0");
            }
        } else {
            System.out.println("Imposible");

        }

    }

}
