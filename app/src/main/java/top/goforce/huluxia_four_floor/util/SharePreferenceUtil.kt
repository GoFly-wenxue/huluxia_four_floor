package top.goforce.huluxia_four_floor.util

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class SharePreferenceUtil private constructor(mContext: Context) {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var instance: SharePreferenceUtil? = null
        private const val FILE_NAME: String = "huluxia_four_floor"

        fun get(): SharePreferenceUtil? {
            return instance
        }

        fun init(context: Application): SharePreferenceUtil? {
            instance = SharePreferenceUtil(context)
            return instance
        }
    }

    private val mSharedPreferences: SharedPreferences

    init {
        mSharedPreferences = mContext.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
    }

    private fun put(key: String, value: Any) {
        val editor: SharedPreferences.Editor = mSharedPreferences.edit()

        if (value is String) {
            editor.putString(key, value)
        } else if (value is Int) {
            editor.putInt(key, value)
        } else if (value is Boolean) {
            editor.putBoolean(key, value)
        } else if (value is Float) {
            editor.putFloat(key, value)
        } else if (value is Long) {
            editor.putLong(key, value)
        } else {
            editor.putString(key, value.toString())
        }

        editor.apply()
    }

    private fun get(key: String, defaultValue: Any): Any? {
        if (defaultValue is String) {
            mSharedPreferences.getString(key, defaultValue)
        } else if (defaultValue is Int) {
            mSharedPreferences.getInt(key, defaultValue)
        } else if (defaultValue is Boolean) {
            mSharedPreferences.getBoolean(key, defaultValue)
        } else if (defaultValue is Float) {
            mSharedPreferences.getFloat(key, defaultValue)
        } else if (defaultValue is Long) {
            mSharedPreferences.getLong(key, defaultValue)
        }

        return null
    }

    var userKey: String
        get() {
            return get("key", "") as String
        }
        set(value) {
            put("key", value)
        }

}