package org.example.springsoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import soapclient.MNBArfolyamServiceSoap;
import soapclient.MNBArfolyamServiceSoapGetExchangeRatesStringFaultFaultMessage;
import soapclient.MNBArfolyamServiceSoapImpl;

@SpringBootApplication
@Controller
public class SpringSoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSoapApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/exercise";
    }

    @GetMapping("/exercise")
    public String showForm(Model model) {
        model.addAttribute("messagePrice", new MessagePrice());
        return "form";
    }

    @PostMapping("/exercise")
    public String handleForm(
            @ModelAttribute MessagePrice messagePrice,
            Model model
    ) throws MNBArfolyamServiceSoapGetExchangeRatesStringFaultFaultMessage {

        MNBArfolyamServiceSoapImpl impl = new MNBArfolyamServiceSoapImpl();
        MNBArfolyamServiceSoap service = impl.getCustomBindingMNBArfolyamServiceSoap();

        String xmlResponse = service.getExchangeRates(
                messagePrice.getStartDate(),
                messagePrice.getEndDate(),
                messagePrice.getCurrency()
        );

        String header = "Currency: " + messagePrice.getCurrency()
                + "; Start date: " + messagePrice.getStartDate()
                + "; End date: " + messagePrice.getEndDate() + ";";

        model.addAttribute("header", header);
        model.addAttribute("rawXml", xmlResponse);

        return "result";
    }
}