package org.example;

import java.util.Scanner;

public class T2Loop_Exercices {
    public static Scanner entry = new Scanner(System.in);
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
    public void T2LEx2(){}
    public void T2LEx3(){}
    public void T2LEx4(){}
    public void T2LEx5(){}
    public void T2LEx6(){}
    public void T2LEx7(){}
    public void T2LEx8(){}
}
