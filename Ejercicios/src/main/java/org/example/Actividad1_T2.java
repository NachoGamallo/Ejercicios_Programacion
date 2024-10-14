package org.example;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Actividad1_T2 {
    public void A1T2(){
        Scanner entry = new Scanner(System.in);
        LocalDateTime today = LocalDateTime.now();
        int actual_year = today.getYear();

        System.out.println("Elije un modo del programa (modo: 1 , Año/ modo: 2 , Edad): ");
        String elecction = entry.next();
        int born_year = 0;
        int age = 0;

        boolean error = false;
        if (elecction.equals("1")){

            try {
                String C_born_year = entry.next();
                born_year = Integer.parseInt(C_born_year);
            }catch (NumberFormatException e){
                System.out.println("No es un numero. ");
            }

            if (born_year<1900 || born_year>actual_year){
                System.out.println("El año introducido no es correcto");
                error = true;
            }

        } else if (elecction.equals("2")) {

            if (entry.hasNextInt()){
                age = entry.nextInt();
            }else{
                System.out.println("No es correcto");
                error = true;
            }

            if (age<0){
                System.out.println("La edad introducida no es valida");
                error = true;
            }else {
                born_year = actual_year - age;
            }

        }else{
            System.out.println("No has elejido un modo valido. ");
            error = true;
        }
        if (!error){

            if (born_year>=1900 && born_year<=1927){
                System.out.println("Sin Generación bautizada");
            } else if (born_year>=1928 && born_year<=1944) {
                System.out.println("Generación Silent");
            } else if (born_year>=1945 && born_year<=1964) {
                System.out.println("Baby Boomers");
            } else if (born_year>=1965 && born_year<=1981) {
                System.out.println("Generación X");
            } else if (born_year>=1982 && born_year<=1994) {
                System.out.println("Generación Y o Millennials");
            } else if (born_year>=1995 && born_year<=actual_year) {
                System.out.println("Generación Z o Centennials");
            }else {
                System.out.println("No eres de ninguna generacion");
            }

        }
    }
}
