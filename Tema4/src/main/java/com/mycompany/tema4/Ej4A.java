package com.mycompany.tema4;

import java.lang.*;
import java.util.*;

public class Ej4A {

    public static void main(String[] args) {
        Random rand = new Random();
        //загадывают цифру
        //одновременно произносит цифру от 1 до 10
        //Одновременно показывают руку с цифрой
        //Тот кто назвал правильно сумму цифр побеждает
        int i = 0;
        int numeroSumma = 0;
        int numeroMano = 0;
        int jugar = 1;//se utiliza para repetir juego
        do {

            while (i == 0) {
                numeroMano = numeroMano();//numero de jugador
                if (numeroMano == -1) {
                    i = 0;
                } else {
                    i++;
                }
            }

            int numeroManoOrdenador = rand.nextInt(6);//numero de ordenador
            i = 0;

            while (i == 0) {
                numeroSumma = numeroSumma();//numeroSumma de jugador
                if (numeroSumma == 0) {
                    i = 0;
                } else {
                    i++;
                }
            }
            int numeroSummaOrdenador = rand.nextInt(10) + numeroManoOrdenador;//numeroSumma de ordenador
            System.out.printf("mi numero de suma es %d\n\nmi numero de dedos es %d\n\n", numeroSummaOrdenador, numeroManoOrdenador);
            i = 0;

            int ganador = ganador(numeroSummaOrdenador, numeroManoOrdenador, numeroMano, numeroSumma);//quien ha ganado
            if (ganador == 0) {
                System.out.printf("Yo he ganado\n\n");
            } else if (ganador == 1) {
                System.out.printf("Tu has ganado\n\n");
            } else if (ganador == 2) {
                System.out.printf("Nadie ha ganado\n\n");
            }
            boolean playAgain = playAgain();
            if (!playAgain) {
                System.out.println("Saliendo...");
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
        System.out.printf("Entoduce numero de 0 a 5\nEste numero es numero de dedos:\n ");
        try {
            numeroMano = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("Debe ser numero de 0 a 5\n\n");
            numeroMano = 0;
        }
        if (numeroMano > 5 || numeroMano < 0) {
            System.out.printf("Debe ser numero de 0 a 5\n\n");
            numeroMano = -1;
        }
        return numeroMano;
    }

    public static int ganador(int numeroSummaOrdenador, int numeroManoOrdenador, int numeroMano, int numeroSumma) {
        int ganador;
        int summa = numeroMano + numeroManoOrdenador;
        if (numeroSumma == summa) {
            ganador = 1;
        } else if (numeroSummaOrdenador == summa) {
            ganador = 0;
        } else {
            ganador = 2;
        }
        return ganador;
    }

    public static boolean playAgain() {
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;
        int i = 0;
        while (i == 0) {
            System.out.printf("Quieres jugar otra vez?\n\n");
            String answer = in.nextLine();
            answer = answer.toUpperCase();

            if (!answer.equals("SI") && !answer.equals("NO")) {
                System.out.println("Entroduce Si o No");
                i = 0;
            } else if (answer.equals("SI")) {
                playAgain = true;
                i = 1;
            } else if (answer.equals("NO")) {
                playAgain = false;
                i = 1;
            }
        }
        return playAgain;
    }

} /*Los clientes de una tienda casi siempre tienen descuento al llegar a pagar a la caja durante la semana loca. Cuando van a pagar tienen que sacar una bola de una bolsa, que es la que nos indica el descuento. Si la bola es de color azul se obtiene un 20%, si es roja un 25%, si es blanca no hay descuento y si es verde, se saca de la bolsa y se vuelve a sacar otra de las restantes.
Escribe un programa que lea el importe a pagar por el cliente e imprima la bola que “sacó” de la bolsa y el importe con el descuento aplicado.
El programa, una vez finaliza un cliente, pregunta si hay otro en la cola para operar de la misma forma. Si no hay clientes, el programa termina.
