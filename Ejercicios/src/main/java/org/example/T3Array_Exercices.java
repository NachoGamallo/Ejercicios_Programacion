package org.example;
import java.util.Random;

public class T3Array_Exercices {
    public void Arrayex1(){
        Random random = new Random();
        int vector[] = new int [8],suma=0;
        for (int i = 0;i<vector.length;i++){
            vector[i] = random.nextInt(501);
            suma += vector[i];
        }
        System.out.println("La suma de los elementos es: " + suma);
    }
    public void Arrayex2(){}
    public void Arrayex3(){}
    public void Arrayex4(){}
    public void Arrayex5(){}
    public void Arrayex6(){}
    public void Arrayex7(){}
    public void Arrayex8(){}
    public void Arrayex9(){}
    public void Arrayex10(){}
}
