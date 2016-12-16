package com.yapta.travel.client;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.yapta.travel.core.ClassOfService;
import com.yapta.travel.core.FlightSegment;
import com.yapta.travel.core.PriceQuote;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PriceService implements IPriceService {

    private static final ImmutableMap<List<FlightSegment>, List<PriceQuote>> pricesByFlightSegments = ImmutableMap.<List<FlightSegment>, List<PriceQuote>>builder()
            .put(Lists.newArrayList(
                    new FlightSegment("487K", "10OCT", "SEA", "LAX"),
                    new FlightSegment("487K", "18OCT", "LAX", "SEA")),
                Lists.newArrayList(
                    new PriceQuote(Money.of(CurrencyUnit.USD, 285.15), ClassOfService.ECONOMY),
                    new PriceQuote(Money.of(CurrencyUnit.USD, 29000.00), ClassOfService.FIRST),
                    new PriceQuote(Money.of(CurrencyUnit.USD, 2840.00), ClassOfService.BUSINESS),
                    new PriceQuote(Money.of(CurrencyUnit.USD, 2150.00), ClassOfService.BUSINESS)
                )
            ).build();
    @Override
    public List<PriceQuote> fetchPrices(List<FlightSegment> segmentsToPrice) {
        return Optional.ofNullable(pricesByFlightSegments.get(segmentsToPrice)).orElse(new ArrayList<>());
    }
}
