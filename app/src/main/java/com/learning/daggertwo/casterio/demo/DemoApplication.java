package com.learning.daggertwo.casterio.demo;

import android.app.Application;
import android.content.Context;


/**
 * Created by wahibulhaq on 28/03/16.
 */
public class DemoApplication extends Application {

    public DemoComponent getComponent() {
        return demoComponent;
    }

    private DemoComponent demoComponent;

    @Override
    public void onCreate() {
        super.onCreate();

//        demoComponent = createComponent();
    }

//    public DemoComponent createComponent() {
//        return DaggerDemoApplicationComponent.builder()
//                .demoModule(new DemoModule())
//                .build();
//    }

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }
}
