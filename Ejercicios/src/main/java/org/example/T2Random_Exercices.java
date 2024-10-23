package org.example;
import java.util.Random;
import java.util.Scanner;

public class T2Random_Exercices {
    public static Random random = new Random();
    public static Scanner entry = new Scanner(System.in);

    public void T2REx1(){}
    public void T2REx2(){
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int tam = caracteres.length();
        int longitud_contrasenya = 12;
        int indice;
        String contrasenya = "";

        for (int i=0;i<longitud_contrasenya;i++){
            indice = random.nextInt();
            contrasenya += caracteres.charAt(indice);
        }
        System.out.println("La contraseña era: " + contrasenya);
    }
    public void T2REx3(){}
    public void T2REx4(){}
}
