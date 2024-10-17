package org.example;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Practica2_T2 {
    public void calculator(){
            Scanner entry = new Scanner(System.in);
            String operationTD = "";
            int f_operator = 0, s_operator = 0, operationRS;

            System.out.println("Buenos días usuario, te damos la bienvenida a esta calculadora simple :)");
            System.out.println("----------");

            try {
                System.out.println("Introduce el primer operando: ");
                f_operator = entry.nextInt();

                System.out.println("Introduce el signo de la operación que quieres realizar: (+,-,x,/,R)");
                operationTD = entry.next();

                if (!operationTD.equals("R")){
                    System.out.println("Dame un segundo operando: ");
                    s_operator = entry.nextInt();
                }
            }catch (InputMismatchException | NumberFormatException error1){
                System.out.println("Has introducido un formato erroneo, " + error1.getMessage());
            }

                switch (operationTD) {

                    case "+":
                        operationRS = (f_operator + s_operator);
                        System.out.println("El resultado de la suma es " + operationRS);
                        break;

                    case "-":
                        operationRS = (f_operator - s_operator);
                        System.out.println("El resultado de la resta es " + operationRS);
                        break;

                    case "x":
                        operationRS = (f_operator * s_operator);
                        System.out.println("El resultado de la multiplicación es " + operationRS);
                        break;

                    case "/":
                        if (s_operator == 0)
                            System.out.println("No se puede dividir entre 0");
                        else {
                            operationRS = (f_operator / s_operator);
                            System.out.println("El resultado de la división es " + operationRS);
                        }
                        break;

                    case "R":
                        if (f_operator <= 0){
                            System.out.println("Número erroneo");
                        }else{
                            System.out.println("La raíz cuadrada del número que has introducido es " + Math.sqrt(f_operator));
                            break;
                        }

                    default:
                        System.out.println("No has introducido el formato correcto al elegir operación a realizar.");
                }
            }
    }