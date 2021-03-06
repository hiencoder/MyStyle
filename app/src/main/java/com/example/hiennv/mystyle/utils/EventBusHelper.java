package com.example.hiennv.mystyle.utils;


import org.greenrobot.eventbus.EventBus;

public class EventBusHelper {
    public static void register(Object subscriber){
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(subscriber)){
            eventBus.register(subscriber);
        }
    }

    public static void unRegister(Object subscriber){
        EventBus eventBus = EventBus.getDefault();
        if (eventBus.isRegistered(subscriber)){
            eventBus.unregister(subscriber);
        }
    }

    public static void post(Object object){
        EventBus.getDefault().post(object);
    }
}
