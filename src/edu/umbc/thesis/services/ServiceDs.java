package edu.umbc.thesis.services;
import edu.umbc.thesis.domain.DataSet;

import java.util.ArrayList;

import edu.umbc.thesis.domain.DataFile;
import weka.core.Instances;
public class ServiceDs {
	
	private DataSet datas= new DataSet();
	 

	 
	public DataSet createDataset(Instances datatrain,Instances datatest,String training, String test, double percentageT, double percentageS)throws Exception
	
	{ 
		ArrayList<DataFile> trainingtest= new ArrayList<DataFile>();
		Service trainingds= new Service(training);
		Service testds= new Service(test);
		
		
		trainingtest.add(trainingds.createDataFile(datatrain, training));
		trainingtest.add(testds.createDataFile(datatest, test));
		datas.setTrainingtest(trainingtest);
		
		datas.setPercentageTrainning(percentageT);
		datas.setPercentagetest(percentageS);
		
		return datas;
		
	}
	
}
	

