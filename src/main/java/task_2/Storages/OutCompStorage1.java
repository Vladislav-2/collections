package task_2.Storages;

import task_2.Exeptions.NotEnoughQuantity;
import task_2.Products.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutCompStorage1 implements Storage{

    private Map<Product, Integer> storage = new HashMap<Product, Integer>();

    public static final String DIRECTION = "OUT_COMP_STORAGE1";

    public void add(Product product, int quantity) {
        if (!list.contains(DIRECTION))
        list.add(DIRECTION);
        if (quantity != 0)
        storage.put(product,quantity);
    }

    public void add(Map<Product, Integer> produsts) {
        if (!list.contains(DIRECTION))
        list.add(DIRECTION);
        for (Product product : produsts.keySet()) {
            if (produsts.get(product) != 0)
            storage.put(product, produsts.get(product));
        }
    }

    public boolean contains(Product product) {
        return storage.containsKey(product);
    }

    public Map export(Product product, int quantity) throws Exception{
        if (storage.get(product) >= quantity){
            Map<Product, Integer> part = new HashMap<Product, Integer>();
            storage.put(product, storage.get(product) - quantity);
            if (storage.get(product) == 0){
                storage.remove(product);
            }
            part.put(product,quantity);
            return part;
        } else {
            throw new NotEnoughQuantity();
        }
    }

    public Map export(List<Product> exportPr, List <Integer> exportQuan) throws Exception{
        Map<Product, Integer> part = new HashMap<Product, Integer>();
        for (int i = 0; i < exportPr.size(); i++){
            if (storage.get(exportPr.get(i)) >= exportQuan.get(i)){
                storage.put(exportPr.get(i) , storage.get(exportPr.get(i)) - exportQuan.get(i));
                if (storage.get(exportPr.get(i)) == 0){
                    storage.remove(exportPr.get(i));
                }
                part.put(exportPr.get(i),exportQuan.get(i));
            } else {
                throw new NotEnoughQuantity();
            }
        }
        return part;
    }

    public Map content() { return storage; }
}
