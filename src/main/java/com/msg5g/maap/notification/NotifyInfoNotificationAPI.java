package com.msg5g.maap.notification;


import com.msg5g.maap.notification.receive.CheckNotification;
import com.msg5g.maap.notification.receive.RcsspamNotification;


@SuppressWarnings("unused")
public interface NotifyInfoNotificationAPI {


    void informationChange() throws Exception;

    RcsspamNotification rcsspam() throws Exception;

    CheckNotification check() throws Exception;


}
