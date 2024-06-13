package sg.nus.iss.com.Leaveapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LeaveType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String type;

    // Getters and Setters
    
    public Long getId() { return id; }
    
    public void setId(Long id) { this.id = id; }
    

    
    public String getType() { return type; }
    
    public void setType(String type) { this.type = type; }
    
    
    
    
}
