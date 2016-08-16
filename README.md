#Yapta Take Home Question: Travel Service

##Summary
Your goal here is to create a new travel service. The service has one requirement: given the record locator for an existing PNR, provide a list of lower prices in the same class of service as each of the tickets on the PNR. 

To accomplish this, you'll be integrating with a few existing web services (for the purposes of this question, the 'services' have been simplified into fake clients which return stubbed data). Each service can provide a piece of the functionality you need. Two of the services are relatively modern, and will return data to you as POJOs. Unfortunately, one of the services is decades old, and is only capable of returning text - it will be up to you to extract the data you need from this service.


##Existing Services
The following 'services' already exist in the project, and can be called to get the data you need to implement your solution:
       

```
#!java

interface TicketService {

    /**
     * Returns details about the given ticket
     * @param ticketNumber The ticketNumber to look up
     */
    Ticket fetchTicket(String ticketNumber) throws TicketNotFoundException;
}

interface PnrService {

    /**
     * Returns the raw PNR associated with the given record locator
     * @param recordLocator the record locator of the PNR to fetch
     * @return example:
     *      RECLOC: ABCDEF
     *      FLIGHTS:
     *      1. AS 0277850344766
     *          a. 487K 10OCT SEALAX HK1   250P  535P /DCAS*HJQTEX /E*
     *          b. 486T 18OCT LAXSEA HK1   230P  513P /DCAS*HJQTEX /E*
     *      HOTELS:
     *       …
     *
     * The "FLIGHTS" section has a list of ticket numbers, which each have a list of flight segments on the ticket. In the
     * example above, ticket number 0277850344766 is a direct, round-trip flight from SEA to LAX and back. The format of each segment is:
     * {flightNumber} {departureDate} {originDestination} {segmentStatus}   {departureTime} {arrivalTime}   /{fareLadder} /E*
     */
    String fetchPnr(String recordLocator) throws PnrNotFoundException;
}

interface PriceService {

    /**
     * Provides pricing for the given list of segments
     * @param segmentsToPrice the list of flight segments to provide pricing for
     * @return Returns a list of PriceQuotes for the given trip
     */
    List<PriceQuote> fetchPrices(List<FlightSegment> segmentsToPrice);
}
```





##Glossary of Travel Terms

**PNR**: Stands for "Passenger Name Record". Generally speaking, it is the object that contains all the details of a trip - passenger information, flights, hotels, car rentals, etc. For this example, the PNR is simplified to contain a very small subset of the data on a real PNR.

**Record Locator**: This is the unique identifier for a PNR. Typically a 6 digit alphanumeric code, e.g. RT5Q9Y.