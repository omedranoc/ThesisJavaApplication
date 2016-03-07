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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "DATAFILES")
public class DataFile {
	@Id
	@Column(name = "FILEID")

	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "hASeq", sequenceName = "H_A_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hASeq")
	private long dataid;
	@Column
	private String name;
	@Column
	private String type;
	@ManyToOne
    @JoinColumn(name="DATASETID")
    private DataSet dataset;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="FILEID")
	private Collection <NumNegPos > nums= new ArrayList <NumNegPos>();
	
	@Column(name = "NUM_ATTRIBUTES")
	private  int num_attributes;
	
	public int getNum_attributes() {
		return num_attributes;
	}
	public void setNum_attributes(int num_attributes) {
		this.num_attributes = num_attributes;
	}
	public Collection<NumNegPos> getNums() {
		return nums;
	}
	public DataSet getDataset() {
		return dataset;
	}
	public void setDataset(DataSet dataset) {
		this.dataset = dataset;
	}
	public void setNums(Collection<NumNegPos> nums) {
		this.nums = nums;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDataid() {
		return dataid;
	}
	public void setDataid(long dataid) {
		this.dataid = dataid;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
