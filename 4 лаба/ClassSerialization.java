
import java.io.*;
import java.util.ArrayList;

public class ClassSerialization {

    String path;
    ArrayList<PC> PCs;

    public ClassSerialization(String path) {

        this.path = path;

    }

    public void setPCs(ArrayList<PC> PCs) {

        this.PCs = PCs;
    }

    public void writeObj(PC pc) throws IOException{

        ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(path));
        OOS.writeObject(pc);
        OOS.close();
    }

    public PC readObj() throws IOException, ClassNotFoundException {
        ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(path));
        PC res = (PC)OIS.readObject();
        OIS.close();
        return res;
    }

    public void writeArr() throws IOException{

        ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(path));
        OOS.writeObject(PCs);
        OOS.close();
    }



    public void readArr() throws IOException, ClassNotFoundException {

        ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(path));
        PCs = (ArrayList<PC>)OIS.readObject();
        OIS.close();
    }

    public ArrayList<PC> getPCs() {

        return PCs;
    }

}