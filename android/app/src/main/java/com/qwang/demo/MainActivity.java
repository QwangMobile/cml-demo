package com.qwang.demo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.didi.chameleon.weex.container.CmlWeexView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private CmlWeexView cmlView;
    // 加载远程的JS Bundle文件
    // private String IP = "192.168.4.223:5556";
    // private String RENDER_URL = "http://" + IP + "/?cml_addr=http://"+IP+"/weex/chameleon-ui-builtin.js&path=/pages/index/index";

    // degrade_to_h5为js加载错误时的webview降级地址
    private String RENDER_URL = "file://local/weex/chameleon-ui-builtin.js?degrade_to_h5=http://bbcdemo.qwang.com.cn/wap/web/qwang.html#/&path=/pages/index/index";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("source", "android");

        cmlView = findViewById(R.id.weex_view);
        cmlView.onCreate();
        cmlView.render(RENDER_URL, hashMap);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (cmlView != null) {
            cmlView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (cmlView != null) {
            cmlView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cmlView != null) {
            cmlView.onDestroy();
        }
    }
}
