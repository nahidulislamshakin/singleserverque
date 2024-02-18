import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SingleServerQueueSystem extends JFrame {
    Queue<Customer> queue;
    Server server;
    Timer timer;
    int currentTime;
    public static int id = 1;
    Random random;
    public SingleServerQueueSystem(){
        setTitle("Single Server Queue System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        queue = new LinkedList<>();
        server = new Server();
        random = new Random();
        currentTime = 0;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTime++;
                updateQueue();
                repaint();
            }
        });
        timer.start();
    }
    public void updateQueue(){
        int x = random.nextInt();
        BigInteger bi = new BigInteger(String.valueOf(currentTime));
        if(bi.isProbablePrime(10)){
            int executionTime = random.nextInt(10) + 1;
            queue.offer(new Customer(currentTime, executionTime, id));
            id++;
        }

        if(!server.isBusy() && !queue.isEmpty()){
            Customer customer = queue.poll();
            server.startServing(customer, currentTime);
        }
        server.update(currentTime);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font customFont = new Font("Arial", Font.BOLD, 16);
        g.setFont(customFont);

        g.setColor(Color.BLACK);
        g.drawString("Queue", 50,70);
        int yPos = 90;
        for(Customer customer: queue){
            g.drawString("Customer " + customer.getId(), 50, yPos);
            yPos += 20;
        }
        server.draw(g);
        g.drawString("Time: "+ currentTime, 200, 70);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SingleServerQueueSystem system = new SingleServerQueueSystem();
                system.setVisible(true);
            }
        });
    }
}
