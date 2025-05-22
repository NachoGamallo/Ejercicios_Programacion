package T4_Bateria1Ejercicios;
import Functions.CommonFunctions;

public class T4B1_Ex3 {

    public static String ConvertToUpperLetters(String chain){
        System.out.println(chain.toUpperCase());
        return chain;
    }

    public static int VocalsCount(String Word){
        int vocals = 0;
        String[] UserWord = Word.split("");
        for (int i=0;i<UserWord.length;i++){
            if (!UserWord[i].equalsIgnoreCase("a") &&
                    !UserWord[i].equalsIgnoreCase("e") &&
                    !UserWord[i].equalsIgnoreCase("i") &&
                    !UserWord[i].equalsIgnoreCase("o") &&
                    !UserWord[i].equalsIgnoreCase("u")) {
                continue;
            }
            vocals++;
        }
        return vocals;
    }

    public static void Ex3_main(){

        String User_word = CommonFunctions.UserChainOrWord();
        User_word = ConvertToUpperLetters(User_word);
        int vocals = VocalsCount(User_word);
        System.out.println("Tiene " + vocals + " vocales");
    }
}