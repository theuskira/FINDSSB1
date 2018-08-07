package br.com.icoddevelopers.findssp;

import android.content.Context;
import android.content.SharedPreferences;

public class Status {

    private final SharedPreferences mSharedPreferences;

    public Status(Context context){
        this.mSharedPreferences = context.getSharedPreferences("LogadoEmpresa", Context.MODE_PRIVATE);
    }

    public void storageString(String key, String value){
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStorageStrin(String key){
        return this.mSharedPreferences.getString(key, "");
    }

}
