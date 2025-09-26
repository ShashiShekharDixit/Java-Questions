import java.util.List;
import java.util.stream.Collectors;
class UserEntity {
    private Long id;
    private String username;
    private String email;
    public UserEntity(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
}
class UserDTO {
    private String username;
    private String email;
    public UserDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
}
class UserMapper {
    static UserDTO toDTO(UserEntity entity) {
        return new UserDTO(entity.getUsername(), entity.getEmail());
    }
    static UserEntity toEntity(UserDTO dto) {
        return new UserEntity(null, dto.getUsername(), dto.getEmail());
    }
    static List<UserDTO> toDTOList(List<UserEntity> entities) {
        return entities.stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }
}
public class DtoEntityMapping {
    public static void main(String[] args) {
        UserEntity entity = new UserEntity(1L, "Shashi", "Shashiswadh20@gmail.com");
        UserDTO dto = UserMapper.toDTO(entity);
        System.out.println("DTO: " + dto.getUsername() + ", " + dto.getEmail());
        UserEntity newEntity = UserMapper.toEntity(dto);
        System.out.println("Entity: " + newEntity.getUsername() + ", " + newEntity.getEmail());
    }
}
