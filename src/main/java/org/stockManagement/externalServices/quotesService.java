package org.stockManagement.externalServices;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.stockManagement.dtos.external.QuotesServiceDTO.ExternalQuotesResponseDTO;
import org.stockManagement.dtos.external.QuotesServiceDTO.OHLCdata;
import org.stockManagement.entities.OHLC;
import org.stockManagement.repositories.quotesRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Slf4j
@Service
public class quotesService {
    private final String url = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY";

    @Autowired
    private quotesRepository quotesRepository;

    @Value("${external.api-key.alpha-vantage}")
    private String apiKey;

    public void getQuotes(String sym, String interval) {
        String temp1 = String.format("&symbol=%s&interval=%s&apikey=%s", sym, interval, apiKey);
        String finalUrl = url + temp1;
        log.info("Hitting url: {}", finalUrl);
        RestTemplate template = new RestTemplate();
        ResponseEntity<ExternalQuotesResponseDTO> response = template.getForEntity(finalUrl, ExternalQuotesResponseDTO.class);

        if(response.getBody() != null) {

            HashMap<String, OHLCdata> timeSeries = response.getBody().getTimeSeries();
            List<OHLC> quotes = new ArrayList<>();
            for (String timeStamp : timeSeries.keySet()) {
                OHLCdata ohlc = timeSeries.get(timeStamp);
                OHLC datapoint = new OHLC(sym, ohlc.getOpen(),
                        ohlc.getHigh(),
                        ohlc.getLow(),
                        ohlc.getClose(),
                        ohlc.getVolume(),
                        timeStamp);
                quotes.addLast(datapoint);

            }
            quotesRepository.saveAll(quotes);
        }
    }

    public boolean fetchAllQuotes(){
        String[] quotes = {"AAPL","MSFT", "IBM"};
        for (String quote : quotes) {
            getQuotes(quote, "5min");
        }
        return true;
    }

}
