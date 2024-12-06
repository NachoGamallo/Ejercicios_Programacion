package T4_Bateria1Ejercicios;
import Functions.CommonFunctions;

public class T4B1_Ex1 {

    public static int CubeOfANumCalc(int num){
        int calc = 1;
        for (int i = 1;i<=3;i++){

            calc = calc * num;

        }

        return calc;
    }

    public static void Ex1_main(){
        int num = CommonFunctions.UserPositiveNum();
        System.out.println(num);
        System.out.println("El número elebado al cubo es: " + CubeOfANumCalc(num));
    }
}