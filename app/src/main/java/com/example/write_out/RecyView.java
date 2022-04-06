package com.example.write_out;

public class RecyView {
    String header, category , author ;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public RecyView(String header, String category, String author) {
        this.header = header;
        this.category = category;
        this.author = author;
    }
}

