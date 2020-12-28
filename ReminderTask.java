import java.util.Calendar;
import java.util.Iterator;
import java.util.TreeSet;

public class ReminderTask implements Runnable {
	
	private TreeSet<Reminder> reminders = new TreeSet<Reminder>();

	public ReminderTask(TreeSet<Reminder> reminders) {
		super();
		this.reminders = reminders;
	}
	
	@Override
	public void run() {
		Iterator<Reminder> itr = reminders.iterator();
		while (itr.hasNext()) {
			if (((Reminder) itr).getExpiration().before(Calendar.getInstance())) {
				System.out.println((Reminder) itr);
				((Reminder) itr).setPoped(true);
				if (((Reminder) itr).isImportant()){
					//call ImportantReminderTask
					ImportantReminderTask task = new ImportantReminderTask((Reminder) itr);
					Thread taskThread = new Thread(task);
					taskThread.start();
				}
			}
			itr.next();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public String toString() {
		return "ReminderTask [reminders=" + reminders + "]";
	}
	
	

}
