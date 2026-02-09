package main.designs.composite;

public class CompTest {
    static void test(){
        BoxItem boxItem = new BoxItem();
        SmartPhone sm = new SmartPhone();
        EarBuds buds = new EarBuds();
        boxItem.getItems().add(sm);
        boxItem.getItems().add(buds);
        boxItem.getItems().forEach(Item::print);
    }
}
