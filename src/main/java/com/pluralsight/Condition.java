package com.pluralsight;

public enum Condition {
    //
    HORRIBLE(1), POOR(2), FAIR(3), GOOD(4), EXCELLENT(5);
    public int condition;

    public int getCondition() {
        return condition;
    }
    //must have a constructor for enum class to work
    Condition(int condition) {
        this.condition = condition;
    }
}
