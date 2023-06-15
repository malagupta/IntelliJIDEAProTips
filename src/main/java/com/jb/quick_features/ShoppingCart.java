package com.jb.quick_features;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    final private List<ShoppingItem> shoppingItemList;

    public ShoppingCart() {
        shoppingItemList = new ArrayList<>();
    }

    // Get the total cost of all items in the cart
    public double getTotalCost() {
        double totalCost = 0;
        for (ShoppingItem item : shoppingItemList) {
            totalCost += item.getUnitPrice() * item.getQuantity();
        }
        return totalCost;
    }

    // Add an item to the cart if it doesn't exist.
    // If it exists, update its quantity
    public void addItem(ShoppingItem newItem) {
        boolean itemExists = false;
        for (ShoppingItem item : shoppingItemList) {
            if (item.getName().equals(newItem.getName())) {
                // Item already exists, update its quantity
                item.setQuantity(item.getQuantity() + newItem.getQuantity());
                itemExists = true;
                break;
            }
        }
        if (!itemExists) {
            // Item does not exist, add it to the shopping list
            shoppingItemList.add(newItem);
        }
    }


    // Remove an item from the cart
    public void removeItem(ShoppingItem item) {
        shoppingItemList.remove(item);
    }


    // Get the number of items in the cart
    public int getNumItems() {
        return shoppingItemList.size();
    }

    // Get the list of items in the cart
    public List<ShoppingItem> getShoppingItemList() {
        return shoppingItemList;
    }

    // Clear all items from the cart
    public void clearCart() {
        shoppingItemList.clear();
    }
}
