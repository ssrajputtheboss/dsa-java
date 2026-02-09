package main.designs.adaptor;

import main.designs.builder.Message;
import main.designs.common.MessageInterface;
import main.designs.common.User;

public class MessageWithReactionAdaptor implements MessageInterface {
    private MessageWithReactions messageWithReactions;
    public MessageWithReactionAdaptor(MessageWithReactions message){
        messageWithReactions = message;
    }
    @Override
    public String getText() {
        return messageWithReactions.getText();
    }

    @Override
    public User getFrom() {
        return messageWithReactions.getFrom();
    }

    @Override
    public User getTo() {
        return messageWithReactions.getTo();
    }

    @Override
    public String getTime() {
        return messageWithReactions.getTime();
    }
}
