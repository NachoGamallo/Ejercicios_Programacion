package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sopa_De_Letras {
    public void P3T3(){
        Scanner entry = new Scanner(System.in);
        boolean status;
        int column = 0, row = 0;

        do{
            try {
                status = true;
                System.out.println("Introduce el número de filas: ");
                row = entry.nextInt();

                System.out.println("Introduce el número de columnas: ");
                column = entry.nextInt();

            }catch (InputMismatchException error){
                System.out.println("Has introducido un parametro no permitido...");
                entry.next();
                status = false;
                continue;
            }

            if (row <= 0 || column <= 0){
                System.out.println("Has introducido un 0 en las filas/columnas, no permitido...");
                status = false;
            }

        }while (!status);

        String[][] letter_soup = new String [row][column];
        String[] row_chain;
        String usr_chain;

        for (int i = 0;i<row;i++){

            System.out.println("Introduce las letras de la fila " + i);
            usr_chain = entry.next();
            row_chain = usr_chain.split("");

            if (row_chain.length != column || !usr_chain.matches("[a-zA-Z]{"+ column +"}")){
                System.out.println("No has introducido una longitud/paremetros correctos...");
                return;
            }else {

                for (int j = 0;j<column;j++){

                    letter_soup[i][j] = row_chain[j];

                }
            }
        }
        System.out.println("\n");
        for(String[] i: letter_soup){
            for(String j: i){
                System.out.print(j);
            }
            System.out.println();
        }

        String usr_word;
        String[] word_vector;
        System.out.println("Introduce la palabra a buscar: ");
        usr_word = entry.next();
        word_vector = usr_word.split("");

        if (!usr_word.matches("[a-zA-Z]{"+ column +"}") && word_vector.length > column && word_vector.length > row){
            System.out.println("Has introducido mal el formato...");
            return;
        }
        System.out.println(Arrays.toString(word_vector));

        search_word:
        for (int i = 0;i<letter_soup.length;i++){

            for (int j = 0;j<letter_soup[0].length;j++){

                if (letter_soup[i][j].equalsIgnoreCase(word_vector[0])){
                    status = false;
                    for (int row_search = 0;row_search<letter_soup[0].length - j;row_search++){

                        if (!letter_soup[i][row_search].equalsIgnoreCase(word_vector[row_search])){
                            status = false;
                            break;
                        }else {
                            status = true;
                        }
                    }
                    if (!status){
                        for (int column_search = 0;column_search<letter_soup.length - i;column_search++){
                            if (!letter_soup[column_search][j].equalsIgnoreCase(word_vector[column_search])){
                                status = false;
                                break;
                            }else {
                                status = true;
                            }
                        }
                    }
                    if (status){
                        System.out.println("ENCONTRADA!! En la posicion: " + i + " , " + j);
                        break search_word;
                    }
                }
            }
        }
    }
}