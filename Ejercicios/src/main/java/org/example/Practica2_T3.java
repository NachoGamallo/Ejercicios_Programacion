package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Practica2_T3 {
    public void laprimitivaP2T3(){
        Scanner entry = new Scanner(System.in);
        Random random = new Random();

       String[] user_chain = new String[7];
       int [] random_chain = new int[7];
       String user_input;
       boolean status;
        do {
            status = true;
            System.out.println("Introduce la cadena ");
            user_input = entry.next();
            status = user_input.matches("\\d-\\d-\\d-\\d-\\d-\\d/ \\d");
            for (int i=0;i< user_chain.length;i++){
                try {

                }catch (InputMismatchException error){
                    System.out.println("ERROR. Has introducido un valor no válido");
                    status = false;
                }
            }
        }while (!status);
        user_chain = user_input.split("[-/]");
        do {
            status = true;
            for (int i:random_chain){
                if (i!=random_chain.length -1){
                    random_chain[i] = random.nextInt(49)+1;
                }
            }
        }while (!status);
    }
}
