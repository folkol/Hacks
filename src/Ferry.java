import java.util.ArrayList;
import java.util.List;

public class Ferry {
    private List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        Ferry ferry = new Ferry();
        ferry.embark(new Car(2));
        ferry.embark(new Lorry(2));
        ferry.embark(new Bus(16));

        System.out.println("Total passengers: " + ferry.numberOfPassengers());
        System.out.println("Total vehicle slots: " + ferry.numberOfVehicleSlots());
    }

    int numberOfPassengers() {
        int passengers = 0;
        for (Vehicle v : vehicles) {
            passengers += v.getPassengers();
        }
        return passengers;
    }

    int numberOfVehicleSlots() {
        int slots = 0;
        for (Vehicle v : vehicles) {
            slots += v.getSize();
        }
        return slots;
    }

    private void embark(Vehicle v) {
        vehicles.add(v);
    }
}

class Vehicle {
    int passengers;
    int getPassengers() {
        return passengers;
    }

    int getSize() {
        System.out.println("This should not be called.");
        return 0;
    }
}

class Car extends Vehicle {
    public Car(int passengers) {
        this.passengers = passengers;
    }

    int getSize() {
        System.out.println("Getting Car size!");
        return 1;
    }
}

class Lorry extends Vehicle {
    public Lorry(int passengers) {
        this.passengers = passengers;
    }

    int getSize() {
        System.out.println("Getting Lorry size!");
        return 8;
    }
}

class Bus extends Vehicle {
    public Bus(int passengers) {
        this.passengers = passengers;
    }

    int getSize() {
        System.out.println("Getting Bus size!");
        return 4;
    }
}