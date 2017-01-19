package Helper;

import java.util.Random;

/**
 * Created by HP on 1/17/2017.
 */
public class Creds {
    private static Random random = new Random();
    private static double value = random.nextInt(100);

    public static final String DESIGNER_EMAIL = "designer.sigrid@gmail.com";
    public static final String MANAGER_EMAIL = "manager.sigrid@gmail.com";
    public static final String ADMIN_EMAIL = "admi.sigrid@gmail.com";
    public static final String DESIGNER_PASSWORD = "123";
    public static final String MANAGER_PASSWORD = "123";
    public static final String ADMIN_PASSWORD = "123";
    public static final String MAIN_URL = "http://localhost:8080/sd/#/login-register";
    public static final String PROJECT_NAME = "CIRCUIT"+value;
    public static final String NUMBER_OF_INPUTS = "1";
    public static final String FILE_PATH = "C:\\Users\\HP\\Desktop\\uploadDocument.exe";


    public Object[][] loginInput (){
        Object[][] loginData = new Object[3][2];
        loginData[0][0] = Creds.ADMIN_EMAIL;
        loginData[0][1] = Creds.ADMIN_PASSWORD;
        loginData[1][0] = Creds.DESIGNER_EMAIL;
        loginData[1][1] = Creds.DESIGNER_PASSWORD;
        loginData[2][0] = Creds.MANAGER_EMAIL;
        loginData[2][1] = Creds.MANAGER_PASSWORD;
        return loginData;
    }

}
