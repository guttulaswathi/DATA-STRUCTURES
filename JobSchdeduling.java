import java.util.*;
class Job
{
    int id;
    int deadline;
    int profit;
    Job(int id,int deadline,int profit)
    {
        this.id=id;
        this.deadline=deadline;
        this.profit=profit;
    }
}
public class JobSchdeduling
{
    public static void schdeduleJobs(Job[] jobs)
    {
        Arrays.sort(jobs,(a,b)->b.profit-a.profit);
        int n=jobs.length;
        int totalprofit=0;
        boolean[] slots=new boolean[n];
        int[] result=new int[n];
        for(Job job:jobs)
        {
            for(int i=job.deadline-1;i>=0;i--)
            {
                if(slots[i]!=true)
                {
                    slots[i]=true;
                    result[i]=job.deadline;
                    totalprofit=totalprofit+job.profit;
                    break;
                }
            }
        }
        System.out.println("selected Jobs:");
        for(int job: result)
        {
            if(job!=0)
            {
                System.out.println(job+" ");
            }
        }
        System.out.println("\n Totalprofit="+totalprofit);
    }
    public static void main(String[] args)
    {
        Job[] jobs={new Job(1,2,100),new Job(2,1,19),new Job(3,2,27),new Job(4,1,25),new Job(5,3,15)};
        schdeduleJobs(jobs);
    }

}