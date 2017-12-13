/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

/**
 *
 * @author jiahuanli
 */
public class DonorAccount extends UserAccount implements Comparable<DonorAccount>{
    private boolean Type;
    private int Age;
    private String Occupation;
    private boolean apply;
    private String applyWork;
    private String applyUserName;
    private String applyPassword;
    private double totalAmount=0.0;
    
     public DonorAccount() {
        super();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isApply() {
        return apply;
    }

    public void setApply(boolean apply) {
        this.apply = apply;
    }

    public String getApplyWork() {
        return applyWork;
    }

    public void setApplyWork(String applyWork) {
        this.applyWork = applyWork;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getApplyPassword() {
        return applyPassword;
    }

    public void setApplyPassword(String applyPassword) {
        this.applyPassword = applyPassword;
    }

    public boolean isType() {
        return Type;
    }

    public void setType(boolean Type) {
        this.Type = Type;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String Occupation) {
        this.Occupation = Occupation;
    }

    @Override
    public int compareTo(DonorAccount donorAccount) {
        if (this.totalAmount > donorAccount.getTotalAmount()) {
            return -1;
        } else if (this.totalAmount < donorAccount.getTotalAmount()) {
            return 1;
        } else {
            return 0;
        } //To change body of generated methods, choose Tools | Templates.
    }
}