package org.example;

import java.util.Scanner;

public class Pre_Matrices {
    Scanner entry = new Scanner(System.in);
    public void ex1_PMatrices(){
        //Hecho en clase, Es en papel.
    }
    public void ex2_PMatrices(){
        System.out.println("Introduce una entrada: ");
        int height = entry.nextInt();

        for (int i=1;i<=height;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void ex3_PMatrices(){
        for (int i=1;i<=10;i++){
            for(int j=1;j<=10;j++){
                System.out.println( i + "x" +j + " = " + (i*j));
            }
            System.out.println();
        }
    }
    public void ex4_PMatrices(){
        int limit;
        boolean status;
        System.out.println("Introduce un numero:");
        limit = entry.nextInt();
        for (int i=2;i<limit;i++){
            status = true;
            for (int j = 2;j<i;j++){

                if (i % j == 0){
                    status = false;
                    break;
                }
            }
            if (status){
                System.out.print(i + " ");
            }
        }
    }
}
