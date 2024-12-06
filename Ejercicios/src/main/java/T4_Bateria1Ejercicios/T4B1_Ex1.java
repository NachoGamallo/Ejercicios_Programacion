package T4_Bateria1Ejercicios;
import java.util.InputMismatchException;
import java.util.Scanner;

public class T4B1_Ex1 {
    public static Scanner entry = new Scanner(System.in);

    public static int user_num(){
        System.out.println("Introduce un número positivo: ");
        int num = 0;
        try {
            num = entry.nextInt();
        }catch (InputMismatchException error){
            System.out.println("No has ingresado un tipo de dato correcto ");
            System.exit(1);
        }
        return num;
    }

    public static int cube_calc(int num){

        int calc = 1;
        for (int i = 1;i<=3;i++){

            calc = calc * num;

        }
        return calc;
    }

    public static void Ex1_main(){
        int num = user_num();
        System.out.println(num);
        System.out.println("El número elebado al cubo es: " + cube_calc(num));
    }
}
