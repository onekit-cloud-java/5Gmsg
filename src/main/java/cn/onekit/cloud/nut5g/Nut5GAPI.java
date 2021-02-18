package cn.onekit.cloud.nut5g;

import cn.onekit.cloud.nut5g.entity.Nut5GError;
import cn.onekit.cloud.nut5g.entity.accessToken;

public interface Nut5GAPI {

    accessToken accessToken(String appId, String appKey) throws Nut5GError;
    update_ChatBotInfo update_ChatBotInfo(String appId, String appKey) throws Nut5GError;

}
