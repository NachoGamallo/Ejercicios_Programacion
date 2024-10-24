package org.example;

import java.util.Scanner;
import static java.lang.System.exit;

public class Practica3_T2 {
    public void isbn_check(){
        Scanner entry = new Scanner(System.in);
        String isbn;
        int operation = 0;
        int irregular_character = 0;
        int irregular_op;
        int character;
        int number = 0;
        int irregular_N = 0;

        System.out.println("Introduzca un ISBN");
        isbn = entry.next();

        if (isbn.length() == 10){

            for (int i=1; i <= 10 ; i ++) {

                if (isbn.charAt(i-1) == '?') {
                    irregular_character = i;
                } else {

                    if (i == 10 && isbn.charAt(i - 1) == 'X') {

                        number = (10 * i);

                    }else {
                        try {
                            character = Integer.parseInt(isbn.substring(i - 1, i));
                            number = (character * i);
                        }catch (NumberFormatException error){
                            System.out.println(error.getMessage());
                            exit(1);
                        }

                    }
                    operation = (operation + number);
                }
            }
            if (irregular_character != 0){

                for (int a=0;a<=9;a++){
                    irregular_op = (irregular_character * a);
                    if ((operation + irregular_op) % 11 == 0){
                        irregular_N = a;
                        break;
                    }
                }
                System.out.println("El dígito que falta es " + irregular_N);

            }else {

                if ((operation % 11) == 0){
                    System.out.println("El ISBN es válido");
                }else{
                    System.out.println("El ISBN no es válido (No es multiplo de 11)");
                }

            }

        }else{
            System.out.println("El ISBN no es válido (longitud erronea)");
        }
    }
}
