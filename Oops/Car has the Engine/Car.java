class Car {
    private Engine engine;
    Car() {
        engine = new Engine();  
    }
    void startCar() {
        engine.start();   
        System.out.println("Car is running...");
    }
    void stopCar() {
        engine.stop();
        System.out.println("Car stopped.");
    }
}