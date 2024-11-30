package me.assetaid.feature.mypage.application.dto;

import java.util.List;

public class GetSavingLikeInfoResponseDTO {

    private List<SavingBookmarkDTO> bookmarks;

    public GetSavingLikeInfoResponseDTO(List<SavingBookmarkDTO> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public List<SavingBookmarkDTO> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<SavingBookmarkDTO> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public static class SavingBookmarkDTO {
        private Integer savingId;
        private String bank;
        private String savingName;
        private String benefit;

        public SavingBookmarkDTO(Integer savingId, String bank, String savingName, String benefit) {
            this.savingId = savingId;
            this.bank = bank;
            this.savingName = savingName;
            this.benefit = benefit;
        }

        public Integer getSavingId() {
            return savingId;
        }

        public void setSavingId(Integer savingId) {
            this.savingId = savingId;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getSavingName() {
            return savingName;
        }

        public void setSavingName(String savingName) {
            this.savingName = savingName;
        }

        public String getBenefit() {
            return benefit;
        }

        public void setBenefit(String benefit) {
            this.benefit = benefit;
        }
    }
}
