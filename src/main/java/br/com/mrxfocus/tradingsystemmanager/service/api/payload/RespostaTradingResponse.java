package br.com.mrxfocus.tradingsystemmanager.service.api.payload;

import br.com.mrxfocus.tradingsystemmanager.service.api.model.TradingAutorizado;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class RespostaTradingResponse {
    private RespostaTradingEnum autorizado;
    private TradingAutorizado tradingAutorizado;
}
