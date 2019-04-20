package id.havanah.app.androidjavautils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;

import java.util.Set;

/**
 * Created by farhan at 16:13
 * on 20/04/2019.
 * Havanah Team, ID.
 */
public class Utils {
    private Context context;

    public Utils(Context context) {
        this.context = context;
    }

    public static float convertPixelsToDp(float px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    public static float convertDpToPixels(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    public int getScreenHeight() {
        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    public int getStatusBarHeight() {
        // status bar height
        int statusBarHeight = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }

    // Convert Array of Integer  to string
    public String convertIntArrayToString(int[] intArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : intArray) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    // Convert Set of Integer to Array of Integer
    public int[] convertSetIntegerToIntArray(Set<Integer> setInteger) {
        int[] arr = new int[setInteger.size()];
        int index = 0;
        for (Integer i : setInteger) {
            arr[index++] = i;
        }
        return arr;
    }

    public int[] convertSetIntegerToIntArray(Set<Integer> setInteger, int params) {
        int[] arr = new int[setInteger.size()];
        int index = 0;
        for (Integer i : setInteger) {
            arr[index++] = i + params;
        }
        return arr;
    }
}
