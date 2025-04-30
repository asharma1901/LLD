package VehicleRentalSystem;

import java.util.List;

public class RentalSystem {

    List<User> userList;
    List<Store> storeList;

    public RentalSystem(List<User> userList, List<Store> storeList) {
        this.userList = userList;
        this.storeList = storeList;
    }

    public Store getStoreWithLocation(Location location)
    {
        for(Store store: storeList)
        {
            if(store!=null && store.location.equals(location))
            {
                return store;
            }
        }
        return null;
    }

}
