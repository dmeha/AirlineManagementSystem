package ticketBooking.EventHandlers;

import ticketBooking.DataLayer.BookTicket;
import ticketBooking.DataLayer.Payment;
import ticketBooking.View.Menu;
import ticketBooking.View.PaymentGatewayMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import RouteFinder.Flight;
public class PaymentGatewayEvent implements Event {
    private final String userName;
    private ArrayList<String> formResponse;
    private List<Flight> flights;
    public PaymentGatewayEvent(String userName, List<Flight> flights){
        this.flights = flights;
        this.userName = userName;
    }


    @Override
    public Event handle() {
        Menu menu = new PaymentGatewayMenu(this.userName);
        HashMap<String, ArrayList<String>> userResp = menu.getMenu();
        this.formResponse = userResp.get("formData");

        String option = userResp.get("option").get(0);
        return this.chooseNextEvent(Integer.parseInt(option));
    }

    public Event chooseNextEvent(int option){
        Event responseController = null;
        if(option == 0){
            responseController = new TicketBookingEvent(this.userName);

        }else if(option == 1){

            bookTicket(this.formResponse, this.flights);
            responseController = new TicketBookingEvent(this.userName);
        }
        else{
            System.out.println("Enter Valid Option");
            this.handle();
        }
        return responseController;

    }


    public void bookTicket(ArrayList<String> userPaymentInfo, List<Flight> flights){
        flights.forEach(flight->{
            //flight.price(),this.userName, userPaymentInfo.get(0);
            long transactionId = new Payment().execute(flight.price(), this.userName, userPaymentInfo.get(0));
            new BookTicket().book(this.userName, flight.flightNumber(), transactionId);
            System.out.println("Ticket Booked");
        });

    }

}
