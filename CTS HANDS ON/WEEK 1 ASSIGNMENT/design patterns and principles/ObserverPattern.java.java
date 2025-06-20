public class ObserverPattern {

    interface Observer {
        void update(String stockName, double stockPrice);
    }

    
    interface Stock {
        void registerObserver(Observer o);
        void removeObserver(Observer o);
        void notifyObservers();
    }


    static class StockMarket implements Stock {
        private String stockName;
        private double stockPrice;
        private java.util.List<Observer> observers = new java.util.ArrayList<>();

        public void setStock(String name, double price) {
            this.stockName = name;
            this.stockPrice = price;
            notifyObservers();
        }

        @Override
        public void registerObserver(Observer o) {
            observers.add(o);
        }

        @Override
        public void removeObserver(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(stockName, stockPrice);
            }
        }
    }


    static class MobileApp implements Observer {
        private String appName;

        public MobileApp(String name) {
            this.appName = name;
        }

        @Override
        public void update(String stockName, double stockPrice) {
            System.out.println(appName + " received update: " + stockName + " is now ₹" + stockPrice);
        }
    }


    static class WebApp implements Observer {
        private String appName;

        public WebApp(String name) {
            this.appName = name;
        }

        @Override
        public void update(String stockName, double stockPrice) {
            System.out.println(appName + " received update: " + stockName + " is now ₹" + stockPrice);
        }
    }

  
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp("MobileApp");
        Observer web = new WebApp("WebApp");

        market.registerObserver(mobile);
        market.registerObserver(web);

        market.setStock("TCS", 3650.75);
        market.setStock("INFY", 1450.60);

        market.removeObserver(web);
        market.setStock("WIPRO", 780.00);
    }
}
