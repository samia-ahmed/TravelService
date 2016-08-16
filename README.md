#Yapta Take Home Question: Travel Service

##Summary
Your goal here is to create a new travel service. The service has one requirement: given the record locator for an existing PNR, provide a list of lower prices in the same class of service as each of the tickets on the PNR. 

To accomplish this, you'll be integrating with a few existing web services (for the purposes of this question, the 'services' have been simplified into fake clients which return stubbed data). Each service can provide a piece of the functionality you need. Two of the services are relatively modern, and will return data to you as POJOs. Unfortunately, one of the services is decades old, and is only capable of returning text - it will be up to you to extract the data you need from this service.


##Existing Services
The following 'services' already exist in the project, and can be called to get the data you need to implement your solution:
       
```interface TicketService {

    List<Ticket> fetchTicketsOnPnr(String recordLocator)
}

interface PnrService {

    String fetchPnr(String recordLocator)
}

interface PriceService {

    List<PriceQuote> priceTrip(String origin, String destination, DateTime arrivalDate, DateTime departureDate)
}

```


##Glossary of Travel Terms

**PNR**: Stands for "Passenger Name Record". Generally speaking, it is the object that contains all the details of a trip - passenger information, flights, hotels, car rentals, etc. For this example, the PNR is simplified to contain a very small subset of the data on a real PNR.

**Record Locator**: This is the unique identifier for a PNR. Typically a 6 digit alphanumeric code, e.g. RT5Q9Y.