package edu.sulima.genesis.model.white_bit.rest_api_v4;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CurrencyInfo {

  private int base_id;
  private int quote_id;
  private BigDecimal last_price;
  private BigDecimal quote_volume;
  private BigDecimal base_volume;
  private boolean isFrozen;
  private BigDecimal change;
}
