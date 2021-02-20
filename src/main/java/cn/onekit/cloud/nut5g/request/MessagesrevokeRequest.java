package cn.onekit.cloud.nut5g.request;

import java.util.ArrayList;

public class MessagesrevokeRequest {
    private String messageId;
    private final String status = "RevokeRequested";
    private ArrayList<String> destinationAddress;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<String> getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(ArrayList<String> destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
}
