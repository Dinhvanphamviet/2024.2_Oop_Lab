public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;  

    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;     

    public int addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The DVD \"" + disc.getTitle() + "\" has been added!");
            return 1;
        } else {
            System.out.println("The cart is full. Can't add more discs.");
            return 0;
        }
    }

    public int addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        int added = 0;
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The DVD \"" + disc.getTitle() + "\" has been added!");
                added++;
            } else {
                System.out.println("The cart is full. Can't add more discs.");
                break;
            }
        }
        return added;
    }

    public int addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        int added = 0;
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("The DVD \"" + dvd1.getTitle() + "\" has been added!");
            added++;
        }
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The DVD \"" + dvd2.getTitle() + "\" has been added!");
            added++;
        }
        return added;
    }

    public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("Removed DVD \"" + disc.getTitle() + "\" successfully!");
                return 1;
            }
        }
        System.out.println("No matching DVD found!");
        return 0;
    }

    public float totalCost() {
        float sum = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
    
    public void displayInfo() {
        System.out.println("********************* CART **************************");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCost() + " $");
        }
        System.out.println("***************************************************");
    }
}
