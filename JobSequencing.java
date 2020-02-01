import java.util.*;
class JobSequencing implements Comparable <JobSequencing>{

    String jobid;
    int deadline;
    int profit;
    
    JobSequencing(String jobid,int deadline, int profit){
        this.jobid=jobid;
        this.deadline=deadline;
        this.profit=profit;
    }
    
    public int compareTo(JobSequencing job){
        return job.profit-this.profit;
    }
    static void performSequencing(JobSequencing[] jobs){
        Arrays.sort(jobs);
        
      
        StringBuffer str=new StringBuffer("");
        int clock=1;
        int netprofit=0;
        for(int i=0;i<jobs.length;i++){
            if(jobs[i].deadline>=clock){
                netprofit=netprofit+jobs[i].profit;
                str.append(jobs[i].jobid+" ");
                clock++;
            }
            
        }
        System.out.println(str+" Total profit after sequencing is "+netprofit);
        
    }
    
    public static void main(String []a){
        JobSequencing []jobs={
            new JobSequencing("a",2,100),
            new JobSequencing("b",1,19),
            new JobSequencing("c",2,27),
            new JobSequencing("d",1,25),
            new JobSequencing("e",3,15)
        };
        
        performSequencing(jobs);
        
    }
    
}