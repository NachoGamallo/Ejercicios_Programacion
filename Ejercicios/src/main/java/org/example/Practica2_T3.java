package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Practica2_T3 {
    public void laprimitivaP2T3(){
        Scanner entry = new Scanner(System.in);
        Random random = new Random();

       String[] user_chain; //Aquí definimos los 3 vectores que usaremos de forma fija y definimos variables para mas adelante.
       int [] random_chain = new int[7];
       int [] user_convert_toInt = new int[7];
       int [] temp_array = new int[6];
       String user_input;
       int complementary;
       boolean status;

        do {

            System.out.println("Introduce la cadena ");
            user_input = entry.next();//Aqui el usuario ingresa los numeros que quiere con formato.
            //x-x-x-x-x-x/x.
            status = user_input.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}-\\d{1,2}/\\d");//si no tiene el formato indicado,
            //nos devolvera un false en status por lo cual el bucle se volvera a ejecutar, si ingresa bien el formato devuelve true.
            user_chain = user_input.split("[-/]");//Convierte la cadena del usuario en un array, separando por - y /.

            if (status){//Si no ha saltado false el formato entra al bucle para convertir el array String en un array Int.

                try {
                    for (int i = 0;i<user_chain.length;i++){
                        user_convert_toInt[i] = Integer.parseInt(user_chain[i]);//Aqui convertira de texto a numero.
                        if (user_convert_toInt[i] < 0 || user_convert_toInt[i] > 49){
                            status=false;
                        }//Si el numero es menor a 0 o mayor a 49, status false.
                    }
                }catch (InputMismatchException error){//Si falla al intentar convertir a numero saltara el catch y dara status false.
                    status = false;
                }

            }
            int[] temp = Arrays.stream(user_convert_toInt).distinct().toArray();//Convierte el array int en un array int sin duplicados.
            if (status && temp.length != user_convert_toInt.length){//Si no tienen la misma longitud es que hay duplicados, y pasa a status false.
                status = false;
            }
            if (!status){//Si status false, imprimir mensaje de error
                System.out.println("Has introducido un formato no permitido...");
            }
        }while (!status);//Mientras el status sea false, nunca saldra del bucle while.

        do {

            status = true;//declara status true al principio del bucle por si da mas de 1 vuelta.
            for (int i=0;i<random_chain.length;i++){//Vamos a declarar los valores del array random de la loteria.
                if (i!=random_chain.length -1){
                    random_chain[i] = random.nextInt(49)+1;//Si es de los 6 primeros dijitos genera un numero del 1 al 49
                }else {
                    random_chain[i] = random.nextInt(10);//Si es el numero reintegro, sera del 0 al 9
                }
            }

            int[] random_temp = Arrays.stream(random_chain).distinct().toArray();//Ahora creamos un array limpio de duplicados.
            if (random_temp.length != random_chain.length){
                status = false;//Si son de diferentes longitud significa que habia algun duplicado, asi que declaramos false, para que vuelva a generar numeros.
            }
            complementary = random.nextInt(49)+1;//Declaramos el complementario, que tampoco puede ser como ninguno de los numeros de la posicion 0
            //a la posicion 5 (6 primeros numeros).
            for (int i = 0;i<random_chain.length -2;i++){//recorremos el array random.
                temp_array[i] = random_chain[i];//declaramos un array temporal que tendra los 6 primeros numeros para usarlos mas adelante.
                if (random_chain[i] == complementary) {status = false;break;}//si el complementario coincide con alguno de los numeros originales del array,
                //saltara el status false, y parara el bucle
            }

        }while (!status);//Mientras no sea true, seguira ejecutando el bucle.

        System.out.println(Arrays.toString(user_convert_toInt));//Imprimimos los numeros del usuario.
        System.out.println("SORTEO: ");
        System.out.println(Arrays.toString(temp_array));//Imprimimos los numeros random menos el reintregro.
        System.out.println("Complementario: " + complementary);//Imprimimos el complementario.
        System.out.println("Reintegro: " + random_chain[random_chain.length-1]);//Imprimimos el reintegro.
        
        int points = 0, reintegro = 0, special_point=0;//declaramos las variables que usaremos para marcar los puntos que ha conseguido el usuario.
        for (int i = 0; i<user_convert_toInt.length; i++){
            if (i == user_convert_toInt.length-1 && user_convert_toInt[i] == random_chain[i]){//Si el bucle esta en la ultima posicion (reintegro) y coinciden,
                //el usuario tiene el punto del reintegro y se saltara la siguiente comprobacion.
                reintegro++;
                continue;
            }
            if (user_convert_toInt[i]==random_chain[i]){//Si el array del usuario coincide con el array generado, tiene 1 punto de los numeros originales.
                points++;
            } else if (user_convert_toInt[i] == complementary) {//Si la posicion actual coincide con el numero complementario, tiene el punto de este.
                special_point++;
            }
        }
        System.out.println(" ");
        System.out.println("Resultados: ");//Aqui declaramos los resultados segun los puntos del usuario.
        if (points == 6 && reintegro == 1){
            System.out.println("Categoría Especial.");
        } else if (points == 6) {
            System.out.println("1ª Categoría.");
        } else if (points == 5 && special_point == 1) {
            System.out.println("2ª Categoría.");
        } else if (points == 4 && special_point == 1) {
            System.out.println("3ª Categoría.");
        } else if (points == 3 && special_point == 1) {
            System.out.println("4ª Categoría.");
        } else if (points == 2 && special_point == 1) {
            System.out.println("5ª Categoría.");
        } else if (points == 1 && special_point == 1){
            System.out.println("2 Aciertos.");
        }else if (points == 0 && special_point == 1 || points == 1 && special_point == 0){
            System.out.println("1 Aciertos.");
        }

        if (reintegro == 1){
            System.out.println("Reintegro.");
        }

        if (reintegro == 0 && (points + special_point) == 0) {
            System.out.println("No premiado.");
        }
    }
}
