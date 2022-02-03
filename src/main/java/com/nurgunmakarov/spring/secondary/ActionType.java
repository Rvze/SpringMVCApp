package com.nurgunmakarov.spring.secondary;

public enum ActionType {
    REGISTRATION(1),
    CHECK_EMAIL(2),
    LOG_IN_PASS(3),
    LOG_OUT(4),
    LOGIN_FAIL(5);

    private final int description;

    ActionType(int description) {
        this.description = description;
    }

    public int getDescription() {
        return description;
    }
}
