package cl.inacap.exam.models;

import java.util.Date;
import java.util.HashMap;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="citas")
public class Cita {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=4, message="Minimo 4 caracteres")
	private String task;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@Column(name="updatedDateTime")
	private LocalDate date3;
	private String status;
	@Column(updatable = false)
	private Date createdAt;
	@Column(updatable = false)
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user; // Este es el usuario que realiza la cita
	
	
	public Cita () {
		
		
	}
	
	public String getFormatDate() {
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dFormat.format(date);
	}
	
	public void newDate() {
		LocalDate n =  LocalDate.now();
		 setDate3(n);
	}
	
	public HashMap<String, String> getOptionsStatus(){
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("Pending", "Pending");
		options.put("Missed", "Missed");
		options.put("Done", "Done");
		return options;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
		this.date3 = LocalDate.now();
	}

	public LocalDate getDate3() {
		return date3;
	}

	public void setDate3(LocalDate date3) {
		this.date3 = date3;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
