package HighSchool.Other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CoursePlanner {
    public static void main(String[] args) throws IOException {
        File dir = new File("RU_Classes");
        File[] fileArray = dir.listFiles();

        BufferedReader br = new BufferedReader(new FileReader(fileArray[0]));
        String contentLine;
        int j;
        String[] contentLineData;
        ArrayList<RU_Class> classTypeArrayList;
        RU_Class[] classTypes;
        RU_Class[][] allClasses = new RU_Class[9][0];
        ArrayList<RU_Class> everyClass = new ArrayList<>();
        boolean inArray = false;

        //ArrayList<RU_Class>[] classes = (ArrayList<RU_Class>) new ArrayList[10];

        for (int i = 0; i < fileArray.length; i++) {
            contentLine = br.readLine();
            j = 1;
            classTypeArrayList = new ArrayList<>();
            while (contentLine != null) {
                //System.out.println(j + ":\t" + contentLine);
                contentLineData = contentLine.split("\t");
                RU_Class tempClass = new RU_Class(contentLineData[0], contentLineData[1].substring(0, contentLineData[1].length()-5));
                classTypeArrayList.add(tempClass);
                inArray = false;
                for (int k = 0; k < everyClass.size(); k++) {
                    if(tempClass.getId().equals(everyClass.get(k).getId())) {
                        inArray = true;
                        tempClass = everyClass.get(k);
                        break;
                    }
                }
                if(!inArray) {
                    tempClass.addTag(fileArray[i].getName().substring(3, 6));
                    everyClass.add(tempClass);
                }
                if(inArray) {
                    //System.out.println(everyClass.indexOf(tempClass));
                    //System.out.println(tempClass.getName());
                    //System.out.println(Arrays.toString(everyClass.toArray()));
                    //System.out.println(everyClass.get(0));
                    //System.out.println(tempClass);
                    //System.out.println(everyClass.indexOf(tempClass));
                    everyClass.get(everyClass.indexOf(tempClass)).addTag(fileArray[i].getName().substring(3, 6));
                }
                contentLine = br.readLine();
                j++;
            }
            classTypes = new RU_Class[classTypeArrayList.size()];
            for (int k = 0; k < classTypeArrayList.size(); k++) {
                classTypes[k] = classTypeArrayList.get(k);
            }
            allClasses[i] = classTypes;
            if(i!=fileArray.length-1) {
                br = new BufferedReader(new FileReader(fileArray[i+1]));
            }
        }

        //for (int i = 0; i < allClasses.length; i++) {
        //    for (int k = 0; k < allClasses[i].length; k++) {
        //        System.out.println(k + ":\t" + allClasses[i][k].getId() + "\t" + allClasses[i][k].getName());
        //    }
        //}

        for (int i = 0; i < everyClass.size(); i++) {
            if(everyClass.get(i).getTags().length() > 5) {
                System.out.println(everyClass.get(i).getId() + "\t" + everyClass.get(i).getTags() + "\t" + everyClass.get(i).getName());
            }
            //System.out.println(everyClass.get(i).getTags().length() + "\t" + everyClass.get(i));
        }

        System.out.println(allClasses.length);
        System.out.println(everyClass.size());
    }
}
