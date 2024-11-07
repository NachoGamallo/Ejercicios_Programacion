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
        int [] fvector = new int [3];
        int [] svector = new int [3];
        
    }
    public void Arrayex8(){}
    public void Arrayex9(){}
    public void Arrayex10(){}
}
