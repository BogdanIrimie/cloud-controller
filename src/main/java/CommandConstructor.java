import dto.ProgramArguments;

public class CommandConstructor
{
    public static String createPreemptiveInstanceGroup(String uuid)
    {
        return "gcloud compute instance-groups managed create pvm-" + uuid + " " + "--base-instance-name pvm-" + uuid + " " + "--size " + ProgramArguments.getPreemptiveVmNumber() + " " + "--template pvm-ubunut-http";
    }

    public static String createPreemptiveAutoScaling(String uuid)
    {
        return "gcloud compute instance-groups managed set-autoscaling pvm-" + uuid + " " + "--min-num-replicas " + ProgramArguments.getPreemptiveVmMinNumber() + " " + "--max-num-replicas " + ProgramArguments.getPreemptiveVMMaxNumber();
    }

    public static String createInstanceGroup(String uuid)
    {
        return "gcloud compute instance-groups managed create vm-" + uuid + " " + "--base-instance-name vm-" + uuid + " " + "--size " + ProgramArguments.getVmNumber() + " " + "--template vm-ubunut-http";
    }

    public static String createAutoScaling(String uuid)
    {
        return "gcloud compute instance-groups managed set-autoscaling vm-" + uuid + " " + "--min-num-replicas " + ProgramArguments.getVmMinNumber() + " " + "--max-num-replicas " + ProgramArguments.getVmMaxNumber();
    }
}
