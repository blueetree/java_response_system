/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Admin.System;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author jiahuanli
 */
public class AllCountryList {
    private ArrayList<CountryName> countries;
    public AllCountryList() {
    countries = new ArrayList<>();

    Locale[] locales = Locale.getAvailableLocales();
    for (Locale locale : locales) {
      String name = locale.getDisplayCountry();

      if ( !"".equals(name)) {
        countries.add(new CountryName(name));
      }
    }
    //System.out.println("locales: "+locales.toString());
    Collections.sort(countries, new CountryComparator());
   // System.out.println("countries:"+countries.toString());
  }

    public ArrayList<CountryName> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<CountryName> countries) {
        this.countries = countries;
    }
}

class CountryComparator implements Comparator<CountryName> {
  private Comparator comparator;

  CountryComparator() {
    comparator = Collator.getInstance();
  }

  public int compare(CountryName o1, CountryName o2) {
    return comparator.compare(o1.name, o2.name);
  }
}

class CountryName {
  public String name;

  CountryName(String name) {
    this.name = name;
  }

  public String toString() {
    return name.toUpperCase();
  }
}
