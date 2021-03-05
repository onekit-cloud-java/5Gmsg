package com.msg5g.maap.request;

import java.util.List;
@SuppressWarnings("unused")
public class ChatBotInfomenuRequest {
    private BigMenu menu;

    public static class BigMenu{
        private List<Entries> entries;

        public static class Entries{
            private Reply reply;
            private smallMenu menu;
            private Action action;

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

            public static class smallMenu{
                private String displayText;
                private List<Entries> entries;

                public String getDisplayText() {
                    return displayText;
                }

                public void setDisplayText(String displayText) {
                    this.displayText = displayText;
                }

                public List<Entries> getEntries() {
                    return entries;
                }

                public void setEntries(List<Entries> entries) {
                    this.entries = entries;
                }
            }

            public static class Action {
                private UrlAction urlAction;
                private String displayText;
                private Postback postback;
                private DialerAction dialerAction;

                public static class  DialerAction{
                    private DialPhoneNumber dialPhoneNumber;
                    public static class DialPhoneNumber{
                        private String phoneNumber;

                        public String getPhoneNumber() {
                            return phoneNumber;
                        }

                        public void setPhoneNumber(String phoneNumber) {
                            this.phoneNumber = phoneNumber;
                        }
                    }

                    public DialPhoneNumber getDialPhoneNumber() {
                        return dialPhoneNumber;
                    }

                    public void setDialPhoneNumber(DialPhoneNumber dialPhoneNumber) {
                        this.dialPhoneNumber = dialPhoneNumber;
                    }
                }

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

                public UrlAction getUrlAction() {
                    return urlAction;
                }

                public void setUrlAction(UrlAction urlAction) {
                    this.urlAction = urlAction;
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

                public DialerAction getDialerAction() {
                    return dialerAction;
                }

                public void setDialerAction(DialerAction dialerAction) {
                    this.dialerAction = dialerAction;
                }
            }

            public Reply getReply() {
                return reply;
            }

            public void setReply(Reply reply) {
                this.reply = reply;
            }

            public smallMenu getMenu() {
                return menu;
            }

            public void setMenu(smallMenu menu) {
                this.menu = menu;
            }

            public Action getAction() {
                return action;
            }

            public void setAction(Action action) {
                this.action = action;
            }
        }

        public List<Entries> getEntries() {
            return entries;
        }

        public void setEntries(List<Entries> entries) {
            this.entries = entries;
        }
    }

    public BigMenu getMenu() {
        return menu;
    }

    public void setMenu(BigMenu menu) {
        this.menu = menu;
    }
}
