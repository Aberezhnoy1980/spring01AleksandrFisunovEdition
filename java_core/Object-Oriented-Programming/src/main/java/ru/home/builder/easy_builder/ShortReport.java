package ru.home.builder.easy_builder;

import java.time.LocalDateTime;

public class ShortReport {
    private String title;
    private String content;
    private String content2;
    private String content3;
    private LocalDateTime dateTime;
    private int pageCount;

    public static Builder createBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Title: " + title +
                "\ncontent: " + content +
                "\ncontent2: "  + content2 +
                "\ncontent3: "  + content3 +
                "\ndate: " + dateTime +
                "\npages: " + pageCount;

    }

    public static class Builder {

        private final ShortReport shortReport;

        public Builder() {
            this.shortReport = new ShortReport();
        }

        public Builder includeTitle(String title) {
            this.shortReport.title = title;
            return this;
        }
        public Builder includeContent(String content) {
            this.shortReport.content = content;
            return this;
        }
        public Builder includeContent2(String content2) {
            this.shortReport.content2 = content2;
            return this;
        }
        public Builder includeContent3(String content3) {
            this.shortReport.content3 = content3;
            return this;
        }
        public Builder includeDateTime(LocalDateTime dateTime) {
            this.shortReport.dateTime = dateTime;
            return this;
        }
        public Builder includePageCount(int pageCount) {
            this.shortReport.pageCount = pageCount;
            return this;
        }

        public ShortReport build() {
            return shortReport;
        }
    }

}
