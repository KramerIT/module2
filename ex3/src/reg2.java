import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class reg2 {
    public static void main(String[] args){
        String s = "<p class=\"p1\"> Текст один </p>" + "\n"+
                "<p class=\"p1\"> Текст два </p>" + "\n"+
                "<p id=\"p1\"> Текст три </p>" + "\n"+
                "<p>Текст четыре </p>" +  "\n"+
                "<p id=\"beginParagraph\"> test 1 </p> " +
                "and <p id=\"endParagraph\"> test 2 </p>";
        Pattern p = Pattern.compile("<p ?\\S*>");
        Matcher m = p.matcher(s);
        System.out.println(s + "\n");
        while (m.find()){
            System.out.println(m.group());
        }
        System.out.println();
        s = m.replaceAll("<p>") + "\n";
        System.out.println(s);
    }
}

