package cn.onekit.cloud.nut5g.notification;


import cn.onekit.cloud.nut5g.BadSignException;
import cn.onekit.thekit.SIGN;



import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unused")
public abstract class Nut5GNotify {
    protected static void _checkSign(HttpServletRequest request, String accessToken) throws Exception {
        String signature = request.getHeader("signature");
        String timestamp = request.getHeader("timestamp");
        String nonce = request.getHeader("nonce");
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

    protected static String _receiveJson(HttpServletRequest request) throws IOException {
        BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
        }
        return  responseStrBuilder.toString();
    }
}
