package com.msg5g.maap.notification;


import com.msg5g.maap.notification.receive.StatusNotification;

@SuppressWarnings("unused")
public interface DeliveryNotificationAPI  {


    StatusNotification status() throws Exception;



}
