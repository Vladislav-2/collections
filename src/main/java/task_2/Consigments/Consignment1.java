package task_2.Consigments;

import task_2.CoWorkeres.CoWorkers;
import task_2.Exeptions.NotEnoughQuantity;
import task_2.Exeptions.NotFullConsigment;
import task_2.Products.Product;
import task_2.Proxy.Proxy;
import task_2.Storages.Storage;

import java.util.ArrayList;
import java.util.List;

public class Consignment1 implements Consignment {

    private List<Integer> date = new ArrayList<Integer>();
    private Storage sender;
    private Storage addressee;
    private String text;
    private Proxy proxy;

    private List <Product> name = new ArrayList<Product>();
    private List <Integer> quantity = new ArrayList<Integer>();
    private List <Integer> cost = new ArrayList<Integer>();
    private List <Integer> sum = new ArrayList<Integer>();

    private CoWorkers letGo;
    private CoWorkers received;

    public void Consignment1(){}

    public void setDate(List<Integer> date) {
        this.date = date;
    }

    public void setSender(Storage sender) {
        this.sender = sender;
    }

    public void setAddressee(Storage addressee) {
        this.addressee = addressee;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public void setName(Product name) {
        this.name.add(name);
    }

    public void setQuantity(Integer quantity) {
        this.quantity.add(quantity);
    }

    public void setCost(Integer cost) {
        this.cost.add(cost);
    }

    public void setSum() {
        this.sum.add(cost.get(sum.size()) + quantity.get(sum.size()));
    }

    public void setLetGo(CoWorkers letGo) {
        this.letGo = letGo;
    }

    public void setReceived(CoWorkers received) {
        this.received = received;
    }

    public void writeIn() throws Exception{
        if (date != null
                && sender != null
                && text != null
                && proxy != null
                && name != null
                && name.size() == quantity.size()
                && name.size() == cost.size()
                && name.size() == sum.size()
                && letGo != null
                && received != null
                && !quantity.contains(0))
        {
            if (name.size() == sender.content().size()) {
                addressee.add(sender.export(name, quantity));
            } else {
                throw new NotEnoughQuantity();
            }
        } else {
            throw new NotFullConsigment();
        }
    }
}
