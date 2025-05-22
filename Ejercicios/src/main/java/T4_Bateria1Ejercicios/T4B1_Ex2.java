package T4_Bateria1Ejercicios;
import Functions.CommonFunctions;

public class T4B1_Ex2 {

    public static void Ex2_main(){
        int N_options = CommonFunctions.UserPositiveNum();
        CommonFunctions.OptionsFor1ToNum(N_options);
        int user_option= CommonFunctions.SelectAndOption();
        CommonFunctions.SearchInARange(user_option,N_options);
    }
}
