package edu.sulima.genesis.service;
import edu.sulima.genesis.model.white_bit.rest_api_v4.CurrencyInfo;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class WhiteBitService {
  private final WebClient webSocketWC;
  public BigDecimal getLastPrice(){

    Map<String, CurrencyInfo> response = webSocketWC
        .get()
        .uri("/api/v4/public/ticker")
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<Map<String, CurrencyInfo>>() {})
        .block();

    return Optional.ofNullable(response.get("BTC_USD"))
        .map(CurrencyInfo::getLast_price)
        .orElse(new BigDecimal(0));
  }
}
