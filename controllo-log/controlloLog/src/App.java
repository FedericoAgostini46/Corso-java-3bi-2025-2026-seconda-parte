import controllo_log.Logs;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Logs l1 = new Logs();
        Logs l2 = new Logs(5000);
        Logs l3 = new Logs(10000, 0.5);
    }
}
