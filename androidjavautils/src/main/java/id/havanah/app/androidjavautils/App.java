package id.havanah.app.androidjavautils;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by farhan at 16:14
 * on 20/04/2019.
 * Havanah Team, ID.
 */
public class App extends Application {
    public static final String TAG = App.class.getSimpleName();
    private RequestQueue requestQueue;
    private static App instance;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

    public static synchronized App getInstance() {
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue  == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag){
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req){
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag){
        if (requestQueue != null) {
            requestQueue.cancelAll(tag);
        }
    }
}
