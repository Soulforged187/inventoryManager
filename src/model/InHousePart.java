package model;
// this is the logical model for Parts built in house.
public class InHousePart extends Part {
    private int machineId;
    // constructor for In-housePart
    public InHousePart(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }
    // getter for machineID
    public int getMachineId() {
        return machineId;
    }
    // setter for machineID
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
}
