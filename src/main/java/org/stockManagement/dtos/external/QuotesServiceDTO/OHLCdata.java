package org.stockManagement.dtos.external.QuotesServiceDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

// { "1. open": "303.9409", "2. high": "303.9409", "3. low": "303.6600", "4. close": "303.6600", "5. volume": "172" },

@Getter
@Setter
public class OHLCdata {

    @JsonProperty("2. high")
    public float high;
    @JsonProperty("3. low")
    public float low;
    @JsonProperty("4. close")
    public float close;
    @JsonProperty("5. volume")
    public float volume;
    @JsonProperty("1. open")
    private float open;
}
