import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg {
    public static void main(String[] args){
        Pattern p = Pattern.compile("0[xX][a-fA-F0-9][^ ]*");
        Matcher m = p.matcher(" abc 123 Abc ADF FFF 0x123f 0x123FF  0xa 0xddb 0xabc 0xabcd  0Xabc 0XABC 0X ABC");
        while (m.find()){
            String s = m.group();
            int i = Integer.decode(s);
            System.out.println(s + " - " + i);
        }
    }
}

