package com.example.rootlib.mvp.view;

public interface IBaseLoadView extends IBaseView {
    /**
     * 重新加载，重置刷新方式
     */
    void onReload();
    /**
     * 加载结束
     */
    void onLoadFinished();
    /**
     * 加载全部
     */
    void onLoadAll();
}
