
public class ImportantReminderTask implements Runnable {
	
	private Reminder reminder;
	
	public ImportantReminderTask(Reminder reminder) {
		super();
		this.reminder = reminder;
	}

	@Override
	public void run() {		
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(reminder);
		}
	}
	


}
