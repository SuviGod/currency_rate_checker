package edu.sulima.genesis.model.white_bit.web_socket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WhiteBitWebSocketError {
  private String message;

  private Short code;
}
