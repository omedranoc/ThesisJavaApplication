package edu.umbc.thesis.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javax.persistence.Table;

@Entity
@Table(name = "CLASSIFIERS")
public class Classifierw {
@Id
@Column(name = "CLASSIFIERSID")
@GeneratedValue(strategy = GenerationType.AUTO)
private long classifiersid;
@Column
private String name;
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn( name="RESULTID")
private ResultExperiment result= new ResultExperiment();
@ManyToOne
@JoinColumn(name="EXPERIMENTID" )
private Experiment experiment;


public Experiment getExperiment() {
	return experiment;
}
public void setExperiment(Experiment experiment) {
	this.experiment = experiment;
}
public long getClassifiersid() {
	return classifiersid;
}
public void setClassifiersid(long classifiersid) {
	this.classifiersid = classifiersid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public ResultExperiment getResult() {
	return result;
}
public void setResult(ResultExperiment result) {
	this.result = result;
}






}
