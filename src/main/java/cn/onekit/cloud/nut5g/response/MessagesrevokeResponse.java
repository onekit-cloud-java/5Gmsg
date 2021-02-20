package cn.onekit.cloud.nut5g.response;

public class MessagesrevokeResponse extends Nut5GResponse{
    private String messageId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
