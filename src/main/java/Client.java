import constructors.CommandConstructor;
import executors.CommandExecutor;
import executors.CommandLineArgumentParser;
import java.util.UUID;

public class Client {
    public static void main(String[] args) {
        String uuid = null;
        String commandOutput = null;

        // Parse commands line arguments
        new CommandLineArgumentParser(args).parse();

        CommandExecutor commandExecutor = new CommandExecutor();

        // Create instance group and auto scalling for preemptive VMs.
        uuid = UUID.randomUUID().toString().substring(0, 8).toLowerCase();
        commandOutput = commandExecutor.execute(CommandConstructor.createPreemptiveInstanceGroup(uuid));
        commandOutput = commandExecutor.execute(CommandConstructor.createPreemptiveAutoScaling(uuid));

        // Create instance group and auto scaling for VMs.
        uuid = UUID.randomUUID().toString().substring(0, 8).toLowerCase();
        commandOutput = commandExecutor.execute(CommandConstructor.createInstanceGroup(uuid));
        commandOutput = commandExecutor.execute(CommandConstructor.createAutoScaling(uuid));
    }
}