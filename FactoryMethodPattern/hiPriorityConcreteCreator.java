public class hiPriorityConcreteCreator extends RequestConcreator {

    @Override
    public requestProduct createRequest() {
      return new highPriorityConcrete();
    }
    
}
