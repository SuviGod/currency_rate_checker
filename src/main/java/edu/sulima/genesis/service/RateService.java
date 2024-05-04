package edu.sulima.genesis.service;

import jakarta.annotation.PostConstruct;
import java.io.File;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RateService {
  private final FileService fileService;

  private final EmailSendService emailSendService;

  @Value("${filepaths.email-subscriptions}")
  private String subscribedEmailsFileUri;
  private static final String subscribedEmailsFilename = "subscribedEmails.txt";



  @PostConstruct
  public void init() {
    subscribedEmailsFileUri = subscribedEmailsFileUri + File.separator + subscribedEmailsFilename;
    fileService.createFile(subscribedEmailsFileUri);
  }

  public void subscribeEmail(String email) {
    fileService.appendToFile(email + '\n', subscribedEmailsFileUri);
  }

  public void sendSubscribedEmails() {
    var emails = fileService.readAllLines(subscribedEmailsFileUri);
    emailSendService.sendRateToAll(emails);
  }

  public void sendEmails(List<String> emails) {
    emailSendService.sendRateToAll(emails);
  }
}
