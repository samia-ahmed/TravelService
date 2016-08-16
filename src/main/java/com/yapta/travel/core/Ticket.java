package com.yapta.travel.core;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.joda.money.Money;

public class Ticket {

    private final Money price;
    private final String ticketNumber;
    private final ClassOfService classOfService;

    public Ticket(Money price, String ticketNumber, ClassOfService classOfService) {

        this.price = price;
        this.ticketNumber = ticketNumber;
        this.classOfService = classOfService;
    }

    public Money getPrice() {
        return price;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public ClassOfService getClassOfService() {
        return classOfService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equal(getPrice(), ticket.getPrice()) &&
                Objects.equal(getTicketNumber(), ticket.getTicketNumber()) &&
                getClassOfService() == ticket.getClassOfService();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPrice(), getTicketNumber(), getClassOfService());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("price", price)
                .add("ticketNumber", ticketNumber)
                .add("classOfService", classOfService)
                .toString();
    }
}
