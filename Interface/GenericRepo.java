import java.util.*;
interface Repository<T, ID> {
    void save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
}
class User {
    private Integer id;
    private String name;
    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() { return id; }
    public String getName() { return name; }
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}
class InMemoryUserRepo implements Repository<User, Integer> {
    private Map<Integer, User> store = new HashMap<>();
    @Override
    public void save(User entity) {
        store.put(entity.getId(), entity);
    }
    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(store.get(id));
    }
    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }
    @Override
    public void deleteById(Integer id) {
        store.remove(id);
    }
}
public class GenericRepo {
    public static void main(String[] args) {
        Repository<User, Integer> userRepo = new InMemoryUserRepo();
        userRepo.save(new User(1, "Shashi"));
        userRepo.save(new User(2, "Shekhar"));
        System.out.println("All users: " + userRepo.findAll());
        userRepo.findById(1).ifPresent(user -> System.out.println("Found: " + user));
        userRepo.deleteById(2);
        System.out.println("After deletion: " + userRepo.findAll());
    }
}
