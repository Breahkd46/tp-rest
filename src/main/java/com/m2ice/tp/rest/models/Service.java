package com.m2ice.tp.rest.models;

import com.m2ice.tp.rest.utils.XMLFinder;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private int id;
    private String title;
    private int price;
    private List<Done> dones;

    public Service(int id, String title, int price, List<Done> dones) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.dones = dones;
    }

    public Service(String xml) {
        this.id = Integer.parseInt(XMLFinder.findAttribute(xml, "id"));
        this.title = XMLFinder.findAttribute(xml, "title");
        this.price = Integer.parseInt(XMLFinder.findAttribute(xml, "price"));
        this.dones = new ArrayList<>();
    }

    public String toXML() {
        return "<SERVICE id=\"" + id + "\" title=\"" + title + "\" price=\"" + price + "\" ></SERVICE>";
    }
}
