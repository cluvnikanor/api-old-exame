import java.util.Calendar;

public class Reminder implements Comparable <Reminder> {
	
	private Calendar expiration;
	private String text;
	private boolean important;
	private boolean poped;

	public Calendar getExpiration() {
		return expiration;
	}
	public void setExpiration(Calendar expiration) {
		this.expiration = expiration;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isImportant() {
		return important;
	}
	public void setImportant(boolean important) {
		this.important = important;
	}
	public boolean isPoped() {
		return poped;
	}
	public void setPoped(boolean poped) {
		this.poped = poped;
	}

	public Reminder(Calendar expiration, String text, boolean important) {
		super();
		this.expiration = expiration;
		this.text = text;
		this.important = important;
		
		
	}
	
	@Override
	public int compareTo(Reminder o) {
		return expiration.compareTo(o.expiration);
	}
	@Override
	// Returns true even if one of the field equals, for later use at ReminderSystem
	public boolean equals(Object o) {
		if (!(o instanceof Reminder))
            return false; 
		Reminder r = (Reminder)o;
		return expiration.equals(r.expiration) || text.equals(r.text);
	}
	@Override
	public String toString() {
		return "\n" +  text + "\n\t" + expiration.getTime() + "\n\timportant=" + important + ", poped=" + poped + "\n";
	}
	
	
	
	
}
