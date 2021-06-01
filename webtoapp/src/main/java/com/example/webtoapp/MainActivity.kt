package com.example.webtoapp

import android.content.DialogInterface
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var ShowOrHideWebViewInitialUse = "show"
    private var webview: WebView? = null
    private var spinner: ProgressBar? = null
    var webUrl: String? = "https://www.joinmytrip.com/en/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webview = findViewById<View>(R.id.webView) as WebView
        spinner = findViewById<View>(R.id.progressBar1) as ProgressBar
        webview!!.webViewClient = CustomWebViewClient()
        webview!!.settings.javaScriptEnabled = true
        webview!!.settings.domStorageEnabled = true
        webview!!.overScrollMode = WebView.OVER_SCROLL_NEVER
        webview!!.loadUrl(webUrl!!)
    }

    /**
     * This allows for a splash screen
     * Hide elements once the page loads
     * Show custom error page
     * Resolve issue with SSL certificate
     */
    private inner class CustomWebViewClient : WebViewClient() {
        // Handle SSL issue
        override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
            val builder: android.app.AlertDialog.Builder =
                android.app.AlertDialog.Builder(this@MainActivity)
            builder.setMessage(R.string.notification_error_ssl_cert_invalid)
            builder.setPositiveButton("continue",
                DialogInterface.OnClickListener { dialog, which -> handler.proceed() })
            builder.setNegativeButton("cancel",
                DialogInterface.OnClickListener { dialog, which -> handler.cancel() })
            val dialog: android.app.AlertDialog? = builder.create()
            dialog?.show()
        }

        override fun onPageStarted(webview: WebView, url: String, favicon: Bitmap?) {

            // only make it invisible the FIRST time the app is run
            if (ShowOrHideWebViewInitialUse == "show") {
                webview.visibility = View.INVISIBLE
            }
        }

        override fun onPageFinished(view: WebView, url: String) {
            ShowOrHideWebViewInitialUse = "hide"
            spinner!!.visibility = View.GONE
            view.visibility = View.VISIBLE
            super.onPageFinished(view, url)
        }

        // Show custom error page
        override fun onReceivedError(
            view: WebView, errorCode: Int,
            description: String, failingUrl: String
        ) {
            webUrl = view.url
            setContentView(R.layout.error)
            super.onReceivedError(view, errorCode, description, failingUrl)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (event.action === KeyEvent.ACTION_DOWN) {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    if (webview!!.canGoBack()) {
                        webview!!.goBack()
                    } else {
                        val builder: android.app.AlertDialog.Builder =
                            android.app.AlertDialog.Builder(this@MainActivity)
                        builder.setMessage(R.string.exit_app)
                        builder.setPositiveButton("Yes",
                            DialogInterface.OnClickListener { dialog, which -> finish() })
                        builder.setNegativeButton("No",
                            DialogInterface.OnClickListener { dialog, which ->
                                // Do nothing
                            })
                        val dialog: android.app.AlertDialog? = builder.create()
                        dialog?.show()
                    }
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    /* Retry Loading the page */
    fun tryAgain(v: View?) {
        setContentView(R.layout.activity_main)
        webview = findViewById<View>(R.id.webView) as WebView
        spinner = findViewById<View>(R.id.progressBar1) as ProgressBar
        webview!!.webViewClient = CustomWebViewClient()
        webview!!.settings.javaScriptEnabled = true
        webview!!.settings.domStorageEnabled = true
        webview!!.overScrollMode = WebView.OVER_SCROLL_NEVER
        webview!!.loadUrl(webUrl!!)
    }
}