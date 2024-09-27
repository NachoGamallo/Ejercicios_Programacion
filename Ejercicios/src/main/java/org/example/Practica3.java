package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Practica3 {
    public void ej3(){
        int min_age = 18;
        int age = -1;
        Scanner entry = new Scanner(System.in);
        System.out.println("Como te llamas?");
        String name = entry.next();
        while (age < 0){
            try {
                System.out.println("Hola " + name + ". Introduce tu edad:");
                age = entry.nextInt();
            }catch (NumberFormatException | InputMismatchException e){
                System.out.println("Introduce un numero valido.");
                entry.nextLine();
            }
        }
        if ( age < min_age){
            int dif = (min_age - age);
            System.out.println("Lo siento "+ name + ". No puedes votar");
            if (dif == 1){
                System.out.println("Te faltan " + dif + " año para ser mayor de edad.");
            }else {
                System.out.println("Te faltan " + dif + " años para ser mayor de edad.");
            }
        }else {
            System.out.println("Enhorabuena " + name + ". Puedes votar");
        }
    }
}