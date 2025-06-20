class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return orderId + " - " + customerName + " - ₹" + totalPrice;
    }
}

public class Sort {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] bubbleSortedOrders = {
            new Order(101, "Alice", 4500.00),
            new Order(102, "Bob", 2500.50),
            new Order(103, "Charlie", 5200.75),
            new Order(104, "David", 3000.25)
        };

        bubbleSort(bubbleSortedOrders);
        System.out.println("Bubble Sort by Total Price:");
        printOrders(bubbleSortedOrders);

        Order[] quickSortedOrders = {
            new Order(201, "Eve", 7100.00),
            new Order(202, "Frank", 3200.00),
            new Order(203, "Grace", 1500.00),
            new Order(204, "Hannah", 6100.50)
        };

        quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("Quick Sort by Total Price:");
        printOrders(quickSortedOrders);
    }
}
