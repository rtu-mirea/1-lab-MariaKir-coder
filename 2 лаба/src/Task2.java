import java.util.*;
import java.lang.*;

    public class Task2 {
        String[] array;
        List<String> array16 = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();

        public Task2(String[] array) {
            this.array = array;
        }

        public String swap(String n) {
            StringBuilder sb = new StringBuilder(n);
            int last_index = sb.lastIndexOf(n);
            char last_ch = sb.charAt(last_index);
            sb.setCharAt(last_index,sb.charAt(0));
            sb.setCharAt(0, last_ch);
            String f = sb.toString();
            return f;
        }

        public void ConvertToArray16() {
            for (int i = 0; i < array.length; i++) {
                String converted = Integer.toHexString(Integer.parseInt(array[i])).toUpperCase();
                if (containChar(converted)) {
                    array16.add(converted);
                }
            }
        }

        public boolean containChar(String word) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!Character.isDigit(ch)) {
                    return true;
                }
            }
            return false;
        }


    }





