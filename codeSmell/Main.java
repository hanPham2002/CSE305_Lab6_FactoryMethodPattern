import java.util.*;

class Message {
    private final String content;
    private final String sender;
    private final String recipient;

    public Message(String content, String sender, String recipient) {
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }
}

class MessagePrinter {

    public static void printSummary(Message message) {
        System.out.println("Summary:");
        System.out.println("Content: " + message.getContent());
        System.out.println("Sender: " + message.getSender());
        System.out.println("Recipient: " + message.getRecipient());
        System.out.println("----------------------");
    }

    public static void printDetails(Message message) {
        System.out.println("Details:");
        printSummary(message);
        System.out.println("Content Length: " + message.getContent().length());
        System.out.println("Sender Uppercase: " + message.getSender().toUpperCase());
        System.out.println("Recipient Lowercase: " + message.getRecipient().toLowerCase());
        System.out.println("----------------------");
    }
}

class MessagingService {
    private final Map<String, List<Message>> inbox;

    public MessagingService() {
        this.inbox = new HashMap<>();
    }

    public void sendMessage(String content, String sender, String recipient) {
        Message message = new Message(content, sender, recipient);
        inbox.computeIfAbsent(recipient, k -> new ArrayList<>()).add(message);
    }

    public List<Message> getMessagesForRecipient(String recipient) {
        return inbox.getOrDefault(recipient, new ArrayList<>());
    }

    public void printAllMessages() {
        for (String recipient : inbox.keySet()) {
            List<Message> messages = inbox.get(recipient);
            for (Message message : messages) {
                MessagePrinter.printSummary(message);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MessagingService messagingService = new MessagingService();

        
        messagingService.sendMessage("Hello, tenant!", "Property Manager", "Tenant A");
        messagingService.sendMessage("Important notice: Rent due next week.", "Property Owner", "Tenant A");
        messagingService.sendMessage("Maintenance request received.", "Tenant A", "Property Manager");

        List<Message> tenantAMessages = messagingService.getMessagesForRecipient("Tenant A");
        for (Message message : tenantAMessages) {
            System.out.println("From: " + message.getSender() + ", Content: " + message.getContent());
        }

        Message exampleMessage = new Message("Test", "Sender", "Recipient");
        MessagePrinter.printDetails(exampleMessage);

      
        messagingService.printAllMessages();
    }
}
