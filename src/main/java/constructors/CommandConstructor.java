package constructors;

import dto.ProgramArguments;

/**
 * Construct commands that will be executed by gcloud
 */
public class CommandConstructor {
    public static final String pvmTemplate = "pvm-ubunut-http-short";
    public static final String vmTemplate = "vm-ubunut-http-short";

    public static String createPreemptiveInstanceGroup(String uuid) {
        return "gcloud compute instance-groups managed create pvm-" + uuid + " " +
                "--base-instance-name pvm-" + uuid + " " +
                "--size " + ProgramArguments.getPreemptiveVmNumber() + " " +
                "--template " + pvmTemplate;
    }

    public static String createPreemptiveAutoScaling(String uuid) {
        return "gcloud compute instance-groups managed set-autoscaling pvm-" + uuid + " " +
                "--min-num-replicas " + ProgramArguments.getPreemptiveVmMinNumber() + " " +
                "--max-num-replicas " + ProgramArguments.getPreemptiveVMMaxNumber();
    }

    public static String createInstanceGroup(String uuid) {
        return "gcloud compute instance-groups managed create vm-" + uuid + " " +
                "--base-instance-name vm-" + uuid + " " +
                "--size " + ProgramArguments.getVmNumber() + " " +
                "--template " + vmTemplate;
    }

    public static String createAutoScaling(String uuid) {
        return "gcloud compute instance-groups managed set-autoscaling vm-" + uuid + " " +
                "--min-num-replicas " + ProgramArguments.getVmMinNumber() + " " +
                "--max-num-replicas " + ProgramArguments.getVmMaxNumber();
    }
}
