package org.example;
import java.util.Scanner;

public class Ejercicio2 {
    public void ex2(){
    Scanner enter = new Scanner(System.in);
    System.out.println("Dame un numero: ");
    int num1 = enter.nextInt();
    System.out.println("Dame otro numero diferente: ");
    int num2 = enter.nextInt();
    if (num1 == num2){
        System.out.println("ERROR, Los numeros introducidos son iguales. :(");
    } else {
                if (num1 > num2){
                    System.out.println("El numero " + num1 + " es mayor que " + num2);
                }else {
                    System.out.println("El numero " + num2 + " es mayor que " + num1);
                }
    }
    }
}
