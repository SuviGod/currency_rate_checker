package edu.sulima.genesis.service;

import jakarta.annotation.PostConstruct;
import java.io.File;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
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

  public void sendEmails() {
    var emails = fileService.readAllLines(subscribedEmailsFileUri);
    emailSendService.sendRateToAll(emails);
  }
}
