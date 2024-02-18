public class Customer {
    private int arrivalTime;
    private int executionTime;
    private int waitingTime;
    private int startTime;
    private int completionTime;
    private int id;

    public Customer( int id, int arrivalTime, int executionTime, int waitingTime, int startTime, int completionTime) {
        this.arrivalTime = arrivalTime;
        this.executionTime = executionTime;
        this.waitingTime = waitingTime;
        this.startTime = startTime;
        this.completionTime = completionTime;
        this.id = id;
    }

    public int getWaitingTime() {
        return waitingTime;
    }


    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public Customer(int arrivalTime, int executionTime, int id){
        this.arrivalTime = arrivalTime;
        this.executionTime = executionTime;
        this.id = id;
    }
    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }



    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
