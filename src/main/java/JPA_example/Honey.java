package JPA_example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Project: HibernateTutorial
 * FileName: Honey
 * Date: 2016-01-19
 * Time: 오전 10:55
 * Author: redfo
 * Note:
 * To change this template use File | Settings | File Templates.
 */
@Entity
@SequenceGenerator(name = "honey_seq", sequenceName = "honey_id_seq")
public class Honey implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "honey_seq")
    private Integer id;
    private String name;
    private String taste;
    @OneToMany(mappedBy = "honey")
    private Set<Bee> bees = new HashSet<Bee>();

    public Honey() {
    }

    public Honey(String name, String taste) {
        this.name = name;
        this.taste = taste;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public Set<Bee> getBees() {
        return bees;
    }

    public void setBees(Set<Bee> bees) {
        this.bees = bees;
    }

    @Override
    public String toString() {
        return "Honey{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taste='" + taste + '\'' +
                ", bees=" + bees +
                '}';
    }
}
