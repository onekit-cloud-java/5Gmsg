package cn.onekit.cloud.nut5g.notification;

import cn.onekit.cloud.nut5g.notification.request.StatusNotification;
import cn.onekit.thekit.JSON;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
public class DeliveryNotification extends Nut5GNotify{


    public DeliveryNotification(HttpServletRequest request, String signKey) throws Exception {
        super(request, signKey);
    }

    public  StatusNotification status() throws Exception{
        return JSON.string2object(_receiveJson(request),StatusNotification.class);
    }
}
