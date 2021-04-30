package com.group56.view;

import javafx.scene.Parent;

/**
 * 组件面板（fxml）的控制器必须实现本接口
 */
public interface ViewController {
    /**
     * 将ViewModel数据注入View
     */
    default void inject(){}

    /**
     * 绑定属性
     */
    default void bind(){}

    /**
     * 将ViewController注册到本模块的中介者
     */
    void registerToMediator();

    /**
     * 获取root面板
     * @return
     */
    Parent getView();
}
