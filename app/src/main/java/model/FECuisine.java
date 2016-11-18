package model;

/**
 * Created by Nicholascwz on 11/15/2016.
 */

public class FECuisine {
    public FECuisine(int id, String name, int sortnum){
        this.id = id;
        this.name = name;
        this.sortNum = sortnum;
    }
    public final int id;
    public String name;
    public int sortNum;
    public boolean isUsed;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean used) {
        isUsed = used;
    }
}
