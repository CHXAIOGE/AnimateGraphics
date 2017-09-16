package com.xiaoge.graphics.animategraphics.core.target;


import com.xiaoge.graphics.animategraphics.core.wrapper.DrawableWrapper;

/**
 * Created by zhanglei on 2017/9/9.
 */

public interface Target {

    void onLoadFailed();

    void onResourceReady(DrawableWrapper target);
}
