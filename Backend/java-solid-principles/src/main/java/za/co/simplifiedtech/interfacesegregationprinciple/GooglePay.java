package za.co.simplifiedtech.interfacesegregationprinciple;

public class GooglePay implements UPIPayments,CashBackManager {

    public void payMoney() {

    }

    public void getScratchCard() {

    }

    public void getCashBackAsCreditBalance() {
      //This features are available in Google Pay
    }
}
