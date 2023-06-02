package hw2;

public abstract class Actor implements ActorBehaviour {
    protected String name;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;
    abstract String getName();

    public Actor(String name) {
        this.name = name;
    }

    @Override
    public void setMakeOrder() {
        System.out.println("Клиент " + name + " оформил заказ");
        isMakeOrder = true;
    }

    @Override
    public void setTakeOrder() {
        System.out.println("Клиент " + name + " получил заказ");
        isTakeOrder = true;
    }

    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }
}
