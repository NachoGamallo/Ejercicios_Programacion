package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sopa_De_Letras {
    public void P3T3(){
        Scanner entry = new Scanner(System.in);//Aquí definimos el scanner y las
        // variables que usaremos en el do/while de mas adelante
        boolean status;
        int column = 0, row = 0;

        do{//El bucle pedira al usuario que ingrese el N de columnas y rows para la sopa de letras,
            // si ingresa algo no esperado (Letras, numero 0 o menor), repetirá el bucle.
            try {
                status = true;
                System.out.println("Introduce el número de filas: ");
                row = entry.nextInt();//Pide el N de columnas y rows de la sopa de letras.

                System.out.println("Introduce el número de columnas: ");
                column = entry.nextInt();

            }catch (InputMismatchException error){//Si ingresa letras, el catch cambiará
                // el status y empezará el bucle de nuevo.
                System.out.println("Has introducido un parametro no permitido...");
                entry.next();
                status = false;
                continue;
            }

            if (row <= 0 || column <= 0){//Si los números ingresados son 0 o
                // inferiores, vuelve a pedir los números.
                System.out.println("Has introducido un 0 en las filas/columnas, no permitido...");
                status = false;
            }

        }while (!status);

        String[][] letter_soup = new String [row][column];//Definimos la matriz que se usara para la sopa
        // de letras, y un vector/variable que usaremos para rellenar esta misma.
        String[] row_chain;
        String usr_chain;

        for (int i = 0;i<row;i++){//Con este bucle y el siguiente lo que vamos a hacer es
            // recorrer la matriz que hemos definido con los valores ingresados por el usuario.

            System.out.println("Introduce las letras de la fila " + i);//Pedimos que ingrese
            // la linea a ingresar en la sopa de letras.
            usr_chain = entry.next();
            row_chain = usr_chain.split(""); //Convertimos los datos que nos a ingresado
            // el usuario en un vector, no tiene separador definido por lo que los caracteres deben ir
            // juntos Ej: asdf

            if (row_chain.length != column || !usr_chain.matches("[a-zA-Z]{"+ column +"}")){//Con esta
                // condicion verificamos que se ha ingresadado la linea de forma correcta (Que solo contenga
                // letras y que sea de la longitud definida previamente).
                System.out.println("No has introducido una longitud/paremetros correctos...");
                return;//Si se ingresa mal el sistema muestra un mensaje y sale de la clase.
            }else {

                for (int j = 0;j<column;j++){//Si se ha ingresado bien, lo que hace el for es reccorrer cada
                    //caracter de la matriz (de la linea actual). Y la define con la linea ingresada por
                    // el usuario posicion por posicion (Tambien se puede usar arraycopy , pero asi lo veo
                    // mas claro)

                    letter_soup[i][j] = row_chain[j];

                }
            }
        }
        System.out.println("\n");
        for(String[] i: letter_soup){//Con este bucle lo que hacemos es reccorer la matriz entera, y
            // mostrarla por pantalla para que la vea el usuario
            for(String j: i){
                System.out.print(j);
            }
            System.out.println();
        }

        String usr_word;//Esta parte ya es la parte del jugador como tal, vamos a definir las
        // variables/vector que usaremos y haremos lo mismo que previamente, el usuario
        // ingresa una cadena y nos guardamos el valor y despues la convertimos en un vector individual.
        String[] word_vector;
        System.out.println("Introduce la palabra a buscar: ");
        usr_word = entry.next();
        word_vector = usr_word.split("");

        if (!usr_word.matches("[a-zA-Z]{"+ column +"}") //Comprueba que sean letras
                && word_vector.length > column //Comprueba que no sea mas ancho que la sopa de letras
                && word_vector.length > row){//Comprueba que no sea mas largo que la sopa de letras.
            System.out.println("Has introducido mal el formato...");
            return;//Si todas las anteriores comprobaciones se cumplen, se imprime un mesaje y
            // saca de la clase
        }

        search_word://Definimos con un nombre, este for. Que recorre junto al siguiente
        // la matriz entera. Caracter por caracter.
        for (int i = 0;i<letter_soup.length;i++){

            for (int j = 0;j<letter_soup[0].length;j++){//Recorre cada línea de la matriz.

                //Aqui comprobamos si el caracter actual, que estamos recorriendo de la linea es
                // igual a la primera posicion del vector que contiene la palabra que el usuario
                // queria buscar. Si no se cumple sigue recorriendo el for anterior sigue recorriendo
                // caracter por caracter.
                if (letter_soup[i][j].equalsIgnoreCase(word_vector[0])){
                    status = false;//Declaramos el status en false, porque ahora vamos a comprobar
                    // la linea y la columna a partir de la posicion en la que se ha encontrado la letra.
                    for (int row_search = 0;row_search<letter_soup[0].length - j;row_search++){
                        //Hacemos un nuevo for, que va a reccorer la linea a partir de la posicion
                        // en la que lo ha encontrado, es decir si se encuentra en la posicion 1 y
                        // el vector tiene una longitud de 4. Vamos a recorrer a la cantidad exacta
                        // de caracteres que nos faltan por recorrer.

                        if (!letter_soup[i][row_search].equalsIgnoreCase(word_vector[row_search])){
                            //Aqui se comprueba que el siguiente caracter sea igual que el de la cadena del usuario,
                            //si no es igual. No queremos seguir buscando porque no es la misma palabra.
                            status = false;
                            break;
                        }else {
                            status = true;
                        }//Si es el mismo ponemos status true, porque ha encontrado la misma. Este true, es para
                        //verificar que cada caracter es el correcto hasta el final.
                    }
                    if (!status){//Si en la linea no hemos encontrado la palabra, pues habra que comprobar la columna.
                        //Asi que este for hace eso mismo, comprueba la columna igual que la linea anterior. Con la
                        // cantidad exacta de caracteres que faltan por recorrer.
                        for (int column_search = 0;column_search<letter_soup.length - i;column_search++){
                            if (!letter_soup[column_search][j].equalsIgnoreCase(word_vector[column_search])){
                                status = false;
                                break;//Comprobamos que sea el mismo caracter, sino saldra del bucle porque
                                //no necesitamos seguir buscando
                            }else {
                                status = true;
                            }//Si es true hasta el final, hemos encontrado la palabra.
                        }
                    }
                }
                if (status){//Y aquí esta el motivo del status en esto, si ha encontrado la palabra,
                    // ya sea en la línea o en la columna. Nos indicara la posicion de la
                    // primera letra y acabara el juego. Si no la ha encontrado, no pasa nada. Seguira
                    // recorriendo la matriz hasta que encuentre la palabra, si esta claro.
                    System.out.println("ENCONTRADA!! En la posicion: " + j + " , " + i);
                    break search_word;//Cuando la encuntra acaba el programa.
                }
            }
        }
        if (!status){//Si se ha reccorido toda la matriz, y no se encontro nada. Has perdido.
            System.out.println("Lo siento... no has encontrado la palabra :(");
        }
    }
}