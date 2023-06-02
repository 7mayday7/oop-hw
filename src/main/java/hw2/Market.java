package hw2;

import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {
    private final List<Actor> actors;

    public Market() {
        actors = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        boolean isNameFound = false;
        for (Actor actorInList : actors) {
            if ((actorInList instanceof Human)
                    && ((Human) actorInList).getName().equals(((Human) actor).getName())) {
                System.out.printf("Клиент %s уже в магазине%n",
                        (((Human) actor).getName()));
                isNameFound = true;
                break;
            }
        }
        if (!isNameFound && actor instanceof Human) {
            actors.add(actor);
            System.out.printf("Клиент: %s пришел в магазин%n",
                    (((Human) actor).getName()));
        }
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actorInList : actors) {
            if (actorInList.isTakeOrder()) {
                System.out.printf("Клиент %s вышел из магазина",
                        (((Human) actorInList).getName()));
            }
        }
    }



    @Override
    public void takeInQueue(Actor actor) {
        boolean isUserFound = false;
        for (Actor actorInList : actors) {
            if ((actorInList instanceof Human)
                    && ((Human) actorInList).getName().equals(((Human) actor).getName())
                    && actor.isMakeOrder()) {
                System.out.printf("Клиент %s встал в очередь%n",
                        (((Human) actor).getName()));
                isUserFound = true;
                break;
            }
            if ((actorInList instanceof Human)
                    && ((Human) actorInList).getName().equals(((Human) actor).getName())) {
                System.out.printf("Клиент %s еще не в очереди%n",
                        (((Human) actor).getName()));
                isUserFound = true;
                break;
            }
        }
        if (!isUserFound && actor instanceof Human) {
            System.out.printf("Пользователь: %s не найден на маркетплейсе%n",
                    (((Human) actor).getName()));
        }
    }

    @Override
    public void takeOrders() {
        boolean isUserFound = false;
        for (Actor actor : actors) {
            if ((actor instanceof Human) && actor.isMakeOrder()) {
                System.out.printf("Клиент %s оформил заказ%n",
                        (((Human) actor).getName()));
                isUserFound = true;
            }
        }
        if (!isUserFound) {
            System.out.println("Заказов нет");
        }
    }

    @Override
    public void giveOrders() {
        boolean isUserFound = false;
        for (Actor actor : actors) {
            if ((actor instanceof Human)
                    && actor.isMakeOrder()
                    && !actor.isTakeOrder()) {
                System.out.printf("Клинт %s получил заказ%n",
                        (((Human) actor).getName()));
                isUserFound = true;
            }
        }
        if (!isUserFound) {
            System.out.println("Заказов нет");
        }
    }

    @Override
    public void releaseFromQueue() {
        for (int i = actors.size() - 1; i >= 0; i--) {
            if ((actors.get(i) instanceof Human) && actors.get(i).isTakeOrder()) {
                System.out.printf("Клиент %s вышел из очереди и готов уходить%n",
                        (((Human) actors.get(i)).getName()));
                actors.remove(actors.get(i));
            }
        }
    }

    @Override
    public void update() {
        int lineWidth = 60, counter = 1;
        String lineChar = " ";
        System.out.println();
        System.out.println(lineChar.repeat(lineWidth));
        System.out.println("Статус магазина: ");
        for (Actor actor : actors) {
            if (actor instanceof Human) {
                takeInQueue(actor);
            }
        }
        takeOrders();
        giveOrders();
        System.out.println(lineChar.repeat(lineWidth));
        System.out.printf(" %-2s %-18s  %-14s  %-14s %n", "№", "Данные лиента", "Заказ размещен", "Заказ получен");
        System.out.println(lineChar.repeat(lineWidth));
        for (Actor actor : actors) {
            System.out.printf(" %-2s %-18s ", counter, ((Human) actor).getName());
            if (actor.isMakeOrder()) {
                System.out.printf(" %7s%8s", "+", " ");
            } else {
                System.out.printf(" %15s", " ");
            }
            if (actor.isTakeOrder()) {
                System.out.printf(" %7s%8s", "+", " ");
            } else {
                System.out.printf(" %15s", " ");
            }
            System.out.printf("%n");
            counter++;
        }
        System.out.println(lineChar.repeat(lineWidth));
        releaseFromQueue();
    }
}
