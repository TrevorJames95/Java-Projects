package machine;

public class Coffee {

    int cash = 550;
    int milk = 540;
    int water = 400;
    int beans = 120;
    int cups = 9;
    String option = "";

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk += milk;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water += water;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans += beans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups += cups;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void coffeeCheck() {
        boolean canMake = mkCups();

        if (canMake) {
            switch (option) {
                case "1":
                    water -= 250;
                    beans -= 16;
                    cups --;
                    cash += 4;
                    break;

                case "2":
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups --;
                    cash += 7;
                    break;

                case "3":
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cash += 6;
                    cups --;
                    break;
                case "back":
                    break;

                default:
                    break;
            }

            displayMachine();
        }
    }

    public boolean mkCups(){
        switch (option){
            case "1":
            {
                if(water >= 250 && beans >= 16 && cups > 0){
                    System.out.println("I have enough resources, making you a coffee!");
                    return true;
                }
                else{
                    return false;
                }
            }

            case "2":
            {
                if(milk >= 75 && water >= 350 && beans >= 20 && cups > 0){
                    System.out.println("I have enough resources, making you a coffee!");
                    return true;
                }
                else{
                    if(water < 350){
                        System.out.println("Sorry, not enough water!");
                    }
                    return false;
                }
            }

            case "3":
            {
                if(milk >= 100 && water >= 200 && beans >= 12 && cups > 0){
                    System.out.println("I have enough resources, making you a coffee!");
                    return true;
                }
                else{
                    return false;
                }
            }

            default:
                break;

        }
        return false;
    }

    public void displayMachine(){
        System.out.println("The coffee machine has: ");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.beans + " of of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println(this.cash + " of money");
    }

}
