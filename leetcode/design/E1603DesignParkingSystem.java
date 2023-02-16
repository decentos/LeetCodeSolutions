package design;

public class E1603DesignParkingSystem {
    private final int[] slots;

    public E1603DesignParkingSystem(int big, int medium, int small) {
        slots = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType) {
        return slots[carType]-- > 0;
    }
}
