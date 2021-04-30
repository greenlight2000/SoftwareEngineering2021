package com.group56.utils;

/**
 * fxml路径的配置类，控制器中访问必须通过本类访问。修改/更新fxml时直接修改本配置类里的路径，实现布丁式更新
 */
public enum FXMLSrcMenu {
    NAVIGATOR("/navigator.fxml"),
    FOOTER("/footer.fxml"),

    USER_INFO("/UserInfo.fxml"),
    USER_INFO_MODIFY("/UserInfoModify.fxml"),
    USER_ADS("/Advertisement.fxml"),
    USER_FRAMEWORK("/UserModuleFrameWork.fxml");

    private String src;

    FXMLSrcMenu(String src) {
        this.src = src;
    }
    public String getSrc() {
        return src;
    }

}
