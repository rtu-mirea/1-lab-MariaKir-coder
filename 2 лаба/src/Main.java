import java.util.ArrayList;
import java.util.List;

public class Main //Variant 1 Kireeva Maria
{
    static String num1= "22, 0, 100, 2359, 4, 1005";
    static String num2= "2092, 0, 1300, 666, 124, 10405";

    static String domain_only = ".ru";
    static String text = "gmail.ru/b/memento моя мама недавно зар.егеСтРировала Меня в odnoklassniki.com, но я всегда хотела завести аккаунт в vk.ru ghjh? .ru";

    public static void main(String[] args)
    {
        String[] array = convertToArray(num1);
        String[] array2 = convertToArray(num2);

        Task1 newtask1= new Task1(array);
        System.out.print("\n----------------------\nПервое задание.\nМассив:");
        ArrayShow(array,0);
        System.out.println("\nМаксимальная разрядность числа в массиве: " + newtask1.GetMaxCapacity());
        System.out.print("Числа из массива в 16-ричной с/c, в кот. присутствует буква:");
        newtask1.ConvertToArray16();
        StrArrayShow(newtask1.array16);
        newtask1.indexListFilling();
        System.out.print("Массив из индексов чисел:");
        IntArrayShow(newtask1.indexList);
        System.out.println("Массив c заменой 1-ой цифры числа на последнюю, и наоборот:");
        for(int i=0;i<array.length;i++)
        {
            array[i] = newtask1.swap(array[i]);
        }
        ArrayShow(array,0);

        System.out.println("\n----------------------\nВторое задание задание.");
        Task2 newtask2 = new Task2(array2);
        System.out.println("Массив и его сумма:");
        ArrayShow(array2,1);
        System.out.println("Числа из массива в 16-ричной с/c, в кот. присутствует буква:");
        newtask2.ConvertToArray16();
        StrArrayShow(newtask2.array16);
        System.out.println("Массив c заменой 1-ой цифры числа на последнюю, и наоборот, и его сумма:");
        for(int i=0;i<array2.length;i++)
        {
            array2[i] = newtask1.swap(array2[i]);
        }
        ArrayShow(array2,1);

        System.out.println("\n----------------------\nТретье задание.");
        Task3 newtask3= new Task3();
        int res = newtask3.isDomain(domain_only);
        if (res == 1) {
            System.out.println("Изначальный текст: " + domain_only);
            System.out.println("Введено доменное имя - только имя 2-го порядка.");
        } else if (res==2) {
            System.out.println("Введена путая строка.");
        } else {
            System.out.println("Введено доменное имя - не только имя 2-го порядка.");

        }

        System.out.println("Исходный текст: gmail.ru/b/memento моя мама недавно зар.егеСтРировала Меня в odnoklassniki.com, но я всегда хотела завести аккаунт в vk.ru ghjh? .ru");
        System.out.println("Измененный текст: " + newtask3.ReplaceRu(text));
    }
    public static String[] convertToArray (String n){
        String[] array = n.split(", ");
        return array;
    }
    public static void ArrayShow(String[] array, int mode)
    {
        int sum = 0;
        for(int i=0;i<array.length;i++)
        {
            sum+=Integer.parseInt(array[i]);
            System.out.print("["+ array[i]+"] ");
        }
        if(mode==1)
            System.out.print("Сумма всех чисел в массиве: " +sum +"\n");
    }
    public static void IntArrayShow(List<Integer> arrayToShow)
    {
        for(int i=0;i<arrayToShow.size();i++)
        {
            System.out.print("["+ arrayToShow.get(i)+"] ");
        }
        System.out.println("");
    }
    public static void StrArrayShow(List<String> arrayToShow)
    {
        for(int i=0;i<arrayToShow.size();i++)
        {
            System.out.print("["+ arrayToShow.get(i)+"] ");
        }
        System.out.println("");
    }
}
