package edu.sulima.genesis.controller;

import edu.sulima.genesis.model.SubscribeRequest;
import edu.sulima.genesis.service.SubscriptionService;
import edu.sulima.genesis.service.WhiteBitService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class RateController {

  private final WhiteBitService whiteBitService;

  private final SubscriptionService subscriptionService;

  @GetMapping("/rate")
  @ResponseBody
  public BigDecimal getRate() {

    return whiteBitService.getLastPrice();
  }

  @PostMapping("/subscribe")
  @ResponseStatus(HttpStatus.OK)
  public void subscribe(@RequestBody SubscribeRequest request) {
    subscriptionService.subscribeEmail(request.getEmail());
  }

  @PostMapping("/sendEmails")
  @ResponseStatus(HttpStatus.OK)
  public void sendEmails() {

    subscriptionService.sendEmails();
  }

}
