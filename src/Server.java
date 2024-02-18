import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Server extends Rectangle {
    private boolean busy = false;
    private Customer servingCustomer;
    private int serviceTime;
    private final List<Customer> completed;

    public Server(){
        this.busy = false;
        completed = new ArrayList<>();
    }
    public void startServing(Customer customer, int currentTime){
        servingCustomer = customer;
        busy = true;
        serviceTime = currentTime;

        int waitingTime = currentTime - customer.getArrivalTime();
        int arrivalTime = customer.getArrivalTime();
        int executionTime = customer.getExecutionTime();
        int completionTime = currentTime + executionTime;
        int id = customer.getId();
        completed.add(new Customer(id, arrivalTime, executionTime, waitingTime, currentTime, completionTime));
    }
    public void update(int currentTime){
            if (busy && currentTime - serviceTime >= servingCustomer.getExecutionTime()) {
                busy = false;
            }
    }
    public void draw(Graphics g){
        g.drawString("Completed Tasks",370, 70);
        g.drawString("Arrival Time: ", 550, 70);
        g.drawString("Waiting Time: ", 670, 70);
        g.drawString("Start Time: ", 800, 70);
        g.drawString("Execution Time: ", 920, 70);
        g.drawString("Completion Time: ", 1070, 70);

        int ypos = 90;
        for(int i=0; i<completed.size()-1; i++){
            g.setColor(Color.BLACK);
            g.drawString("Customer: "+Integer.toString(completed.get(i).getId()), 370, ypos);
            g.drawString(Integer.toString(completed.get(i).getArrivalTime()), 550, ypos);
            g.drawString(Integer.toString(completed.get(i).getWaitingTime()), 670, ypos);
            g.drawString(Integer.toString(completed.get(i).getStartTime()), 800, ypos);
            g.drawString(Integer.toString(completed.get(i).getExecutionTime()), 920, ypos);
            g.drawString(Integer.toString(completed.get(i).getCompletionTime()), 1070, ypos);

            ypos += 20;
        }
        if(busy){
            g.setColor(Color.RED);
            g.fillRect(200, 150, 150, 100);
            g.setColor(Color.BLACK);
            g.drawString("Serving ", 210, 170);
            g.drawString("Customer: "+Integer.toString(servingCustomer.getId()), 210, 190);

        }else{
            g.setColor(Color.GREEN);
            g.fillRect(200, 150, 150, 100);
            g.setColor(Color.BLACK);
            g.drawString("Idle",210, 170);
        }
    }

    public boolean isBusy() {
        return busy;
    }
}