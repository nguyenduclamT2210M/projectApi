package org.example.projectapi.Enum;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum PaymentMethod {
    @JsonProperty("BANK_TRANSFER")
    BANK_TRANSFER,

    @JsonProperty("CREDIT_CARD")
    CREDIT_CARD,

    @JsonProperty("MOBILE_PAYMENT")
    MOBILE_PAYMENT,

    @JsonProperty("CASH")
    CASH
}
