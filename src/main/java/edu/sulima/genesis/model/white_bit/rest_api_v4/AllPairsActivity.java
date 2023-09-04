package edu.sulima.genesis.model.white_bit.rest_api_v4;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AllPairsActivity {

  private Map<Integer, CurrencyInfo> currenciesInfoMap = new HashMap<>();

}
