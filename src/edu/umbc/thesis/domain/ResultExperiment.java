package edu.umbc.thesis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RESULT")
public class ResultExperiment {
	@Id
	@Column(name = "RESULTID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "hrSeq", sequenceName = "H_r_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hrSeq")
	private long resultid;
//	private String name;
	@Column
	private double precisiontrue;
	@Column
	private double precisionfalse;
	@Column
	private double recalltrue;
	@Column
	private double recallfalse;
	@Column
	private double roc;
	

	@Override
	public String toString() {
		return "ResultExperiment [resultid=" + resultid + ", precisiontrue=" + precisiontrue + ", precisionfalse="
				+ precisionfalse + ", recalltrue=" + recalltrue + ", recallfalse=" + recallfalse + ", roc=" + roc + "]";
	}
	


	public long getResultid() {
		return resultid;
	}
	public void setResultid(long resultid) {
		this.resultid = resultid;
	}
	public double getPrecisiontrue() {
		return precisiontrue;
	}
	public void setPrecisiontrue(double precisiontrue) {
		this.precisiontrue = precisiontrue;
	}
	public double getPrecisionfalse() {
		return precisionfalse;
	}
	public void setPrecisionfalse(double precisionfalse) {
		this.precisionfalse = precisionfalse;
	}
	public double getRecalltrue() {
		return recalltrue;
	}
	public void setRecalltrue(double recalltrue) {
		this.recalltrue = recalltrue;
	}
	public double getRecallfalse() {
		return recallfalse;
	}
	public void setRecallfalse(double recallfalse) {
		this.recallfalse = recallfalse;
	}
	public double getRoc() {
		return roc;
	}
	public void setRoc(double roc) {
		this.roc = roc;
	}
	
	
	
	
}
