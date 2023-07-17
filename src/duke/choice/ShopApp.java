
package duke.choice;

import java.util.*;
import java.util.concurrent.*;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ShopApp {
    public static void main(String[] args) {
        //double tax=0.2;
        double total = 0.0;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter our measurement size: ");
        int measurement = 13;
        System.out.println("min price of any item is :"+Clothing.minPrice);
        System.out.println("welcome to Duke Choice Shop");

        Customer c1 = new Customer("pinky", measurement);
        //c1.setName("Pinky");

        //c1.setSize(measurement);

        System.out.println("customer is " + c1.getName() + " size : " + c1.getSize());

        Clothing[] items = {new Clothing("Blue Jacket", 20.9, "M"),
                new Clothing("Orange T-Shirt", 10.5, "S"),
                new Clothing("Green Scraft", 11, "S"),
                new Clothing("Blue T-shirt", 10, "S")};

        try{
            ItemList list =new ItemList(items);
            Routing routing=Routing.builder().get("/items",list).build();
            ServerConfiguration config = ServerConfiguration.builder()
                    .bindAddress(InetAddress.getLocalHost())
                    .port(8888).build();
            WebServer ws=WebServer.create(config,routing);
            ws.start();
        }catch (UnknownHostException ex){
            ex.printStackTrace();
        }
        /*items[0].setDescription("Blue Jacket");
        items[0].setPrice(20.9);
        items[0].setSize("M");
*/
        //System.out.println(item1.description+", "+item1.price+", "+item1.size);

        /*items[1].setDescription("Orange T-Shirt");
        items[1].setPrice(10.5);
        items[1].setSize("S");

        items[2].setDescription("Green Scraaft");
        items[2].setPrice(11);
        items[2].setSize("S");

        items[3].setDescription("Blue T-shirt");
        items[3].setPrice(10);
        items[3].setSize("S");*/

        c1.addItems(items);
        //System.out.println(item2.description+", "+item2.price+", "+item2.size);

        //total=((2* item2.price)+(item1.price))*(1+tax);
        System.out.println("Items available in the shop:");
        for (Clothing item : items) {
            System.out.println("items are :"+item);
        }
        System.out.println("Customer is : " + c1.getName() + ", " + c1.getSize());
        int average=0;
        int count=0;
        for (Clothing item : items) {
            if (item.getSize().equals(c1.getSize())) {
                System.out.println("Purchased items are : " + item);
                average+=item.getPrice();
                count++;
            }

        }

        try {
            average = (count==0) ? 0:average / count;
            System.out.println("average value is : " + average + " count : " + count);
            System.out.println("Total amount of your purchased order is " + c1.getTotalClothingCost());
        }catch (ArithmeticException e){
            System.out.println("dont divide by zero");
        }
        Arrays.sort(c1.getItems());
        for (Clothing item : items) {
            if (item.getSize().equals(c1.getSize())) {
                System.out.println("Purchased items are : " + item);
                average+=item.getPrice();
                count++;
            }

        }
    }
}