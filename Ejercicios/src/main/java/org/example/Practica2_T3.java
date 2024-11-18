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
       int [] temp_array = new int[6];
       String user_input;
       int complementary;
       boolean status;

        do {

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
                temp_array[i] = random_chain[i];
                if (random_chain[i] == complementary) {status = false;break;}
            }

        }while (!status);

        System.out.println(Arrays.toString(user_convert_toInt));
        System.out.println("SORTEO: ");
        System.out.println(Arrays.toString(temp_array));
        System.out.println("Complementario: " + complementary);
        System.out.println("Reintegro: " + random_chain[random_chain.length-1]);
        
        int points = 0, reintegro = 0, special_point=0;
        for (int i = 0; i<user_convert_toInt.length; i++){
            if (i == user_convert_toInt.length-1 && user_convert_toInt[i] == random_chain[i]){
                reintegro++;
                continue;
            }
            if (user_convert_toInt[i]==random_chain[i]){
                points++;
            } else if (user_convert_toInt[i] == complementary) {
                special_point++;
            }
        }
        System.out.println(" ");
        System.out.println("Resultados: ");
        if (points == 6 && special_point == 1){
            System.out.println("Categoría Especial");
        } else if (points == 6 && special_point == 0) {
            System.out.println("1ª Categoría");
        } else if (points == 5 && special_point == 1) {
            System.out.println("2ª Categoría");
        } else if (points == 4 && special_point == 1) {
            System.out.println("3ª Categoría");
        } else if (points == 3 && special_point == 1) {
            System.out.println("4ª Categoría");
        } else if (points == 2 && special_point == 1) {
            System.out.println("5ª Categoría");
        } else if (points == 1 && special_point == 1){
            System.out.println("2 Aciertos");
        }else {
            System.out.println("1 Aciertos");
        }

        if (reintegro == 1){
            System.out.println("Reintegro");
        }

        if (reintegro == 0 && (points + special_point) == 0) {
            System.out.println("No premiado");
        }
    }
}
