package cn.onekit.cloud.nut5g.notification;

import java.util.List;

public class ReceivemessageNotification {
    private String messageId;
    private List<Message> messageList;
    private String dateTime;
    private String senderAddress;
    private String destinationAddress;
    private String conversationId;
    private String contributionId;
    private String priority;
    private String origUser;
    private String inReplyTo;
    public enum  reportRequest{
        failed,
        delivered
    }

    public static abstract class Message{
        private final ContentType contentType;

        public enum ContentType{
            text("text/plain"),
            botsuggestion("application/vnd.gsma.botsuggestion.v1.0+json"),
            botmessage("application/vnd.gsma.botmessage.v1.0+json"),
            file("application/vnd.gsma.rcs-ft-http"),
            botsharedclientdata("application/vnd.gsma.botsharedclientdata.v1.0+json"),
            geo("text/plain");

            ContentType(String s) {

            }
        }

        public Message(ContentType contentType){
this.contentType=contentType;
        }

        private String contentEncoding;

        public String getContentEncoding() {
            return contentEncoding;
        }

        public void setContentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
        }
    }

    public static class TextMessage extends Message {
        private String contentText;

        public TextMessage() {
            super(ContentType.text);
        }

        public String getContentText() {
            return contentText;
        }

        public void setContentText(String contentText) {
            this.contentText = contentText;
        }
    }

    public static class FileMessage extends Message {

        public FileMessage() {
            super(ContentType.file);
        }
        private List<ContentText> contentText;

        public static class ContentText{
            private String type;
            private long fileSize;
            private String fileName;
            private String contentType;
            private String url;
            private String until;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public long getFileSize() {
                return fileSize;
            }

            public void setFileSize(long fileSize) {
                this.fileSize = fileSize;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getContentType() {
                return contentType;
            }

            public void setContentType(String contentType) {
                this.contentType = contentType;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUntil() {
                return until;
            }

            public void setUntil(String until) {
                this.until = until;
            }
        }

        public List<ContentText> getContentText() {
            return contentText;
        }

        public void setContentText(List<ContentText> contentText) {
            this.contentText = contentText;
        }
    }

    public static class GeoMessage extends Message {
        public static class ContentText{
            private float longitude,latitude;
            private String crs;
            private int u;
            private String rcs_l;

            @Override
            public String toString() {
                return String.format( "geo:%f,%f;crs=%s;u=%d;rcs-l=%s",longitude,latitude,crs,u,rcs_l);
            }
        }
        public GeoMessage() {
            super(ContentType.geo);
        }
        private ContentText contentText;

        public ContentText getContentText() {
            return contentText;
        }

        public void setContentText(ContentText contentText) {
            this.contentText = contentText;
        }
    }

    public static class BotsuggestionMessage extends Message {

        public BotsuggestionMessage() {
            super(ContentType.botsuggestion);
        }

        private ContentText contentText;

        public static class ContentText{
            private Response response;
            public static class Response{
                private Reply reply;

                public static class Reply{
                    private String displayText;
                    private Postback postback;

                    public static class Postback{
                        private String data;

                        public String getData() {
                            return data;
                        }

                        public void setData(String data) {
                            this.data = data;
                        }
                    }


                    public String getDisplayText() {
                        return displayText;
                    }

                    public void setDisplayText(String displayText) {
                        this.displayText = displayText;
                    }

                    public Postback getPostback() {
                        return postback;
                    }

                    public void setPostback(Postback postback) {
                        this.postback = postback;
                    }
                }

                public Reply getReply() {
                    return reply;
                }

                public void setReply(Reply reply) {
                    this.reply = reply;
                }
            }

            public Response getResponse() {
                return response;
            }

            public void setResponse(Response response) {
                this.response = response;
            }
        }

        public ContentText getContentText() {
            return contentText;
        }

        public void setContentText(ContentText contentText) {
            this.contentText = contentText;
        }
    }

    public static class BotsharedclientdataMessage extends Message {

        public BotsharedclientdataMessage() {
            super(ContentType.botsharedclientdata);
        }

        private ContentText contentText;
        public static class ContentText{
            private SharedData sharedData;

            public static class SharedData{
                private DeviceSpecifics deviceSpecifics;

                public static class DeviceSpecifics{
                    private String deviceModel;
                    private String platformVersion;
                    private String clientVendor;
                    private String clientVersion;
                    private String batteryRemainingMinutes;

                    public String getDeviceModel() {
                        return deviceModel;
                    }

                    public void setDeviceModel(String deviceModel) {
                        this.deviceModel = deviceModel;
                    }

                    public String getPlatformVersion() {
                        return platformVersion;
                    }

                    public void setPlatformVersion(String platformVersion) {
                        this.platformVersion = platformVersion;
                    }

                    public String getClientVendor() {
                        return clientVendor;
                    }

                    public void setClientVendor(String clientVendor) {
                        this.clientVendor = clientVendor;
                    }

                    public String getClientVersion() {
                        return clientVersion;
                    }

                    public void setClientVersion(String clientVersion) {
                        this.clientVersion = clientVersion;
                    }

                    public String getBatteryRemainingMinutes() {
                        return batteryRemainingMinutes;
                    }

                    public void setBatteryRemainingMinutes(String batteryRemainingMinutes) {
                        this.batteryRemainingMinutes = batteryRemainingMinutes;
                    }
                }

                public DeviceSpecifics getDeviceSpecifics() {
                    return deviceSpecifics;
                }

                public void setDeviceSpecifics(DeviceSpecifics deviceSpecifics) {
                    this.deviceSpecifics = deviceSpecifics;
                }
            }

            public SharedData getSharedData() {
                return sharedData;
            }

            public void setSharedData(SharedData sharedData) {
                this.sharedData = sharedData;
            }
        }

        public ContentText getContentText() {
            return contentText;
        }

        public void setContentText(ContentText contentText) {
            this.contentText = contentText;
        }
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getContributionId() {
        return contributionId;
    }

    public void setContributionId(String contributionId) {
        this.contributionId = contributionId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getOrigUser() {
        return origUser;
    }

    public void setOrigUser(String origUser) {
        this.origUser = origUser;
    }

    public String getInReplyTo() {
        return inReplyTo;
    }

    public void setInReplyTo(String inReplyTo) {
        this.inReplyTo = inReplyTo;
    }
}
