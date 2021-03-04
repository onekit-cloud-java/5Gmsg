package cn.onekit.cloud.nut5g.notification;

import cn.onekit.thekit.FileDB;
import cn.onekit.thekit.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class NotifyPath extends Notification {
    protected final String appId;
    protected final String echoStr;
    protected HttpServletResponse response;

    public NotifyPath(String appId, HttpServletRequest request, HttpServletResponse response, String token) throws Exception {
        super(request,token);
        this.appId = appId;
        this.request=request;
        this.response= response;
        this.echoStr = request.getHeader("echoStr");
        _checkSign(request);
    }

    public void notifyPath()  {
        response.setHeader("appid",appId);
        response.setHeader("echoStr",echoStr);
    }
}
