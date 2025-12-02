package org.example.springsoap.client;

import org.example.springsoap.dto.AccountInfo;
import org.example.springsoap.dto.AccountResponse;
import org.example.springsoap.dto.PriceInfo;
import org.springframework.beans.factory.annotation.Value;
import org.example.springsoap.dto.CandleInfo;
import org.example.springsoap.dto.CandleResponse;
import org.example.springsoap.dto.CandleRaw;
import org.example.springsoap.dto.CandleMid;
import org.example.springsoap.dto.PositionInfo;
import org.example.springsoap.dto.PositionsResponse;
import org.example.springsoap.dto.PositionRaw;
import org.example.springsoap.dto.PositionSide;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;


// import com.fasterxml.jackson.databind.JsonNode;


import org.example.springsoap.dto.OrderResult;
import org.springframework.http.MediaType;

@Service
public class OandaClient {

   /* private final RestTemplate restTemplate;

    @Value("${oanda.api.url}")
    private String apiUrl;

    @Value("${oanda.api.token}")
    private String apiToken;

    @Value("${oanda.account.id}")
    private String accountId;

    public OandaClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
 */
    public AccountInfo getAccountInfo() {
        /*
        String url = apiUrl + "/accounts/" + accountId;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiToken);
        headers.set("Accept", "application/json");

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<AccountResponse> response =
                    restTemplate.exchange(url, HttpMethod.GET, entity, AccountResponse.class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody().getAccount();
            } else {
                AccountInfo fallback = new AccountInfo();
                fallback.setId("N/A");
                fallback.setCurrency("N/A");
                fallback.setBalance("N/A");
                fallback.setUnrealizedPL("N/A");
                fallback.setRealizedPL("N/A");
                return fallback;
            }
        } catch (Exception e) {
            e.printStackTrace();
            AccountInfo fallback = new AccountInfo();
            fallback.setId("ERROR");
            fallback.setCurrency("?");
            fallback.setBalance("?");
            fallback.setUnrealizedPL("?");
            fallback.setRealizedPL("?");
            return fallback;
        }
    }
        }*/

        AccountInfo demo = new AccountInfo();
        demo.setId("DEMO-ACCOUNT-123");
        demo.setCurrency("EUR");
        demo.setBalance("10000.00");
        demo.setUnrealizedPL("12.34");
        demo.setRealizedPL("56.78");
        return demo;
    }

    public PriceInfo getCurrentPrice(String instrument) {
        PriceInfo price = new PriceInfo();
        price.setInstrument(instrument);

        switch (instrument) {
            case "EUR_USD":
                price.setBid("1.0900");
                price.setAsk("1.0902");
                break;
            case "GBP_USD":
                price.setBid("1.2700");
                price.setAsk("1.2703");
                break;
            case "USD_JPY":
                price.setBid("150.10");
                price.setAsk("150.13");
                break;
            default:
                price.setBid("0.0000");
                price.setAsk("0.0000");
        }

        price.setTime(java.time.ZonedDateTime.now().toString());
        return price;
    }

    /*
    *  String url = apiUrl + "/accounts/" + accountId + "/pricing?instruments=" + instrument;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiToken);
        headers.set("Accept", "application/json");

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<PriceResponse> response =
                    restTemplate.exchange(url, HttpMethod.GET, entity, PriceResponse.class);

            if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null ||
                response.getBody().getPrices() == null || response.getBody().getPrices().isEmpty()) {

                return buildErrorPrice(instrument);
            }

            Price p = response.getBody().getPrices().get(0);

            String bid = p.getBids() != null && !p.getBids().isEmpty()
                    ? p.getBids().get(0).getPrice()
                    : "N/A";

            String ask = p.getAsks() != null && !p.getAsks().isEmpty()
                    ? p.getAsks().get(0).getPrice()
                    : "N/A";

            PriceInfo info = new PriceInfo();
            info.setInstrument(p.getInstrument());
            info.setBid(bid);
            info.setAsk(ask);
            info.setTime(p.getTime());
            return info;

        } catch (Exception e) {
            e.printStackTrace();
            return buildErrorPrice(instrument);
        }
    }
    public List<CandleInfo> getHistoricalPrices(String instrument, String granularity, int count) {
        // Oanda endpoint:
        // GET /v3/instruments/{instrument}/candles?granularity=D&count=10&price=M
        String url = apiUrl
                + "/instruments/" + instrument
                + "/candles?granularity=" + granularity
                + "&count=" + count
                + "&price=M";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiToken);
        headers.set("Accept", "application/json");

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        List<CandleInfo> result = new ArrayList<>();

        try {
            ResponseEntity<CandleResponse> response =
                    restTemplate.exchange(url, HttpMethod.GET, entity, CandleResponse.class);

            if (!response.getStatusCode().is2xxSuccessful()
                    || response.getBody() == null
                    || response.getBody().getCandles() == null) {
                return result; // üres lista – nincs dobálás, nincs dummy
            }

            CandleResponse body = response.getBody();

            for (CandleRaw raw : body.getCandles()) {
                CandleMid mid = raw.getMid();
                if (mid == null) {
                    continue;
                }

                CandleInfo ci = new CandleInfo();
                ci.setInstrument(body.getInstrument());
                ci.setTime(raw.getTime());
                ci.setOpen(parsePrice(mid.getO()));
                ci.setHigh(parsePrice(mid.getH()));
                ci.setLow(parsePrice(mid.getL()));
                ci.setClose(parsePrice(mid.getC()));

                result.add(ci);
            }

        } catch (Exception e) {
            e.printStackTrace(); // konzolban látod a hibát (pl. rossz token)
        }

        return result;
    }

    private double parsePrice(String s) {
        if (s == null) return 0.0;
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    */
    /*
    // ===== Forex-Nyit – VALÓDI MARKET ORDER OANDA-N =====
    public OrderResult openMarketOrder(String instrument, int units) {
        OrderResult result = new OrderResult();
        result.setInstrument(instrument);
        result.setUnits(String.valueOf(units));

        String url = apiUrl + "/accounts/" + accountId + "/orders";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(java.util.List.of(MediaType.APPLICATION_JSON));

        // Oanda market order JSON:
    /*
      {
        "order": {
          "instrument": "EUR_USD",
          "units": "1000",
          "type": "MARKET",
          "positionFill": "DEFAULT"
        }
      }
    */
/*
        String jsonBody = String.format(
                "{\"order\":{\"instrument\":\"%s\",\"units\":\"%d\",\"type\":\"MARKET\",\"positionFill\":\"DEFAULT\"}}",
                instrument, units
        );

        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

        try {
            ResponseEntity<JsonNode> response =
                    restTemplate.exchange(url, HttpMethod.POST, entity, JsonNode.class);

            if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
                result.setSuccess(false);
                result.setMessage("Nem sikerült a megbízás. HTTP: " + response.getStatusCode());
                return result;
            }

            JsonNode body = response.getBody();

            // A tipikus market order válaszban van "orderFillTransaction"
            JsonNode fill = body.get("orderFillTransaction");
            if (fill != null) {
                result.setSuccess(true);
                result.setOrderId(fill.path("id").asText());
                result.setPrice(fill.path("price").asText());
                result.setTime(fill.path("time").asText());
                // ha itt nincs units, akkor az orderCreateTransaction-ből is olvasható
                String u = fill.path("units").asText();
                if (u == null || u.isEmpty()) {
                    JsonNode create = body.get("orderCreateTransaction");
                    if (create != null) {
                        u = create.path("units").asText();
                    }
                }
                if (u != null && !u.isEmpty()) {
                    result.setUnits(u);
                }

                result.setMessage("Pozíció sikeresen nyitva.");
                return result;
            }

            // Ha nincs orderFillTransaction, próbáljunk meg hibát kiolvasni
            JsonNode err = body.get("errorMessage");
            if (err != null) {
                result.setSuccess(false);
                result.setMessage("Hiba: " + err.asText());
            } else {
                result.setSuccess(false);
                result.setMessage("Ismeretlen válasz az Oandától.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("Kivétel történt: " + e.getMessage());
        }

        return result;
    }
    */
    /*
    public List<PositionInfo> getOpenPositions() {
        String url = apiUrl + "/accounts/" + accountId + "/openPositions";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiToken);
        headers.set("Accept", "application/json");

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        List<PositionInfo> result = new ArrayList<>();

        try {
            ResponseEntity<PositionsResponse> response =
                    restTemplate.exchange(url, HttpMethod.GET, entity, PositionsResponse.class);

            if (!response.getStatusCode().is2xxSuccessful()
                    || response.getBody() == null
                    || response.getBody().getPositions() == null) {
                return result; // üres lista
            }

            for (PositionRaw raw : response.getBody().getPositions()) {
                PositionInfo pi = new PositionInfo();
                pi.setInstrument(raw.getInstrument());

                PositionSide ls = raw.getLongSide();
                if (ls != null) {
                    pi.setLongUnits(ls.getUnits());
                    pi.setLongAvgPrice(ls.getAveragePrice());
                } else {
                    pi.setLongUnits("0");
                    pi.setLongAvgPrice("-");
                }

                PositionSide ss = raw.getShortSide();
                if (ss != null) {
                    pi.setShortUnits(ss.getUnits());
                    pi.setShortAvgPrice(ss.getAveragePrice());
                } else {
                    pi.setShortUnits("0");
                    pi.setShortAvgPrice("-");
                }

                result.add(pi);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // ha exception van, visszaadunk egy üres listát → frontenden nem lesz 500
        }

        return result;
    }
 */

}

