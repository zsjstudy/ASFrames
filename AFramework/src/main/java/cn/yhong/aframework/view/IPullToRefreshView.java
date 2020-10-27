package cn.yhong.aframework.view;

public interface IPullToRefreshView extends IBaseView {

    void onSuccessResponse(String response);

    void onFailedResponse(String message);
}
