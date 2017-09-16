package com.xiaoge.graphics.animategraphics.core.loader;

import android.widget.ImageView;

import com.xiaoge.graphics.animategraphics.core.target.Target;

import java.io.File;
import java.io.InputStream;

/**
 * Created by zhanglei on 2017/9/16.
 */

public abstract class GraphicsLoader {

    protected Target target;
    protected File file;
    protected InputStream stream;

    public GraphicsLoader(File data, Target target) {
        this.file = data;
        this.target = target;
    }

    public GraphicsLoader(InputStream stream, Target target) {
        this.stream = stream;
        this.target = target;
    }

    public abstract void into (ImageView view);

}
