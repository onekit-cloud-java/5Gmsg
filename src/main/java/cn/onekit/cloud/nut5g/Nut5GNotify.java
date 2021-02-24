package cn.onekit.cloud.nut5g;


import cn.onekit.cloud.nut5g.notification.CheckNotification;
import cn.onekit.cloud.nut5g.notification.RcsspamNotification;
import cn.onekit.cloud.nut5g.notification.ReceivemessageNotification;
import cn.onekit.cloud.nut5g.notification.StatusNotification;
import cn.onekit.thekit.SIGN;
import org.apache.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public interface Nut5GNotify {
    default void _checkSign(HttpServletRequest request, String accessToken) throws Exception {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        List<String> list = Arrays.asList(accessToken, timestamp, nonce);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o1);
            }
        });
        String str = String.join("", list);


        if (!new SIGN(SIGN.Method.HMACSHA256).sign(str).equals(signature)) {
            throw new BadSignException();
        }
    }
    default ReceivemessageNotification receivemessage(HttpServletRequest request,String accessToken) throws Exception{
        _checkSign(request,accessToken);
        return null;
    }

    default StatusNotification status(HttpServletRequest request,String accessToken) throws Exception{
        _checkSign(request,accessToken);
        return null;
    }

    default void informationChange(HttpServletRequest request,String accessToken) throws Exception{
        _checkSign(request,accessToken);

    }

    default RcsspamNotification rcsspam(HttpServletRequest request,String accessToken) throws Exception{
        _checkSign(request,accessToken);
        return null;
    }

    default CheckNotification check(HttpServletRequest request,String accessToken) throws Exception {
        _checkSign(request,accessToken);
        return null;
    }


}
