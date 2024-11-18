package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Practica2_T3 {
    public void laprimitivaP2T3(){
        Scanner entry = new Scanner(System.in);
        Random random = new Random();

       String[] user_chain; //Aquí definimos los 2 vectores y definimos variables.
       int [] random_chain = new int[7];
       int [] user_convert_toInt = new int[7];
       String user_input;
       int complementary;
       boolean status;

        do {

            status = true;
            System.out.println("Introduce la cadena ");
            user_input = entry.next();//Aqui el usuario ingresa los numeros que quiere con formato
            //x-x-x-x-x-x/x
            status = user_input.matches("\\d-\\d-\\d-\\d-\\d-\\d/\\d");
            user_chain = user_input.split("[-/]");

            if (status){

                try {
                    for (int i = 0;i<user_chain.length;i++){
                        user_convert_toInt[i] = Integer.parseInt(user_chain[i]);
                    }
                }catch (InputMismatchException error){
                    status = false;
                    System.out.println("Has introducido un formato no permitido...");
                }

            }else {System.out.println("Has introducido un formato no permitido...");}
            int[] temp = Arrays.stream(user_convert_toInt).distinct().toArray();
            if (status && temp.length != user_convert_toInt.length){
                System.out.println("Has introducido un formato no permitido...");
                status = false;
            }
        }while (!status);
        do {
            status = true;
            for (int i=0;i<random_chain.length;i++){
                if (i!=random_chain.length -1){
                    random_chain[i] = random.nextInt(49)+1;
                }else {
                    random_chain[i] = random.nextInt(10);
                }
            }

            int[] random_temp = Arrays.stream(random_chain).distinct().toArray();
            if (random_temp.length != random_chain.length){
                status = false;
            }
            complementary = random.nextInt(49)+1;
            for (int i = 0;i<random_chain.length -2;i++){
                if (random_chain[i] == complementary) {status = false;break;}
            }
        }while (!status);
        System.out.println(Arrays.toString(random_chain));
        System.out.println(Arrays.toString(user_convert_toInt));
        System.out.println(complementary);
    }
}
