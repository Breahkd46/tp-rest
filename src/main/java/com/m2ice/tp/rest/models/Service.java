package com.m2ice.tp.rest.models;

import com.m2ice.tp.rest.utils.XMLFinder;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private int id;
    private String title;
    private int price;
    private List<Done> dones;

    public Service(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.dones = new ArrayList<>();
    }

    public Service(String xml) {
        this.id = -1;
        this.title = XMLFinder.findAttribute(xml, "title");
        this.price = Integer.parseInt(XMLFinder.findAttribute(xml, "price"));
        this.dones = new ArrayList<>();
    }

    public String toXML() {
        return "<service id=\"" + id + "\" title=\"" + title + "\" price=\"" + price + "\" ></service>";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Done> getDones() {
        return dones;
    }

    public void setDones(List<Done> dones) {
        this.dones = dones;
    }
}
