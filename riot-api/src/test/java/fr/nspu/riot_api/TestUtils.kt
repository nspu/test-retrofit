package fr.nspu.riot_api

import com.google.gson.Gson
import org.robolectric.Robolectric
import retrofit.client.Response
import retrofit.mime.TypedInput
import java.io.*
import java.lang.reflect.Type
import java.nio.CharBuffer
import java.nio.charset.Charset
import java.util.*

object TestUtils {
    private val TEST_DATA_DIR = "/fixtures/"
    private val MAX_TEST_DATA_FILE_SIZE = 4131072
    private val gson = Gson()

    private class ResponseBody internal constructor(private val mJson: String) : TypedInput {

        override fun mimeType(): String {
            return "application/json"
        }

        override fun length(): Long {
            return mJson.length.toLong()
        }

        @Throws(IOException::class)
        override fun `in`(): InputStream {
            return ByteArrayInputStream(mJson.toByteArray(Charset.forName("UTF-8")))
        }
    }

    fun <T> getResponseFromModel(statusCode: Int, model: T, modelClass: Class<T>): Response {
        val responseBody = ResponseBody(gson.toJson(model, modelClass))
        return createResponse(statusCode, responseBody)
    }

    fun <T> getResponseFromModel(model: T, modelClass: Class<T>): Response {
        val responseBody = ResponseBody(gson.toJson(model, modelClass))
        return createResponse(200, responseBody)
    }

    fun <T> getResponseFromModel(model: T, modelType: Type): Response {
        val responseBody = ResponseBody(gson.toJson(model, modelType))
        return createResponse(200, responseBody)
    }

    private fun createResponse(statusCode: Int, responseBody: ResponseBody): Response {
        return Response("", statusCode, "", ArrayList(), responseBody)
    }

    fun readTestData(fileName: String): String {
        try {
            val path = Robolectric::class.java.getResource(TEST_DATA_DIR + fileName).toURI().path
            return readFromFile(File(path))
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }

    @Throws(IOException::class)
    private fun readFromFile(file: File): String {
        val reader = FileReader(file)
        val charBuffer = CharBuffer.allocate(MAX_TEST_DATA_FILE_SIZE)
        reader.read(charBuffer)
        charBuffer.position(0)
        return charBuffer.toString().trim { it <= ' ' }
    }
}
