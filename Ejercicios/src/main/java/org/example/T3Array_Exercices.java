package org.example;
import java.util.Arrays;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class T3Array_Exercices {
    public static Random random = new Random();
    public static Scanner entry = new Scanner(System.in);
    public void Arrayex1(){
        int[] vector = new int [8];
        int suma=0;
        for (int i = 0;i<vector.length;i++){
            vector[i] = random.nextInt(501);
            suma += vector[i];
        }
        System.out.println("La suma de los elementos es: " + suma);
    }
    public void Arrayex2(){
        int [] vector =new int [5];
        int temp;
        System.out.println("Introduce los números a invertir: ");
        for (int i = 0;i<vector.length;i++){
            vector[i] = entry.nextInt();
        }
        System.out.println(Arrays.toString(vector));
        for (int i = 0;i<vector.length/2;i++){
            temp = vector[i];
            vector[i]=vector[vector.length -1 - i];
            vector[vector.length -1 -i] = temp;
        }
        System.out.println(Arrays.toString(vector));
    }
    public void Arrayex3(){
        int [] vector = new int [25];
        int search_num = 0, N_num = 0;
        boolean status = true;
        do{
            try{
                System.out.println("Ingresa un número para buscar [0,100]: ");
                search_num = entry.nextInt();
            }catch (InputMismatchException error){
                System.out.println(error.getMessage() + "Ingresa un valor válido.");
                status = false;
                entry.nextLine();
            }
        }while (!status || search_num <= 0 || search_num >=100);
        for (int i = 0;i<vector.length;i++){
            vector[i] = random.nextInt(101);
            if (vector[i] == search_num){
                N_num++;
            }
        }
        System.out.println("El número " + search_num + " aparece " + N_num + " veces en el array.");
    }
    public void Arrayex4(){
        int [] vector = new int [5];
        int [] new_vector = new int [5];
        int delete = 0;
        boolean status = true;
        for (int i=0;i<vector.length;i++){
            vector[i] = random.nextInt(11);
        }
        System.out.print("Array original: ");
        for (int n : vector){
            System.out.print(n + " ");
        }
        System.out.println();

        do{
            try {
                System.out.println("Ingresa el índice a eliminar: ");
                delete = entry.nextInt();
                if (delete < 0 || delete > vector.length){
                    status = false;
                }else{
                    status = true;
                }
            }catch (InputMismatchException error){
                System.out.println(error.getMessage() + " ,Ingresa un valor aceptado");
                status = false;
                entry.nextLine();
            }
        }while (!status);
        System.out.print("Array resultante: ");
        for (int a = 0;a<vector.length;a++){
            if (a == delete){
                continue;
            }
            new_vector [a] = vector [a];
            System.out.print(new_vector[a] + " ");
        }
    }
    public void Arrayex5(){
        int [] vector = new int [5];
        System.out.println("Introduce el valor de el vector: ");
        for (int i=0;i<vector.length;i++){
            vector[i] = entry.nextInt();
        }
        int last_position = vector[vector.length - 1];
        System.out.println("Array original: " + Arrays.toString(vector));
        for(int i = vector.length - 1;i>=0;i--){
            if (i == 0){
                vector[i] = last_position;
            }else{
                vector[i] = vector[i - 1];
            }
        }
        System.out.println("Array rotado: " + Arrays.toString(vector));
    }
    public void Arrayex6(){
        int [] vector = new int [5];
        int last_chain,start_chain;
        boolean status = true;
        System.out.println("Introduce los valores: ");
        for (int i=0;i<vector.length;i++){
            try {
                vector[i] = entry.nextInt();
            }catch (InputMismatchException error){
                System.out.println("ERROR, introduce el formato correcto.");
                entry.next();
                i--;
            }
        }
        System.out.println("Array: " + Arrays.toString(vector));
        for (int i=0;i<vector.length/2;i++){
            start_chain = vector[i];
            last_chain = vector[vector.length - 1 - i];
            if (start_chain != last_chain){
                status = false;
                break;
            }
        }
        if (status){
            System.out.println("Es simétrico: SI");
        }else{
            System.out.println("Es simétrico: NO");
        }
    }
    public void Arrayex7(){
        int [] first_vector = {1,2,3};
        int [] second_vector = {4,5,6};
        int [] total_vector =new int [first_vector.length + second_vector.length];
        System.arraycopy(first_vector,0,total_vector,0,3);
        System.arraycopy(second_vector,0,total_vector,3,3);
        System.out.println("Array 1: " + Arrays.toString(first_vector));
        System.out.println("Array 1: " + Arrays.toString(second_vector));
        System.out.println("Array combinado: " + Arrays.toString(total_vector));
    }
    public void Arrayex8(){
        int user_number = 0,user_position = 0;
        int [] original_vector =  {1,2,3,5};
        int [] result_vector = new int [original_vector.length + 1];
        boolean status;
        System.out.println("Array original: " + Arrays.toString(original_vector));
        do {
            try {
                System.out.println("Iserta el número que quieres añadir: ");
                user_number = entry.nextInt();
                System.out.println("Inserta la posición en la que lo quieres poner (máximo 3): ");
                user_position = entry.nextInt();
                if (user_position < 0 || user_position > original_vector.length){
                    System.out.println("ERROR, Has ingresado una posición incorrecta.");
                    status = false;
                    entry.next();
                }else {
                    status = true;
                }
            }catch (InputMismatchException error){
                System.out.println("ERROR, Has ingresado un formato incorrecto.");
                status = false;
                entry.next();
            }
        }while (!status);
        System.out.println("Inserta el número " + user_number + " en la posición " + user_position);
        System.arraycopy(original_vector,0,result_vector,0,user_position);
        result_vector [user_position] = user_number;
        System.arraycopy(original_vector,user_position,result_vector,user_position + 1 ,original_vector.length - user_position);
        System.out.println("Array resultante: " + Arrays.toString(result_vector));

    }
    public void Arrayex9(){
        String longger_vector = "",temp = "";
        String [] vector = {"hola","que","tal","estas","raul"};
        for (int i=0;i<vector.length;i++){
            temp = vector[i];
            if (temp.length() > longger_vector.length()){
                longger_vector = vector[i];
            }
        }
        System.out.println("La palabra mas larga es: " + longger_vector);
    }
    public void Arrayex10(){
        String [] vector = {"Pero","Madre","mia","WILLY","COMPAÑERO","!!!"};
        String user_char,actual_vector;
        System.out.println("Introduce una letra (char): ");
        user_char = entry.next();
        user_char = String.valueOf(user_char.charAt(0));
        for (int i = 0;i<vector.length;i++){
            actual_vector = vector[i];
            if (actual_vector.substring(0,1).equalsIgnoreCase(user_char)){
                System.out.print(actual_vector + ", ");
            }
        }
    }
}