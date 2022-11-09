
package com.mycompany.tema4;
import java.util.*;
import java.lang.*;
import org.apache.commons.lang3.RandomStringUtils;//импорт архивов в файл pom
public class Ej4B {
    public static void main(String[] args) {
        //три варианта приложения
        //1-й: создание пинов для симки из 4-х цифр
        //2-й: генерируюет пароль из 8 символов
        //3-й: генерирует пароль из n символов заваемых пользователем
        System. out. println(RandomStringUtils. random(15,"abcdefghijk"). toUpperCase());
    }
    
}
