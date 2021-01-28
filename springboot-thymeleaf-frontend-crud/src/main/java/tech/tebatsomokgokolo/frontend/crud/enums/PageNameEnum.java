package tech.tebatsomokgokolo.frontend.crud.enums;

public enum PageNameEnum {
    ADD_STUDENT("add-student"),
    UPDATE_STUDENT("update-student"),
    INDEX("index");

    private String value;

    PageNameEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}