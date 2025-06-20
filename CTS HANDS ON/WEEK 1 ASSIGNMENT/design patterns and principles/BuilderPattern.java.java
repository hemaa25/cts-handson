public class BuilderPattern {

    static class Computer {
        private String cpu;
        private String ram;
        private String storage;
        private String gpu;
        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.gpu = builder.gpu;
        }

     
        static class Builder {
            private String cpu;
            private String ram;
            private String storage;
            private String gpu;

            public Builder setCpu(String cpu) {
                this.cpu = cpu;
                return this;
            }

            public Builder setRam(String ram) {
                this.ram = ram;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGpu(String gpu) {
                this.gpu = gpu;
                return this;
            }

            public Computer build() {
                return new Computer(this);
            }
        }

    
        @Override
        public String toString() {
            return "Computer [CPU=" + cpu + ", RAM=" + ram + ", Storage=" + storage + ", GPU=" + gpu + "]";
        }
    }

 
    public static void main(String[] args) {
        Computer officePC = new Computer.Builder()
            .setCpu("Intel i5")
            .setRam("8GB")
            .setStorage("512GB SSD")
            .build();

        Computer gamingPC = new Computer.Builder()
            .setCpu("AMD Ryzen 9")
            .setRam("32GB")
            .setStorage("1TB NVMe")
            .setGpu("NVIDIA RTX 4080")
            .build();

    }
}
