package com.example.googleactionswebhook.google.api.generic;

import com.example.googleactionswebhook.google.api.GAUserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GAOrder {
    private String googleOrderId;
    private String merchantOrderId;
    private String userVisibleOrderId;
    private String userVisibleStateLabel;
    private GAUserInfo buyerInfo;
    private GAImage image;
    private String createTime;
    private String lastUpdateTime;
    private GAMerchant transactionMerchant;
    private GAContents contents;
    private List<GAPriceAttribute> priceAttributes;
    private List<GAAction> followUpActions;
    private GAPaymentData paymentData;
    private String termsOfServiceUrl;
    private String note;
    private List<GAPromotion> promotions;
    private List<GADisclosure> disclosures;
    private GAVerticals verticals;
}
