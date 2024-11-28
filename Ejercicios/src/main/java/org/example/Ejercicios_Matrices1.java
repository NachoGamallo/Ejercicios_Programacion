package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicios_Matrices1 {
    public static Scanner entry = new Scanner(System.in);
    public static Random random = new Random();
    public void ex1(){
        int [][] list = new int [3][3];
        int temp, num;
        for (int i = 0;i<list.length;i++){
            for(int j = 0;j<list[i].length;j++){
                System.out.println("Introduce el parametro " + j + " del vector: " + i);
                try {
                    temp = entry.nextInt();
                    list[i][j] = temp;
                }catch (InputMismatchException error){
                    System.out.println("Has ingresado un parametro no apto...");
                    return;
                }
            }
        }
        try {
            System.out.println("Numero a buscar: ");
            num = entry.nextInt();
        }catch (InputMismatchException error2){
            System.out.println("Has ingresado un parametro no apto...");
            return;
        }
        for(int i = 0;i<list.length;i++){
            for (int j = 0;j<list[i].length;j++){
                if (list[i][j] == num){
                    System.out.println("El numero " + num +" se encuentra en la posicion (" + i + " , " + j + ")");
                }
            }
        }
    }
    public void ex2(){
        int [][] list = new int [random.nextInt(0,5)+1][random.nextInt(0,5)+1];
        int temp, colum_sum,row_sum;
        for (int i = 0;i<list.length;i++){
            for(int j = 0;j<list[i].length;j++){
                System.out.println("Introduce el parametro " + j + " del vector: " + i);
                try {
                    temp = entry.nextInt();
                    list[i][j] = temp;
                }catch (InputMismatchException error){
                    System.out.println("Has ingresado un parametro no apto...");
                    return;
                }
            }
        }
        for (int i = 0;i<list.length;i++){
            row_sum = 0;
            for (int j = 0;j<list[i].length;j++){
                row_sum += list[i][j];
            }
            System.out.println("Fila " + i + " : " + row_sum);
        }
        for (int i = 0; i <list[i].length; i++){
            colum_sum = 0;
            for (int j = 0; j <list.length; j++){
                colum_sum += list[i][j];
            }
            System.out.println("Columna " + i + " : " + colum_sum);
        }
    }
    public void ex3(){

    }
}
