import java.util.ArrayList;
import java.util.List;

interface OrderObserver {
    void update(String status);
}
class User implements OrderObserver {
    
    private String username;
    private String email;
    private String mobile;
    private String address;
    private String lastPizzaType;
    private String lastPizzaSize;
    private String lastPizzaCrust;
    private String lastPizzaSauce;
    private String lastTopping;
    private String lastCheese;
    private String lastPizzaName;
    private List<Pizza> favoritePizzas;
    private double lastPizzaFee;
    private double lastDeliveryFee;
    private double lastSeasonalDiscount;
    private double lastTotalFee;
    private int loyaltyPoints;
    private int rating;
    private String comments;
    private List<OrderObserver> observers = new ArrayList<>();
    
    public User(String username, String email, String mobile, String address) {
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.favoritePizzas = new ArrayList<>();
        this.loyaltyPoints = 0;
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
    public String getAddress() { return address; }

    public void setLastPizzaOrder(String pizzaType, String pizzaSize, String pizzaCrust, String pizzaSauce, String topping, String cheese, double pizzaFee, double deliveryFee, double seasonalDiscount, double totalFee) {
        this.lastPizzaType = pizzaType;
        this.lastPizzaSize = pizzaSize;
        this.lastPizzaCrust = pizzaCrust;
        this.lastPizzaSauce = pizzaSauce;
        this.lastTopping = topping;
        this.lastCheese = cheese;
        this.lastPizzaFee = pizzaFee;
        this.lastDeliveryFee = deliveryFee;
        this.lastSeasonalDiscount = seasonalDiscount;
        this.lastTotalFee = totalFee;     
    }

    public String getLastPizzaType() { return lastPizzaType; }
    public String getLastPizzaSize() { return lastPizzaSize; }
    public String getLastPizzaCrust() { return lastPizzaCrust; }
    public String getLastPizzaSauce() { return lastPizzaSauce; }
    public String getLastTopping() { return lastTopping; }
    public String getLastCheese() { return lastCheese; }
    public double getLastPizzaFee() { return lastPizzaFee; }
    public double getLastDeliveryFee() { return lastDeliveryFee; }
    public double getLastSeasonalDiscount() { return lastSeasonalDiscount; }
    public double getLastTotalFee() { return lastTotalFee; }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRating() {
        return rating;
    }

    public String getComments() {
        return comments;
    }

    public void registerObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String status) {
        for (OrderObserver observer : observers) {
            observer.update(status);
        }
    }
    public void setLastPizzaName(String pizzaName) {
        this.lastPizzaName = pizzaName;
    }
    public String getLastPizzaName() {
        return lastPizzaName;
    }
    public void addFavoritePizza(Pizza pizza) {
        favoritePizzas.add(pizza);
    }
    public List<Pizza> getFavoritePizzas() {
        return favoritePizzas;
    }
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Method to add points (e.g., after each order)
    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }
    public void redeemLoyaltyPoints(int points) {
        if (loyaltyPoints >= points) {
            loyaltyPoints -= points;
        } else {
            System.out.println("Not enough loyalty points to redeem.");
        }
    }
    @Override
    public void update(String status) {
        System.out.println("User " + username + " notified: Order status changed to " + status);
    }
    
}

