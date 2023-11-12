# Exemples JPA 1:N

## Exemples de relacions 1:N

- El carro de la compra i els ítems comprats
- El tutorial i els seus comentaris.
- Una empres i les seves ofertes de feina.

Conceptualment a nivell de disseny de base de dades relacional, l’esquema és el mateix. Una relació 1:N. En el fill ens guardarem la clau forana del pare.

Però quan treballem amb objectes hem de pensar què és el més eficient.

Diferents casuístiques: 

### El carro de la compra i els ítems comprats
Té sentit tenir els ítems com una llista dins el carro. En principi mai consultarem un ítem fora del seu carro. Consultarem els items d’un carro.

### El tutorial i els seus comentaris.
Podríem tenir els comentaris coma una llista dins el tutorial, però si un tutorial té 10.000 comentaris se’ns complica la cosa. Tot i que en principi no consultarem comentaris fora del tutorial corresponent. Consultarem els comentaris d’un tutorial.

### Una empres i les seves ofertes de feina.
Aquí sí que ens pot interessar consultar les ofertes d’una empresa, però també consultar ofertes en general per altres criteris…



Finalment ens pot interessar fer la direcció bidireccional:
https://www.baeldung.com/hibernate-one-to-many


```java
@Entity
@Table(name="CART")
public class Cart {

    //...

    @OneToMany(mappedBy="cart")
    private Set<Item> items;
	
    // getters and setters
}
```


Combinem la @OneToMany i la @ManyToOne
```java
@Entity
@Table(name="ITEMS")
public class Item {
    
    //...
    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;

    public Item() {}
    
    // getters and setters
}
```

https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
