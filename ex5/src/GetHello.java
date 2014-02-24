import java.util.Locale;
import java.util.ResourceBundle;

public class GetHello {
    private Locale locale;
    GetHello(){
        locale = new Locale("en", "US");
        getResourceBundle();
    }
    GetHello(String language, String country){
        locale = new Locale(language, country);
        getResourceBundle();
    }
    void getResourceBundle (){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages", locale);
        System.out.println(resourceBundle.getString("Hello!"));
    }
}
