package com.yapta.travel.client;

import com.yapta.travel.core.FlightSegment;
import com.yapta.travel.core.PriceQuote;

import java.util.List;

public interface IPriceService {

    /**
     * Provides pricing for the given list of segments
     * @param segmentsToPrice the list of flight segments to provide pricing for
     * @return Returns a list of PriceQuotes for the given trip
     */
    List<PriceQuote> fetchPrices(List<FlightSegment> segmentsToPrice);
}
