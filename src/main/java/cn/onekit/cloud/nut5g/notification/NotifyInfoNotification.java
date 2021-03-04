package cn.onekit.
        cloud.nut5g.notification;


import cn.onekit.cloud.nut5g.notification.request.CheckNotification;
import cn.onekit.cloud.nut5g.notification.request.RcsspamNotification;
import cn.onekit.thekit.JSON;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
public class NotifyInfoNotification extends Notification {


    public  NotifyInfoNotification(HttpServletRequest request, String token) throws Exception {
        super(request, token);
    }

    public  void informationChange() throws Exception{


    }

    public  RcsspamNotification rcsspam() throws Exception{
        return JSON.string2object(_receiveJson(request),RcsspamNotification.class);
    }

    public  CheckNotification check() throws Exception {
        return JSON.string2object(_receiveJson(request),CheckNotification.class);
    }


}
