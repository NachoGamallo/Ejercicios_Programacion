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

        int cont = 0;
        search_word:
        for (int i = 0;i<letter_soup.length;i++){//Definimos con un nombre, este for. Que recorre junto al siguiente
            // la matriz entera. Caracter por caracter.

            for (int j = 0;j<letter_soup[0].length;j++){

                if (letter_soup[i][j].equalsIgnoreCase(word_vector[0])){//Aqui comprobamos si el caracter actual, que estamos recorriendo de la linea es
                    // igual a la primera posicion del vector que contiene la palabra que el usuario
                    // queria buscar. Si no se cumple sigue recorriendo el for anterior caracter por caracter.
                    cont = 0;
                    //Declaramos la variable count en 0, porque es el indice que tendremos para comprobar la posicion de la palabra ingresada por el usuario.
                    for (int row_search = j;row_search<letter_soup[i].length;row_search++){
                        //Hacemos un nuevo for, que va a reccorer la linea a partir de la posicion
                        // en la que lo ha encontrado, es decir si se encuentra en la posicion 1 y
                        // el vector tiene una longitud de 4. Vamos a recorrer a la cantidad exacta
                        // de caracteres que nos faltan por recorrer.
                        if (cont != word_vector.length && letter_soup[i][row_search].equalsIgnoreCase(word_vector[cont])){
                            cont++;//Si las dos condiciones se cumplen, es que el caracter es el mismo. Y sumamos 1 a cont para comprobar el siguiente en la siguiente iteracion
                            // del bucle
                        }else {
                            break;
                        }//Aqui se comprueba que el caracter actual sea igual que el de la cadena del usuario,
                        //si no es igual. No queremos seguir buscando porque no es la misma palabra.
                    }

                    if (cont != word_vector.length){//Si la longitud no es la misma, es que no es la palabra.
                        cont = 0;//Si en la linea no hemos encontrado la palabra, pues habra que comprobar la columna.
                        //Asi que este for hace eso mismo, comprueba la columna igual que la linea anterior (pero estamos apuntando a la columna). Con la
                        // cantidad exacta de caracteres que faltan por recorrer. Y definimos de nuevo cont, para que empiece de nuevo desde la primera posicion a comprobar

                        for (int column_search = j;column_search<letter_soup.length;column_search++){

                            if (cont != word_vector.length && letter_soup[column_search][j].equalsIgnoreCase(word_vector[cont])){
                                //Comprobamos que sea el mismo caracter, sino saldra del bucle porque
                                //no necesitamos seguir buscando, el funcionamiento es igual, solo apuntamos de diferente forma a la matriz
                                cont++;
                            }else {
                                break;
                            }
                        }
                        if (cont == word_vector.length){//Si encuentra la palabra, en la columna. Imprime el mensaje y acaba el programa.

                            System.out.println("ENCONTRADA!! En la Fila: " + i + " , Columna: " + j);
                            break search_word;
                        }

                    }else {//Si en la fila ya has encontrado la palabra, el bucle de columnas se lo salta, da el resultado y acaba el programa.

                        System.out.println("ENCONTRADA!! En la Fila: " + i + " , Columna: " + j);
                        break search_word;
                    }
                }
            }
        }
        if (cont != word_vector.length){//Si despues de recorrer toda la matriz, no ha encontrado la palabra. Imprime mensaje de que has perdido.
            System.out.println("Lo siento... no has encontrado la palabra :(");
        }
    }
}