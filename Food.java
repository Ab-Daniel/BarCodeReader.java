import java.util.ArrayList;

public class Food {

public Food(String n, int bar, double p, String t) {
name = n;
barcode = bar;
price = p;
if(t.equalsIgnoreCase("t")) {
tax = true;
}
else {
tax = false;
}



}
public Food(int bar) {
name = "no such thing";
barcode = bar;
price = 0;
tax = false;
}
public String getName() {
return name;
}
public int getBarcode() {
return barcode;
}
public double price() {
return price;
}
public boolean getTax() {
return tax;
}
public double getPrice() {	
return price;
}
public String toString() {
return name + "......$" + getPrice();
}

public int findOrder(int key, ArrayList<Food> list, ArrayList<Food> list2) {

for(int i = 0; i < list.size(); i++) {
if(key == list.get(i).getBarcode()) {
return i;
}
}

return 0;
}

private String name; 
private int barcode;
private double price;
private boolean tax;
}
