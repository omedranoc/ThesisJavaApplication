package edu.umbc.thesis.services;

import java.util.ArrayList;
import edu.umbc.thesis.domain.DataFile;
import edu.umbc.thesis.domain.NumNegPos;
import weka.core.Instances;


public class Service {
	
	 private String name;
	 private DataFile data= new DataFile();
	 

	public Service(String name)throws Exception 
	{
		
		this.name=name;
		
	}
   
	
	


	public DataFile createDataFile ( Instances dataf,String typect)throws Exception 
	{
		
		data.setName(name);
		
		System.out.println("saul");
		NumNegPos numPos= new NumNegPos();
		NumNegPos numNeg=new NumNegPos();
		ArrayList<NumNegPos> nums= new ArrayList<NumNegPos> ();
		
		
			numPos.setFieldvalue(dataf.attribute("L").value(0));
			numNeg.setFieldvalue(dataf.attribute("L").value(1));
		
		int a=dataf.numAttributes();
		
		System.out.println(a+"   hey"+dataf.attributeStats(a-1).nominalCounts[0]);
		numPos.setNumvalue((Integer)dataf.attributeStats(a-1).nominalCounts[0]);
		numNeg.setNumvalue((Integer)dataf.attributeStats(a-1).nominalCounts[1]);
		nums.add(numPos);
		nums.add(numNeg);
		data.setNums(nums);
		data.setType(typect);
		data.setNum_attributes(a);
		
		return data;
	}
	
}
