import org.junit.Assert;
import org.junit.Test;
import task_2.CoWorkeres.LetGo;
import task_2.CoWorkeres.Received;
import task_2.Consigments.Consignment;
import task_2.Consigments.Consignment1;
import task_2.Exeptions.NotEnoughQuantity;
import task_2.Exeptions.NotFullConsigment;
import task_2.Products.Product;
import task_2.Service;
import task_2.Storages.OutCompStorage1;
import task_2.Storages.Storage;
import task_2.Storages.Storage1;
import task_2.Proxy.Proxy;

import java.util.ArrayList;
import java.util.List;

public class XXXTest {

    private Consignment cons = new Consignment1();
    private List<Integer> date = new ArrayList<Integer>();
    private Storage storage = new Storage1();
    private Storage outCompStorage1 = new OutCompStorage1();

    {
                 date.add(9);
                 date.add(3);
                 date.add(2019);

            outCompStorage1.add(Product.ARMCHAIR, 1);
            outCompStorage1.add(Product.CONDUCTOR,12);
            outCompStorage1.add(Product.SCREEN, 3);
            outCompStorage1.add(Product.PLANK,54);
            outCompStorage1.add(Product.PHONE, 6);
            outCompStorage1.add(Product.TABLE, 9);

        cons.setDate(date);

        cons.setSender(outCompStorage1);
        cons.setAddressee(storage);
        cons.setText("to do something");
        cons.setProxy(Proxy.PROXY_1);

        cons.setName(Product.ARMCHAIR);
        cons.setName(Product.CONDUCTOR);
        cons.setName(Product.SCREEN);
        cons.setName(Product.PLANK);
        cons.setName(Product.PHONE);
        cons.setName(Product.TABLE);

        cons.setQuantity(1);
        cons.setQuantity(12);
        cons.setQuantity(3);
        cons.setQuantity(54);
        cons.setQuantity(6);
        cons.setQuantity(9);

        cons.setCost(23);
        cons.setCost(230);
        cons.setCost(3);
        cons.setCost(45);
        cons.setCost(834);
        cons.setCost(2);

        cons.setSum();
        cons.setSum();
        cons.setSum();
        cons.setSum();
        cons.setSum();
        cons.setSum();

        cons.setLetGo(new LetGo());
        cons.setReceived(new Received());
    }

    @Test
    public void consignmentWriteInTest() throws Exception{
        System.out.println("storage : " + storage.content());
        System.out.println("out company storage : " + outCompStorage1.content());

        cons.writeIn();

        System.out.println("storage : " + storage.content());
        System.out.println("out company storage : " + outCompStorage1.content());
    }

    @Test
    public void NotEnoughQuantityTest() throws Exception{
        try {
            outCompStorage1.export(Product.ARMCHAIR, 2);
        } catch (NotEnoughQuantity e){
            Assert.assertNotNull(e);
        }
        outCompStorage1.export(Product.ARMCHAIR, 1);
        try {
            cons.writeIn();
        } catch (NotEnoughQuantity e){
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void NotFullConsigment() throws Exception{
        Consignment consignment = new Consignment1();
        try {
            consignment.writeIn();
        } catch (NotFullConsigment e){
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void ListOfProductsTest(){
        Service service = new Service();
        System.out.println(service.contains(outCompStorage1));
    }

    @Test
    public void ListOfSebdersTest(){
        Service service = new Service();
        System.out.println(service.listOfStorage());
    }

    @Test
    public void FoundProductTest(){
        Service service = new Service();
        Assert.assertTrue(service.found(outCompStorage1, Product.ARMCHAIR));
    }

}
