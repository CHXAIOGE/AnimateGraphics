package com.xiaoge.graphics.animategraphics.core;


import android.support.annotation.Nullable;

import com.xiaoge.graphics.animategraphics.core.target.Target;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;

/**
 * Created by zhanglei on 2017/9/16.
 */

class Registry {

    private static Registry sInstance = null;

    final HashMap<Graphics.Module, Class<Graphics.GraphicsLoader>> encoders = new HashMap<>();


    static Registry get() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (Registry.class) {
            if (sInstance != null) {
                return sInstance;
            }
            sInstance = new Registry();
        }
        return sInstance;
    }

    synchronized HashMap<Graphics.Module, Class<Graphics.GraphicsLoader>> getEncoders() {
        return encoders;
    }


    public synchronized void append(Graphics.Module module, Class<Graphics.GraphicsLoader> loaderClass) {
        encoders.put(module, loaderClass);

    }

    public synchronized void remove(Graphics.Module module) {
        encoders.remove(module);
    }

    public synchronized void clear() {
        encoders.clear();
    }

    @SuppressWarnings("unchecked")
    @Nullable
    synchronized Graphics.GraphicsLoader getLoaderInstance(Class<Graphics.GraphicsLoader> loaderClass, File file, Target target) throws Exception {
        Constructor<Graphics.GraphicsLoader> constructor = loaderClass.getConstructor(File.class, Target.class);
        Graphics.GraphicsLoader instance = constructor.newInstance(file, target);
        Graphics.Log("create object:"+instance);
        return instance;
    }
}
