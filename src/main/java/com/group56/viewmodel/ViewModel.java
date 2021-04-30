package com.group56.viewmodel;

//view model可以每一个页面一个，也可以一个抽象模块用一个（不以页面为单位）。我推荐后者
public interface ViewModel {
    void updateToModel();
    void updateFromModel();
}
