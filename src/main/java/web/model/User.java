package web.model;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age")
    private Byte age;

    @Column(name = "name")
    private String name;

    public User () { }
    public User(String name, Byte age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(Byte age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return  id + " .User: " + name + ", " + age;
    }
}
