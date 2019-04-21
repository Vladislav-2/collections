package task_2.Storages;

import task_2.Products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Storage {

    List<String> list = new ArrayList<String>();

    void add(Product product, int quantity);

    void add(Map<Product, Integer> produsts);

    boolean contains(Product product);

    Map export (Product product, int quantity) throws Exception;

    Map export (List<Product> exportPr, List <Integer> exportQuan) throws Exception;

    Map content();

}
