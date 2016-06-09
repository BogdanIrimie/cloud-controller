package executors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Executes commands in terminal.
 */
public class CommandExecutor {
    private static final Logger logger = LoggerFactory.getLogger(CommandExecutor.class);

    public String execute(String command) {
        StringBuilder commandOutput = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);

            Field pid = process.getClass().getDeclaredField("pid");
            pid.setAccessible(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                commandOutput.append(line + "\n");
            }
            process.waitFor();
            process.exitValue();
            process.destroy();
        }
        catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        catch (NoSuchFieldException e) {
            logger.error(e.getMessage(), e);
        }

        logger.info("Command output:\n" + commandOutput.toString());
        return commandOutput.toString();
    }
}
