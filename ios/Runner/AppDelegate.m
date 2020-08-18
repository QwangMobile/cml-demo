//
//  AppDelegate.m
//  Runner
//
//  Created by 宪祥郑 on 2020/8/12.
//  Copyright © 2020 全网数商. All rights reserved.
//

#import "AppDelegate.h"
#import "ViewController.h"
#import <CMLEnvironmentManage.h>
#import <CMLSDKEngine.h>
#import <CMLWeexRenderPage.h>

@interface AppDelegate ()

@end

@implementation AppDelegate

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    
    self.window = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
    [self.window setBackgroundColor:[UIColor whiteColor]];
    
    NSString *path = @"http://192.168.4.223:5556/weex/chameleon-ui-builtin.js?path=%2Fpages%2Findex%2Findex";
//    NSString *path = @"";
    
    CMLWeexRenderPage *pageRender = [[CMLWeexRenderPage alloc] initWithLoadUrl:path];
    
    pageRender.service = [CMLEnvironmentManage chameleon].weexService;

    self.window.rootViewController = pageRender;
    
    [self.window makeKeyAndVisible];

    return YES;
}

- (void)initCml {
    //初始化 SDK 实例
    [CMLSDKEngine initSDKEnvironment];
    //设置渲染引擎为 weex
    [CMLEnvironmentManage chameleon].serviceType = CMLServiceTypeWeex;
}

@end
