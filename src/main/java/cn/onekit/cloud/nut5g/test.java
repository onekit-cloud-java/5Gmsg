package cn.onekit.cloud.nut5g;

import cn.onekit.cloud.nut5g.request.MessagesRequest;
import cn.onekit.thekit.JSON;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class test {
    public static void main(String[] args) {
        MessagesRequest.GeoMessage geoMessage = new MessagesRequest.GeoMessage();
        MessagesRequest.GeoMessage.ContentText contentText = new MessagesRequest.GeoMessage.ContentText();
        contentText.setLatitude(7.0914591f);
        contentText.setLongitude(50.7311865f);
        contentText.setCrs("gcj02");
        contentText.setU(10);
        contentText.setRcs_l("Qingfeng Steamed Dumpling Shop \uD83C\uDF5A");
        geoMessage.setContentText(contentText);
        System.out.println(JSON.object2string(geoMessage));

    }
}
