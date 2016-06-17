package dto;

/**
 * Data transfer object for program arguments.
 */
public class ProgramArguments {

    private static int preemptiveVmNumber;
    private static int preemptiveVmMinNumber;
    private static int preemptiveVMMaxNumber;
    private static int vmNumber;
    private static int vmMinNumber;
    private static int vmMaxNumber;

    public static int getPreemptiveVmNumber() {
        return preemptiveVmNumber;
    }

    public static void setPreemptiveVmNumber(int preemptiveVmNumber) {
        ProgramArguments.preemptiveVmNumber = preemptiveVmNumber;
    }

    public static int getPreemptiveVmMinNumber() {
        return preemptiveVmMinNumber;
    }

    public static void setPreemptiveVmMinNumber(int preemptiveVmMinNumber) {
        ProgramArguments.preemptiveVmMinNumber = preemptiveVmMinNumber;
    }

    public static int getPreemptiveVMMaxNumber() {
        return preemptiveVMMaxNumber;
    }

    public static void setPreemptiveVMMaxNumber(int preemptiveVMMaxNumber) {
        ProgramArguments.preemptiveVMMaxNumber = preemptiveVMMaxNumber;
    }

    public static int getVmNumber() {
        return vmNumber;
    }

    public static void setVmNumber(int vmNumber) {
        ProgramArguments.vmNumber = vmNumber;
    }

    public static int getVmMinNumber() {
        return vmMinNumber;
    }

    public static void setVmMinNumber(int vmMinNumber) {
        ProgramArguments.vmMinNumber = vmMinNumber;
    }

    public static int getVmMaxNumber() {
        return vmMaxNumber;
    }

    public static void setVmMaxNumber(int vmMaxNumber) {
        ProgramArguments.vmMaxNumber = vmMaxNumber;
    }

}
