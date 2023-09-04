package edu.sulima.genesis.model.white_bit.web_socket;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class WhiteBitWebSocketRequest {
  private int id;
  private String method;
  private List<String> params;

}
