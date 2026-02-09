package main.designs.builder;

import main.designs.common.MessageInterface;
import main.designs.common.User;

public class Message implements MessageInterface {
    public static class MessageBuilder{
        private String text,time;
        private User from,to;

        public MessageBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public MessageBuilder setTime(String time) {
            this.time = time;
            return this;
        }

        public MessageBuilder setFrom(User from) {
            this.from = from;
            return this;
        }

        public MessageBuilder setTo(User to) {
            this.to = to;
            return this;
        }
        public Message build(){
            return new Message(this);
        }
    }
    private String text,time;
    private User from,to;
    private Message(MessageBuilder builder){
        text = builder.text;
        time = builder.time;
        from = builder.from;
        to = builder.to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }
    @Override
    public String toString(){
        return "Message from " + from.name() + " : " + text + " to " + to.name() +
                " at : " + time;
    }
}
