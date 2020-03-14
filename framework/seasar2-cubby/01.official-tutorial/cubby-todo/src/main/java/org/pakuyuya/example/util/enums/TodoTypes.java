package org.pakuyuya.example.util.enums;

public enum TodoTypes {
    TASK(1, "タスク"), NARROW(2, "できれば"), NONE(-1, "");

    final public int id;
    final public String name;

    private TodoTypes(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static TodoTypes of(final int id) {
        for (TodoTypes e : values()) {
            if (e.id == id) {
                return e;
            }
        }
        return NONE;
    }

    public static TodoTypes[] enableValues() {
        return new TodoTypes[] {
            TASK, NARROW
        };
    }
}
