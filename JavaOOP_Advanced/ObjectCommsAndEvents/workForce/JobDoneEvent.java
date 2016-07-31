package workForce;

import workForce.interfaces.JobDone;

import java.util.EventObject;

public class JobDoneEvent extends EventObject implements JobDone {

    private String name;

    public JobDoneEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    @Override
    public String getResult() {
        return String.format("Job %s done!",this.name);
    }
}
