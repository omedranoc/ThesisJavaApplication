package edu.umbc.thesis.services;
import java.util.ArrayList;


import weka.classifiers.CostMatrix;
import weka.classifiers.functions.SMO;
import weka.classifiers.lazy.IBk;
import weka.classifiers.meta.CostSensitiveClassifier;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.meta.ClassificationViaClustering;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;

import weka.core.Instances;
import edu.umbc.thesis.domain.Classifierw;
import edu.umbc.thesis.domain.DataSet;
import edu.umbc.thesis.domain.Experiment;

public class Experiments {
	
	private String training;
	private String test;
	private ServiceC classifiertree= new ServiceC();
	private ServiceC classifieribk= new ServiceC();
	private ServiceC classifiersmo= new ServiceC();
	private ServiceC classifierforest= new ServiceC();
	private ServiceDs serviceds =new ServiceDs();
	private ServiceC classifierCost= new ServiceC();
	private ServiceC classifierAdaboost= new ServiceC();
	private ServiceC classifierKmeans= new ServiceC();

	
			
	
	public String getTraining() {
		return training;
	}
	public void setTraining(String training) {
		this.training = training;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	private ArrayList<Classifierw> classifiers = new ArrayList<Classifierw>();
	
	public Experiment runExdperiment(String training, String test,String extype, String description,String eigenvectors,String undersampling,String Sentiment,
			double oddratio,double percentageS,double percentageT) throws Exception
	{
		J48 tree = new J48();  
		IBk ibk = new IBk();
		RandomForest rf= new RandomForest();
		SMO smo = new SMO();
	Experiment experiment = new Experiment();
	AdaBoostM1 adaBoost = new AdaBoostM1();
	ClassificationViaClustering clusterK = new ClassificationViaClustering();
	
	CostSensitiveClassifier metaCost = new CostSensitiveClassifier();
   
	
	
	String optionString = " -P 100 -S 1 -I 10 -W weka.classifiers.trees.DecisionStump";
	adaBoost.setOptions(weka.core.Utils.splitOptions(optionString));
	
	CostMatrix myCostMatrix = new CostMatrix(2);
	//String optionsClusterK = "weka.classifiers.meta.ClassificationViaClustering -W weka.clusterers.SimpleKMeans -- -init 0 -max-candidates 100 -periodic-pruning 10000 -min-density 2.0 -t1 -1.25 -t2 -1.0 -N 2 -A weka.core.EuclideanDistance -R first-last -I 500 -num-slots 1 -S 10";
	//clusterK.setOptions(weka.core.Utils.splitOptions(optionsClusterK));

	
	myCostMatrix.setElement(0,0, 0);
	myCostMatrix.setElement(0,1, 5);
	myCostMatrix.setElement(1,0, 1);
	myCostMatrix.setElement(1,1, 0);
	metaCost.setClassifier(tree);
	metaCost.setCostMatrix(myCostMatrix);
	
	Classifierw treec=classifiertree.runClassifiers(tree, "tree",training,test, percentageS, percentageT);
	Classifierw ibkc=classifieribk.runClassifiers(ibk, "ibk",training,test, percentageS, percentageT);
	Classifierw smoc=classifiersmo.runClassifiers(smo, "smo",training,test, percentageS, percentageT);
	Classifierw rfc=classifierforest.runClassifiers(rf, "rf",training,test, percentageS, percentageT);
	Classifierw classifierAda=classifierAdaboost.runClassifiers(adaBoost,"adaboost",training,test, percentageS, percentageT);
	Classifierw classifierclusK=classifierKmeans.runClassifiers(clusterK,"cluster K means",training,test, percentageS, percentageT);
	Classifierw metacostc=classifierCost.runClassifiers(metaCost,"MetaCost",training,test, percentageS, percentageT);	
	classifiers.add(metacostc);
	classifiers.add(classifierAda);
	classifiers.add(classifierclusK);
	classifiers.add(treec);
	classifiers.add(ibkc);
	classifiers.add(rfc);
	classifiers.add(smoc);
	
	
    for (Classifierw c : classifiers) {
		System.out.println(c.getName());
	}
	Instances trainingI = ServiceC.getTrainingI();
	Instances testI= ServiceC.getTestI();
	DataSet datas =serviceds.createDataset(trainingI, testI, training, test, percentageS, percentageT);
	experiment.setDatasets(datas);
	experiment.setDescription(description);
	experiment.setClassifiers(classifiers);
	experiment.setExperimenttype(extype);
	experiment.setEigenvectors(eigenvectors);
	experiment.setSentiment_analysis(Sentiment);
	experiment.setOddratio(oddratio);
	experiment.setUndersampling(undersampling);
	datas=null;
	classifiers=null;
	return experiment;
	}
}
