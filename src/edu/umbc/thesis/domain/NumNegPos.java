package edu.umbc.thesis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "NUMNEGPOS")
public class NumNegPos {
	@Id
	@Column(name = "NUMID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "hBSeq", sequenceName = "H_B_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hBSeq")
    private long numid;
	@Column
    private String fieldvalue;
	@Column
    private int  numvalue;
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="FILEID")
   private DataFile datafile;
	

public DataFile getDatafile() {
	return datafile;
}
public void setDatafile(DataFile datafile) {
	this.datafile = datafile;
}
public long getNumid() {
	return numid;
}
public void setNumid(long numid) {
	this.numid = numid;
}
public String getFieldvalue() {
	return fieldvalue;
}
public void setFieldvalue(String fieldvalue) {
	this.fieldvalue = fieldvalue;
}
public int getNumvalue() {
	return numvalue;
}
public void setNumvalue(int numvalue) {
	this.numvalue = numvalue;
}
  
  
}
