public class main {
    public static void main(String[] args) {
      RequestConcreator low = new lowPriorityConcreteCreator();
      low.processRequest();

      RequestConcreator mid = new midPriorityConcreteCreator();
      mid.processRequest();

      RequestConcreator high = new hiPriorityConcreteCreator();
      high.processRequest();
    }
}
