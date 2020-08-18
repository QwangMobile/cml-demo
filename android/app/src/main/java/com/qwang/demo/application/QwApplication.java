package com.qwang.demo.application;

import androidx.multidex.MultiDexApplication;

import com.didi.chameleon.sdk.CmlEngine;
import com.didi.chameleon.sdk.CmlEnvironment;
import com.didi.chameleon.sdk.ICmlConfig;
import com.qwang.demo.adapter.CmlDegradeDefault;

public class QwApplication extends MultiDexApplication implements ICmlConfig {

    @Override
    public void onCreate() {
        super.onCreate();

        CmlEngine.getInstance().init(this, this);
    }

    @Override
    public void configAdapter() {
        // 开发阶段可以禁用js bundle缓存
        CmlEnvironment.CML_ALLOW_BUNDLE_CACHE = false;
        // Debug开关
        CmlEnvironment.CML_DEBUG = true;
        // 开发阶段手动降级测试
        CmlEnvironment.CML_DEGRADE = false;
        CmlEnvironment.CML_ALLOW_LOAD_FROM_FILE = true;
        // 这里注册降级Adapter
        CmlEnvironment.setDegradeAdapter(new CmlDegradeDefault());
    }

    @Override
    public void registerModule() {
        // 这里注册功能模块
    }
}
