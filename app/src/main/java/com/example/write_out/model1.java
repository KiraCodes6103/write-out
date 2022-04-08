package com.example.write_out;

    public class model1 {
        String Title, Category, Body;

        public model1() {
        }

        public model1(String title, String category, String body) {
            Title = title;
            Category = category;
            Body = body;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getCategory() {
            return Category;
        }

        public void setCategory(String category) {
            Category = category;
        }

        public String getBody() {
            return Body;
        }

        public void setBody(String body) {
            Body = body;
        }
    }


