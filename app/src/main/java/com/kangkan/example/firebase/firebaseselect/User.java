package com.kangkan.example.firebase.firebaseselect;

class User {

    private String pname;
    private String p_price;
    private String p_place;

    public User(String pname, String p_price, String p_place) {
        this.pname = pname;
        this.p_price = p_price;
        this.p_place = p_place;
    }

    public User() {
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public String getP_place() {
        return p_place;
    }

    public void setP_place(String p_place) {
        this.p_place = p_place;
    }
}
