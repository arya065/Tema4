package com.mycompany.tema4;

import java.lang.*;
import java.util.*;

public class Ej4A {

    public static void main(String[] args) {
        Random rand = new Random();
        //одновременно произносит цифру от 1 до 10
        //Одновременно показывают руку с цифрой
        //Тот кто назвал правильно сумму цифр побеждает
        int i = 0, numeroSumma = 0, numeroMano = 0;
        int jugar = 1;
        do {
            while (i == 0) {
                numeroSumma = numeroSumma();//numeroSumma de jugador
                if (numeroSumma == 0) {
                    i = 0;
                } else {
                    i++;
                }
            }
            int numeroSummaOrdenador = rand.nextInt(10) + 1;//numeroSumma de ordenador
            System.out.printf("mi numero de suma es %d\n\n",numeroSummaOrdenador);
            i = 0;

            while (i == 0) {
                numeroMano = numeroMano();
                if (numeroMano == 0) {
                    i = 0;
                } else {
                    i++;
                }
            }
            int numeroManoOrdenador=1;
            //int numeroManoOrdenador = rand.nextInt(5) + 1;
            System.out.printf("mi numero es %d\n\n",numeroManoOrdenador);
            i = 0;

            int ganador = ganador(numeroSummaOrdenador, numeroManoOrdenador, numeroMano, numeroSumma);
            if (ganador == 0) {
                System.out.printf("Yo he ganado\n\n");
            } else if (ganador == 1) {
                System.out.printf("Tu has ganado\n\n");
            } else {
                System.out.printf("Nadie ha ganado\n\n");
            }
            boolean playAgain = playAgain();
            if (!playAgain) {
                System.out.println("Adios");
                jugar = 0;
            } else if (playAgain) {
                jugar = 1;
            }
        } while (jugar == 1);

    }

    public static int numeroSumma() {
        Scanner in = new Scanner(System.in);
        int numeroSumma;
        System.out.printf("Entoduce numero de 1 a 10\nEste numero es numero de summa:\n ");
        try {
            numeroSumma = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("Debe ser numero de 1 a 10\n\n");
            numeroSumma = 0;
        }
        if (numeroSumma > 10 || numeroSumma < 1) {
            System.out.printf("Debe ser numero de 1 a 10\n\n");
            numeroSumma = 0;
        }
        return numeroSumma;
    }

    public static int numeroMano() {
        Scanner in = new Scanner(System.in);
        int numeroMano = 0;
        System.out.printf("Entoduce numero de 1 a 5\nEste numero es numero de mano:\n ");
        try {
            numeroMano = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("Debe ser numero de 1 a 5\n\n");
            numeroMano = 0;
        }
        if (numeroMano > 5 || numeroMano < 1) {
            System.out.printf("Debe ser numero de 1 a 5\n\n");
            numeroMano = 0;
        }
        return numeroMano;
    }

    public static int ganador(int numeroSummaOrdenador, int numeroManoOrdenador, int numeroMano, int numeroSumma) {
        int ganador;
        int summa = numeroMano + numeroManoOrdenador;
        if (numeroSumma == summa && numeroSummaOrdenador!=summa) {
            ganador = 1;
        } else if (numeroManoOrdenador == summa) {
            ganador = 0;
        } else {
            ganador = 2;
        }
        return ganador;
    }

    public static boolean playAgain() {
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;
        System.out.printf("Quieres jugar otro vez?\n\n");
        String answer = in.nextLine();
        answer = answer.toUpperCase();

        if (!answer.equals("SI") && !answer.equals("NO")) {
            System.out.println("Entroduce Si o No");
        } else if (answer.equals("SI")) {
            playAgain = true;
        } else if (answer.equals("NO")) {
            playAgain = false;
        }
        return playAgain;
    }

}
