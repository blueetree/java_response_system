package Business;

import Business.Area.Area;
import Business.Country.Country;
import java.util.ArrayList;

/**
 *
 * @author jiahuanli
 */
public class EcoSystem extends Area {

    private static EcoSystem business;
    private ArrayList<Country> countryList;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        countryList = new ArrayList<>();
    }

    public ArrayList<Country> getCountryList() {
        return countryList;
    }

    public Country createAndAddCountry(String name) {
        Country country = new Country(name);
        countryList.add(country);
        return country;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }

       

        return true;
    }
}