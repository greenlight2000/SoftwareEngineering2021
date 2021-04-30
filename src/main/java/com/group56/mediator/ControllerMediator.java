package com.group56.mediator;

import com.group56.utils.FXMLViewHandler;
import com.group56.view.ViewController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 接口推荐用Map存controller，key为fxml路径，value为view controller，当然也可以自己写新的成员和方法来存储。
 */
public interface ControllerMediator {
    Map<String,ViewController> controllersMap = new HashMap<>();
    default ViewController getController(String viewSrc) throws IOException {
        if(controllersMap.get(viewSrc)==null)
            FXMLViewHandler.getView(viewSrc);//默认controller在initialize方法里完成了注册操作
        return controllersMap.get(viewSrc);
    }
    default void registerController(String viewSrc, ViewController viewController){
        controllersMap.put(viewSrc, viewController);
    }
    default void clearMap(){
        controllersMap.clear();
    }
    default void showControllers(){
        controllersMap.forEach((key,value)->{
            System.out.println(key+":"+value.getClass());
        });
    }
}
