package org.example;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class T2Random_Exercices {
    public static Random random = new Random();
    public static Scanner entry = new Scanner(System.in);

    public void T2REx1(){
        int num1 = random.nextInt(6) + 1;
        int num2 = random.nextInt(6) +1;
        System.out.println("El dado 1 a salido "+ num1 + " y el dado 2 a salido " + num2 + " , el resultado de la suma de ambos es: " + (num1+num2));
    }
    public void T2REx2(){
        String characters = "ABCDE vFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int tam = characters.length();
        int password_length = random.nextInt(6,9);
        int indice;
        StringBuilder password = new StringBuilder();

        for (int i=0;i<password_length;i++){
            indice = random.nextInt(tam);
            password.append(characters.charAt(indice));
        }
        System.out.println("La contraseña era: " + password);
    }
    public void T2REx3(){
        int min = 0;
        int max = 0;
        int number = 0;
        String result = "";
        boolean value = true;
        try {
            System.out.println("Ingrese el valor mínimo");
            min = entry.nextInt();
            System.out.println("Ingrese el valor maximo");
            max = entry.nextInt();
            System.out.println("Vale, por ultimo ingresa cuantos números aleatorios quieres");
            number = entry.nextInt();
        }catch (InputMismatchException | NumberFormatException error){
            System.out.println(error.getMessage());
            value = false;
        }
        if (value){
            for (int i = 1;i<=number;i++){
                int generated_number = random.nextInt(min,max );
                result += Integer.toString(generated_number);
            }
            System.out.println("Números generados: " + result);
        }
    }
}
