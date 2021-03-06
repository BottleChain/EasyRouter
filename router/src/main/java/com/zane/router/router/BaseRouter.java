package com.zane.router.router;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.zane.router.message.Message;

/**
 * Created by Zane on 2016/12/23.
 * Email: zanebot96@gmail.com
 * Blog: zane96.github.io
 */

public abstract class BaseRouter {

    public static final String ROUTER_MESSAGE = "router_message";

    public void route (Context context, Message message){
        Intent intent = new Intent();
        intent.putExtra(ROUTER_MESSAGE, message);
        isAppContext(context, intent);
        startRoute(context, intent);
    }

    private void isAppContext(Context context, Intent intent){
        if (context instanceof Application){
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
    }

    abstract void startRoute(Context context, Intent rawIntent);
}
