import java.util.*;
import java.lang.*;

public class Task1
{
    //Scanner in = new Scanner(System.in);
    Integer array[] = {13, 0, 53, 33, 1004};
    List<String> array16 = new ArrayList<>();
    List<Integer> indexList = new ArrayList<>();
    public Task1()
    {
        System.out.println("Массив и его сумма:");
        ArrayShow();
        System.out.println("\nМаксимальная разрядность числа в массиве: " + GetMaxCapacity());
        System.out.println("Числа из массива в 16-ричной с/c, в кот. присутствует буква:");
        ConvertToArray16();
        Array16Show();
        indexListFilling();
        System.out.println("Массив из индексов чисел:");
        indexListShow();
        System.out.println("Массив c заменой 1-ой цифры числа на последнюю, и наоборот, и его сумма:");
        for(int i=0;i<array.length;i++)
        {
            array[i] = swap(array[i]);
        }
        ArrayShow();

    }
    public void indexListFilling()
    {
        for(int i=0;i<array.length;i++)
        {
            if(i==array[i]%10){
                indexList.add(i);
            }
        }
    }


    public int swap(int n)
    {

        String ns = Integer.toString(n);
        char [] arrayChar= ns.toCharArray();
        char last_ch= arrayChar[arrayChar.length-1];
        arrayChar[arrayChar.length-1] = arrayChar[0];
        arrayChar[0] = last_ch;
        String f ="";
        for(int i=0;i<arrayChar.length;i++)
        {
            f+=arrayChar[i];
        }
        n = Integer.parseInt(f);
        return n;
    }

    public void ConvertToArray16()
    {
        for (int i = 0; i < array.length; i++)
        {
            String converted = Integer.toHexString(array[i]).toUpperCase();
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
            int n=array[i];
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

    public void ArrayShow()
    {
        int sum = 0;
        for(int i=0;i<array.length;i++)
        {
            sum+=array[i];
            System.out.print("["+ array[i]+"] ");
        }
        System.out.print("Сумма всех чисел в массиве: " +sum);
    }
    public void Array16Show()
    {
        for(int i=0;i<array16.size();i++)
        {
            System.out.print("["+ array16.get(i)+"] ");
        }
        System.out.println("");
    }
    public void indexListShow()
    {
        for(int i=0;i<indexList.size();i++)
        {
            System.out.print("["+ indexList.get(i)+"] ");
        }
        System.out.println("");
    }
}



