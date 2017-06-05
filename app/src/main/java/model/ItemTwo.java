package model;

/**
 * Created by wolfmatrix on 6/5/17.
 */

public class ItemTwo {
    private int id;
    private String name;

    public ItemTwo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
