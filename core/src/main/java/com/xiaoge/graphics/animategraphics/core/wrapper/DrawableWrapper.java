package com.xiaoge.graphics.animategraphics.core.wrapper;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by zhanglei on 2017/9/11.
 */

public interface DrawableWrapper {

    Drawable getDrawable();

    void start();

    void stop();

    void setRepeatCount(int count);

    void setLoopMode(int count);

    void setPlayListener(PlayListener playListener);

    Bitmap getFirstFrame();
}
