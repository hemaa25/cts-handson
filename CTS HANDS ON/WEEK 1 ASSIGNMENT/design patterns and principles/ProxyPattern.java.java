public class ProxyPattern{

    interface Image {
        void display();
    }
    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromRemoteServer();
        }

        private void loadFromRemoteServer() {
            System.out.println("Loading " + filename + " from remote server...");
            try {
                Thread.sleep(1000); // Simulate network delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void display() {
            System.out.println("Displaying " + filename);
        }
    }

    static class ProxyImage implements Image {
        private String filename;
        private RealImage realImage;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename); // Lazy initialization
            } else {
                System.out.println("Using cached image for: " + filename);
            }
            realImage.display();
        }
    }

    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("--- First call (lazy load) ---");
        image1.display();

        System.out.println("\n--- Second call (cached) ---");
        image1.display();

        System.out.println("\n--- Load another image ---");
        image2.display();
    }
}

