public class Electronics {

    public static class Device {
        private String brand;

        public Device(String brand) {
            this.brand = brand;
        }

        public String getBrand() {
            return brand;
        }

        public void turnOn() {
            System.out.println(brand + " is turning on.");
        }

        public void turnOff() {
            System.out.println(brand + " is turning off.");
        }
    }

    public static class Smartphone extends Device {
        private int cameraResolution;

        public Smartphone(String brand, int cameraResolution) {
            super(brand);
            this.cameraResolution = cameraResolution;
        }

        public void takePhoto() {
            System.out.println(getBrand() + " smartphone taking a photo with " + cameraResolution + " resolution.");
        }


        @Override
        public void turnOn() {
            System.out.println(getBrand() + " smartphone is turning on.");
        }

        @Override
        public void turnOff() {
            System.out.println(getBrand() + " smartphone is turning off.");
        }
    }

    public static class Laptop extends Device {
        private int ram;

        public Laptop(String brand, int ram) {
            super(brand);
            this.ram = ram;
        }

        public void displaySpecs() {
            System.out.println(getBrand() + " laptop has " + ram + "GB of RAM.");
        }


        @Override
        public void turnOn() {
            System.out.println(getBrand() + " laptop is turning on.");
        }

        @Override
        public void turnOff() {
            System.out.println(getBrand() + " laptop is turning off.");
        }
    }

    public static void main(String[] args) {
        Smartphone phone = new Smartphone("Samsung", 12000000);
        phone.turnOn();
        phone.takePhoto();
        phone.turnOff();


        Laptop laptop = new Laptop("Apple", 16);
        laptop.turnOn();
        laptop.displaySpecs();
        laptop.turnOff();
    }
}
