package org.example;
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
        int [] vector = new int [5];
        String original = "",invert = "";
        for (int i=0;i<vector.length;i++){
            vector[i] = i+1;
            if (i == 0){
                original += vector[i];
            }else {
                original += ", " + vector[i];
            }
        }
        for (int a = 4;a > -1;a--){
            vector[a] = a+1;
            if (a == 4){
                invert += vector[a];
            }else {
                invert += ", " + vector[a];
            }
        }
        System.out.println("Array original: " + original);
        System.out.println("Array invertido: " + invert);
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
            }
        }while (!status);
        for (int i = 0;i<vector.length;i++){
            vector[i] = random.nextInt(101);
            if (vector[i] == search_num){
                N_num += 1;
            }
        }
        System.out.println("El número " + search_num + " aparece " + N_num + " veces en el array.");
    }
    public void Arrayex4(){
        int [] vector = new int [5];
        int delete = 0;
        String original = "",result = "";
        boolean status = true;
        for (int i=0;i<vector.length;i++){
            vector[i] = random.nextInt(11);
            if (i == 0){
                original += vector[i];
            }else{
                original += " ," + vector[i];
            }
        }
        System.out.println("Array original: " + original);
        do{
            try {
                System.out.println("Ingresa el índice a eliminar: ");
                delete = entry.nextInt();
                if (delete < 0 || delete > vector.length){
                    status = false;
                }
            }catch (InputMismatchException error){
                System.out.println(error.getMessage() + " ,Ingresa un valor aceptado");
                status = false;
            }
        }while (!status);
        for (int a = 0;a<vector.length;a++){

        }
        System.out.println("Array resultante: " + result);
    }
    public void Arrayex5(){}
    public void Arrayex6(){}
    public void Arrayex7(){}
    public void Arrayex8(){}
    public void Arrayex9(){}
    public void Arrayex10(){}
}
