package VehicleRentalSystem;

public class Location {

    String address;
    String city;
    String state;
    int pinCode;

    public Location(String address, String city, int pinCode, String state) {
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getPinCode() {
        return pinCode;
    }

    public boolean equals(Object o)
    {
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;

        Location location = (Location)o;
        return pinCode == location.pinCode &&
                address.equals(location.address) &&
                city.equals(location.city) &&
                state.equals(location.state);
    }
}
