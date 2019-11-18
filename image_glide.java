package com.infodart.salman.Util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.infodart.salman.R;

public class image_glide {

    public static void loadimg(Context context, ImageView imageView,
                               String baseurL, String Imagelink )
    {
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = (JsonArray) jsonParser.parse(Imagelink);

        String replace = jsonArray.get(0).toString()
                .replace("\"", "")
                .replace("[","")
                .replace("]","");

        String urlform = baseurL+replace;
        Glide.with(context).load(urlform)
                .into(imageView);
    }
}
