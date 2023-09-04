package edu.sulima.genesis.service;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSendService {
  private final JavaMailSender mailSender;
  private final WhiteBitService whiteBitService;


  public void sendRateToAll(List<String> emails) {

    SimpleMailMessage message = new SimpleMailMessage();

    message.setSubject("BTC to USD rate");

    BigDecimal rate = whiteBitService.getLastPrice();
    message.setText(rate.toString());

    message.setTo(emails.toArray(new String[0]));

    mailSender.send(message);

  }
}
