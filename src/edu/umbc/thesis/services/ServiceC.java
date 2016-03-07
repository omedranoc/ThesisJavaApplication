package edu.umbc.thesis.services;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.Instances;
import edu.umbc.thesis.domain.Classifierw;
import edu.umbc.thesis.domain.ResultExperiment;


public class ServiceC {
	
	private static  Instances trainingI;
	private  static Instances testI;
	
	
	public static Instances getTrainingI() {
		return trainingI;
	}


	public static void setTrainingI(Instances trainingI) {
		ServiceC.trainingI = trainingI;
	}


	public static Instances getTestI() {
		return testI;
	}


	public static void setTestI(Instances testI) {
		ServiceC.testI = testI;
	}


	// private ArrayList<Classifiers> classifiers= new ArrayList<Classifiers>();
	private ResultExperiment result =new ResultExperiment();
	
	
	public Classifierw runClassifiers( Classifier model,String name,String training,String test, double percentageS,double percentageT) throws Exception
	{
			System.out.println("algorithm's name "+name);
			int i;
			int j;
			Classifierw  classifierweka= new Classifierw();
			
			classifierweka.setName(name);
			
			
			//DataSets data= serviceds.createDataset(training, test, percentageT, percentageS);
			
		    System.out.println("this is the train: " +training);
			DataSource source = new DataSource(training);
			trainingI = source.getDataSet();
			 if (trainingI.classIndex() == -1)
				 
				   trainingI.setClassIndex(trainingI.numAttributes() - 1);
			
			 DataSource sourcetest = new DataSource(test);
				testI = sourcetest.getDataSet();
				 if (testI.classIndex() == -1)
					 
					   testI.setClassIndex(testI.numAttributes() - 1);
			 
			setTestI(testI);
			setTrainingI(trainingI);
			model.buildClassifier(trainingI);  
			Evaluation eval = new Evaluation(trainingI);
			eval.evaluateModel(model, testI);
			 
			 System.out.println("CLASSIFIER");
			 
			 System.out.println("true recall "+eval.recall(0));
			 System.out.println("false recall "+eval.recall(1));
			 System.out.println("true precision "+eval.precision(0));
			 System.out.println("false precision "+eval.precision(1));
			 System.out.println("roc "+eval.areaUnderROC(0));
			
				
		
			 if(trainingI.attribute("L").value(0).equals(true)||trainingI.attribute("L").value(0).equals("True"))
			 {
			 i=0;
			 j=1;
				result.setPrecisiontrue(eval.precision(i));
				result.setPrecisionfalse(eval.precision(j));
				result.setRecalltrue(eval.recall(i));
				result.setRecallfalse(eval.recall(j));
			 }
			 else if(trainingI.attribute("L").value(0).equals(false)||trainingI.attribute("L").value(0).equals("False"))
			 {
			  i=1;
			  j=0;
				result.setPrecisiontrue(eval.precision(i));
				result.setPrecisionfalse(eval.precision(j));
				result.setRecalltrue(eval.recall(i));
				result.setRecallfalse(eval.recall(j));
			 }
			else {
				System.out.println("values in the instances are not boolean check service C");
				
						
			}
			 System.out.println(trainingI.attribute("L").value(0));
			 System.out.println(trainingI.attribute("L").value(1));
			
		
			result.setRoc(eval.areaUnderROC(0));
			classifierweka.setResult(result);
			return classifierweka;
			
		}

/**********************************************/

	


}
