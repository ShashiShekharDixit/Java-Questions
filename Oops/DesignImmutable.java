public final class DesignImmutable {
    private final String name;
    private final String email;

    public DesignImmutable(String name, String email) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Name is required");
        }
        if (email == null || email.isEmpty()) {
            throw new RuntimeException("Email is required");
        }
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "DesignImmutable{name='" + name + "', email='" + email + "'}";
    }

    public static void main(String[] args) {
        DesignImmutable user = new DesignImmutable("Shashi", "shashiswadh20@gmail.com");
        System.out.println(user);
    }
}
