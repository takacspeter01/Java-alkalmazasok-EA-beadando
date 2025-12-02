package org.example.springsoap.controller;

import org.example.springsoap.client.OandaClient;
import org.example.springsoap.dto.AccountInfo;
import org.example.springsoap.dto.PriceInfo;
import org.example.springsoap.dto.CandleInfo;
import org.example.springsoap.dto.PositionInfo;
import java.util.List;
import org.example.springsoap.dto.OrderResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ForexController {

    private final OandaClient oandaClient;

    public ForexController(OandaClient oandaClient) {
        this.oandaClient = oandaClient;
    }

    @GetMapping("/forex-account")
    public String showAccount(Model model) {
        AccountInfo accountInfo = oandaClient.getAccountInfo();
        model.addAttribute("account", accountInfo);
        return "forex-account";
    }

    @GetMapping("/forex-aktar")
    public String showAktArForm(Model model) {
        String[] instruments = {"EUR_USD", "GBP_USD", "USD_JPY"};
        model.addAttribute("instruments", instruments);
        return "forex-aktar";
    }

    @PostMapping("/forex-aktar")
    public String handleAktAr(
            @RequestParam("instrument") String instrument,
            Model model
    ) {
        String[] instruments = {"EUR_USD", "GBP_USD", "USD_JPY"};
        model.addAttribute("instruments", instruments);
        model.addAttribute("selectedInstrument", instrument);

        PriceInfo priceInfo = oandaClient.getCurrentPrice(instrument);
        model.addAttribute("price", priceInfo);

        return "forex-aktar";
    }
    /*
@GetMapping("/forex-histar")
public String showHistArForm(Model model) {
    String[] instruments = {"EUR_USD", "GBP_USD", "USD_JPY"};
    String[] granularities = {"S5", "M1", "H1", "D"};

    model.addAttribute("instruments", instruments);
    model.addAttribute("granularities", granularities);

    return "forex-histar";
}

@PostMapping("/forex-histar")
public String handleHistAr(
        @RequestParam("instrument") String instrument,
        @RequestParam("granularity") String granularity,
        Model model
) {
    String[] instruments = {"EUR_USD", "GBP_USD", "USD_JPY"};
    String[] granularities = {"S5", "M1", "H1", "D"};

    model.addAttribute("instruments", instruments);
    model.addAttribute("granularities", granularities);
    model.addAttribute("selectedInstrument", instrument);
    model.addAttribute("selectedGranularity", granularity);

    List<CandleInfo> candles = oandaClient.getHistoricalPrices(instrument, granularity, 10);
    model.addAttribute("candles", candles);

    return "forex-histar";
}
*/
    /*
    // ===== Forex-Nyit – form + order =====
@GetMapping("/forex-nyit")
public String showNyitForm(Model model) {
    String[] instruments = {"EUR_USD", "GBP_USD", "USD_JPY"};
    model.addAttribute("instruments", instruments);
    return "forex-nyit";
}

@PostMapping("/forex-nyit")
public String handleNyit(
        @RequestParam("instrument") String instrument,
        @RequestParam("units") int units,
        Model model
) {
    String[] instruments = {"EUR_USD", "GBP_USD", "USD_JPY"};
    model.addAttribute("instruments", instruments);
    model.addAttribute("selectedInstrument", instrument);
    model.addAttribute("enteredUnits", units);

    OrderResult result = oandaClient.openMarketOrder(instrument, units);
    model.addAttribute("orderResult", result);

    return "forex-nyit";
}

@GetMapping("/forex-poz")
public String showPositions(Model model) {
    List<PositionInfo> positions = oandaClient.getOpenPositions();
    model.addAttribute("positions", positions);
    return "forex-poz";
}


     */


}
