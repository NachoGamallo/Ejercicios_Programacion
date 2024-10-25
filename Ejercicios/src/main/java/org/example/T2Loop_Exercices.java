package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class T2Loop_Exercices {
    public
    Scanner entry = new Scanner(System.in);
    public void T2LEx1(){
        System.out.println("Crea tu contraseña: ");
        String real_pass = entry.next();
        String pass = "";
        System.out.println("-------------");
        do{
            System.out.println("Introduce la contraseña: ");
            pass = entry.next();
        }while(!real_pass.equals(pass));
    }
    public void T2LEx2(){
        int num = 1;
        boolean value = true;
        try {
            System.out.println("Introduce un número");
            num = entry.nextInt();
        }catch (NumberFormatException | InputMismatchException error){
            System.out.println(error.getMessage());
            value = false;
        }
        if (value){
            for (int i = num;i>=1;i--){
                System.out.println(i);
            }   
        }
    }
    public void T2LEx3(){
        int num = 50;
        for (int i = 1;i<=num;i++){
            if ((i % 3) == 0){
                System.out.println("El número " + i + " es multiplo de 3");
            }
        }
    }
    public void T2LEx4(){
        System.out.println("Introduce una palabra/frase");
        String chain = entry.next();
        for (int i=1;i<=chain.length();i++){
            System.out.println(chain.charAt(i-1));
        }
    }
    public void T2LEx5(){
        int num = 0;
        boolean value = true;
        try {
            System.out.println("Introduce un número");
            num = entry.nextInt();
        }catch (NumberFormatException | InputMismatchException error){
            System.out.println(error.getMessage());
            value = false;
        }
        if (value){
            for (int i=1;i<=10;i++){
                System.out.println(num +" * "+ i +" es = "+ (num*i));
            }
        }
    }
    public void T2LEx6(){
        int N_numbers = 0;
        int num = 0;
        int sum = 0;
        boolean value = true;
        try {
            System.out.println("Cuantos numeros quieres ingresar?");
            N_numbers = entry.nextInt();
        }catch (NumberFormatException | InputMismatchException error){
            System.out.println(error.getMessage());
            value = false;
        }
        if (value){
            for (int i=1;i<=N_numbers;i++){
                try {
                    System.out.println("Inserta nº" + i);
                    num = entry.nextInt();
                }catch (NumberFormatException | InputMismatchException error2){
                    System.out.println(error2.getMessage());
                    value = false;
                    break;
                }
                sum += num;
            }
        }
        if (value){
            System.out.println("El resultado es " + sum);
        }
    }
    public void T2LEx7(){
        int num = 0;
        boolean value = true;
         int calc = 0;
        try {
            System.out.println("Introduce un número");
            num = entry.nextInt();
            calc = num;
        }catch (NumberFormatException | InputMismatchException error){
            System.out.println(error.getMessage());
            value = false;
        }
        for (int i = 1;i<num;++i){
            calc *= i;
        }
        System.out.println("El factorial del numero es " + calc);
    }
    public void T2LEx8(){
        String inverse_chain = "";
        String character = "";
        System.out.println("Introduce una cadena de texto");
        String chain = entry.next();
        for (int i=chain.length();i>=1;i--){
            character = chain.substring(i-1,i);
            inverse_chain = inverse_chain + character;
        }
        System.out.println("La cadena invertida es " + inverse_chain);
    }
}
