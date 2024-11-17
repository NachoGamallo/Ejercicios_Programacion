package org.example;

import java.util.Arrays;
import java.util.Random;

public class Eliminar_Duplicados {
    Random random = new Random();
    public void form1(){
        int [] original = {4,8,9,1,2,2,1,3,9};
        int [] temp = new int[original.length];
        System.out.println(Arrays.toString(original));
        Arrays.sort(original);

        int tam = 0;
        for (int i = 0;i<original.length;i++){

            if (i!=original.length - 1 && original[i] == original[i + 1]){
                continue;
            }else{
                temp[i] = original[i];
                tam++;
            }
        }
        int pos = 0;
        int[] modified = new int [tam];
        for (int i=0;i<temp.length;i++){
            if(temp[i]!=0){
               modified[pos] = temp[i];
               pos++;
            }
        }
        System.out.println(Arrays.toString(modified));
    }
    public void form2(){
        int[] vector = {4,8,9,1,2,2,1,3};
        int tam=0;
        System.out.println(Arrays.toString(vector));
        Arrays.sort(vector);
        for (int i=0;i< vector.length;i++){

            if (i!=vector.length - 1 && vector[i] == vector[i + 1]){
                vector[i]=0;
            }else{
                tam++;
            }

        }
        int pos = 0;
        int[] vector_wd = new int [tam];
        for (int i=0;i<vector.length;i++){
            if(vector[i]!=0){
                vector_wd[pos] = vector[i];
                pos++;
            }
        }
        System.out.println(Arrays.toString(vector_wd));
    }
    public void form3(){
        int[] sorteo = new int [6];
        for (int i = 0;i< sorteo.length;i++){

            sorteo[i] = random.nextInt(49)+1;

        }
        System.out.println(Arrays.toString(sorteo));
        Arrays.sort(sorteo);

        boolean status = true;
        while(status){
            status = false;
            for (int i=0;i< sorteo.length;i++){

                if (i!=sorteo.length - 1 && sorteo[i] == sorteo[i + 1]){
                    System.out.println("Duplicado: " + sorteo[i]);
                    System.out.println(Arrays.toString(sorteo));
                    sorteo[i]=random.nextInt(49)+1;
                    status = true;
                }
            }
            Arrays.sort(sorteo);
        }
        System.out.println(Arrays.toString(sorteo));
    }
}
