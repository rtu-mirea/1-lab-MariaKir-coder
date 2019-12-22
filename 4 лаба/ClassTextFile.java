import java.io.*;
import java.util.Scanner;
public class ClassTextFile {
    String path;

    public ClassTextFile(String path) {

        this.path = path;

        File f = new File(path);

        if (f.exists())
            System.out.println("Файл " + f.getName() + " существует");

    }

    public PC get() throws FileNotFoundException {

        Scanner sc = new Scanner(new FileInputStream(new File(path)));
        String creator = sc.nextLine();
        String name = sc.nextLine();
        int cost = sc.nextInt();
        sc.close();
        return new PC(creator, name, cost);
    }
}