package tech.tebatsomokgokolo.frontend.crud.enums;

public enum CommonEnum {
    ATTRIBUTE_STUDENTS("students"),
    ATTRIBUTE_STUDENT("student");
    private String value;

    CommonEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}