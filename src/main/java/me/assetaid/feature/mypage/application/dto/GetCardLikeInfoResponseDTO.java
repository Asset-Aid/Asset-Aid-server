package me.assetaid.feature.mypage.application.dto;

import java.util.List;

public class GetCardLikeInfoResponseDTO {

    private List<CardBookmarkDTO> bookmarks;

    public GetCardLikeInfoResponseDTO(List<CardBookmarkDTO> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public List<CardBookmarkDTO> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<CardBookmarkDTO> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public static class CardBookmarkDTO {
        private Integer cardId;
        private String bank;
        private String cardName;
        private String benefit;

        public CardBookmarkDTO(Integer cardId, String bank, String cardName, String benefit) {
            this.cardId = cardId;
            this.bank = bank;
            this.cardName = cardName;
            this.benefit = benefit;
        }

        public Integer getCardId() {
            return cardId;
        }

        public void setCardId(Integer cardId) {
            this.cardId = cardId;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }

        public String getBenefit() {
            return benefit;
        }

        public void setBenefit(String benefit) {
            this.benefit = benefit;
        }
    }
}
