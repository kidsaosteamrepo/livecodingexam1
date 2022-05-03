package com.example.interview.util

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStreamReader

class DataLoader(private val context: Context) {
    private val gson = Gson()

    fun loadTextList(): List<TextData> {
        val message = readAssetFileToString("mock/text_list.json")
        val type = object : TypeToken<List<TextData>>() {}.type
        return gson.fromJson(message, type)
    }

    fun loadImageList(): List<ImageData> {
        val message = readAssetFileToString("mock/image_list.json")
        val type = object : TypeToken<List<ImageData>>() {}.type
        return gson.fromJson(message, type)
    }

    private fun readAssetFileToString(fileName: String): String {
        try {
            val inputStream = context.assets.open(fileName)
            val builder = StringBuilder()
            val reader = InputStreamReader(inputStream, "UTF-8")
            reader.readLines().forEach {
                builder.append(it)
            }
            return builder.toString()
        } catch (e: IOException) {
            throw e
        }
    }
}