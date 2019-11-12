import java.util.*;
import java.lang.*;

public class Task1
{
    String[] array;
    List<String> array16 = new ArrayList<>();
    List<Integer> indexList = new ArrayList<>();
    public Task1(String[] array)
    {
        this.array=array;
    }
    public void indexListFilling()
    {
        for(int i=0;i<array.length;i++)
        {
            if(i==(Integer.parseInt(array[i]))%10){
                indexList.add(i);
            }
        }
    }


    public String swap(String n)
    {

        char [] arrayChar= n.toCharArray();
        char last_ch= arrayChar[arrayChar.length-1];
        arrayChar[arrayChar.length-1] = arrayChar[0];
        arrayChar[0] = last_ch;
        String f ="";
        for(int i=0;i<arrayChar.length;i++)
        {
            f+=arrayChar[i];
        }
        return f;
    }

    public void ConvertToArray16()
    {
        for (int i = 0; i < array.length; i++)
        {
            String converted = Integer.toHexString(Integer.parseInt(array[i])).toUpperCase();
            if (containChar(converted))
            {
                array16.add(converted);
            }
        }
    }

    public int GetMaxCapacity()
    {
        int c_max = 0;
        for(int i=0;i<array.length;i++) {
            int c = 0;
            int n= Integer.parseInt(array[i]);
            while (n > 0) {
                c++;
                n /= 10;
            }
            if(c>c_max) c_max=c;
        }
        return c_max;
    }
    public boolean containChar(String word)
    {
        for (int i = 0; i < word.length(); i++)
        {
            char ch =word.charAt(i);
            if(!Character.isDigit(ch))
            {
                return true;
            }
        }
        return false;
    }


}



