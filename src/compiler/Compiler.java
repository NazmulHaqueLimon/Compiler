/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

/**
 *
 * @author Nazmul Haque
 */
import java.util.*;
import java.io.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
public class Compiler {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    static ArrayList <String> keyWord=new ArrayList<String>();
    static ArrayList <String> identifier=new ArrayList<String>();
    static ArrayList <String> mathOperator=new ArrayList<String>();
    //static ArrayList <String> lo=new ArrayList<String>();
    static ArrayList <String> logicalOperator=new ArrayList<String>();
    static ArrayList <String> number=new ArrayList<String>();
    static ArrayList <String> others=new ArrayList<String>();
    //static ArrayList <String> withoutKW=new ArrayList<String>();
    
    static ArrayList <String> kwResult=new ArrayList<String>();
    //static ArrayList <String> withoutKW=new ArrayList<String>();
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
           // TODO code application logic here
       
           FileReader f=new FileReader("key.txt");
           BufferedReader br=new BufferedReader(f);
            String s="";
           while((s=br.readLine())!=null)
           {
            //s=br.readLine();
               String r=",";
               String[] parts1=s.split(r);
               for(int i=0;i<parts1.length;i++){
                   keyWord.add(parts1[i]);
                  
               }
            }
           //System.out.println(kw);
            
        
        
            FileReader file=new FileReader("code.txt");
        
            BufferedReader brr=new BufferedReader(file);
            String ss="";
            while((ss=brr.readLine())!=null){
                
                //String[] parts = ss.split("\\s+|//,|//;|//=");
                
               
                StringTokenizer stt=new StringTokenizer(ss," ");
                
                while(stt.hasMoreElements())
                {
                    String sp = (String)stt.nextElement();
                    
                    //finding math operator and logical operator
                    
                    String rp="";
                    String[] pp=sp.split(rp);
                    for(int i=0;i<pp.length;i++){
                        
                        String k=(String)pp[i];
                        String x="<|>|==";
                        if(k.matches(x)){
                           logicalOperator.add(k);
                        }
                        String y="[-+/*]";
                        if(k.matches(y)){
                            mathOperator.add(k);
                        }
                        
                    //}
                    //System.out.println(sp);
                    String r="(|)|,|;|{|}|";
                    StringTokenizer spt=new StringTokenizer(sp,r);
                     while(spt.hasMoreElements())
                    {
                        String part = (String)spt.nextElement();
                        //System.out.println(part);
                        //String rrr="^[a-zA-Z][a-zA-Z]+";
                        for(int c=0;c<kwResult.size();c++){
                            
                            String p=kwResult.get(c);
                            if(!part.contains(p)){
                            //System.out.println(part);
                                String rR="=|-|*|+";
                                StringTokenizer sptt=new StringTokenizer(part,rR);
                                while(sptt.hasMoreElements())
                                {
                                    String partt = (String)sptt.nextElement();
                                    //System.out.println(partt);
                                    String rRR="[0-9]*|[0-9]*\\.[0-9]*";
                                    
                                    if(partt.matches(rRR)){
                                        if(!number.contains(partt)){
                                            number.add(partt);
                                        }
                                    }
                                    String rrRR="^[a-z][a-zA-Z]*|//d+";
                                      
                                      if(partt.matches(rrRR)){
                                          if(!identifier.contains(partt)){
                                              identifier.add(partt);
                                          }
                                      }
                                    
                                    
                                    
                                }
                               
                            }
                            
                        }
                        
                        
                        for(int a=0;a<keyWord.size();a++){
                            String p=(String)keyWord.get(a);
                            
                            //String t=parts1[i];
                            if(!part.contains(p)){
                                //withoutKW.add(part);
                            }                                            
                            else{
                                if(!kwResult.contains(p)){
                                  kwResult.add(p);
                                }
                            }
                           
                        }
                
                     
                    }                                      
                }
            }
           
            //System.out.println(withoutKW);
               
                   //String[] parts = ss.split("\\s+");
                //String[] parts = s.split("\\s+|\\.+|\\;+|\\(+|\\)+|\\,+|\\:+|\\[+|\\]+");
                 //String[] lineparts = s.split("\\s+|\\.+|\\;+|\\(+|\\)+|\\\"+|\\:+|\\[+|\\]+");
                    //StringTokenizer stt=new StringTokenizer(s,"\\s+|\\.+|\\;+|\\(+|\\)+|\\,+|\\:+|\\[+|\\]+");                  
                        
        }
             System.out.println("keyWords:");
            System.out.println(kwResult);
            
            System.out.println("Numbers:");
            System.out.println(number);
            
            System.out.println("identifiers:");
            System.out.println(identifier);
            
            System.out.println("logicalOperators:");
            System.out.println(logicalOperator);
            
            System.out.println("mathOperators:");
            System.out.println(mathOperator);
            
           
    }
     
}
    


        
        
    
    

