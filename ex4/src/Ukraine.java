import java.text.NumberFormat;
import java.util.Locale;

public class Ukraine {
    public static void main(String[] args){
        Locale locale = new Locale("uk", "UA");
        NumberFormat ua = NumberFormat.getCurrencyInstance(locale);
        System.out.println(ua.format(153.5));
    }
}
