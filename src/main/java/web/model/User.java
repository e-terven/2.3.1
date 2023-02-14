package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users_231")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @Column (name = "name")
    private String name;
    @Column (name = "age")
    private int age;

    public User () { }
    public User(String name, int age) {
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
        return id + ". User: " + name + ", " + age;
    }
}
