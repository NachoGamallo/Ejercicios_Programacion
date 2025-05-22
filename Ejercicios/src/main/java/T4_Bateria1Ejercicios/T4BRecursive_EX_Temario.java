package T4_Bateria1Ejercicios;

public class T4BRecursive_EX_Temario {

    static int max;

    public static void main (String[] args){

        int temp = 0;
        int temp2 = 0;
        PrintMaxNum(temp);
        int num = SumOfNumbers(temp2);
        System.out.println(num);
    }

    public static void PrintMaxNum(int num){
        if (num < max){
            System.out.println(++num);
            PrintMaxNum(num);
        }
    }

    public static int SumOfNumbers (int num){
        if (max < 10){
            max++;
            num += SumOfNumbers(max);
        }
        return num;
    }
}
