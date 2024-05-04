package edu.sulima.genesis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SendEmailsRequest {
    private List<String> emails;
}
