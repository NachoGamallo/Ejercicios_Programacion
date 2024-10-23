package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practica3_T2 {
    public void isbm_check(){
        Scanner entry = new Scanner(System.in);
        String isbm = "";
        int operation = 0;
        int irregular_character = 0;
        int irregular_op;
        int character;
        int number;
        int irregular_N = 0;

        try {
            System.out.println("Introduzca un ISBN");
            isbm = entry.next();
        }catch (InputMismatchException error){
            System.out.println("No has introducido el formato correcto " + error.getMessage());
        }

        if (isbm.length() == 10){

            for (int i=1; i <= 10 ; i ++) {

                if (isbm.charAt(i-1) == '?') {
                    irregular_character = i;
                } else {

                    if (i == 10 && isbm.charAt(i - 1) == 'X') {

                        number = (10 * i);

                    }else {
                        try {
                            character = Integer.parseInt(isbm.substring(i - 1, i));
                        }catch (NumberFormatException error){
                            System.out.println(error.getMessage());
                            break;
                        }
                        number = (character * i);

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
                    System.out.println("El ISBM es válido");
                }else{
                    System.out.println("El ISBM no es válido (No es multiplo de 11)");
                }

            }

        }else{
            System.out.println("El ISBM no es válido (longitud erronea)");
        }
    }
}
