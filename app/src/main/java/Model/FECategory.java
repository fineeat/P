package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nicholascwz on 11/2/2016.
 */

public class FECategory {
    public FECategory(int id, String name, int sortnum){
        this.id = id;
        this.name = name;
        this.sortNum = sortnum;
    }

    @SerializedName("category_id")
    public final int id;
    @SerializedName("category_name")
    public String name;
    @SerializedName("category_sortnum")
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

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortnum) {
        this.sortNum = sortnum;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean used) {
        isUsed = used;
    }
}
