package com.mycompany.tema4;

import java.util.*;
import java.lang.*;
import org.apache.commons.lang3.RandomStringUtils;//импорт архивов в файл pom

public class Ej4B {

    public static void main(String[] args) {
        //три варианта приложения
        //1-й: создание пинов для симки из 4-х цифр
        //2-й: генерируюет пароль из 8 символов
        //3-й: генерирует пароль из n символов назаваемых пользователем
        int menu;
        Scanner in = new Scanner(System.in);
        do {
            menu = Menu();
            if (menu != 0) {
                if (menu == 1) {
                    System.out.print("Contrasena generada: ");
                    System.out.println(pinSim());
                } else if (menu == 2) {
                    System.out.print("Contrasena generada: ");
                    System.out.println(digit8());
                } else if (menu == 3) {
                    int numeros = 1;
                    int repeat=0;
                    do {
                        System.out.printf("Entroduce numero de digitos\n\n");
                        try {
                            numeros = in.nextInt();
                            repeat=1;
                        } catch (InputMismatchException e) {
                            System.out.println("Debe ser numero entero positivo\n");
                            in.next();
                            
                        }
                        
                    } while (repeat ==0);
                    System.out.println("Contrasena generada: " + digitn(numeros));
                }
            }
        } while (menu != 4);
        System.out.println("Saliendo...");
    }

    public static int Menu() {
        Scanner in = new Scanner(System.in);
        int option = 0;
        String menu = """
                    Elige una opcion
                    
                    1-Crear codigo PIN
                    2-Crear contraseña de 8 digitos
                    3-Crear contraseña de N digitos
                    4-Salir
                    """;
        System.out.println(menu);
        try {
            option = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("Debe ser numero desde 1 a 4\n\n");
            option = 0;
        }
        if (option > 4 || option < 1) {
            System.out.printf("Debe ser numero desde 1 a 4\n\n");
            option = 0;
        }
        return option;
    }

    public static String pinSim() {
        String pin = RandomStringUtils.randomNumeric(4);
        return pin;
    }

    public static String digit8() {
        String digit8 = RandomStringUtils.random(8, true, true);
        return digit8;
    }

    public static String digitn(int numeros) {
        //Scanner in = new Scanner(System.in);
        char[] simbolos = {'a', 'f', 's', '3', '7', '4', '@', 'f', 'l', '/'};
        String digitn = RandomStringUtils.random(numeros, simbolos);
        return digitn;
    }

}
