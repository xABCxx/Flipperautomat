import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {

    // Ein Kompositum das mehrere Commands enthält und beim "execute" all diese Commands ausführt.
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
