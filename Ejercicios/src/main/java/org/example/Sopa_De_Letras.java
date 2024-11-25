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
                column = entry.nextInt();
                System.out.println("Introduce el número de columnas: ");
                row = entry.nextInt();

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
        String usr_Chain = "";

        for (int i = 0;i<letter_soup.length;i++){

            System.out.println("Introduce las letras de la fila " + i);
            usr_chain = entry.next();
            row_chain = usr_Chain.split();
            for (int j = 0;j<letter_soup[i].length;j++){

                letter_soup[i][j] = row_chain[j];

            }
        }

        for(String[] i: letter_soup){
            for(String j: i){
                System.out.print(j);
            }
            System.out.println("\n");
        }
    }
}
