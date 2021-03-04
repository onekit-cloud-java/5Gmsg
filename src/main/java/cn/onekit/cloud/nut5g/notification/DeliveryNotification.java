package cn.onekit.cloud.nut5g.notification;

import cn.onekit.cloud.nut5g.notification.request.StatusNotification;
import cn.onekit.thekit.JSON;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("unused")
public class DeliveryNotification extends Nut5GNotify{
    public static StatusNotification status(HttpServletRequest request, String accessToken) throws Exception{
        _checkSign(request,accessToken);
        return JSON.string2object(_receiveJson(request),StatusNotification.class);
    }
}
