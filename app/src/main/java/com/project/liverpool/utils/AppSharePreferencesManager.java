package com.project.liverpool.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AppSharePreferencesManager {

    private static final String FILE_NAME = "sicn_app_preferences";
    private static final String LIST_SEARCH_WORLD = "LIST_SEARCH_WORLD";

    private SharedPreferences preferences;

    public AppSharePreferencesManager(Context context) {
        preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public void saveListSearchWorld(List<String> listWorldSearchs) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(LIST_SEARCH_WORLD,new Gson().toJson(listWorldSearchs));
        editor.apply();
        Log.d("Ejemplo", "saveListSearchWorld");
    }

    public List<String> getListSearchWorld() {
        Gson gson = new Gson();
        Type type = new TypeToken<List<String>>(){}.getType();
        String json = preferences.getString(LIST_SEARCH_WORLD, "");
        List<String> listWorldSearchs = gson.fromJson(json, type);
        if(listWorldSearchs == null)
            return  new ArrayList<>();

        return listWorldSearchs;
    }

}
