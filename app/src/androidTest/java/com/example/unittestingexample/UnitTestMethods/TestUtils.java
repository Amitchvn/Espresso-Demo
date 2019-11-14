package com.example.unittestingexample.UnitTestMethods;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;

import com.jraska.falcon.FalconSpoonRule;

import java.util.Collection;
import java.util.Iterator;

public class TestUtils {

    public static Activity getCurrentActivity() {
        final Activity[] currentActivity = {null};
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            public void run() {
                Collection<Activity> resumedActivity = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                Iterator<Activity> it = resumedActivity.iterator();
                currentActivity[0] = it.next();
            }
        });

        return currentActivity[0];
    }

    public static void screenShot(FalconSpoonRule rule, String tag) {
        rule.screenshot(getCurrentActivity(), tag);
        Log.i("asd", "Screenshot taken: " + tag);
    }

    public static void showError(String msg) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getCurrentActivity());
        alertDialogBuilder.setMessage(msg);
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                              arg0.dismiss();
                            }
                        });
        /*val builder = AlertDialog.Builder(this)
        builder
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null)
                .show()*/
    }
}
