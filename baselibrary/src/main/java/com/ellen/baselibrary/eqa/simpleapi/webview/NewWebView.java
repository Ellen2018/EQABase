package com.ellen.baselibrary.eqa.simpleapi.webview;

import android.content.Context;
import android.webkit.WebView;

public interface NewWebView {
    /**
     * 获取当一个WebView对象
     * @return
     */
    WebView getNewWebView(Context context);
    int maxSize();
}
