
public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("1");
        list.add("3");
        list.add("3");
        list.add("4");
        list.add("4");
        list.add("5");
        list.add("6");
        System.out.println(list.isExist("3232"));
        System.out.println(list);
        System.out.println(list.get(1));
        list.clear();
        list.remove("3");
        System.out.println(list);
    }
}