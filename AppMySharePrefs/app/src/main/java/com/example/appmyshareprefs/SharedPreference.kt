package com.example.appmyshareprefs

import android.content.Context

class SharedPreference(val context: Context) {
    private val PREFS_NAME = "spUser"

    //creo el sp
    private val sharedPreference = context.getSharedPreferences(
        PREFS_NAME, Context.MODE_PRIVATE
    )

    //las ops del sp
    fun save(keyName: String, value: String){
        val editor = sharedPreference.edit()
        editor.putString(keyName, value)
        editor.commit()
    }

    fun getValue(keyName: String): String?{
        return sharedPreference.getString(keyName, null)
    }

    fun clear(){
        val editor = sharedPreference.edit()
        editor.clear()
        editor.commit()
    }

    fun removeValue(keyName: String){
        val editor = sharedPreference.edit()
        editor.remove(keyName)
        editor.commit()
    }
}