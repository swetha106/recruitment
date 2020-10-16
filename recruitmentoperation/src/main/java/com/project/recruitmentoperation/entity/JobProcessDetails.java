package com.project.recruitmentoperation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "jobprocess")

public class JobProcessDetails {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "jid")
	    private int jid;
	
	 private int currentround;
	 private int marks;
	 private boolean selected;
	 private byte[] resume;
//	 private int id;
  @OneToOne
  private User user;
	  public int getJid() {
	        return jid;
	    }

	    public void setJid(int id) {
	        this.jid = jid;
	    }
/*
  public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }
*/
	    public int getMarks() {
	        return marks;
	    }

	    public void setMarks(int marks) {
	        this.marks = marks;
	    }
	    public Boolean getSelected() {
		    return selected;
		  }

		  public void setSelected(Boolean selected) {
		    this.selected = selected;
		  }

	 
	 
	 @Column(name = "resume")
	    public byte[] getResume() {
	        return resume;
	    }
	 
	    public void setResume(byte[] resume) {
	        this.resume = resume;
	    }
	    
	    @Override
		public String toString() {
			return "JobProcessDetails [jid=" + jid +"currentround=" + currentround + ", marks=" + marks  + ", selected=" + selected+", resume=" + resume + "]";
		}

}
