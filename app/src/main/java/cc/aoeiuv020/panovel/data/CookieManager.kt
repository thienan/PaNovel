@file:Suppress("DEPRECATION")

// 用到Cookies相关的不少过时方法，兼容低版本需要，

package cc.aoeiuv020.panovel.data

import android.content.Context
import android.os.Build
import android.webkit.CookieManager
import android.webkit.CookieSyncManager
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

/**
 * Created by AoEiuV020 on 2018.05.23-20:25:48.
 */
class CookieManager(private val ctx: Context) : AnkoLogger {
    private val cookieManager = CookieManager.getInstance()

    fun putCookie(domain: String, cookiePair: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.setCookie(domain, cookiePair) {
                debug {
                    "cookie has been set $it, <$${DataManager.cookie}>"
                }
            }
        } else {
            cookieManager.setCookie(domain, cookiePair)
            debug {
                "cookie has been set, <$${DataManager.cookie}>"
            }
        }

    }

    fun sync() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.flush()
        } else {
            val syncManager = CookieSyncManager.createInstance(ctx)
            syncManager.sync()
        }
    }

    fun getCookies(domain: String): String? {
        return cookieManager.getCookie(domain)
    }

    fun removeCookies() {
        val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.removeAllCookies(null)
        } else {
            cookieManager.removeAllCookie()
        }
    }
}