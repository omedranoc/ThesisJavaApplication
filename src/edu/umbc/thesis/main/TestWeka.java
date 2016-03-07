package edu.umbc.thesis.main;
import java.io.File;
import java.util.ArrayList;
import edu.umbc.thesis.services.Experiments;
import edu.umbc.thesis.domain.Experiment;
import 	edu.umbc.thesis.dao.ExperimentDao;
 
public class TestWeka {

	
	public static void main(String[] args) throws Exception{
		
		ExperimentDao experimentDao= new ExperimentDao();
	
		ArrayList<Integer> arraya = new ArrayList<>();
		ArrayList<Integer> arrayb = new ArrayList<>();
		ArrayList<Integer> arrayc = new ArrayList<>();
		ArrayList<Double> arrayd = new ArrayList<>();
		arraya.add(0);
		arraya.add(1);
		arrayb.add(0);
		arrayb.add(1);
		arrayc.add(0);
		arrayc.add(1);
		arrayd.add(0.2);
		arrayd.add(0.5);
		arrayd.add(0.8);
		arrayd.add(1.0);
		System.out.println("Init");
		for (Integer a : arraya) {
			
			for (Integer b : arrayb) {
				
				for (Integer c : arrayc) {
					
				System.out.println(c);
				
				String avalue="no";
				String bvalue="no";
				String cvalue="no";
				
				if (a==1){ avalue="yes";}
				if (b==1){ bvalue="yes";}
				if (c==1) {cvalue="yes";}
				System.out.println("saul");
				
				Experiments experimentDrunk= new Experiments();
				Experiments experimentPregnancy= new Experiments();
				
				System.out.println("edu/umbc/thesis/documents/domain/drunk/trainingwu"+a+b+c+".arff");
				Experiment experiment1= experimentDrunk.runExdperiment("edu/umbc/thesis/documents/domain/drunk/trainingwu"+a+b+c+".arff", "edu/umbc/thesis/documents/domain/drunk/testwu"+a+b+c+".arff", "domaindrunk "+a+b+c,"drunk domain",avalue,bvalue,cvalue,1.2,1.0,1.0);
				System.out.println("a and b"+a+b+c);
				Experiment experiment2= experimentPregnancy.runExdperiment("edu/umbc/thesis/documents/domain/pregnancy/trainingwu"+a+b+c+".arff", "edu/umbc/thesis/documents/domain/pregnancy/testwu"+a+b+c+".arff", "domainpregnancy "+a+b+c,"pregnancy domain",avalue,bvalue,cvalue,1.2,1.0,1.0);
				experimentDao.createExperiment(experiment1);
				experimentDao.createExperiment(experiment2);
				
				}
				
			}
			
			
			
		}
		System.out.println("part one");
	for (Double a : arrayd) {
			  for (Integer b : arrayb) {
					Experiments experimentSVDtransfer= new Experiments();
					double c;
					if (b==1)
					{
						c=a;
						
					}
					else
					{
						c=1.0;
					}
					
					
					System.out.println("edu/umbc/thesis/documents/transfer/svd/training"+a+b+".arff");
					
					Experiment experiment1= experimentSVDtransfer.runExdperiment("edu/umbc/thesis/documents/transfer/svd/training"+a+b+".arff", "edu/umbc/thesis/documents/transfer/svd/test"+a+b+".arff", "SVDTRANSFER "+a+b,"transfer Learning based on SVD Meng Jia", "no","yes","yes",1.2,a,c);
					experimentDao.createExperiment(experiment1);
					System.out.println("a and b"+a+b+c);
					
				}
				
				
				
			}
     
		
		
		System.out.println("Done 1");   
		arrayc.add(2);
		for (Double a : arrayd) {
			 System.out.println(a);
			  for (Integer b : arrayb) {
				  for (Integer j : arrayc) {
					  
					  for (Integer k : arraya) {
						  
							String bvalue="no";
							String cvalue="no";
						
							if (j.equals(1)){ bvalue="yes";}
							else if (j.equals(2)){ bvalue="onlyeigenvectors";}
							else{bvalue="no";}
							System.out.println("this is the values "+j+" value eigenvector: "+bvalue);
							if (k.equals(1)){ cvalue="yes";}
					Experiments experimenttransfer= new Experiments();
					
					double sourcet;
					double targett;
					if (b==0)
					{
						sourcet=a;
						 targett=1.0;
						
					}
					else
					{
						sourcet=1.0;
						 targett=a;
					}
					
					File tempFile = new File("src/edu/umbc/thesis/documents/transfer/target/training"+a+b+j+k+".arff");
					boolean exists = tempFile.exists();
					System.out.println("src/edu/umbc/thesis/documents/transfer/target/training"+a+b+j+k+".arff");
	                System.out.println(" exist "+exists);
	                if (!exists) {
	                   System.out.println("the file does not exist"+"edu/umbc/thesis/documents/transfer/target/training"+a+b+j+k+".arff");
	                                         
	                }else{
	                    // It returns true if File or directory exists
	                                                       

					System.out.println("edu/umbc/thesis/documents/transfer/target/training"+a+b+j+k+".arff");
					
					Experiment experiment1= experimenttransfer.runExdperiment("edu/umbc/thesis/documents/transfer/target/training"+a+b+j+k+".arff", "edu/umbc/thesis/documents/transfer/target/test"+a+b+j+k+".arff", "spectral "+a+b+j+k,"transfer spectral cluster aligment", bvalue,cvalue,"yes",1.2,sourcet,targett);
					experimentDao.createExperiment(experiment1);
					System.out.println("a and b"+a+b+targett);
	                }
				   }
				  }
			  }
				
				
			}
   
		
		System.out.println("done2");
		
		for (Integer a : arraya) {
		
		
			
			
				
		
			
			String avalue="no";
			String bvalue="yes";
			String cvalue="yes";
			
			if (a==1){ avalue="pca";}
			else {avalue="just  bag of words";}
			

			System.out.println("saul");
			
			Experiments experimentunsupervised= new Experiments();
			
			
			System.out.println("edu/umbc/thesis/documents/transfer/unsupervised/training"+a+".arff");
			Experiment experiment1= experimentunsupervised.runExdperiment("edu/umbc/thesis/documents/transfer/unsupervised/training"+a+".arff", "edu/umbc/thesis/documents/transfer/unsupervised/test"+a+".arff", "unsupervised "+a,"unsupervised k means 20% training",avalue,bvalue,cvalue,1.2,1.0,1.0);
			System.out.println("a and b"+a);
			experimentDao.createExperiment(experiment1);
			experiment1=null;
			experimentunsupervised=null;
			
			
		}
		System.out.println("Done all");
		
		
	
		  
	
	  
		
		 
	}
}


