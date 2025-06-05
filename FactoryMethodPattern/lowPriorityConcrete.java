import java.time.LocalDateTime;

public class lowPriorityConcrete implements requestProduct {
    private String priority;
    private String status;
    private String expireDay;
    
    @Override
    public void setPriority() {
      this.priority="Ignore";
    }

    @Override
    public void setExpire() {
        this.expireDay=LocalDateTime.now().toString();
    }

    @Override
    public void setStatus() {
       this.status="Done";
    }

    @Override
    public void processRequest() {
       setPriority();
       setExpire();
       setStatus();
       System.out.println("Low: Request dennied");
    }    
}
