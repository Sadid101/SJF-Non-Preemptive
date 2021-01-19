package SJFNon;

import java.util.Scanner;

public class SJFNon {
   public static void main(String[] args) {
       Scanner scan=new Scanner(System.in);
       System.out.println("Enter number of processes");
       int pro=scan.nextInt();
       int[] aT=new int[pro];
       int[] bT=new int[pro];
       for(int i=0; i<pro; i++){
           System.out.println("Enter Arrival time of process "+i);
           aT[i]=scan.nextInt();
           System.out.println("Enter Burst time of process "+i);
           bT[i]=scan.nextInt();
       }
       int[] wait=new int[pro];
       int[] turn=new int[pro];
       int min=aT[0];
       int minLoc=0;
       for(int i=1; i<pro; i++){
           if(aT[i]<min){
               min=aT[i];
               minLoc=i;
           }
       }
       int[] ini=new int[pro];
       int x=0;
       int minB=bT[minLoc];
       for(int time=0; time<99; time++){
           for(int i=0; i<pro; i++){
            if(aT[i]==time){
                ini[x]=i;
                x++;
            }
           }
//            for(int i=0; i<ini.length; i++){
//                if(bT[ini[i]]<minB){
//                    minLoc=i;
//                    minB=bT[i];
            bT[minLoc]--;
            if(bT[minLoc]==0){
                wait[minLoc]=time+1;
                bT[minLoc]=100;
                minB=100;
            }
       }
       for(int j=0; j<pro; j++){
           System.out.println("Process "+j+" has a turnaround time of "+wait[j]);
       }
           
       }
}