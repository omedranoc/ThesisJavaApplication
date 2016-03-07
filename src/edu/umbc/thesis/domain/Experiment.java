package edu.umbc.thesis.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EXPERIMENT")
public class Experiment {
	@Id
	@Column(name = "EXPERIMENTID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long experimentid;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="EXPERIMENTID" )
	private List <Classifierw> classifiers= new  ArrayList<Classifierw>();
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="DATASETID",nullable=false)
	private DataSet datasets;
	@Column
	private String description;
	
	@Column(name = "EXPERIMENT_TYPE")
	private String experimenttype;
	
	@Column(name = "SENTIMENT_ANALYSIS")
	private String sentiment_analysis;
	
	@Column(name = "UNDESPAMPLING")
	private String undersampling;
	@Column(name = "ODD_RATIO")
	private Double oddratio;
	@Column(name = "EIGENVECTORS")
	private String eigenvectors;
	
	
	public String getUndersampling() {
		return undersampling;
	}
	public void setUndersampling(String undersampling) {
		this.undersampling = undersampling;
	}
	public String getSentiment_analysis() {
		return sentiment_analysis;
	}
	public void setSentiment_analysis(String sentiment_analysis) {
		this.sentiment_analysis = sentiment_analysis;
	}

	
	public Double getOddratio() {
		return oddratio;
	}
	public void setOddratio(Double oddratio) {
		this.oddratio = oddratio;
	}
	public String getEigenvectors() {
		return eigenvectors;
	}
	public void setEigenvectors(String eigenvectors) {
		this.eigenvectors = eigenvectors;
	}
	public long getExperimentid() {
		return experimentid;
	}
	public void setExperimentid(long experimentid) {
		this.experimentid = experimentid;
	}
	
	

	public List<Classifierw> getClassifiers() {
		return classifiers;
	}
	public void setClassifiers(List<Classifierw> classifiers) {
		this.classifiers = classifiers;
	}
	public DataSet getDatasets() {
		return datasets;
	}
	public void setDatasets(DataSet datasets) {
		this.datasets = datasets;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExperimenttype() {
		return experimenttype;
	}
	public void setExperimenttype(String experimenttype) {
		this.experimenttype = experimenttype;
	}

	
	

}
