package executors;

import dto.ProgramArguments;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandLineArgumentParser {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineArgumentParser.class);
    private String[] args;
    private Options options = new Options();

    public CommandLineArgumentParser(String[] args) {
        this.args = args;
        this.options.addOption("h", "help", false, "Show help.");
        this.options.addOption("pvnum", "pvm-number", true, "Set static preemptive VM number.");
        this.options.addOption("pvmin", "pvm-min-num-replicas", true, "Set minimum number of preemptive VMs.");
        this.options.addOption("pvmax", "pvm-max-num-replicas", true, "Set maximum number of preemptive VMs.");
        this.options.addOption("vnum", "vm-number", true, "Set static VM number.");
        this.options.addOption("vmin", "vm-min-num-replicas", true, "Set minimum number of VMs.");
        this.options.addOption("vmax", "vm-max-num-replicas", true, "Set maximum number of VMs.");
    }

    public void parse() {
        DefaultParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(this.options, this.args);
            if (cmd.hasOption("h")) {
                help();
            }

            if (cmd.hasOption("pvnum")) {
                String e = cmd.getOptionValue("pvnum");
                ProgramArguments.setPreemptiveVmNumber(Integer.parseInt(e));
            }
            else {
                ProgramArguments.setPreemptiveVmNumber(1);
            }

            if (cmd.hasOption("pvmnum")) {
                String e = cmd.getOptionValue("pvnum");
                ProgramArguments.setPreemptiveVmMinNumber(Integer.parseInt(e));
            }
            else {
                ProgramArguments.setPreemptiveVmMinNumber(1);
            }

            if (cmd.hasOption("pvmin")) {
                String e = cmd.getOptionValue("pvmin");
                ProgramArguments.setPreemptiveVmMinNumber(Integer.parseInt(e));
            }
            else {
                ProgramArguments.setPreemptiveVmMinNumber(1);
            }

            if (cmd.hasOption("pvmax")) {
                String e = cmd.getOptionValue("pvmax");
                ProgramArguments.setPreemptiveVMMaxNumber(Integer.parseInt(e));
            }
            else {
                ProgramArguments.setPreemptiveVMMaxNumber(3);
            }

            if (cmd.hasOption("vnum")) {
                String e = cmd.getOptionValue("vnum");
                ProgramArguments.setVmNumber(Integer.parseInt(e));
            }
            else {
                ProgramArguments.setVmNumber(1);
            }

            if (cmd.hasOption("vmin")) {
                String e = cmd.getOptionValue("vmin");
                ProgramArguments.setVmMinNumber(Integer.parseInt(e));
            }
            else {
                ProgramArguments.setVmMinNumber(1);
            }
            if (cmd.hasOption("vmax")) {
                String e = cmd.getOptionValue("vmax");
                ProgramArguments.setVmMaxNumber(Integer.parseInt(e));
            }
            else {
                ProgramArguments.setVmMaxNumber(3);
            }
        }
        catch (ParseException var4) {
            logger.error(var4.getMessage(), var4);
        }
    }

    private void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java -jar --pvm-min [NUMBR] --pvm-max [NUMBER] --vm-min [NUMBER] --vm-max [NUMBER]", this.options);
        System.exit(0);
    }
}
