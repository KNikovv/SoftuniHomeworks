package wasteDisposal.utilities;

public class Messages {

    public static final String PROGRAM_END_COMMAND = "TimeToRecycle";
    public static final String MANAGEMENT_REQUIREMENT_CHANGED = "Management requirement changed!";
    public static final String SUCCESSFULLY_PROCESSED_TYPE = "%.2f kg of %s successfully processed!";
    public static final String FAILED_TO_PROCESS_TYPE = "Processing Denied!";
    public static final String FAILED_TO_GET_STRATEGY = " \"The passed in garbage does not implement an annotation " +
            "implementing the Disposable \" +\n" +
            "                            \"meta-annotation or is not supported by the StrategyHolder.\"";
    public static final String NO_BAN_YET = "No type banned yet";
    public static final String STATUS_REPORT_MESSAGE = "Energy: %.2f Capital: %.2f";

}
