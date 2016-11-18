package data;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import util.Util;

/**
 * Created by Nicholascwz on 11/14/2016.
 */

public class HttpClient {
    public static String getData(String urlext)
    {
        HttpURLConnection connection;
        InputStream inputStream;

        try{
            connection = (HttpURLConnection)(new URL(Util.BaseURL + urlext)).openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            //Read the response
            StringBuffer stringBuffer = new StringBuffer();
            inputStream = connection.getInputStream();
            BufferedReader bufferReader = new BufferedReader( new InputStreamReader(inputStream));
            String line;

            while((line = bufferReader.readLine()) != null){
                stringBuffer.append(line + "\r\n");
            }

            inputStream.close();
            connection.disconnect();

            return stringBuffer.toString();

        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }
}
