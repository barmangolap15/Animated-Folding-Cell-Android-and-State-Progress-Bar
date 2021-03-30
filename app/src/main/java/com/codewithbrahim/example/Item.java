package com.codewithbrahim.example;

import android.view.View;

import java.util.ArrayList;
import java.util.Objects;

public class Item {

    private String price, pledgePrice, fromAddress, toAddress, date, time;
    private int requestCount;

    private View.OnClickListener requestBtnClickListener;

    public Item() {
    }

    public Item(String price, String pledgePrice, String fromAddress,
                String toAddress, String date, String time, int requestCount) {
        this.price = price;
        this.pledgePrice = pledgePrice;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.date = date;
        this.time = time;
        this.requestCount = requestCount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPledgePrice() {
        return pledgePrice;
    }

    public void setPledgePrice(String pledgePrice) {
        this.pledgePrice = pledgePrice;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }


    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (requestCount != item.requestCount) return false;
        if (pledgePrice != null ? !pledgePrice.equals(item.pledgePrice) : item.pledgePrice != null)
            return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;

        if (fromAddress != null ? !fromAddress.equals(item.fromAddress) : item.fromAddress != null)
            return false;
        if (toAddress != null ? !toAddress.equals(item.toAddress) : item.toAddress != null)
            return false;
        if (date != null ? !date.equals(item.date) : item.date != null)
            return false;
        return !(time !=null ? !time.equals(item.time) : item.time != null);
    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;

        result = 31 * result + (pledgePrice !=null ? pledgePrice.hashCode() : 0);
        result = 31 * result + (fromAddress !=null ? fromAddress.hashCode() : 0);
        result = 31 * result + (toAddress !=null ? toAddress.hashCode() : 0);
        result = 31 * result + (date !=null ? date.hashCode() : 0);
        result = 31 * result + (time !=null ? time.hashCode() : 0);
        result = 31 * result + requestCount;
        return result;
    }

    public static ArrayList<Item> getTestingList(){
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("₹2456", "₹4500","Hazrat Nizamuddin, New Delhi","Yesvantpur Junction, Bangalor", "TODAY","05:10 PM",3));
        items.add(new Item("₹2456", "₹4500","Hazrat Nizamuddin, New Delhi","Yesvantpur Junction, Bangalor", "TODAY","05:10 PM",3));
        items.add(new Item("₹2456", "₹4500","Hazrat Nizamuddin, New Delhi","Yesvantpur Junction, Bangalor", "TODAY","05:10 PM",3));
        items.add(new Item("₹2456", "₹4500","Hazrat Nizamuddin, New Delhi","Yesvantpur Junction, Bangalor", "TODAY","05:10 PM",3));
        items.add(new Item("₹2456", "₹4500","Hazrat Nizamuddin, New Delhi","Yesvantpur Junction, Bangalor", "TODAY","05:10 PM",3));
        items.add(new Item("₹2456", "₹4500","Hazrat Nizamuddin, New Delhi","Yesvantpur Junction, Bangalor", "TODAY","05:10 PM",3));
        return items;
    }
}
