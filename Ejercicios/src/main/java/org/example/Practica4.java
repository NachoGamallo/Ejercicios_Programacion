package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Practica4 {
    public void practice_4(){
        Scanner entry = new Scanner(System.in);
        int num = 0;
        int num2 = 0;
        while (num <= 0 || num2 <= 0){
            try {
                if (num == 0){
                    System.out.println("Introduce el número multiplicado (3 cifras)");
                    num = entry.nextInt();
                    if (num < 100 || num > 999){num = 0;}
                }else{
                    System.out.println("Introduce el número que multiplica (3 cifras)");
                    num2 = entry.nextInt();
                    if (num2 < 100 || num2 > 999){num2 = 0;}
                }

            }catch (NumberFormatException | InputMismatchException e){
                System.out.println("Introduce un numero valido");
                entry.nextLine();
            }
        }
        int result = (num * num2);
        String num2_C = Integer.toString(num2);
        String num2_C1 = num2_C.substring(0,1);
        int num_1 = Integer.parseInt(num2_C1);
        num_1 = (num * num_1);
        /*numero izquierdo*/
        String num2_C2 = num2_C.substring(1,2);
        int num_2 = Integer.parseInt(num2_C2);
        num_2 = (num * num_2);
        /*numero central*/
        String num2_C3 = num2_C.substring(2,3);
        int num_3 = Integer.parseInt(num2_C3);
        num_3 = (num * num_3);
        /*numero derecho*/
        System.out.println("El producto de la multiplicación es: " + result);
        System.out.println("El proceso es: ");
        System.out.println("  " + num);
        System.out.println("x " + num2);
        System.out.println("--------");
        System.out.println("  " + num_1);
        System.out.println(" " + num_2 + "x");
        System.out.println(" "+ num_3 + "xx");
        System.out.println("--------");
        System.out.println(" " + result);

    }
}

