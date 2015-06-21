package jousyo.jousyo_android;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import jousyo.jousyo_android.db.DbController;
import jousyo.jousyo_android.db.Question;

import static jousyo.jousyo_android.common.Constants.*;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); // main.xmlをセット

        // Enabling JavaScript
        WebView webView = (WebView)findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // アプリ内でHTML表示
        webView.setWebViewClient(new WebViewClient());

        // JavaScriptをAndroidへバインド
        webView.addJavascriptInterface(new JavaScriptInterface(this), "JsInterface");
        webView.loadUrl("file:///android_asset/main.html");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class JavaScriptInterface {
        protected Context mContext;
        JavaScriptInterface(Context context) {
            mContext = context;
        }
        public String getYear() {
            return "GET!!";
        }
    }
}
