package interfaces;

import interfaces.impl.BeanFishBurnShop;
import interfaces.impl.PizzaFishBurnShop;

public class FishBurnShop {

    public static void main(String[] args) {

        String headOfficeName = FishBurnMachineDesign.headOfficeName();
        System.out.println("headOfficeName = " + headOfficeName);

        BeanFishBurnShop beanShop = new BeanFishBurnShop();
        String beanTaste  = beanShop.taste();
        int beanRoastTime = beanShop.roastTime();
        int beanFirePower = beanShop.firePower();
        int beanElectricityConsumption = beanShop.electricityConsumption();
        String beanSignatureBurn = beanShop.signatureBurn();
        String beanShopName = beanShop.shopName("팥");

        System.out.println("beanShopName : " + beanShopName);
        System.out.println("beanTaste : " + beanTaste);
        System.out.println("beanRoastTime : " + beanRoastTime);
        System.out.println("beanFirePower : " + beanFirePower);
        System.out.println("beanElectricityConsumption : " + beanElectricityConsumption);
        System.out.println("beanSignatureBurn : " + beanSignatureBurn);

        PizzaFishBurnShop pizzaShop = new PizzaFishBurnShop();
        String pizzaTaste  = pizzaShop.taste();
        int pizzaRoastTime = pizzaShop.roastTime();
        int pizzaFirePower = pizzaShop.firePower();
        int pizzaElectricityConsumption = pizzaShop.electricityConsumption();
        String pizzaSignatureBurn = pizzaShop.signatureBurn();
        String pizzaShopName = pizzaShop.shopName("피자");

        System.out.println("pizzaShopName : " + pizzaShopName);
        System.out.println("pizzaTaste : " + pizzaTaste);
        System.out.println("pizzaRoastTime : " + pizzaRoastTime);
        System.out.println("pizzaFirePower : " + pizzaFirePower);
        System.out.println("pizzaElectricityConsumption : " + pizzaElectricityConsumption);
        System.out.println("pizzaSignatureBurn : " + pizzaSignatureBurn);
    }
}