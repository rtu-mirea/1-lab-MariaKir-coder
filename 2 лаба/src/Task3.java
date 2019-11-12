import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    Pattern pattern = Pattern.compile("(\\.\\w+)");
    Pattern pattern2 = Pattern.compile("(\\.ru)");

    public int isDomain(String text)
    {
        String[] smass = text.split(pattern.toString());
        if (smass.length == 0) {
            return 1;
        } else if (smass.length == 1 && smass[0] == "") {
            return 2;
        } else {
            return 0;
        }
    }
    public String ReplaceRu(String text)
    {
        Matcher matcher2 = pattern2.matcher(text);
        return matcher2.replaceAll(".рус");

    }
    public Task3() {

    }
}
