package pr1984.models;

import pr1984.annotations.Monitored;
import pr1984.annotations.Inject;

public class Employee extends EntityImpl {

    @Inject
    private Integer income;

    public Employee() {
        super();
    }

    @Monitored("income")
    private void setIncome(Integer income) throws NoSuchFieldException {
        Integer oldIncome = this.income;
        this.income = income;
        super.fireEvent(new ChangeEventImpl<>(
                this,
                this.getClass().getDeclaredField("income"),
                oldIncome,
                this.income));
    }

}
