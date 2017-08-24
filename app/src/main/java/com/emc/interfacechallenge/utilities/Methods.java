package com.emc.interfacechallenge.utilities;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by bird1 on 8/24/17.
 */

public class Methods
{

    public static String loadJsonFile(Context context) {

        String jsonString = null;
        try {
            InputStream inputStream = context.getAssets().open("team.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return jsonString;
    }

}
