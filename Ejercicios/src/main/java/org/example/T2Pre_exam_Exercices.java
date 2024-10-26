package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class T2Pre_exam_Exercices {
    public static Scanner entry = new Scanner(System.in);
    public void T2pre_exam_ex1(){
        int total_num = 0;
        int num;
        boolean value = true;
        int equal = 0;
        int upper = 0;
        int smaller = 0;

        try {
            System.out.println("Introduce la cantidad de números a introducir: ");
            total_num = entry.nextInt();
        }catch (InputMismatchException error){
            System.out.println(error.getMessage());
            value = false;
        }
        if (value){
            for (int i=1;i<=total_num;i++){
                try{
                    System.out.println("Introduce el número");
                    num = entry.nextInt();

                }catch (InputMismatchException error2) {
                    System.out.println(error2.getMessage());
                    value = false;
                    break;
                }
                if (num < 0){smaller++;}
                else if (num > 0) {upper++;}
                else{equal++;}
            }
            if (value){
                System.out.println("Mayores de 0: " + upper);
                System.out.println("Menores de 0: " + smaller);
                System.out.println("Iguales a 0: " + equal);
            }
        }
    }
    public void T2pre_exam_ex2(){
        boolean value = true;
        int base = 0;
        int exponent = 0;
        int result = 0;
        try {
            System.out.println("Introduce la base:");
            base = entry.nextInt();
            result = base;
            System.out.println("Introduce la base:");
            exponent = entry.nextInt();
            if (exponent<0){value=false;}
        }catch (InputMismatchException error){
            System.out.println(error.getMessage());
            value = false;
        }
        if (value){
            for (int i=1;i<exponent;i++){
                result *= base;
            }
            System.out.println("El resultado es: " + result);
        }

    }
    public void T2pre_exam_ex3(){
        int fiance = 0;
        int total_pay = 10;
        int pay = total_pay;
        boolean value = true;
        try {
            System.out.println("De cuentos meses es la fianza? ");
            fiance = entry.nextInt();
            if (fiance <= 0){value=false;}
        }catch (InputMismatchException error){
            System.out.println(error.getMessage());
            value = false;
        }
        if (value){
            for (int i = 1;i<fiance;i++){
                total_pay += pay *= 2;
            }
            System.out.println("Total a pagar: " + total_pay);
        }
    }
    public void T2pre_exam_ex4(){
        int note = 0;
        System.out.println("Dame una nota númerica");
        note = entry.nextInt();
    }
    public void T2pre_exam_ex5(){}
    public void T2pre_exam_ex6(){}
    public void T2pre_exam_ex7(){}
}
