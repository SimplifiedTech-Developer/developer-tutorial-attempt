package za.co.telkom.keycloak.enums;

public enum KeycloakEnum {
    CUSTOM_REALM("CUSTOM_REALM"),
    USER_INFO("USER_INFO"),
    USER_CREDENTIALS("USER_CREDENTIALS"),
    KEYCLOAK_USER_ID("KEYCLOAK_USER_ID"),
    KEYCLOAK_USER_FIRST_NAME("KEYCLOAK_USER_FIRST_NAME"),
    KEYCLOAK_USER_EMAIL("KEYCLOAK_USER_EMAIL"),
    KEYCLOAK_SESSION("KEYCLOAK_SESSION"),
    CUSTOM_CLIENT("CUSTOM_CLIENT"),
    TELKOM_APP_CLIENT("telkom-app"),
    TELKOM_REALM("master"),
    TELKOM_ADMIN_CLI("admin-cli"),
    TELKOM_CONSUMER_REALM("telkom-consumer"),
    PASSWORD("password"),
    USER_PASSWORD("USER_PASSWORD"),
    ACCOUNT_CLIENT_ID("ACCOUNT_CLIENT_ID"),
    OTP_MESSAGE("Successfully Confirmed The OTP"),
    PASSWORD_RESET_SUCCESS_MESSAGE("Successfully Changed The Password"),
    OTP_INVALID_MESSAGE("OTP Not Valid, Please Enter A Valid OTP"),
    USER_LOGIN_SUCCESS_MESSAGE("User Has Been Successfully Authenticated"),
    OTP_NULL_MESSAGE("OTP Is Null"),
    RESEND_OTP("RESEND_OTP");

    private String value;

    KeycloakEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
