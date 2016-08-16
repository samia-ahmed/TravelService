package com.yapta.travel.client;

import com.google.common.collect.ImmutableMap;

import java.util.Optional;

public class PnrService implements IPnrService {

    private static final ImmutableMap<String, String> pnrsByRecordLocator = ImmutableMap.<String,String>builder()
            .put("ABC123",
                    "RECLOC: ABC123\n" +
                    "      FLIGHTS:\n" +
                    "      1. AS 0277850344766\n" +
                    "          a. 487K 10OCT SEALAX HK1   250P  535P /DCAS*HJQTEX /E*\n" +
                    "          b. 486T 18OCT LAXSEA HK1   230P  513P /DCAS*HJQTEX /E*")
            .build();
    public String fetchPnr(String recordLocator) throws PnrNotFoundException {
        return Optional.ofNullable(pnrsByRecordLocator.get(recordLocator)).orElseThrow(PnrNotFoundException::new);
    }
}
