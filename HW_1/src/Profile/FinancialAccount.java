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
public class FinancialAccount {
    
    private int num;
    private String creationDate;
    private String expDate;
    private Boolean active; //Boolean
    private String debtOrCredit; //Boolean

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDebtOrCredit() {
        return debtOrCredit;
    }

    public void setDebtOrCredit(String debtOrCredit) {
        this.debtOrCredit = debtOrCredit;
    }

    
    

}
