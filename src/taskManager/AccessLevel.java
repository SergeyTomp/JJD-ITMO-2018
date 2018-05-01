package taskManager;

public enum AccessLevel {ADMIN("ADMIN"),
                        SUPER("SUPER"),
                        MIDDLE("MIDDLE"),
                        JUNIOR("JUNIOR"),
                        COMBINED("COMBINED");

    String access;
    AccessLevel(String access) {
        this.access = access;
    }

    public String getAccess() {
        return access;
    }

}
