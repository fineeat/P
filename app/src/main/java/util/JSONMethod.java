package util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Nicholascwz on 11/14/2016.
 */

public class JSONMethod {
    public static JSONObject getJSONObject(String tagname, JSONObject jsonObject) throws JSONException{
        return jsonObject.getJSONObject(tagname);
    }

    public static JSONArray getJSONArary(String tagname, JSONObject jsonObject) throws JSONException{
        return jsonObject.getJSONArray(tagname);
    }

    public static String getJSONString(String tagname, JSONObject jsonObject) throws JSONException{
        return jsonObject.getString(tagname);
    }

    public static double getJSONFloat(String tagname, JSONObject jsonObject) throws JSONException{
        return jsonObject.getDouble(tagname);
    }

    public static int getJSONInt(String tagname, JSONObject jsonObject) throws JSONException{
        return jsonObject.getInt(tagname);
    }

}
