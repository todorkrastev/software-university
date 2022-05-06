package hiberspring.domain.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="branches")
public class Branch extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Town town;

    @OneToMany(mappedBy = "branch", fetch = FetchType.EAGER)
    private Set<Product> products;

    public Branch() {
        this.products = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
