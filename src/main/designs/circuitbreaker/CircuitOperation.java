package main.designs.circuitbreaker;

public interface CircuitOperation {
    enum Status{
        SUCCESS,FAILED
    }

    public Status operation();

}
