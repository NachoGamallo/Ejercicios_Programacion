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

            for (int i=1; i <= 10 ; i ++) { //bucle que recorre 10 números

                if (isbn.charAt(i-1) == '?') { //Si el caracter en la posición del valor de i, es un ?
                    irregular_character = i; // se guarda el valor en una variable
                } else { //si no es una ?

                    if (i == 10 && isbn.charAt(i - 1) == 'X') { //Comprueba si i es 10 (ultimo carácter) y a su vez
                        //comprueba que el caracter de la ultima posición sea una x.

                        number = (10 * i); //multiplica la i por un 10

                    }else {
                        try { //Intenta convertir el caracter en número entero, y multiplicar el caracter * i(bucle)
                            character = Integer.parseInt(isbn.substring(i - 1, i));
                            number = (character * i);
                        }catch (NumberFormatException error){//Si al intentar convertir en número falla el programa sale
                            System.out.println(error.getMessage());
                            exit(1);
                        }

                    }
                    operation = (operation + number); //Esta variable va acumulando el valor de number, que lo usamos
                    //en todas las operaciónes de este bucle
                }
            }
            if (irregular_character != 0){ //Comprueba si hay alguna ? en el número

                for (int a=0;a<=9;a++){ //Hace un bucle del 0 al 9 (10 números)
                    irregular_op = (irregular_character * a); //Guarda en una variable el número que nos guardamos en
                    //el anterior for y lo multiplica por a (bucle).
                    if ((operation + irregular_op) % 11 == 0){//Si operación, acumulacion de los resultados del otro for
                        //más el número que tenemos calculado de la anteriór linea es multiplo de 11. Se guarda el número
                        //de a (bucle),depues se sale del bucle
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
