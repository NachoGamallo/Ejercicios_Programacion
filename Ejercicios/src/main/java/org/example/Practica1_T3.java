package org.example;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Practica1_T3 {
    public void practica1T3(){
        Scanner entry = new Scanner(System.in);
        Random random = new Random();

        String team1_chain,team2_chain;//Cadena ingresada por los 2 usuarios.
        int total = 0,winner; //Total de cada equipo y la variable winner es el ganador de cada batalla.
        int[] deaths = {0,0};//Vector de los resultados de cada uno de los equipos.
        boolean status;//Estado de las pruebas realizadas en el ingreso de la cadena del usuario.
        String[] team1 = new String[0]; //Definimos los vectores que usaremos (Equipos).
        String[] team2 = new String[0];
            System.out.println("--- Equipo 1 ---");
            do {//Bucle para pedir al equipo 1 los numeros de los samurais.
                try {
                    System.out.println("Introduce potencia a los samurais (Son 7 samurais): ");
                    team1_chain = entry.nextLine();
                    team1 = team1_chain.split(" ");//Convertimos la cadena que nos a dado el usuario en un vector, separa por los espacios.
                    if (team1.length == 7){//Si es mas largo de 7 o menos.
                        total = 0;
                        for (String i : team1) {
                            total += Integer.parseInt(i);//Se suman los numeros si se puede.
                        }
                        status = true;
                    }else{
                        System.out.println("Has introducido numeros de mas o de menos");//Si introduces mas o menos numeros.
                        status = false;
                    }
                }catch (InputMismatchException | NumberFormatException error){ //Si se ingresa letras o formatos no aptos.
                    System.out.println("ERROR, ha habido un problema al asignar el equipo: " +error.getMessage());
                    status = false;
                }
                if (status){ //Si no ha fallado nada aun se comprueba si la suma de los numeros es 30 sino salta en error.
                    if (total != 30){
                        System.out.println("ERROR. La potencia total no suma 30");
                        status = false;
                    }
                }
            }while (!status);//Mientras salte algun error seguira pidiendole al usuario que ingrese numeros.

            System.out.println("Equipo completado.");
            System.out.println("--- Equipo 2 ---");
        do {//El mismo proceso que en equipo 1, pero en el 2.
            try {
                System.out.println("Introduce potencia a los samurais (Son 7 samurais): ");
                team2_chain = entry.nextLine();
                team2 =  team2_chain.split(" ");
                if (team2.length == 7){
                    total = 0;
                    for (String i : team2) {
                        total += Integer.parseInt(i);
                    }
                    status = true;
                }else{
                    System.out.println("Has introducido numeros de mas o de menos");
                    status = false;
                }
            }catch (InputMismatchException | NumberFormatException error){
                System.out.println("ERROR, ha habido un problema al asignar el equipo: " +error.getMessage());
                status = false;
            }
            if (status){
                if (total != 30){
                    System.out.println("ERROR. La potencia total no suma 30");
                    status = false;
                }
            }
        }while (!status);

        System.out.println("Equipo completado.");
        System.out.println("¡Empieza la batalla!");
        int random_start = random.nextInt(7), t1samurai, t2samurai;//Aqui se genera un numero aleatorio que usaremos para saber por donde empieza el bucle.
        System.out.println("La batalla inicia con el Samurai " + (random_start+1) +".");

        for (int i = random_start;i<team1.length;i++){//Bucle desde el numero random hasta el ultimo samurai.
            t1samurai = Integer.parseInt(team1[i]);//Combertimos los dos numeros del array actual a numero.
            t2samurai = Integer.parseInt(team2[i]);

            if (t1samurai > t2samurai){//Aqui comprobamos cual es mayor de los dos y se resta al que respecte, si hay empate se mueren los 2.
                winner = 1;
                deaths[1]++;
            } else if (t2samurai > t1samurai) {
                winner = 2;
                deaths[0]++;
            }else {
                winner = 0;
                deaths[0]++;
                deaths[1]++;
            }

            System.out.println("Samurai " + (i+1) + ". Gana Equipo " + winner + ". " + team2[i] + " vs " + team1[i]);//Se imprime la linea actual y el resultado.

            if (deaths[0] == 4 || deaths[1] == 4){//Si alguno de los dos equipos tiene 4 muertos acaba el bucle
                break;
            }
        }
        if (deaths[0] != 4 || deaths[1] != 4){//Si ha acabado el bucle y aun no hay ganador, empieza por el samurai 1. El interior del bucle es el mismo que el anterior
            for (int i = 0;i<team1.length;i++){
                t1samurai = Integer.parseInt(team1[i]);
                t2samurai = Integer.parseInt(team2[i]);

                if (t1samurai > t2samurai){
                    winner = 1;
                    deaths[1]++;
                } else if (t2samurai > t1samurai) {
                    winner = 2;
                    deaths[0]++;
                }else {
                    winner = 0;
                    deaths[0]++;
                    deaths[1]++;
                }

                System.out.println("Samurai " + (i+1) + ". Gana Equipo " + winner + ". " + team2[i] + " vs " + team1[i]);
                if (deaths[0] == 4 || deaths[1] == 4){
                    break;
                }
            }
        }
        if (deaths[0] == 4){//El equipo con 4 muertes pierde
            System.out.println("Equipo 2 GANA! Equipo 1 ha tenido " + deaths[0] + " bajas.");
        }else {
            System.out.println("Equipo 1 GANA! Equipo 2 ha tenido " + deaths[1] + " bajas.");
        }
    }
}