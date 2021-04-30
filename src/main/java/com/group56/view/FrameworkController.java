package com.group56.view;

import javafx.scene.layout.Pane;

/**
 * 框架面板的控制器必须实现本接口
 */
public interface FrameworkController extends ViewController{
    /**
     * 获取主内容面板
     * @return
     */
    Pane getContentPane();

    /**
     * 获取广告面板
     * @return
     */
    Pane getAdsPane();

    /**
     * 获取导航栏面板
     * @return
     */
    Pane getNavigatorPane();

    /**
     * 获取角标面板
     * @return
     */
    Pane getFooterPane();
}
