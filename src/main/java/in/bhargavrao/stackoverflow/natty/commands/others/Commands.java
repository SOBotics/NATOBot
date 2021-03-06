package in.bhargavrao.stackoverflow.natty.commands.others;

import in.bhargavrao.stackoverflow.natty.commands.Command;
import in.bhargavrao.stackoverflow.natty.commands.reserved.ReservedCommand;
import in.bhargavrao.stackoverflow.natty.utils.PrintUtils;
import org.sobotics.chatexchange.chat.Message;
import org.sobotics.chatexchange.chat.Room;

import java.util.List;

/**
 * Created by bhargav.h on 30-Sep-16.
 */
public class Commands extends NormalCommand {

    private Message message;
    private List<Command> commands;

    public Commands(Message message, List<Command> commands) {
        super(message, "commands");
        this.message = message;
        this.commands = commands;
    }


    @Override
    public void execute(Room room) {
        room.replyTo(message.getId(),PrintUtils.printCommandHeader());
        StringBuilder printstr = new StringBuilder();
        boolean isAuthorized = message.getUser().isModerator() || message.getUser().isRoomOwner();
        for (Command command: commands){
            boolean authorizedCommand = command instanceof ReservedCommand;
            String cmdName = command.getName();
            String cmdDesc = command.description();
            if (cmdDesc.length() > 0 && (isAuthorized ||  !authorizedCommand)) {
                printstr.append("    ").append(padRight(cmdName, 15)).append(" - ").append(cmdDesc).append("\n");
            }
        }

        room.send(printstr.toString());
    }

    private static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    @Override
    public String description() {
        return "Returns the list of commands associated with this bot";
    }


}
