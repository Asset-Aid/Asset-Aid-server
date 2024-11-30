package me.assetaid.feature.mypage.application.dto;

import java.util.List;

public class GetDepositLikeInfoResponseDTO {

    private List<DepositBookmarkDTO> bookmarks;

    public GetDepositLikeInfoResponseDTO(List<DepositBookmarkDTO> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public List<DepositBookmarkDTO> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<DepositBookmarkDTO> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public static class DepositBookmarkDTO {
        private Integer depositId;
        private String bank;
        private String depositName;
        private String benefit;

        public DepositBookmarkDTO(Integer depositId, String bank, String depositName, String benefit) {
            this.depositId = depositId;
            this.bank = bank;
            this.depositName = depositName;
            this.benefit = benefit;
        }

        public Integer getDepositId() {
            return depositId;
        }

        public void setDepositId(Integer depositId) {
            this.depositId = depositId;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getDepositName() {
            return depositName;
        }

        public void setDepositName(String depositName) {
            this.depositName = depositName;
        }

        public String getBenefit() {
            return benefit;
        }

        public void setBenefit(String benefit) {
            this.benefit = benefit;
        }
    }
}
