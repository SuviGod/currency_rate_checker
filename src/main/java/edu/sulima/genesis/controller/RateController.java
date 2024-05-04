package edu.sulima.genesis.controller;

import edu.sulima.genesis.model.SendEmailsRequest;
import edu.sulima.genesis.model.SubscribeEmailRequest;
import edu.sulima.genesis.service.RateService;
import edu.sulima.genesis.service.WhiteBitService;
import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class RateController {

  private final WhiteBitService whiteBitService;

  private final RateService rateService;

  @Operation(description = "Returns last price of BTC in USD.")
  @GetMapping("/rate")
  @ResponseBody
  public BigDecimal getRate() {

    return whiteBitService.getLastPrice();
  }

  @Operation(description = "Subscribes specified email for receiving of email with last price of BTC in USD. ")
  @PostMapping("/subscribe")
  @ResponseStatus(HttpStatus.OK)
  public void subscribe(@RequestBody SubscribeEmailRequest request) {
    rateService.subscribeEmail(request.getEmail());
  }

  @Operation(description = "Sends last price of BTC in USD to all subscribed emails")
  @PostMapping("/sendSubscribedEmails")
  @ResponseStatus(HttpStatus.OK)
  public void sendSubscribedEmails() {

    rateService.sendSubscribedEmails();
  }

  @Operation(description = "Sends last price of BTC in USD to all specified emails")
  @PostMapping("/sendEmails")
  @ResponseStatus(HttpStatus.OK)
  public void sendEmails(@RequestBody SendEmailsRequest request) {
    rateService.sendEmails(request.getEmails());
  }

}
