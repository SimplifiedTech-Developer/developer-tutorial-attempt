package za.co.simplifiedtech.openclosedprinciple;

public interface NotificationService {
    void sendOTP(String medium);

    void sendTransactionReport(String medium);
}
