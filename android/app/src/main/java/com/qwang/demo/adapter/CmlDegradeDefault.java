package com.qwang.demo.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.didi.chameleon.sdk.CmlEngine;
import com.didi.chameleon.sdk.adapter.ICmlDegradeAdapter;
import com.didi.chameleon.web.container.CmlWebView;

import java.util.HashMap;

public class CmlDegradeDefault implements ICmlDegradeAdapter {

    private static final String DEGRADE_TO_H5 = "degrade_to_h5";

    @Override
    public DegradeViewWrapper getDegradeView(int degradeCode) {
        return new DegradeViewWrapper() {
            CmlWebView webView;

            @Override
            public View getView(@NonNull Context context) {
                webView = new CmlWebView(context);
                webView.onCreate();
                return webView;
            }

            @Override
            public void onDestroy() {
                if (null != webView) {
                    webView.onDestroy();
                }
            }

            @Override
            public void loadURL(@NonNull Context context, @NonNull String url, @Nullable HashMap<String, Object> options) {
                if (null != webView) {
                    Uri degradeUri = Uri.parse(url);
                    String degradeToH5 = degradeUri.getQueryParameter(DEGRADE_TO_H5);
                    webView.render(degradeToH5, options);
                }
            }
        };
    }

    @Override
    public void degradeActivity(@NonNull Activity activity, @NonNull String url, @Nullable HashMap<String, Object> options, int degradeCode) {
        if (url.contains("?")) {
            url = url.substring(0, url.indexOf("?"));
        }
        CmlEngine.getInstance().launchPage(activity, url, null);
    }
}
