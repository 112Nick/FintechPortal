package ru.fintech.tinkoff.fintechportal

import android.content.Context
import android.preference.PreferenceManager
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.HashSet


/**
 * This interceptor put all the Cookies in Preferences in the Request.
 * Your implementation on how to get the Preferences may ary, but this will work 99% of the time.
 */
class AddCookieInterceptor(private val context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        val preferences = PreferenceManager.getDefaultSharedPreferences(context).getStringSet(
            PREF_COOKIES,
            HashSet()
        ) as HashSet<String>

        // Use the following if you need everything in one line.
        // Some APIs die if you do it differently.
        /*String cookiestring = "";
        for (String cookie : preferences) {
            String[] parser = cookie.split(";");
            cookiestring = cookiestring + parser[0] + "; ";
        }
        builder.addHeader("Cookie", cookiestring);
        */

        for (cookie in preferences) {
            builder.addHeader("Cookie", cookie)
        }

        return chain.proceed(builder.build())
    }

    companion object {
        val PREF_COOKIES = "PREF_COOKIES"
    }
}