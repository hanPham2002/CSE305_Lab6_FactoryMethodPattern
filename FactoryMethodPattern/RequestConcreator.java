public abstract class RequestConcreator {
    public abstract requestProduct createRequest();

    public void processRequest(){
        requestProduct request = createRequest();
        request.processRequest();
    }
}
