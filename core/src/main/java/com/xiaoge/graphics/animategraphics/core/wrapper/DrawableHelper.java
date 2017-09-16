package com.xiaoge.graphics.animategraphics.core.wrapper;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zhanglei on 2017/9/11.
 */

public class DrawableHelper {

    public static final int REPEAT_MODE_INFINITE = 0;

    public static final int REPEAT_MODE_FINITE = 1;

    public static final int REPEAT_COUNT_INFINITE = 0;

    @IntDef({REPEAT_MODE_INFINITE, REPEAT_MODE_FINITE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface REPEAT_MODE {}
}
