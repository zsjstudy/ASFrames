package cn.yhong.aframework.presenter;

import android.os.Bundle;

import cn.yhong.aframework.view.IBaseView;
import zm.bus.event.BusProvider;

public abstract class BasePresenter {

    public void onCreate(Bundle savedState) {
        BusProvider.getInstance().register(this);
    }

    public abstract void onAttach(IBaseView view);

    public void onSaveInstanceState(Bundle outState) {
    }

    public abstract void onDetach();

    public void onDestroy() {
        BusProvider.getInstance().unregister(this);
    }
}
