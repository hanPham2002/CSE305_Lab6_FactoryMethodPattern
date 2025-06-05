public class lowPriorityConcreteCreator extends RequestConcreator {
    
    @Override
    public requestProduct createRequest() {
        return new lowPriorityConcrete();
    }
}

