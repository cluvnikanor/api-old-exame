import java.util.Calendar;
import java.util.Scanner;
import java.util.TreeSet;

public class ReminderSystem {
	
	private TreeSet<Reminder> reminders = new TreeSet<Reminder>();
	private ReminderTask task;
	
	public ReminderSystem() {
		super();
	}
	
	public boolean addReminder(Reminder reminder) {
		if (reminders.add(reminder))
			return true;
		return false;
	}

	public TreeSet<Reminder> getReminders() {
		return reminders;
	}

	public void reminderMenu() {
		
		task  = new ReminderTask(reminders);
		Thread taskThread = new Thread(task);
		taskThread.start();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int cmd = 0;
		
		while (cmd != 3) {	
			System.out.println("\n=====================================");
			System.out.println("= 1 - Add Reminder                  =");
			System.out.println("= 2 - Reminder List                 =");
			System.out.println("= 3 - Exit                          =");
			System.out.println("=====================================");
			cmd = scanner.nextInt();
			
			if (cmd == 1 ) {
				System.out.println("reminder year:");
				int year= scanner.nextInt();
				System.out.println("reminder month:");
				int month= scanner.nextInt();
				System.out.println("reminder day:");
				int day= scanner.nextInt();
				System.out.println("reminder hour:");
				int hour= scanner.nextInt();
				System.out.println("reminder min:");
				int minute= scanner.nextInt();
				System.out.println("reminder text:");
				String text = scanner.next();
				System.out.println("is important?");
				boolean important = false;
				if (scanner.next()=="true") 
					important = true;
				
				Calendar expiration = Calendar.getInstance();
				expiration.set(year, month, day, hour, minute, 0);
				Reminder reminder = new Reminder(expiration, text, important);	
				if (!reminders.contains(reminder)) {
					addReminder(reminder);
					System.out.println("Reminder Added");
				}
				else {
					System.out.println("Duplicate Reminder");
				}
			}
			else if (cmd==2) {
				System.out.println(reminders);
			}
				
			
		}
	}


	@Override
	public String toString() {
		return "ReminderSystem [reminders=" + reminders + ", task=" + task + "]";
	}
	
	
}
