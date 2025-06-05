public class midPriorityConcreteCreator extends RequestConcreator {

    @Override
    public requestProduct createRequest() {
        return new midPriorityConcrete();
    }
    
}
