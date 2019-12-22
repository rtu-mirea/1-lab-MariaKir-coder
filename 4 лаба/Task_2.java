import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Класс – Видеофильм (в системе видео проката)
Поля: Название, Студия, Год выпуска, Режиссер, Фамилия исполнителя главной роли.

1)одного режиссера
Дополнительные операции
1) Определить по названию фильма фамилию исполнителя главной роли.
2) Определить, созданы ли два фильма одним и тем же режиссером.

2)Удалить запись по самом старом видеофильме
 */
public class Task_2
{
    static File database = new File("./DataBase.bi");
    static Scanner in = new Scanner(System.in);
    static List<Film> datalist = new ArrayList<>();
    public static void main(String[] args)
    {
        //load_data();
        datalist.add(new Film("film 1",  "com 1", "3", "Valera", "Mered"));
        datalist.add(new Film("film 2",  "com 2", "24", "Masha", "Ira"));
        datalist.add(new Film("film 3",  "com 3", "11", "John", "Bill"));
        datalist.add(new Film("film 4",  "com 4", "17", "Vasya", "Vanya"));
        save_data();
        load_data();
        boolean exit = false;
        while (!exit)
        {
            System.out.println("Add film(1)/Delete the oldest(2)/Have the same producer?(3)/Get main actor(4)/Show films(5):");
            String cm = in.nextLine();
            switch (cm)
            {
                case "1":
                    System.out.print("Name:");
                    String name = in.nextLine();
                    System.out.print("Producer:");
                    String producer = in.nextLine();
                    System.out.print("Company:");
                    String company = in.nextLine();
                    System.out.print("Release date:");
                    String date = in.nextLine();
                    System.out.print("Main role actor:");
                    String main_role = in.nextLine();
                    //addFilm();
                    datalist.add(new Film(name,  company, date, producer, main_role));
                    save_data();
                    break;
                case "2":
                    int oldest = Integer.MAX_VALUE;
                    int index = 0;
                    for (int i = 0; i < datalist.size(); i++)
                    {
                        int curr_date = Integer.parseInt(datalist.get(i).date_release);
                        if (curr_date <= oldest)
                        {
                            oldest = curr_date;
                            index = i;
                        }
                    }
                    datalist.remove(index);
                    save_data();
                    break;
                case "3":
                    System.out.print("Name[1]:");
                    String _number1 = in.nextLine();
                    System.out.print("Name[2]:");
                    String _number2 = in.nextLine();
                    String first_author = "";
                    String second_author = "";
                    for (int i = 0; i < datalist.size(); i++)
                    {
                        if (datalist.get(i).film_name.equals(_number1))
                        {
                            first_author = datalist.get(i).producer;
                            if (!second_author.equals("")) break;
                        }
                        if (datalist.get(i).film_name.equals(_number2))
                        {
                            second_author = datalist.get(i).producer;
                            if (!first_author.equals("")) break;
                        }
                    }
                    if (first_author.equals(second_author))
                        System.out.println("Similar author: " + first_author);
                    else
                    {
                        System.out.println("Different author: " + first_author + " and " + second_author);
                    }
                    break;

                case "4":
                    System.out.print("Name:");
                    String _number3 = in.nextLine();
                    for (int i = 0; i < datalist.size(); i++)
                    {
                        if (datalist.get(i).film_name.equals(_number3))
                        {
                            System.out.println(datalist.get(i).main_role);
                        }
                    }
                    break;
                case "5":
                    for (int i = 0; i < datalist.size(); i++)
                    {
                        System.out.println(datalist.get(i).film_name + '/' + datalist.get(i).company + "/" + datalist.get(i).date_release + '/' + datalist.get(i).producer + '/' + datalist.get(i).main_role);
                    }
                    break;
                default:
                    break;
            }
        }
    }
    public static String getText(File file)
    {
        String text = "";
        try(FileInputStream fin=new FileInputStream(database))
        {
            int i=-1;

            while((i=fin.read())!=-1)
            {
                text+=(char)i;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return text;
    }
    /*public static void addFilm(Film film)
    {
        try(FileOutputStream fos=new FileOutputStream(database))
        {
            datalist.add(film);
            String database_text = getText(database);
            String text = database_text + film.film_name + '/' + film.company + '/' + film.date_release + '/' + film.producer + '/' + film.main_role + '\n';
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("The file has been written");
    }*/
    public static void save_data()
    {
        try(FileOutputStream fos=new FileOutputStream(database))
        {
            String text = "";
            for(int i=0;i<datalist.size();i++)
            {
                text += datalist.get(i).film_name + '/' + datalist.get(i).company + '/' + datalist.get(i).date_release + '/' + datalist.get(i).producer + '/' + datalist.get(i).main_role + '\n';

            }
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("The file has been written");
    }
    public static void load_data()
    {
        datalist.clear();
        try(FileInputStream fin=new FileInputStream(database))
        {
            String text = "";
            int i=-1;
            String[] arr = new String[5];
            int index = 0;
            while((i=fin.read())!=-1)
            {
                if ((char) i == '\n')
                {
                    arr[index] = text;
                    index = 0;
                    text = "";
                    datalist.add(new Film(arr[0], arr[1], arr[2], arr[3], arr[4]));
                    System.out.println("New Film read:["+ arr[0] + '/' + arr[1] + '/' + arr[2] + '/' + arr[3] + '/' + arr[4] +"]");
                }
                else if ((char) i == '/')
                {
                    arr[index] = text;

                    index+=1;
                    System.out.println("word("+ text +")");
                    text = "";
                }
                else if((char) i != '\n')
                    text += (char) i;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
