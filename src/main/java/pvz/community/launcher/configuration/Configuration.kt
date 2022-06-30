package pvz.community.launcher.configuration

import org.apache.commons.io.FileUtils
import org.json.JSONObject
import java.io.File
import java.io.FileWriter
import java.io.IOException
import kotlin.text.Charsets.UTF_8

class Configuration(
    private val file: File,
    private var options: MutableMap<String?, Any?> = mutableMapOf()
) {

    operator fun get(key: String?): Any? {
        return options[key]
    }

    operator fun set(key: String?, value: Any?) {
        options[key] = value
    }

    @Throws(IOException::class)
    fun save() {
        val jsonObject = JSONObject(options)
        file.createNewFile()
        val fileWriter = FileWriter(file).use {
            it.write(jsonObject.toString())
        }
    }

    companion object {
        @Throws(IOException::class)
        fun loadExistingConfiguration(file: File): Configuration {
            val jsonObject = JSONObject(FileUtils.readFileToString(file, UTF_8))
            return Configuration(file, jsonObject.toMap())

        }

        fun newConfiguration(file: File): Configuration {
            return Configuration(file)
        }
    }
}