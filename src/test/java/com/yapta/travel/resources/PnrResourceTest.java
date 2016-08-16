package com.yapta.travel.resources;

import com.yapta.travel.client.IPnrService;
import com.yapta.travel.client.PnrNotFoundException;
import com.yapta.travel.client.PnrService;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.*;

import static org.mockito.Mockito.*;

public class PnrResourceTest {

    public static final IPnrService mockPnrService = mock(PnrService.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PnrResource(mockPnrService))
            .build();

    @After
    public void tearDown() {
        reset(mockPnrService);
    }

    @Test
    public void testGetPnrReturnsExpectedPnrGivenExistingPnr() throws PnrNotFoundException {
        //Arrange
        String expectedPnr = "EXPECTED PNR";
        when(mockPnrService.fetchPnr("ABC123")).thenReturn(expectedPnr);

        //Act
        String actualPnr = resources.client().target("/pnrs/ABC123").request().get(String.class);

        //Assert
        Assert.assertEquals(expectedPnr, actualPnr);
        verify(mockPnrService).fetchPnr("ABC123");
    }

    @Test
    public void testGetPnrReturnsNotFoundMessageGivenNonExistingPnr() throws PnrNotFoundException {
        //Arrange
        when(mockPnrService.fetchPnr("NONPNR")).thenThrow(new PnrNotFoundException());
        String expectedResponse = "PNR NOT FOUND";
        //Act
        String actualResponse = resources.client().target("/pnrs/NONPNR").request().get(String.class);

        //Assert
        Assert.assertEquals(expectedResponse, actualResponse);
    }

}
