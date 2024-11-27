package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sopa_De_Letras {
    public void P3T3(){
        Scanner entry = new Scanner(System.in);
        boolean status;
        int column = 0, row = 0;

        do{
            status = true;
            try {

                System.out.println("Introduce el número de filas: ");
                row = entry.nextInt();

                System.out.println("Introduce el número de columnas: ");
                column = entry.nextInt();

            }catch (InputMismatchException error){
                status = false;
            }

            if (status && row == 0 || column == 0){
                System.out.println("Has introducido un 0 en las filas/columnas, no permitido...");
                status = false;
            }

        }while (!status);

        String[][] letter_soup = new String [row][column];
        String[] row_chain;
        String usr_chain;

        for (int i = 0;i<letter_soup.length;i++){

            System.out.println("Introduce las letras de la fila " + i);
            usr_chain = entry.next();
            row_chain = usr_chain.split("");

            if (row_chain.length != row || !usr_chain.matches("[a-zA-Z]{"+ row +"}")){
                System.out.println("No has introducido una longitud/paremetros correctos...");
                return;
            }else {

                for (int j = 0;j<letter_soup[i].length;j++){

                    letter_soup[i][j] = row_chain[j];

                }
            }
        }

        for(String[] i: letter_soup){
            for(String j: i){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
