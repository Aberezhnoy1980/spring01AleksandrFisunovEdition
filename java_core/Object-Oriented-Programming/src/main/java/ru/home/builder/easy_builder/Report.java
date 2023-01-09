package ru.home.builder.easy_builder;

public class Report {
    private String header;
    private String title;
    private String content;
    private String table;
    private int pageNumber;

    private Report(Builder builder) {
        this.header = builder.header;
        this.title = builder.title;
        this.content = builder.content;
        this.table = builder.table;
        this.pageNumber = builder.pageNumber;
    }

    public String getHeader() {
        return header;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTable() {
        return table;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public String toString() {
        return "report: " + header +
                "\ntitle: " + title +
                "\ncontent: " + content +
                "\ntable: " + table +
                "\npage: " + pageNumber;
    }

    static class Builder {
        private String header;
        private String title;
        private String content;
        private String table;
        private int pageNumber;

        public Builder(String header) {
            this.header = header;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setTable(String table) {
            this.table = table;
            return this;
        }

        public Builder setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }
}
