import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    String domain_only = ".ru";
    String domain_only2 = "";
    String text = "gmail.ru/b/memento моя мама недавно зар.егеСтРировала Меня в odnoklassniki.ru, но я всегда хотела завести аккаунт в vk.ru ghjh? .ru";

    public Task2() {

        String pattern = "(\\.\\w+)";

        // Создание Pattern объекта
        Pattern r = Pattern.compile(pattern);

        // Создание matcher объекта
        Matcher m = r.matcher(text);
        String[] smass = text.split(pattern);
        if (smass.length == 0) {
            System.out.println("Введено только имя 2-го порядка.");
        } else if (smass.length == 1 && smass[0] == "") {
            System.out.println("Введена путая строка.");
        } else {
            System.out.println("Введено не только имя 2-го порядка.");
            System.out.println("Изначальный текст: " + text);
            System.out.print("Замена домена 2-го порядка .ru на .рус:");
            while (m.find()) {
                if (m.group().compareTo(".ru") == 0) {
                    StringBuilder sb = new StringBuilder(text);
                    sb.replace(m.start(), m.start() + 3, ".рус");
                    text = sb.toString();
                    m = r.matcher(text);
                } else
                    System.out.println(m.group());
            }
            System.out.println("\n" + text);
        }

    }
}
