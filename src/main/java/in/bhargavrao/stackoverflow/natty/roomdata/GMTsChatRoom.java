package in.bhargavrao.stackoverflow.natty.roomdata;

import in.bhargavrao.stackoverflow.natty.commandlists.GMTsCommandsList;
import in.bhargavrao.stackoverflow.natty.printers.GmtsPostPrinter;
import in.bhargavrao.stackoverflow.natty.printers.PostPrinter;
import in.bhargavrao.stackoverflow.natty.services.ReplyHandlerService;
import in.bhargavrao.stackoverflow.natty.services.RunnerService;
import in.bhargavrao.stackoverflow.natty.validators.GMTsValidator;
import in.bhargavrao.stackoverflow.natty.validators.Validator;
import org.sobotics.chatexchange.chat.ChatHost;
import org.sobotics.chatexchange.chat.Room;
import org.sobotics.chatexchange.chat.event.MessageReplyEvent;
import org.sobotics.chatexchange.chat.event.UserMentionedEvent;

import java.util.function.Consumer;

/**
 * Created by bhargav.h on 28-Dec-16.
 */
public class GMTsChatRoom implements BotRoom{
    @Override
    public int getRoomId() {
        return 75819;
    }

    @Override
    public Consumer<UserMentionedEvent> getMention(Room room, RunnerService service) {
        return event->new GMTsCommandsList().mention(room, event, service, getSiteName(), getSiteUrl(), true);
    }

    @Override
    public Consumer<MessageReplyEvent> getReply(Room room) {
        return event-> new ReplyHandlerService().reply(room, event, getSiteName(), getSiteUrl(), true);
    }

    @Override
    public Validator getValidator() {
        return new GMTsValidator();
    }

    @Override
    public double getNaaValue() {
        return 3.5;
    }

    @Override
    public PostPrinter getPostPrinter() {
        return new GmtsPostPrinter();
    }

    @Override
    public boolean getIsLogged() {
        return false;
    }

    @Override
    public ChatHost getHost() {
        return ChatHost.STACK_OVERFLOW;
    }

    @Override
    public String getSiteName() {
        return "stackoverflow";
    }

    @Override
    public String getSiteUrl() {
        return "stackoverflow.com";
    }
}
