package com.example.write_out;

public class model {
    String Body, Category, Title;

    public model() {
    }

    public model(String body, String category, String title) {
        Body = body;
        Category = category;
        Title = title;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

}
