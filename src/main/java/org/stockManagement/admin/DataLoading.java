package org.stockManagement.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stockManagement.externalServices.quotesService;

@RestController
@RequestMapping("/admin")
public class DataLoading {

    public quotesService quotesService;
    public DataLoading(quotesService quotesService){
        this.quotesService = quotesService;
    }

    @GetMapping("/load-quotes")
    public void loadQuotes(){
        this.quotesService.fetchAllQuotes();
    }
}
