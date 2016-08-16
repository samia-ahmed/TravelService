package com.yapta.travel.client;

import com.yapta.travel.core.Ticket;

import java.util.List;

public interface ITicketService {

    /**
     * Returns details about the given ticket
     * @param ticketNumber The ticketNumber to look up
     */
    Ticket fetchTicket(String ticketNumber) throws TicketNotFoundException;
}
