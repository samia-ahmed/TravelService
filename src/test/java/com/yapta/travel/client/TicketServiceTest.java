package com.yapta.travel.client;

import com.yapta.travel.core.ClassOfService;
import com.yapta.travel.core.Ticket;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;

public class TicketServiceTest {

    private ITicketService ticketService = new TicketService();

    @Test
    public void fetchTicketShouldReturnExpectedTicketGivenExistingTicketNumber() throws TicketNotFoundException {
        //Arrange
        String ticketNumber = "0277850344766";
        Ticket expectedTicket = new Ticket(Money.of(CurrencyUnit.USD, 2500.00), "0277850344766", ClassOfService.BUSINESS);

        //Act
        Ticket actualTicket = ticketService.fetchTicket(ticketNumber);

        //Assert
        Assert.assertEquals(expectedTicket, actualTicket);
    }

    @Test(expected = TicketNotFoundException.class)
    public void fetchTicketShouldThrowTicketNotFoundExceptionGivenNonExistingTicketNumber() throws TicketNotFoundException {
        //Arrange

        //Act
        ticketService.fetchTicket("0000000000000");

        //Assert
    }
}
