package Functions;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonFunctions {
    public static Scanner entry = new Scanner(System.in);

    public static int UserPositiveNum(){
        System.out.println("Introduce un número positivo: ");
        int num = 0;
        try {
            num = entry.nextInt();
        }catch (InputMismatchException error){
            System.out.println("No has ingresado un tipo de dato correcto ");
            System.exit(1);
        }
        if (num == 0){
            System.out.println("Has introducido un 0, no permitido...");
            System.exit(2);
        }
        return num;
    }

    public static void SearchInARange(int search, int range){
        if (search > range || search <= 0){
            System.out.println("Opcion fuera del rango...");
            System.exit(10);
        } else if (search == range) {
            System.out.println("Ultima opcion, saliendo del programa...");
            System.exit(0);
        }else {
            System.out.println("opcion " + search + " seleccionada...");
        }
    }

    public static void OptionsFor1ToNum(int N_options){
        for (int i = 1; i <= N_options; i++){
            if ( i == N_options){
                System.out.println("Opcion de salida. (" + i + ")");
            }else {
                System.out.println("Opcion: " + i + ".");
            }
        }
    }

    public static int SelectAndOption(){
        System.out.println("Introduce una opcion: ");
        int num = 0;
        try {
            num = entry.nextInt();
        }catch (InputMismatchException error){
            System.out.println("Has introducido un parametro no permitido...");
            System.exit(2);
        }
        return num;
    }

    public static String UserChainOrWord(){

        System.out.println("Quieres guardar una cadena entera(1) o una palabra(2)?");
        int option = SelectAndOption();
        System.out.println("\n");

        switch (option){
            case 1:
                System.out.println("Introduce una cadena:");
                if (entry.hasNextLine()){
                    entry.nextLine();
                }

                return entry.nextLine();

            case 2:
                System.out.println("Introduce una palabra:");
                return entry.next();

            default:
                System.out.println("Caso no contemplado...");
                System.exit(10);
        }
        return "";
    }
}