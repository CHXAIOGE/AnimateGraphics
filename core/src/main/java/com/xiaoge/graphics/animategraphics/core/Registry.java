package com.xiaoge.graphics.animategraphics.core;


import android.support.annotation.Nullable;

import com.xiaoge.graphics.animategraphics.core.loader.GraphicsLoader;
import com.xiaoge.graphics.animategraphics.core.target.Target;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;

/**
 * Created by zhanglei on 2017/9/16.
 */

public class Registry<T> {

    private static Registry sInstance = null;

    final HashMap<Graphics.Module, Class<GraphicsLoader>> encoders = new HashMap<>();


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

    synchronized HashMap<Graphics.Module, Class<GraphicsLoader>> getEncoders() {
        return encoders;
    }


    public synchronized void append(Graphics.Module module, Class<GraphicsLoader> loaderClass) {
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
    synchronized GraphicsLoader getLoaderInstance(Class<GraphicsLoader> loaderClass, File file, Target target) throws Exception {
        GraphicsLoader instance = null;
        Constructor<GraphicsLoader> constructor = loaderClass.getConstructor(File.class, Target.class);
        if(constructor != null) {
            instance = constructor.newInstance(file, target);
            Graphics.Log("create object:"+instance);
        } else {
            Graphics.Log("no Constructor in :"+loaderClass.getClass().getSimpleName());
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    synchronized GraphicsLoader getLoaderInstance(Class<GraphicsLoader> loaderClass, InputStream inputStream, Target target) throws Exception {
        GraphicsLoader instance = null;
        Constructor<GraphicsLoader> constructor = loaderClass.getConstructor(InputStream.class, Target.class);
        if(constructor != null) {
            instance = constructor.newInstance(inputStream, target);
            Graphics.Log("create object:"+instance);
        } else {
            Graphics.Log("no Constructor in :"+loaderClass.getClass().getSimpleName());
        }
        return instance;
    }

}
