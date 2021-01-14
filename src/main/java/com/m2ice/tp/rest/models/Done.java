package com.m2ice.tp.rest.models;

import com.m2ice.tp.rest.utils.XMLFinder;

public class Done {
    private int id;
    private String date;
    private String qt;

    public Done(int id, String date, String qt) {
        this.id = id;
        this.date = date;
        this.qt = qt;
    }

    public Done(String xml) {
        this.id = -1;
        this.date = XMLFinder.findAttribute(xml, "date");
        this.qt = XMLFinder.findAttribute(xml, "qt");
    }

    public String toXML() {
        return "<done id=\"" + id + "\" date=\"" + date + "\" qt=\"" + qt + "\"></done>";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }
}
