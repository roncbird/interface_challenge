package com.emc.sofiinterfacechallenge.utilities;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by bird1 on 4/13/17.
 */

public class FontCache
{

    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();

    public static Typeface get(String name, Context context) {
        Typeface typeface = fontCache.get(name);
        if(typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), name);
            }
            catch (Exception e) {
                return null;
            }
            fontCache.put(name, typeface);
        }
        return typeface;
    }
}