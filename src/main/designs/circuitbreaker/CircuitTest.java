package main.designs.circuitbreaker;

public class CircuitTest {
    public static void main(String[] args) {
        CircuitOperation success = ()->{
            System.out.println("success");
            return CircuitOperation.Status.SUCCESS;
        },
                failed= ()->{
                    System.out.println("failed");
                    return CircuitOperation.Status.FAILED;
                },
                failed2 = ()->{
                    System.out.println("failed2");
                    return CircuitOperation.Status.FAILED;
                };
        Circuit circuit = new Circuit();
        Thread thread = new Thread(()->{
            circuit.addOperation(failed);
        });
        thread.start();
        thread = new Thread(()->circuit.addOperation(failed2));
        thread.start();
        thread= new Thread(()->circuit.addOperation(success));
        thread.start();
    }
}
