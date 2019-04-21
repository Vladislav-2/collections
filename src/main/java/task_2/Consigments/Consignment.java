package task_2.Consigments;

import task_2.CoWorkeres.CoWorkers;
import task_2.Products.Product;
import task_2.Proxy.Proxy;
import task_2.Storages.Storage;

import java.util.List;

public interface Consignment {

    public void Consignment1();

    public void setDate(List<Integer> date);

    public void setSender(Storage sender);

    public void setAddressee(Storage addressee);

    public void setText(String text);

    public void setProxy(Proxy proxy);

    public void setName(Product name);

    public void setQuantity(Integer quantity);

    public void setCost(Integer cost);

    public void setSum();

    public void setLetGo(CoWorkers letGo);

    public void setReceived(CoWorkers received);

    public void writeIn() throws Exception;

}
