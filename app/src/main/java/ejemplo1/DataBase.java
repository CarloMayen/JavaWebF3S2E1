package ejemplo1;

import java.util.LinkedList;
import java.util.List;

public class DataBase {
    private List<Product> db;

    public DataBase() {
        db = new LinkedList<>();
    }

    public void insert(Product data) {
        db.add(data);
    }

    public int size() {
        return db.size();
    }

    public Product getById(long id) {
        for (Product product : db) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public void update(long id, String name){
        for (Product product : db) {
            if (product.getId() == id) {
                product.setName(name);
                break;
            }
        }
    }

    public void delete(long id){
        for (Product product : db) {
            if (product.getId() == id) {
                db.remove(product);
                break;
            }
        }
    }

    public void clear() {
        db.clear();
    }
}
