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
        boolean value = true;
        try {
            System.out.println("Dame una nota númerica (redondeada)");
            note = entry.nextInt();
        }catch (InputMismatchException error){
            System.out.println(error.getMessage() + ". No valido");
            value = false;
        }
        if (value){
            switch (note){
                case 0, 1 , 2, 3, 4:
                    System.out.println("Insuficiente");
                    break;
                case 5:
                    System.out.println("Suficiente");
                    break;
                case 6:
                    System.out.println("Bien");
                    break;
                case 8 , 7:
                    System.out.println("Notable");
                    break;
                case 9 , 10:
                    System.out.println("Sobresaliente");
                    break;
                default:
                    System.out.println("No valido");
                    break;
            }
        }

    }
    public void T2pre_exam_ex5(){
        int max_salary= 0, actual_salary, num = 5, more_than1000 = 0;
        boolean value = true;
        for (int i=1;i<=num;i++){
            try {
                System.out.println("Introduce el salario " + i + " de la empresa NTT data");
                actual_salary = entry.nextInt();
            }catch (InputMismatchException error){
                System.out.println(error.getMessage());
                value = false;
                break;
            }
            if (actual_salary > 1000){
                more_than1000++;
            }
            if (max_salary < actual_salary){
                max_salary = actual_salary;
            }
        }
        if (value){
            System.out.println("El salario mas alto es: " + max_salary);
            System.out.println("De los salarios introducidos " + more_than1000 + " son superiores a 1000");
        }

    }
    public void T2pre_exam_ex6(){
        int n_alum = 0, actual_age = 0, actual_height = 0, total_age = 0, total_height = 0, more_than175 = 0, more_than18 = 0;
        boolean value = true;
        try {
            System.out.println("De cuantos alumnos quieres preguntar la edad/altura");
            n_alum = entry.nextInt();
        }catch (InputMismatchException error){
            System.out.println(error.getMessage());
            value = false;
        }
        if (value){
            for (int i = 1;i <= n_alum;i++){
                try {
                    System.out.println("Introduce la edad del alumno " + i);
                    actual_age = entry.nextInt();
                    System.out.println("Introduce la altura del alumno " + i);
                    actual_height = entry.nextInt();
                }catch (InputMismatchException error){
                    System.out.println(error.getMessage());
                    value = false;
                    break;
                }
                total_age += actual_age;
                total_height += actual_height;
                if (actual_age > 18){
                    more_than18++;
                }
                if (actual_height > 175){
                    more_than175++;
                }
            }
            if (value){
                System.out.println("En esta clase, la media de edad es " + (total_age / n_alum) + " y la media de altura esta en " + (total_height / n_alum));
                System.out.println("Y en la clase hay " + more_than18 + " mayores de edad, y " + more_than175 + " miden mas de 175cm");
            }
        }
    }
    public void T2pre_exam_ex7(){
        int sequence_n = 0,sequence_value = 0,next_sequence=1;
        boolean value = true;
        do{
            try{
                System.out.println();
                System.out.println("Introduce el numero de secuencias que quieres ver");
                sequence_n = entry.nextInt();
                if (sequence_n <= 0){
                    value = false;
                    System.out.println("Has introducido un número menor o igual a 0");
                }
            }catch (InputMismatchException error){
                System.out.println("Has introducido un valor incorrecto: " + error.getMessage());
                value = false;
            }
        }while (value);

        for (int i=1;i<=sequence_n;i++){
            System.out.print(sequence_value);
            next_sequence += sequence_value;
            sequence_value = next_sequence - sequence_value;
        }
    }
}