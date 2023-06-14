import java.util.HashMap;
import java.util.List;

public class ItineraryFinder {
    public static void findItenary(List<Ticket> tickets) {
        HashMap<String, String> itinerary = new HashMap<>();

        for (Ticket ticket : tickets) {
            itinerary.put(ticket.source, ticket.destination);
        }
        // finding the starting point of the itr
        String start = null;
        for (String source : itinerary.keySet()) {
            if (!itinerary.containsValue(source)) {
                start = source;
                break;
            }
        }
        String current = start;
        while (current != null) {
            System.out.print(current + " -> ");
            current = itinerary.get(current);
        }
        System.out.println("End");
    }

    public static void main(String[] args) {
        Ticket ticket1 = new Ticket("A", "B");
        Ticket ticket2 = new Ticket("C", "D");
        Ticket ticket3 = new Ticket("B", "C");
        Ticket ticket4 = new Ticket("D", "E");

        List<Ticket> tickets = List.of(ticket1, ticket2, ticket3, ticket4);

        findItenary(tickets);
    }
}

class Ticket {
    String source;
    String destination;

    Ticket(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }
}