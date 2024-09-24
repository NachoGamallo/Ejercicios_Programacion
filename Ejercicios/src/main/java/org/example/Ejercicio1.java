package org.example;
import java.util.Scanner;

public class Ejercicio1{
    public void ex1(){
        Scanner enter = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int number = enter.nextInt();
        if (number == 0){
            System.out.println("El numero es neutro");
        } else if (number > 0 ) {
            System.out.println("El numero es positivo");

        }else{
            System.out.println("El numero es negativo");
        }
    }
}
