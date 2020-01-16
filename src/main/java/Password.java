import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Password {
    static Pattern  pt = Pattern.compile("[0-9]+");
    static Pattern let = Pattern.compile(".*[A-Z].*");
    static Pattern spec = Pattern.compile("[!@#$%^&()_~.?/,*;+=-]");
    static Pattern low = Pattern.compile(".*[a-z].*");

    private static final Logger logger = LogManager.getLogger(Password.class.getName());

    public static boolean passwordIsValid(String pass)  {

        Matcher mac = pt.matcher(pass);
        Matcher letters = let.matcher(pass);
        Matcher lowc = low.matcher(pass);
        Matcher special = spec.matcher(pass);

        try {
            for (int i = 0; i < pass.length(); i += 1) {

                if (pass.length() != 0) {
                    if (pass.length() >= 8) {
                        if (mac.find()) {
                            logger.info("It has numbers");
                        } else {
                            logger.error("password should at least have one digit");
                        }
                        if (letters.find()) {
                            logger.info("It has Uppercases");
                        } else {
                            throw new Exception("password should have at least one uppercase letter");
                        }
                        if (lowc.find()) {
                            logger.info("It has lowercases");
                        } else {
                            logger.error("password should have at least one lowercase letter");
                        }
                        if (special.find()) {
                            logger.info("It has special characters");
                        } else {
                            logger.error("password should have at least one special character");
                        }
                    } else {
                        logger.error("password should be longer than than 8 characters");
                    }
                }
                else {
                    logger.error("password should exist");
                }
                break;
            }
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }

        return false;
    }

    public static boolean passwordIsOk(String password) {

        Matcher mac = pt.matcher(password);
        Matcher letters = let.matcher(password);
        Matcher special = spec.matcher(password);
        Matcher lowc = low.matcher(password);
        try {
            for (int i = 0; i < password.length(); i += 1) {
            if (password.length() != 0)
                if (password.length() > 7) {
                    if ((mac.find() && letters.find()) || (mac.find() && special.find()) ||
                            (letters.find() && special.find()) || (lowc.find() && letters.find()) ||
                            (lowc.find() && special.find()) || (mac.find() && lowc.find())){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                   logger.error("Password should meet 2 requirements");
                }
                else {
                    logger.error("Password cannot be Empty");
            }
            }
        }
        catch (Exception w){
            logger.error(w.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the password : ");
        String in = scan.nextLine();
        if (passwordIsValid(in)){
            logger.info("Password : "+ in+ " : is Valid");
        }
        else {
            logger.info("Password : " + in + " : is InValid");
        }
        System.out.println("---------------------");
        if (passwordIsOk(in)){
            logger.info("Password : "+ in + " : is OK");
        }
        else {
            logger.info("Password : "+ in+ " : is not OK ");
        }
    }
}
