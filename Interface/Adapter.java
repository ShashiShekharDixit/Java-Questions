interface Authenticator {
    boolean login(String username, String password);
}
class LegacyAuth {
    public boolean checkUser(String user, String pass) {
        System.out.println("Checking user in LegacyAuth system...");
        return "admin".equals(user) && "1234".equals(pass);
    }
}
class LegacyAuthAdapter implements Authenticator {
    private LegacyAuth legacyAuth;
    LegacyAuthAdapter(LegacyAuth legacyAuth) {
        this.legacyAuth = legacyAuth;
    }
    @Override
    public boolean login(String username, String password) {
        return legacyAuth.checkUser(username, password);
    }
}
public class Adapter {
    public static void main(String[] args) {
        Authenticator auth = new LegacyAuthAdapter(new LegacyAuth());
        System.out.println("Login attempt 1: " + auth.login("admin", "1234")); 
        System.out.println("Login attempt 2: " + auth.login("user", "wrong")); 
    }
}
