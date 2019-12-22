import java.io.Serializable;

public class PC implements Serializable {

    String creator, name;
    int cost;

    PC(String creator, String name, int cost) throws IllegalArgumentException {

        this.creator = creator;
        this.name = name;

        if (cost < 0) {

            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }

        this.cost = cost;
    }

    public void setCreator(String creator) {

        this.creator = creator;

    }

    public void setName(String name) {

        this.name = name;
    }
    public void setCost(int cost) throws IllegalArgumentException {

        if (cost < 0) {

            throw new IllegalArgumentException("Цена не может быть отрицательной");

        }

        this.cost = cost;

    }
    @Override

    public String toString() {

        return "{Создатель: " + creator +" Название: " + name + " Цена: " + cost + "}";
    }
}