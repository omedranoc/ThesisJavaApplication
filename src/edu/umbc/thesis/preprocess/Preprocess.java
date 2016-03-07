package edu.umbc.thesis.preprocess;


import java.util.ArrayList;

import weka.core.Instance;
import weka.core.Instances;
import weka.filters.supervised.instance.Resample;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection; 
public class Preprocess {
	
	
	
	Resample smote= new Resample();
	
	public Instance smoteData(Instance instance)
	{
		smote.input(instance);
		Instance output= smote.output();
		return output;
	}
	
	public ArrayList<Instances> getPca(Instances train, Instances test)  throws Exception
	{
		      
				 Filter  filter = new AttributeSelection();
				 filter.setInputFormat(train);
				 
				 ArrayList<Instances> instanceL= new ArrayList<Instances>();
				 
				 Instances newTrain = Filter.useFilter(train, filter);  // configures the Filter based on train instances and returns filtered instances
				 Instances newTest = Filter.useFilter(test, filter);    // create new test set
	             instanceL.add(newTrain);
	             instanceL.add(newTest);
				 return instanceL;
	              
	}
	
	

}
