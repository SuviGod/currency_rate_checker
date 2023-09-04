package edu.sulima.genesis.model.white_bit.web_socket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WhiteBitWebSocketResponse {

  private Integer id;

  private WhiteBitWebSocketError error;

  private String result;
}
