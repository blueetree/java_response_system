/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile;

/**
 *
 * @author jiahuanli
 */
public class Person {
    
    public Boolean self;
    private String firstName;
    private String lastName;
    private String dob; 
    private String gender;
    private String photo;
    public Address address;
    public FinancialAccount checkingAccount;
    public FinancialAccount savingAccount;
    public CreditCard creditCard;
    public License license;
    
    public Person(){
        
    address = new Address();
    checkingAccount = new FinancialAccount();
    savingAccount = new FinancialAccount();
    creditCard = new CreditCard();
    license = new License();
    
}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public FinancialAccount getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(FinancialAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public FinancialAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(FinancialAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    
    
}
