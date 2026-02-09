package main.designs.adaptor;

import main.designs.common.Icon;
import main.designs.common.MessageInterface;
import main.designs.common.User;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MessageWithReactions{
    public static class MessageWithReactionsBuilder{
        private String text,time;
        private User from,to;
        private HashMap<Icon, Set<User>> reactions;

        public void setReactions(HashMap<Icon, Set<User>> reactions) {
            this.reactions = reactions;
        }

        public MessageWithReactions.MessageWithReactionsBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public MessageWithReactions.MessageWithReactionsBuilder setTime(String time) {
            this.time = time;
            return this;
        }

        public MessageWithReactions.MessageWithReactionsBuilder setFrom(User from) {
            this.from = from;
            return this;
        }

        public MessageWithReactions.MessageWithReactionsBuilder setTo(User to) {
            this.to = to;
            return this;
        }
        public MessageWithReactions build(){
            return new MessageWithReactions(this);
        }
    }
    private String text,time;
    private User from,to;
    private HashMap<Icon, Set<User>> reactions;
    private MessageWithReactions(MessageWithReactions.MessageWithReactionsBuilder builder){
        text = Objects.requireNonNull(builder.text);
        time = builder.time;
        from = builder.from;
        to = builder.to;
        this.reactions = Objects.requireNonNullElseGet(builder.reactions, HashMap::new);
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

    public HashMap<Icon, Set<User>> getReactions() {
        return reactions;
    }

    public void setReactions(HashMap<Icon, Set<User>> reactions) {
        this.reactions = reactions;
    }

    @Override
    public String toString(){
        return "MessageWithReactions from " + from.name() + " : " + text + " to " + to.name() +
                " at : " + time;
    }
}
