package osass3;

import java.util.*;

class SJF {

    int num_of_processes;     // process ID
    int[] burstTime;      // burst Time
    int[] arrivalTime;
    int[] complete_time = new int[num_of_processes];

    public SJF(int[] burstTime, int[] arrivalTime, int num_of_processes) {
        this.num_of_processes = num_of_processes;
        this.burstTime = new int [num_of_processes];
        this.arrivalTime = new int [num_of_processes];
        this.complete_time = new int [num_of_processes];
        for (int i = 0; i < num_of_processes; i++) {
            /*if (this.burstTime[i-1] > this.burstTime[i]) {
                this.burstTime[i-1] = this.burstTime[i];
                this.arrivalTime[i-1] = this.arrivalTime[i];*/
                complete_time[i] += this.burstTime[i];
            

        }
    }

    /*public SJF[] get_shorter() {
        SJF arr[] = new SJF[num_of_processes];
        for(int i =0; i < num_of_processes; i++)
        {
            if(burstTime[i] > burstTime[i+1])
            {
                arr[i] = arr[i+1];
                complete_time[i] += burstTime[i]; 
            }
        }
        return arr;
    }*/
    public int[] get_turnAround_time() {
        int turnAround_time[] = new int[num_of_processes];
        for (int i = 0; i < num_of_processes; i++) {
            turnAround_time[i] = complete_time[i] + arrivalTime[i];
        }
        return turnAround_time;
    }

    public int[] get_Waiting_time() {
        int turnAroundArr[] = get_turnAround_time();
        int Waiting_time[] = new int[num_of_processes];
        Waiting_time[0] = 0;

        for (int i = 1; i < num_of_processes; i++) {
            Waiting_time[i] = turnAroundArr[i] + burstTime[i];
        }
        return Waiting_time;
    }

    public int[] get_IDS() {
        int idArr[] = new int[num_of_processes];
        for (int i = 0; i < num_of_processes; i++) {
            idArr[i] = i + 1;
        }
        return idArr;
    }

    public String toString() {
        for (int i = 0; i < num_of_processes; i++) {
            System.out.println(get_IDS());
        }
        return " burstTime: " + burstTime + " arrivalTime: " + arrivalTime + " complete_time: " + complete_time;

    }

    public void print() {
        for (int i = 0; i < num_of_processes; i++) {
            System.out.println(get_Waiting_time());
            System.out.println(get_turnAround_time());
        }
    }

    public static void main(String[] args) {

        int num;
        Scanner input = new Scanner(System.in);
        System.out.println("enter number of processes");
        num = input.nextInt();
        int burst[] = new int[num];
        int arrival[] = new int[num];
        System.out.println("enter processes burst time");

        for (int i = 0; i < num; i++) {
            burst[i] = input.nextInt();
        }
        
        System.out.println("enter processes arrival time");
        for (int i = 0; i < num; i++) {
            arrival[i] = input.nextInt();
        }

        SJF sjf = new SJF(burst, arrival, num);
        System.out.println(sjf);
        sjf.print();
    }

}
