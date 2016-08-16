package com.yapta.travel.core;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.joda.money.Money;

public class PriceQuote {

    private final Money price;
    private final ClassOfService classOfService;

    public PriceQuote(Money price, ClassOfService classOfService) {

        this.price = price;
        this.classOfService = classOfService;
    }

    public Money getPrice() {
        return price;
    }

    public ClassOfService getClassOfService() {
        return classOfService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceQuote that = (PriceQuote) o;
        return Objects.equal(getPrice(), that.getPrice()) &&
                getClassOfService() == that.getClassOfService();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPrice(), getClassOfService());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("price", price)
                .add("classOfService", classOfService)
                .toString();
    }
}
