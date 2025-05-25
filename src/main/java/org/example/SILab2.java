package org.example;
import java.util.List;

class Item {
    String name;
    int quantity; //numerical
    int price;
    double discount;

    public Item(String name, int quantity, int price, double discount) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static double checkCart(List<Item> allItems, String cardNumber){
        if (allItems == null){//1
            throw new RuntimeException("allItems list can't be null!");//2
        }

        double sum = 0;//3

        for (int i = 0; i < allItems.size(); i++){ //4
            Item item = allItems.get(i);//5
            if (item.getName() == null || item.getName().length() == 0){//6
                throw new RuntimeException("Invalid item!");//7
            }

            if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10){//8
                sum -= 30;//9
            }

            if (item.getDiscount() > 0){//10
                sum += item.getPrice()*(1-item.getDiscount())*item.getQuantity();//11
            }
            else {//12
                sum += item.getPrice()*item.getQuantity();//13
            }

        }
        if (cardNumber != null && cardNumber.length() == 16) {//14
            String allowed = "0123456789";//15
            char[] chars = cardNumber.toCharArray();//16
            for (int j = 0; j < cardNumber.length(); j++) {//17
                char c = cardNumber.charAt(j);//18
                if (allowed.indexOf(c) == -1) {//19
                    throw new RuntimeException("Invalid character in card number!");//20
                }
            }
        }
        else{//21
            throw new RuntimeException("Invalid card number!");//22
        }

        return sum;//23

    }
    
}
