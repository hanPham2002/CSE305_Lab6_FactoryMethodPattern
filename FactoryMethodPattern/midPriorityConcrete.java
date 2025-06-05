import java.time.LocalDateTime;

public class midPriorityConcrete implements requestProduct {
    private String priority;
    private String status;
    private String expireDay;

    @Override
    public void setPriority() {
       this.priority="Medium";
    }

    @Override
    public void setExpire() {
        this.expireDay=LocalDateTime.now().plusMonths(1).toString();
    }

    @Override
    public void setStatus() {
       this.status="Accepted";
    }

    @Override
    public void processRequest() {
        setPriority();
        setExpire();
        setStatus();
        System.out.println("Mid: Request accept, estimated completion date is " + expireDay);
   
    }
    
}
