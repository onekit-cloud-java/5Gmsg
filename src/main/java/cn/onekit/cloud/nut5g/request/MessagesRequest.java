package cn.onekit.cloud.nut5g.request;

import java.util.ArrayList;

public class MessagesRequest {
    private String messageId;
    private ArrayList<Message> messageList;
    private ArrayList<String> destinationAddress;
    private String senderAddress;
    private String conversationId;
    private String contributionId;
    private ArrayList<ServiceCapability> serviceCapability;
    private String trafficType;
    private boolean smsSupported;
    private String imFormat;
    private String inReplyTo;
    private boolean storeSupported;
    private String smsContent;

    public enum reportRequest{
        sent,
        failed,
        delivered,
        displayed,
        deliveredToNetwork
    }

    public static class ServiceCapability{
        private final String capabilityId = "ChatbotSA";
        private String version;

        public String getCapabilityId() {
            return capabilityId;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }

    public static abstract class Message{
        public enum ContentType{
            text("text/plain"),
            botsuggestion("application/vnd.gsma.botsuggestion.v1.0+json"),
            botmessage("application/vnd.gsma.botmessage.v1.0+json"),
            file("application/vnd.gsma.rcs-ft-http"),
            geo("text/plain");
            ContentType(String s) {
            }
        }

        private String contentEncoding;

        public Message(ContentType contentType){
            
        }

        public String getContentEncoding() {
            return contentEncoding;
        }

        public void setContentEncoding(String contentEncoding) {
            this.contentEncoding = contentEncoding;
        }
    }

    public static class TextMessage extends Message{

        public TextMessage() {
            super(ContentType.text);
        }
        private String contentText;

        public String getContentText() {
            return contentText;
        }

        public void setContentText(String contentText) {
            this.contentText = contentText;
        }
    }

    public static class BotsuggestionMessage extends Message{
        public static class ContentText {
            private ArrayList<Suggestion> suggestions;

            public static class Suggestion {
                private Reply reply;
                private Action action;

                public static class Reply {
                    private String displayText;
                    private Postback postback;

                    public static class Postback {
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

                public static class Action {
                    private UrlAction urlAction;
                    private String displayText;
                    private Postback postback;

                    public static class Postback {
                        private String data;

                        public String getData() {
                            return data;
                        }

                        public void setData(String data) {
                            this.data = data;
                        }
                    }

                    public static class UrlAction {
                        private OpenUrl openUrl;

                        public static class OpenUrl {
                            private String url;

                            public String getUrl() {
                                return url;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }
                        }

                        public OpenUrl getOpenUrl() {
                            return openUrl;
                        }

                        public void setOpenUrl(OpenUrl openUrl) {
                            this.openUrl = openUrl;
                        }
                    }
                }

                public Reply getReply() {
                    return reply;
                }

                public void setReply(Reply reply) {
                    this.reply = reply;
                }

                public Action getAction() {
                    return action;
                }

                public void setAction(Action action) {
                    this.action = action;
                }
            }

        }

        public BotsuggestionMessage() {
            super(ContentType.botsuggestion);
        }
        private ContentText contentText;

        public ContentText getContentText() {
            return contentText;
        }

        public void setContentText(ContentText contentText) {
            this.contentText = contentText;
        }
    }

    public static class FileMessage extends Message{

        public FileMessage() {
            super(ContentType.file);
        }

        private ArrayList<ContentText> contentText;

        public static class ContentText{
            private String type;
            private String fileSize;
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

            public String getFileSize() {
                return fileSize;
            }

            public void setFileSize(String fileSize) {
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
    }

    public static class GeoMessage extends Message{
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

    public static class Botmessage extends Message{

        public Botmessage() {
            super(ContentType.botmessage);
        }

        private ContentText contentText;

        public static class ContentText{
            private CssMessage message;

            public static class CssMessage{
                private GeneralPurposeCard generalPurposeCard;

                public static class GeneralPurposeCard{
                    private Layout layout;
                    private Content content;

                    public static class Layout{
                        private String cardOrientation;
                        private String imageAlignment;
                        private ArrayList<String> titleFontStyle;
                        private ArrayList<String> descriptionFontStyle;
                        private String style;

                        public String getCardOrientation() {
                            return cardOrientation;
                        }

                        public void setCardOrientation(String cardOrientation) {
                            this.cardOrientation = cardOrientation;
                        }

                        public String getImageAlignment() {
                            return imageAlignment;
                        }

                        public void setImageAlignment(String imageAlignment) {
                            this.imageAlignment = imageAlignment;
                        }

                        public ArrayList<String> getTitleFontStyle() {
                            return titleFontStyle;
                        }

                        public void setTitleFontStyle(ArrayList<String> titleFontStyle) {
                            this.titleFontStyle = titleFontStyle;
                        }

                        public ArrayList<String> getDescriptionFontStyle() {
                            return descriptionFontStyle;
                        }

                        public void setDescriptionFontStyle(ArrayList<String> descriptionFontStyle) {
                            this.descriptionFontStyle = descriptionFontStyle;
                        }

                        public String getStyle() {
                            return style;
                        }

                        public void setStyle(String style) {
                            this.style = style;
                        }
                    }

                    public static class Content{
                        private String title;
                        private String description;
                        private Media media;
                        private ArrayList<Suggestion> suggestions;

                        public static class Media{
                            private String mediaUrl;
                            private String mediaContentType;
                            private String mediaFileSize;
                            private String thumbnailUrl;
                            private String thumbnailContentType;
                            private long thumbnailFileSize;
                            private String height;
                            private String contentDescription;

                            public String getMediaUrl() {
                                return mediaUrl;
                            }

                            public void setMediaUrl(String mediaUrl) {
                                this.mediaUrl = mediaUrl;
                            }

                            public String getMediaContentType() {
                                return mediaContentType;
                            }

                            public void setMediaContentType(String mediaContentType) {
                                this.mediaContentType = mediaContentType;
                            }

                            public String getMediaFileSize() {
                                return mediaFileSize;
                            }

                            public void setMediaFileSize(String mediaFileSize) {
                                this.mediaFileSize = mediaFileSize;
                            }

                            public String getThumbnailUrl() {
                                return thumbnailUrl;
                            }

                            public void setThumbnailUrl(String thumbnailUrl) {
                                this.thumbnailUrl = thumbnailUrl;
                            }

                            public String getThumbnailContentType() {
                                return thumbnailContentType;
                            }

                            public void setThumbnailContentType(String thumbnailContentType) {
                                this.thumbnailContentType = thumbnailContentType;
                            }

                            public long getThumbnailFileSize() {
                                return thumbnailFileSize;
                            }

                            public void setThumbnailFileSize(long thumbnailFileSize) {
                                this.thumbnailFileSize = thumbnailFileSize;
                            }

                            public String getHeight() {
                                return height;
                            }

                            public void setHeight(String height) {
                                this.height = height;
                            }

                            public String getContentDescription() {
                                return contentDescription;
                            }

                            public void setContentDescription(String contentDescription) {
                                this.contentDescription = contentDescription;
                            }
                        }

                        public static class Suggestion{
                            private Reply reply;
                            private Action action;

                            public static class Reply{
                                private String displayText;
                                private Postback postback;

                                public static class Postback {
                                    private String data;

                                    public String getPostback() {
                                        return data;
                                    }

                                    public void setPostback(String data) {
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

                            public static class Action{
                                private UrlAction urlAction;
                                private Postback postback;

                                public static class Postback {
                                    private String data;

                                    public String getPostback() {
                                        return data;
                                    }

                                    public void setPostback(String data) {
                                        this.data = data;
                                    }
                                }

                                public static class UrlAction{
                                    private OpenUrl openUrl;
                                    private String displayText;

                                    public static class OpenUrl{
                                        private String url;
                                        private String application;
                                        private String viewMode;

                                        public String getUrl() {
                                            return url;
                                        }

                                        public void setUrl(String url) {
                                            this.url = url;
                                        }

                                        public String getApplication() {
                                            return application;
                                        }

                                        public void setApplication(String application) {
                                            this.application = application;
                                        }

                                        public String getViewMode() {
                                            return viewMode;
                                        }

                                        public void setViewMode(String viewMode) {
                                            this.viewMode = viewMode;
                                        }
                                    }

                                    public String getDisplayText() {
                                        return displayText;
                                    }

                                    public void setDisplayText(String displayText) {
                                        this.displayText = displayText;
                                    }

                                    public OpenUrl getOpenUrl() {
                                        return openUrl;
                                    }

                                    public void setOpenUrl(OpenUrl openUrl) {
                                        this.openUrl = openUrl;
                                    }
                                }

                                public Postback getPostback() {
                                    return postback;
                                }

                                public void setPostback(Postback postback) {
                                    this.postback = postback;
                                }

                                public UrlAction getUrlAction() {
                                    return urlAction;
                                }

                                public void setUrlAction(UrlAction urlAction) {
                                    this.urlAction = urlAction;
                                }
                            }

                            public Reply getReply() {
                                return reply;
                            }

                            public void setReply(Reply reply) {
                                this.reply = reply;
                            }

                            public Action getAction() {
                                return action;
                            }

                            public void setAction(Action action) {
                                this.action = action;
                            }
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public String getDescription() {
                            return description;
                        }

                        public void setDescription(String description) {
                            this.description = description;
                        }

                        public Media getMedia() {
                            return media;
                        }

                        public void setMedia(Media media) {
                            this.media = media;
                        }

                        public ArrayList<Suggestion> getSuggestions() {
                            return suggestions;
                        }

                        public void setSuggestions(ArrayList<Suggestion> suggestions) {
                            this.suggestions = suggestions;
                        }
                    }

                    public Layout getLayout() {
                        return layout;
                    }

                    public void setLayout(Layout layout) {
                        this.layout = layout;
                    }

                    public Content getContent() {
                        return content;
                    }

                    public void setContent(Content content) {
                        this.content = content;
                    }
                }

                public GeneralPurposeCard getGeneralPurposeCard() {
                    return generalPurposeCard;
                }

                public void setGeneralPurposeCard(GeneralPurposeCard generalPurposeCard) {
                    this.generalPurposeCard = generalPurposeCard;
                }
            }

            public CssMessage getMessage() {
                return message;
            }

            public void setMessage(CssMessage message) {
                this.message = message;
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

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }

    public ArrayList<String> getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(ArrayList<String> destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
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

    public ArrayList<ServiceCapability> getServiceCapability() {
        return serviceCapability;
    }

    public void setServiceCapability(ArrayList<ServiceCapability> serviceCapability) {
        this.serviceCapability = serviceCapability;
    }

    public String getTrafficType() {
        return trafficType;
    }

    public void setTrafficType(String trafficType) {
        this.trafficType = trafficType;
    }

    public boolean isSmsSupported() {
        return smsSupported;
    }

    public void setSmsSupported(boolean smsSupported) {
        this.smsSupported = smsSupported;
    }

    public String getImFormat() {
        return imFormat;
    }

    public void setImFormat(String imFormat) {
        this.imFormat = imFormat;
    }

    public String getInReplyTo() {
        return inReplyTo;
    }

    public void setInReplyTo(String inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    public boolean isStoreSupported() {
        return storeSupported;
    }

    public void setStoreSupported(boolean storeSupported) {
        this.storeSupported = storeSupported;
    }

    public String getSmsContent() {
        return smsContent;
    }

    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent;
    }
}
