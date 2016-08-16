package com.yapta.travel.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PnrServiceTest {

    IPnrService pnrService = new PnrService();

    @Test
    public void fetchPnrReturnsExpectedStringGivenExistingRecordLocator() throws PnrNotFoundException {
        //Arrange
        String recordLocator = "ABC123";
        String expectedPnr =
                "RECLOC: ABC123\n" +
                "      FLIGHTS:\n" +
                "      1. AS 0277850344766\n" +
                "          a. 487K 10OCT SEALAX HK1   250P  535P /DCAS*HJQTEX /E*\n" +
                "          b. 486T 18OCT LAXSEA HK1   230P  513P /DCAS*HJQTEX /E*";
        //Act
        String actualPnr = pnrService.fetchPnr(recordLocator);

        //Assert
        Assert.assertEquals(expectedPnr, actualPnr);
    }

    @Test(expected=PnrNotFoundException.class)
    public void fetchPnrThrowsPnrNotFoundExceptionGivenNonExistingRecordLocator() throws PnrNotFoundException {
        //Arrange
        String recordLocator = "NOT123";

        //Act
        pnrService.fetchPnr(recordLocator);
    }


}
