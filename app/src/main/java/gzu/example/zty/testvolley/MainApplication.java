package gzu.example.zty.testvolley;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by zty on 15-8-31.
 */
public class MainApplication extends Application {
    public  static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue= Volley.newRequestQueue(getApplicationContext());

    }
    public static RequestQueue getRequestQueue(){
        return requestQueue;
    }
}
