package com.xiaoge.graphics.animategraphics.core;

import android.util.Log;
import android.widget.ImageView;


import com.xiaoge.graphics.animategraphics.core.target.Target;

import java.io.File;
import java.util.HashMap;

/**
 * Created by zhanglei on 2017/9/8.
 */

public class Graphics {

    private static final String TAG = "Graphics";
    private static final boolean DEBUG = false;

    public static Graphics get() {
        return new Graphics();
    }

    private Graphics() {

    }

    public static boolean isSupported(File file) {
        HashMap<Module, Class<GraphicsLoader>> encoders = get().getRegistry().getEncoders();

        for(Module module : encoders.keySet()) {
            if(module.isSupport(file)) {
                return true;
            }
        }
        return false;
    }

    public GraphicsLoader load(File data, Target target) throws Exception {
        GraphicsLoader graphicsLoader = null;
        HashMap<Module, Class<GraphicsLoader>> encoders = getRegistry().getEncoders();

        for(Module module : encoders.keySet()) {
            if(module.isSupport(data)) {
                Class<GraphicsLoader> loader =  encoders.get(module);
                graphicsLoader = getRegistry().getLoaderInstance(loader, data, target);
                break;
            }
        }
        Log.d(TAG, "graphicsLoader:"+graphicsLoader);
        return graphicsLoader;
    }

    public Registry getRegistry() {
        return Registry.get();
    }

    public interface GraphicsLoader {
        void into (ImageView view);
    }

    public interface Module {
        boolean isSupport (File data);
    }

    public static void Log(String log){
        if(DEBUG) {
            Log.d(Graphics.TAG, log);
        }
    }

    public static void Log(String TAG, String log){
        if(DEBUG) {
            Log.d(TAG, log);
        }
    }

}
