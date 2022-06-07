package Mundo;

import java.util.ArrayList;
import gfutria.Logic;

public class Coins extends Logic {

    //Atributos
    private int npilas, multiplo;
    public int[] stacks;
    private static int to, from, ind;

    //Contructores
    public Coins(int npilas, int multiplo, int[] grupoMonedas) {
        this.npilas = npilas;
        this.multiplo = multiplo;
        this.stacks = grupoMonedas;
    }

    public Coins() {
    }

    public int getNpilas() {
        return npilas;
    }

    public void setNpilas(int n) {
        this.npilas = n;
    }

    public int getMultiplo() {
        return multiplo;
    }

    public void setMultiplo(int m) {
        this.multiplo = m;
    }

    public int[] getGrupoMonedas() {
        return stacks;
    }

    public void setGrupoMonedas(int[] grupoMonedas) {
        this.stacks = grupoMonedas;
    }

    public void action(int index) {
        if (index == 1) {
            to = from = 0;
            ind = 1;
        } else {
            if (ind == npilas) {
                ind = 1;
                from = from + 1;
                to = 0;
            }
        }
        ind++;
        if (to == from) {
            to++;
        }
        // System.out.println("index " + index + " from: " + from + " to " + to);
        if (stacks[from] > 0) {
            stacks[from]--;
            stacks[to]++;
        }
        to++;
    }

    // Metodos sobreescritos de la clases Logic  
    @Override
    public String state() {
        String state = "";
        int i;
        for (i = 0; i < npilas; i++) {
            state = state + " " + stacks[i];//.getClass();
        }

        int j;
        for (j = 0; j < npilas; j++) {
            if (stacks[j] % multiplo != 0) {
                break;
            }
        }
        //System.out.println("i"+i+"j"+j);

        if (j == npilas) {
            state = "Okay";
        }
        //System.out.println("state"+state);
        return state;
    }

    public Logic cloneObject(Logic logic) {
        Coins obj = (Coins) logic;
        Coins objClone;
        int vec[];

        vec = new int[npilas];

        objClone = new Coins();
        objClone.setMultiplo(obj.getMultiplo());
        objClone.setNpilas(obj.getNpilas());

        for (int i = 0; i < npilas; i++) {
            vec[i] = obj.getGrupoMonedas()[i];
        }

        objClone.setGrupoMonedas(vec);

        return objClone;
    }

    public static boolean comprobar(int[] pilas, int n, int m) {
        int j;
        for (j = 0; j < n; j++) {
            if (pilas[j] % m != 0) {
                break;
            }
        }
        if (j == n) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean suma(int[] pilas, int n, int m) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result + pilas[i];
        }
        if (result % m == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int suma2(int[] pilas, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result + pilas[i];
        }
        return result;
    }
}
