package org.stockManagement.dtos.external.QuotesServiceDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

// Response json format
//{
//        "Meta Data": { "1. Information": "Intraday (5min) open, high, low, close prices and volume",
//        "2. Symbol": "IBM",
//        "3. Last Refreshed": "2025-11-26 18:55:00",
//        "4. Interval": "5min",
//        "5. Output Size": "Compact",
//        "6. Time Zone": "US/Eastern"
//        },
//        "Time Series (5min)": {
//        "2024-12-04 19:55:00": { "1. open": "303.9409", "2. high": "303.9409", "3. low": "303.6600", "4. close": "303.6600", "5. volume": "172" },
//        "2024-12-04 19:50:00": { "1. open": "..." , ... },
//        ...
//        }
//}


@Getter
@Setter
public class ExternalQuotesResponseDTO {

    @JsonProperty("Meta Data")
    private Object metaData;

    @JsonProperty("Time Series (Daily)")
    private HashMap<String, OHLCdata> timeSeries;
}
