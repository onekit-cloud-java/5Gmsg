package cn.onekit.cloud.nut5g;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class test {
    public static void main(String[] args) {
       String string = "geo:50.7311865,7.0914591;crs=gcj02;u=10;rcs-l=Qingfeng%20Steamed%20Dumpling%20Shop%20%F0%9F%8D%9A";
        String[] items = string.split(";");
        String crs = items[1].split("=")[1];
        System.out.println(crs);

    }
}
