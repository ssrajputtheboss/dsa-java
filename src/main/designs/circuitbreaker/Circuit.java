package main.designs.circuitbreaker;

import java.util.ArrayDeque;
import java.util.Deque;


public class Circuit {
    private enum State{
        OPEN,CLOSE,HALF_OPEN
    }
    private static final int TIMEOUT_MILLIS = 1000; // 1 minute
    private static final int RETRY_LIMIT = 2;


    private int retries;
    private final Object lock = new Object();
    private boolean running;
    private State circuitState;
    private void startExecution(){
        synchronized (lock){
            System.out.println(operationQueue.isEmpty());
            if(!operationQueue.isEmpty()){
                System.out.println("running now");
                running = true;
                run();
            }
        }
    }

    private void stopExecution(){
        synchronized (lock){
            if(operationQueue.isEmpty())
                this.running = false;
        }
    }

    private final Deque<CircuitOperation> operationQueue;

    public Circuit() {
        this.operationQueue = new ArrayDeque<>();
        running = false;
        retries = 0;
        circuitState=State.CLOSE;
    }

    public void addOperation(CircuitOperation operation){
        operationQueue.add(operation);
        if(!running){
            startExecution();
        }
    }

    private void updateStateOnFailure(){
        retries++;
        if(retries >= RETRY_LIMIT && !circuitState.equals(State.OPEN)){
            circuitState = State.OPEN;
        }else if(circuitState.equals(State.CLOSE)){
            circuitState = State.HALF_OPEN;
        }
    }

    private void run(){
        if(operationQueue.isEmpty()){
             stopExecution();
             return;
        }
        if(circuitState.equals(State.OPEN)){
            restartAfterTimeout();
            return;
        }
        System.out.println(circuitState);
        CircuitOperation operation = operationQueue.peekFirst();
        assert operation != null;
        CircuitOperation.Status status = operation.operation();
        if(status.equals(CircuitOperation.Status.SUCCESS)){
            operationQueue.removeFirst();
            clearRetry();
        }else {
            updateStateOnFailure();
        }
        run();
    }

    private void restartAfterTimeout(){
        try{
            stopExecution();
            Thread.sleep(TIMEOUT_MILLIS);
        } catch (InterruptedException ignored) {
        }finally {
            clearRetry();
            // remove failed for testing
            operationQueue.removeFirst();
            circuitState = State.CLOSE;
            startExecution();
        }
    }

    private void clearRetry(){
        retries=0;
    }


}
