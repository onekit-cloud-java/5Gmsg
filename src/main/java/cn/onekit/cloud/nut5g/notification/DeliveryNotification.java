package cn.onekit.cloud.nut5g.notification;

import cn.onekit.cloud.nut5g.notification.request.StatusNotification;
import cn.onekit.thekit.JSON;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
public class DeliveryNotification extends Notification {


    public DeliveryNotification(HttpServletRequest request, String token) throws Exception {
        super(request, token);
    }

    public  StatusNotification status() throws Exception{
        return JSON.string2object(_receiveJson(request),StatusNotification.class);
    }
}
