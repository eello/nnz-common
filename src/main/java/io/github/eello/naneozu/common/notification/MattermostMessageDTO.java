package io.github.eello.naneozu.common.notification;

import io.github.eello.naneozu.common.exception.CustomException;
import io.github.eello.naneozu.common.exception.ErrorCode;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class MattermostMessageDTO {

    public static class Attachments {
        private Props props;
        private List<Attachment> attachments;

        public Attachments() {
            attachments = new ArrayList<>();
        }

        public Attachments(List<Attachment> attachments) {
            this.attachments = attachments;
        }

        public Attachments(Attachment attachment) {
            this();
            this.attachments.add(attachment);
        }

        public void addProps(Exception e) {
            props = new Props(e);
        }

    }

    public static class Attachment {
        private String channel;

        private String pretext;

        private String color;

        private String author_name;

        private String author_icon;

        private String title;

        private String text;

        private String footer;

        public Attachment(Builder builder) {
            this.channel = builder.channel;
            this.pretext = builder.pretext;
            this.color = builder.color;
            this.author_name = builder.author_name;
            this.author_icon = builder.author_icon;
            this.title = builder.title;
            this.text = builder.text;
            this.footer = builder.footer;
        }

        public Attachment addExceptionInfo(Exception e) {
            this.title = e.getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(text);

            if (e instanceof CustomException) {
                ErrorCode errorCode = ((CustomException) e).getErrorCode();
                sb.append("`Code: ").append(errorCode.getCode()).append("`\n")
                        .append("`Message: ").append(errorCode.getMessage()).append("`\n\n");
            } else {
                sb.append("**Error Message**").append("\n").append("\n").append("```").append(e.getMessage()).append("```")
                        .append("\n").append("\n");
            }

            this.text = sb.toString();

            return this;
        }

        public Attachment addExceptionInfo(Exception e, String uri) {
            this.addExceptionInfo(e);
            StringBuilder sb = new StringBuilder(text);

            sb.append("**Reqeust URL**").append("\n").append("\n").append(uri).append("\n").append("\n");

            this.text = sb.toString();
            return this;
        }

        public Attachment addExceptionInfo(Exception e, String uri, String params) {
            this.addExceptionInfo(e, uri);
            StringBuilder sb = new StringBuilder(text);

            sb.append("**Parameters**").append("\n").append("\n")
                    .append(params.toString()).append("\n").append("\n");

            this.text = sb.toString();
            return this;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getPretext() {
            return pretext;
        }

        public void setPretext(String pretext) {
            this.pretext = pretext;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public String getAuthor_icon() {
            return author_icon;
        }

        public void setAuthor_icon(String author_icon) {
            this.author_icon = author_icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getFooter() {
            return footer;
        }

        public void setFooter(String footer) {
            this.footer = footer;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {
            private String channel;

            private String pretext;

            private String color;

            private String author_name;

            private String author_icon;

            private String title;

            private String text;

            private String footer;

            public Builder channel(String channel) {
                this.channel = channel;
                return this;
            }

            public Builder pretext(String pretext) {
                this.pretext = pretext;
                return this;
            }

            public Builder color(String color) {
                this.color = color;
                return this;
            }

            public Builder author_name(String author_name) {
                this.author_name = author_name;
                return this;
            }

            public Builder author_icon(String author_icon) {
                this.author_icon = author_icon;
                return this;
            }

            public Builder title(String title) {
                this.title = title;
                return this;
            }

            public Builder text(String text) {
                this.text = text;
                return this;
            }

            public Builder footer(String footer) {
                this.footer = footer;
                return this;
            }

            public Attachment build() {
                return new Attachment(this);
            }
        }

    }


    public static class Props {
        private String card;

        public Props(Exception e) {
            StringBuilder text = new StringBuilder();

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            text.append("**Stack Trace**").append("\n").append("\n").append("```");
            text.append(sw.toString().substring(0,
                    Math.min(5500, sw.toString().length())) + "\n...").append("\n").append("\n");

            this.card = text.toString();
        }
    }

}
