import java.time.LocalDateTime;

public class highPriorityConcrete implements requestProduct {
    private String priority;
    private String status;
    private String expireDay;
    @Override
    public void setPriority() {
        this.priority="Emergency";
    }

    @Override
    public void setExpire() {
       this.expireDay=LocalDateTime.now().toString();
    }
    @Override
    public void setStatus() {
        this.status="Accept";
    }
    @Override
    public void processRequest() {
        setPriority();
        setExpire();
        setStatus();
        System.out.println("Hight : Emergency request, our\r\n" + //
                        "Administer will contact you immediately !”.");
    }
}
