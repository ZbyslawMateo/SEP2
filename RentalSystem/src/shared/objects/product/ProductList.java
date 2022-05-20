package shared.objects.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class ProductList implements Serializable
{
    private ArrayList<Product> list;

    /**
     * Constructor initializing empty array list.
     */
    public ProductList() {
        list = new ArrayList<>();
    }

    /**
     * Add new product to list.
     * @param element This element is inserted in to the list.
     * @return Same elements that gets inserted it gets returned.
     */
    public Product add(Product element) {
        list.add(element);
        return element;
    }

    /**
     * Add nes product to the list by specifying each parameter manually.
     * @param price Price of the product.
     * @param color Color of the product.
     * @param equipmentType Type of the product.
     * @param size Size of the product.
     * @return Returns the same product that was created and inserted in to the list.
     */
    public Product add(double price, Color color, EquipmentType equipmentType, Size size) {
        Product product = new Product(getUniqueId(), price, color, equipmentType, size);
        list.add(product);
        return product;
    }

    /**
     * Chancing specific product from the list by index.
     * @param index Index of the product we want to change.
     * @param price New price of the product.
     * @param color New Color for the product.
     * @param size New Size of the product.
     */
    public void change(int index, double price, Color color, Size size) {
        Product product = list.get(index);
        product.setPrice(price);
        product.setColor(color);
        product.setSize(size);
    }

    /**
     * Returns Product by ID.
     * @param id ID of the Product we are searching for.
     * @return Returns the Product from the list with specified ID.
     */
    public Product get(int id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id)
                return list.get(i);
        }

        return null;
    }

    /**
     * Returns Product by Index.
     * @param index Index of the Product we are searching for.
     * @return Returns the Product from the list with specified index.
     */
    public Product getByIndex(int index) {
        return list.get(index);
    }

    /**
     * Removes the Product by ID.
     * @param id ID of the Product we are searching for to remove.
     * @return Returns the Product from the list with specified ID.
     */
    public Product remove(int id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id)
                return list.remove(i);
        }

        return null;
    }

    /**
     * Removes the Product by Index.
     * @param index Index of the Product we are searching for to remove.
     * @return Returns the Product from the list with ID.
     */
    public Product removeByIndex(int index) {
        return list.remove(index);
    }

    /**
     * Returns a Map with Products as a key and values as the quantity of that Product.
     * @return
     */
    public Map<Product, Integer> getAllProductsByQuantity() {
        Map<Product, Integer> map = new Hashtable<>();
        for (int i = 0; i < list.size(); i++) {
            Product product = list.get(i);
            map.merge(product, 1, Integer::sum);
        }

        return map;
    }

    /**
     * Returns the amount of elements in the list.
     * @return Returns size of the list.
     */
    public int size() {
        return list.size();
    }

    /**
     * Iterates throw the list and keeps track of the biggest ID and returns the incrementation of the biggest ID in the list.
     * @return Returns unique ID.
     */
    public int getUniqueId() {
        int maxId = -1;
        for (Product product : list) {
            if(product.getId() > maxId) {
                maxId = product.getId();
            }
        }

        return ++maxId;
    }

    /**
     * Check if provided object is same as this ProductList.
     * @param obj Any object.
     * @return True if objects are same and false if objects are not same.
     */
    public boolean equals(Object obj) {
        if(!(obj instanceof ProductList productList))
            return false;

        return productList.list.equals(list);
    }

    /**
     * Create new copy of ProductList.
     * @return Copy of ProductList.
     */
    public ProductList copy() {
        ProductList temp = new ProductList();

        for (Product product : list) {
            temp.add(product);
        }

        return temp;
    }

    /**
     * Convert ReservationList to String ArrayList.
     * @return String ArrayList.
     */
    public ArrayList<String> convertToStringArrayList() {
        ArrayList<String> temp = new ArrayList<>();

        for (Product p : list) {
            temp.add(p.toString());
        }

        return temp;
    }

    /**
     * Create string from all reservations
     * @return String
     */
    public String toString() {
        StringBuilder values = new StringBuilder();

        for (Product p : list) {
            values.append(p.toString()).append("\n");
        }

        return values.toString();
    }

    /**
     * Iterates throw the list and sum's all the prices of the products in the list.
     * @return Returns the total price of all products in the list.
     */
    public double getTotalPrice() {
        double sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getPrice();
        }

        return sum;
    }

    /**
     * Checks if the list is empty.
     * @return Returns true if the list is empty and false if it contains more than one element.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }
}