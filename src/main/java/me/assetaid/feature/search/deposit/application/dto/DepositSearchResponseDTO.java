package me.assetaid.feature.search.deposit.application.dto;

public class DepositSearchResponseDTO {
    private String productName;
    private String bankName;
    private String salesPeriod;
    private int savingTerm;
    private String subscriptionAmount;
    private double basicInterestRate;
    private double maxInterestRate;

    public DepositSearchResponseDTO(String productName, String bankName, String salesPeriod, int savingTerm,
                                    String subscriptionAmount, double basicInterestRate, double maxInterestRate) {
        this.productName = productName;
        this.bankName = bankName;
        this.salesPeriod = salesPeriod;
        this.savingTerm = savingTerm;
        this.subscriptionAmount = subscriptionAmount;
        this.basicInterestRate = basicInterestRate;
        this.maxInterestRate = maxInterestRate;
    }

    // Getters only
}

