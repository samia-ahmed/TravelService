package com.yapta.travel.client;

import com.google.common.collect.ImmutableMap;
import com.yapta.travel.core.ClassOfService;
import com.yapta.travel.core.Ticket;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.Optional;

public class TicketService implements ITicketService {

    private static final ImmutableMap<String, Ticket> ticketsByTicketNumber = ImmutableMap.<String,Ticket>builder()
            .put("0277850344766", new Ticket(Money.of(CurrencyUnit.USD, 2500.00), "0277850344766", ClassOfService.BUSINESS))
            .build();

    @Override
    public Ticket fetchTicket(String ticketNumber) throws TicketNotFoundException {
        return Optional.ofNullable(ticketsByTicketNumber.get(ticketNumber)).orElseThrow(TicketNotFoundException::new);
    }
}
