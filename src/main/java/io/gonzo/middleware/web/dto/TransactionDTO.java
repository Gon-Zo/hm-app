package io.gonzo.middleware.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    // 거래금
    private String amount;

    // 아파트
    private String apartment;

    // 법정동
    private String courtBuilding;

    // date
    private String pickDate;

    public BigDecimal getAmount() {
        return BigDecimal.valueOf(Long.valueOf(this.amount.trim().replace(",", "")));
    }

    public String getCourtBuilding() {
        return courtBuilding.trim();
    }

    public boolean isUsed(String courtBuilding, String apartment) {
        boolean result = false;

        if(isNotEmpty(courtBuilding)){
           result = this.getCourtBuilding().equals(courtBuilding);
        }

        if(isNotEmpty(apartment)){
           result = this.apartment.equals(apartment);
        }

        return result;
    }

}