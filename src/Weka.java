


package weka.api;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Weka{
	public static void main(String[] args)throws Exception{
		CSVLoader loader=new CSVLoader();
		loader.setSource(new File("C:\\Users\\Admin\\Downloads\\1.csv"));
		Instances data=loader.getDataSet();
		
		ArffSaver saver=new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File("C:\\Users\\Admin\\Downloads\\1.arff"));
	saver.writeBatch();
	
	DataSource source = new DataSource("C:\\Users\\Admin\\Downloads\\1.arff");
    Instances dat = source.getDataSet();
    System.out.println(dat.numInstances()+" instances loaded.");
    
    
    String[] attributeTitles = {"erythema","scaling","definite-borders","itching","koebner-phenomenon","polygonal-papules","follicular-papules","oral-mucosal-involvement","knee-and-elbow-involvement","scalp-involvement","family-history","melanin-incontinence","eosinophils-in-the-infiltrate","PNL-infiltrate","fibrosis-of-the-papillary-dermis","exocytosis","acanthosis","hyperkeratosis","parakeratosis","clubbing-of-the-rete-ridges","elongation-of-the-rete-ridges","thinning-of-the-suprapapillary-epidermis","spongiform-pustule","munro-microabcess","focal-hypergranulosis","disappearance-of-the-granular-layer","vacuolisation-and-damage-of-basal-layer","spongiosis","saw-tooth-appearance-of-retes","follicular-horn-plug","perifollicular-parakeratosis","inflammatory-monoluclear-inflitrate","band-like-infiltrate","Age","Class-Distribution"};
    int[][] attributeRanges = new int[attributeTitles.length][2];
    attributeRanges[0] = new int[] {0,3};
    attributeRanges[1] = new int[] {0,3};
    attributeRanges[2] = new int[] {0,3};
    attributeRanges[3] = new int[] {0,3};
    attributeRanges[4] = new int[] {0,3};
    attributeRanges[5] = new int[] {0,3};
    attributeRanges[6] = new int[] {0,3};
    attributeRanges[7] = new int[] {0,3};
    attributeRanges[8] = new int[] {0,3};
    attributeRanges[9] = new int[] {0,3};
    attributeRanges[10] = new int[] {0,1};
    attributeRanges[11] = new int[] {0,3};
    attributeRanges[12] = new int[] {0,3};
    attributeRanges[13] = new int[] {0,3};
    attributeRanges[14] = new int[] {0,3};
    attributeRanges[15] = new int[] {0,3};
    attributeRanges[16] = new int[] {0,3};
    attributeRanges[17] = new int[] {0,3};
    attributeRanges[18] = new int[] {0,3};
    attributeRanges[19] = new int[] {0,3};
    attributeRanges[20] = new int[] {0,3};
    attributeRanges[21] = new int[] {0,3};
    attributeRanges[22] = new int[] {0,3};
    attributeRanges[23] = new int[] {0,3};
    attributeRanges[24] = new int[] {0,3};
    attributeRanges[25] = new int[] {0,3};
    attributeRanges[26] = new int[] {0,3};
    attributeRanges[27] = new int[] {0,3};
    attributeRanges[28] = new int[] {0,3};
    attributeRanges[29] = new int[] {0,3};
    attributeRanges[30] = new int[] {0,3};
    attributeRanges[31] = new int[] {0,3};
    attributeRanges[32] = new int[] {0,3};
    attributeRanges[33] = new int[] {0,100};
    attributeRanges[34] = new int[] {1,6};
    
    
    
    PrintStream fileStream = new PrintStream(new File("C:\\Users\\Admin\\Downloads\\test.arff"));
    
    System.out.println("@relation beach");
    System.out.println();

    fileStream.println("@relation beach");
    fileStream.println();
    
    
    for (int i = 0; i<attributeTitles.length;i++) {
    	String s = "";
    	s+="@attribute " + attributeTitles[i] + " {";

    	
    	if (attributeTitles[i].equals("Age")) {
    		s+="?,";

    	}
    	
    	for (int j=attributeRanges[i][0];j<=attributeRanges[i][1];j++) {
    		s+=j;

    		if (j!=attributeRanges[i][1]) {
    			s+=",";

    		}
    	}
    	s+="}";
    	System.out.println(s);

    	fileStream.println(s);
    }
    

    
    
    System.out.println();
    System.out.println("@data");
    
    fileStream.println();
    fileStream.println("@data");
    for (int inst=0; inst<dat.numInstances();inst++) {
    	Instance patInst = dat.get(inst);
    	String[] attrs = patInst.toString().split(";");
    	for (int iTitle=0;iTitle<attributeTitles.length;iTitle++) {

    		
    		System.out.print(attrs[iTitle] + " ");
    		fileStream.print(attrs[iTitle] + " ");
    	}
    	System.out.println();
    	fileStream.println();
    }
    
    fileStream.close();
  

}
}