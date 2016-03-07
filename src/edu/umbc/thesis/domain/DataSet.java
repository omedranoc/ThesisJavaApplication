package edu.umbc.thesis.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DATASETS")
public class DataSet {

	@Id
	@Column(name = "DATASETID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long datasetid;
	@OneToMany( cascade=CascadeType.ALL)
	@JoinColumn(name="DATASETID")
	private Collection<DataFile> trainingtest=new ArrayList<DataFile>();;
	
	@Column(name = "PERCENTAGESOURCE")
	private double percentageTrainning;
	@Column(name = "PERCENTAGETARGET")
	private double percentagetest;
	
	public long getDatasetid() {
		return datasetid;
	}
	public void setDatasetid(long datasetid) {
		this.datasetid = datasetid;
	}
	
	public double getPercentageTrainning() {
		return percentageTrainning;
	}
	public void setPercentageTrainning(double percentageTrainning) {
		this.percentageTrainning = percentageTrainning;
	}
	public double getPercentagetest() {
		return percentagetest;
	}
	public void setPercentagetest(double percentagetest) {
		this.percentagetest = percentagetest;
	}
	public Collection<DataFile> getTrainingtest() {
		return trainingtest;
	}
	public void setTrainingtest(Collection<DataFile> trainingtest) {
		this.trainingtest = trainingtest;
	}
	
	
}
