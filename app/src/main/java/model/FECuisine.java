package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nicholascwz on 11/15/2016.
 */

public class FECuisine {
    public FECuisine(int id, String name, int sortnum){
        this.id = id;
        this.name = name;
        this.sortNum = sortnum;
    }

    @SerializedName("cuisine_id")
    private final int id;
    @SerializedName("cuisine_name")
    private String name;
    @SerializedName("cuisine_sortnum")
    private int sortNum;
    private boolean isUsed;

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

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean used) {
        isUsed = used;
    }
}
