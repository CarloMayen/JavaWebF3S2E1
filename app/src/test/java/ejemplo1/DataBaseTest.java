package ejemplo1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DataBaseTest {
    private DataBase db;

    @BeforeEach
    void setUp() {
        db = new DataBase();
    }

    @Test
    @DisplayName("The size of an empty database is zero")
    void testSize() {
        assertEquals(0, db.size());
    }

    @Test
    @DisplayName("DataBase can write data.")
    void testInsert() {
        db.insert(new Product(1, "Product 1"));
        db.insert(new Product(2, "Product 2"));
        assertEquals(2, db.size());
    }

    @Test
    @DisplayName("DataBase can read data.")
    void testGetById() {
        db.insert(new Product(1, "Product 1"));
        db.insert(new Product(2, "Product 2"));
        db.insert(new Product(3, "Product 3"));
        db.insert(new Product(4, "Product 4"));
        Product p = new Product(2, "Product 2");

        assertEquals(2, db.getById(2).getId());
        assertEquals("Product 2", db.getById(2).getName());
    }

    @Test
    @DisplayName("DataBase can delete data.")
    void testClear() {
        db.insert(new Product(1, "Product 1"));
        db.insert(new Product(2, "Product 2"));
        db.insert(new Product(3, "Product 3"));
        db.insert(new Product(4, "Product 4"));
        assertEquals(4, db.size());
        db.clear();
        assertEquals(0, db.size());
    }

    @Test
    @DisplayName("DataBase can update data.")
    void testUpdate() {
        db.insert(new Product(1, "Product 1"));
        db.insert(new Product(2, "Product 2"));
        db.insert(new Product(3, "Product 3"));
        db.insert(new Product(4, "Product 4"));
        db.update(2, "Producto dos");
        assertEquals("Producto dos", db.getById(2).getName());
    }

    @Test
    @DisplayName("DataBase can delete data by id.")
    void testDelete() {
        db.insert(new Product(1, "Product 1"));
        db.insert(new Product(2, "Product 2"));
        db.insert(new Product(3, "Product 3"));
        db.insert(new Product(4, "Product 4"));
        assertEquals(4, db.size());
        db.delete(3);
        assertEquals(3, db.size());
    }
}
