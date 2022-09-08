package javaPrj;

import java.util.Timer;
import java.util.TimerTask;

public class StopWatch {
    Timer timer;
    
    public StopWatch(int seconds) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new RepeatedTask(), 500, 1000);
    }

    public static void main(String[] args) {
        new StopWatch(15);
    }
    class RepeatedTask extends TimerTask {
    	int a=15;
        public void run() {
        	if(a>0) {
				System.out.print(a+" ");
				a--;
			}else {
				timer.cancel();
			}
        }
    }
}

