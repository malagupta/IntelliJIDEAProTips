package com.jb.quick_features;

import java.util.Objects;

/**
 * This class encapsulates an item
 * in a ShoppingCart.
 * It has multiple attributes - name,
 * displayName, description, quantity, and unitPrice.
 * <p>
 * When a shopping cart adds the same item again,
 * its quantity is increased rather than adding another
 * instance in the list.
 * @version 1.0
 * @author Mala Gupta
 */

public class ShoppingItem {
    /*
     * This is a shorter name for internal use
     */
    private String name;

    /*
     * This name would be displayed at places
     * where this item would be listed
     */
    private String displayName;

    /*
     * A longer description that includes essential
     * information
     */
    private String description;

    /*
     * Quantity in stock for this item
     */
    private int quantity;

    private double unitPrice;

    public ShoppingItem(String name, String displayName, String description, int quantity, double unitPrice) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "ShoppingItem{" + "name='" + name + '\'' + ", displayName='" + displayName + '\'' + ", description='" + description + '\'' + ", quantity=" + quantity + ", unitPrice=" + unitPrice + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingItem that = (ShoppingItem) o;

        if (quantity != that.quantity) return false;
        if (Double.compare(that.unitPrice, unitPrice) != 0) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(displayName, that.displayName)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(unitPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
