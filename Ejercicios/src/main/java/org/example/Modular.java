package org.example;

import java.util.Random;
import java.util.Scanner;

public class Modular {

    public static void heads_or_tails() {

        options();
        String user_option = user_option();
        String lottery = random();
        find_out_result(user_option, lottery);

    }

    public static void options() {

        System.out.println("BIENVENIDO");
        System.out.println("Elije tu opcion:");
        System.out.println("C: Cara");
        System.out.println("X: Cruz");

    }

    public static String user_option() {

        Scanner entry = new Scanner(System.in);
        return entry.next();
    }

    public static String random() {

        Random random = new Random();
        String[] options = {"cara", "cruz"};
        return options[random.nextInt(options.length)];
    }

    public static void find_out_result(String user_option, String random) {

        if (user_option.equalsIgnoreCase(random)) {
            System.out.println("Has ganado!! ha salido: " + random);
        } else {
            System.out.println("Has perdido!! ha salido: " + random);
        }

    }

    //------------------------------------------------------------------------------
}
