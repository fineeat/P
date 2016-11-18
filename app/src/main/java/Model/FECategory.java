package model;

/**
 * Created by Nicholascwz on 11/2/2016.
 */

public class FECategory {
    public FECategory(int id, String name, int sortnum){
        this.id = id;
        this.name = name;
        this.sortNum = sortnum;
    }

    public final int id;
    public String name;
    public int sortNum;

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean used) {
        isUsed = used;
    }

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

    public int getSortNum() {
        return sortNum;
    }

    public void setSort(int sortnum) {
        this.sortNum = sortnum;
    }
}
