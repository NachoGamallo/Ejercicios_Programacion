package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class T2Exercices {
    public void T2ex1(){

        Scanner entry = new Scanner(System.in);

        System.out.println("Introduce una cadena de carácteres: ");
        String character_chain = entry.nextLine();
        //0
        System.out.println(character_chain);
        //1
        System.out.println(character_chain.length());
        //2
        System.out.println(character_chain.replace(" ",""));
        //3
        int value = (character_chain.length() / 2);
        System.out.println(" Primera mitad del texto  " + character_chain.substring(0,value) + " Y la segunda mitad es " + character_chain.substring(value));
        //4
        System.out.println(character_chain.toUpperCase());

    }
    public void T2ex2(){
        Scanner entry = new Scanner(System.in);

        System.out.println("Dame una palabra: ");
        String word_1 = entry.nextLine();

        System.out.println("Dame otra palabra: ");
        String word_2 = entry.nextLine();

        if (word_1.length() != word_2.length()){
            if ( word_1.length() > word_2.length()){
                System.out.println("La primera cadena es más larga.");
            }else{
                System.out.println("La segunda cadena es más larga.");
            }
        }else{
            System.out.println("Las dos cadenas son del mismo tamaño.");
        }
    }
    public void T2ex3(){
        Scanner entry = new Scanner(System.in);
        String full_num = "";
        int exiled_num = 0;
        try {
            System.out.println("Dame una varíable númerica (N).");
            full_num = entry.nextLine();

            System.out.println("Dame la cantidad de números que excluir (M).");
            exiled_num = entry.nextInt();

        }catch (NumberFormatException | InputMismatchException error){
            System.out.println("Error, el valor debe ser el adecuado.");
            entry.nextLine();
        }
        catch (StringIndexOutOfBoundsException error_2){
            System.out.println("El numero que exilias no puede ser mayor que el numero total.");
        }

        System.out.println("El nuevo valor de N será: " + full_num.substring(0,full_num.length() - exiled_num));
    }
    public void T2ex4(){
        Scanner entry = new Scanner(System.in);
        System.out.println("Dime la frase/oracion que quieres ingresar:");
        String text = entry.nextLine();
        System.out.println("Palabra que quieres contar:");
        String word = entry.nextLine();
        String new_text = text.replace(word,"");
        int number = text.length() - new_text.length();
        int appear = number / word.length();
        System.out.println("Aparece " + appear + " veces en el texto");
        System.out.println(new_text);
    }
    public void T2ex5(){
        Scanner entry = new Scanner(System.in);
        String player1_chain, player2_word, player1_words;
        System.out.println("Jugador 1, ingresa una cadena: ");
        player1_chain = entry.nextLine();
        System.out.println("-------------------");

        for(int i=10;i>=1;i--){

            System.out.println("Intento Numero " + i);
            System.out.println("Jugador 2, ingresa una palabra: ");
            player2_word = entry.nextLine();

            for (int a=0;a<=player1_chain.length();a++){
                player1_words = player1_chain.replace(" ","");
                int length_chain = (player1_words.length());

                if ((length_chain - a) >= player2_word.length()){

                    player1_words = player1_words.substring(a,player2_word.length());
                    if (player1_words.equalsIgnoreCase(player2_word)){

                        System.out.println("Enhorabuena, has acertado una palabra");
                        i = 1;
                        break;
                    }
                }
            }
        }
    }
}
