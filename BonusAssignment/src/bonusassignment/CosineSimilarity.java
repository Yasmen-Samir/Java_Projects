package bonusassignment;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import static java.util.stream.Collectors.toMap;

public class CosineSimilarity {
    
    private String [] files = {
        "C:\\Users\\Yasmen\\OneDrive\\Documents\\NetBeansProjects\\BonusAssignment\\src\\bonusassignment\\docs\\100.txt",
        "C:\\Users\\Yasmen\\OneDrive\\Documents\\NetBeansProjects\\BonusAssignment\\src\\bonusassignment\\docs\\101.txt",
        "C:\\Users\\Yasmen\\OneDrive\\Documents\\NetBeansProjects\\BonusAssignment\\src\\bonusassignment\\docs\\102.txt",
        "C:\\Users\\Yasmen\\OneDrive\\Documents\\NetBeansProjects\\BonusAssignment\\src\\bonusassignment\\docs\\103.txt"};
    private double [] res1 = {};
    private double [] res2 = {};
    private double [] res3 = {};
    private double [] res4 = {};
    private double [] res5 = {};
    private double [] res6 = {};

    public double[] CosSimilarity(String documnet1, String document2) {

        ArrayList<String> doc1 = new ArrayList<String>();
        ArrayList<String> doc2 = new ArrayList<String>();
        HashSet<String> bothDocs = new LinkedHashSet<String>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        try ( BufferedReader file1 = new BufferedReader(new FileReader(new File(documnet1)));  BufferedReader file2 = new BufferedReader(new FileReader(new File(document2)));) {
            String ln1;
            String ln2;

            while ((ln1 = file1.readLine()) != null) {
                String[] sentence1 = ln1.split("\\W+");
                for (String d1 : sentence1) {
                    doc1.add(d1.toLowerCase());
                    bothDocs.add(d1.toLowerCase());
                }
            }

            while ((ln2 = file2.readLine()) != null) {
                String[] sentence2 = ln2.split("\\W+");
                for (String d2 : sentence2) {
                    doc2.add(d2.toLowerCase());
                    bothDocs.add(d2.toLowerCase());
                }
            }

        } catch (IOException e) {
            System.out.println("File " + documnet1 + " not found. Skip it");
            System.out.println("File " + document2 + " not found. Skip it");
        }
 
       for (String bd : bothDocs) {
           
           list1.add(Collections.frequency(doc1, bd));
           list2.add(Collections.frequency(doc2, bd));

        }

        double multiplying = 0, sqrD1 = 0, sqrD2 = 0;
        for (int i = 0; i < list1.size(); i++) {
            multiplying += list1.get(i) * list2.get(i);
            sqrD1 += Math.pow(list1.get(i), 2);
            sqrD2 += Math.pow(list2.get(i), 2);
        }

        double res = multiplying / (Math.sqrt(sqrD1) * Math.sqrt(sqrD2));
        double rad = Math.acos(res);
        double angle = rad * (180 / Math.PI);
        double[] arr = {res, angle};

        return arr;
    }

    public void Cos_Angle()
    {
        res1 = CosSimilarity(files[0], files[1]);
        res2 = CosSimilarity(files[0], files[2]);
        res3 = CosSimilarity(files[0], files[3]);
        res4 = CosSimilarity(files[1], files[2]);
        res5 = CosSimilarity(files[1], files[3]);
        res6 = CosSimilarity(files[2], files[3]);
        
        DecimalFormat df = new DecimalFormat("0.00000");
        DecimalFormat df2 = new DecimalFormat("0.000");          
        System.out.println("file1 and file2: \n \n" + "cos(Θ) =  " + df.format(res1[0]) + "\n" + "   Θ   =  " + df2.format(res1[1]));
        System.out.println("\nfile1 and file3: \n \n" + "cos(Θ) =  " + df.format(res2[0]) + "\n" + "   Θ   =  " + df2.format(res2[1]));
        System.out.println("\nfile1 and file4: \n \n" + "cos(Θ) =  " + df.format(res3[0]) + "\n" + "   Θ   =  " + df2.format(res3[1]));
        System.out.println("\nfile2 and file3: \n \n" + "cos(Θ) =  " + df.format(res4[0]) + "\n" + "   Θ   =  " + df2.format(res4[1]));
        System.out.println("\nfile2 and file4: \n \n" + "cos(Θ) =  " + df.format(res5[0]) + "\n" + "   Θ   =  " + df2.format(res5[1]));
        System.out.println("\nfile3 and file4: \n \n" + "cos(Θ) =  " + df.format(res6[0]) + "\n" + "   Θ   =  " + df2.format(res6[1]) + "\n");
    }
    
    public void rankFiles ()
    {   
        DecimalFormat df3 = new DecimalFormat("0.0");       
        Map<String,Double> doc_cos = new HashMap<String,Double>();
        Map<String,Double> sorted_doc_cos = new HashMap<String,Double>();
        
        System.out.println("Ranking: \n");
        doc_cos.put("file1 and file2 cosine similarity", res1[0]);
        doc_cos.put("file1 and file3 cosine similarity", res2[0]);
        doc_cos.put("file1 and file4 cosine similarity", res3[0]);
        doc_cos.put("file2 and file3 cosine similarity", res4[0]);
        doc_cos.put("file2 and file4 cosine similarity", res5[0]);
        doc_cos.put("file3 and file4 cosine similarity", res6[0]);
        
        sorted_doc_cos = doc_cos.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect
        (toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,LinkedHashMap::new));

        for (String key: sorted_doc_cos.keySet())
        {  
            System.out.println(key + " = " + df3.format(sorted_doc_cos.get(key)));
        }
        System.out.println(" ");
    }

}