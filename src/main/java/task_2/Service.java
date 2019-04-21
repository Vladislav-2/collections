package task_2;

import task_2.Products.Product;
import task_2.Storages.Storage;

import java.util.List;
import java.util.Map;

public class Service {

    public Map contains(Storage storage){
        return storage.content();
    }

    public List listOfStorage(){
        return Storage.list;
    }

    public boolean found(Storage storage, Product product){
        return storage.contains(product);
    }
}
