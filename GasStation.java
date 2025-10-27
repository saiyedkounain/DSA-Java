// Leetcode 134
// ref: https://youtu.be/fOaUh1_fJPw?si=RJGPNQBFasAoxIkZ
// img:

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //first of all, lets return for impossibe, 
        // imposible when total cost > total gas avail

        int tcost = 0, tgas = 0;
        for(int i=0;i<gas.length; i++){
            tgas += gas[i];
        }
        for(int i=0;i<cost.length; i++){
            tcost += cost[i];
        }

        if(tcost > tgas){
            return -1;
        }

        // main logic
        int indx = 0; //identifying from the start
        int gasAvail = 0; //gas available
        for(int i = 0; i < cost.length; i++){
            gasAvail += gas[i] - cost[i]; //add gas and travel to next

            //if at any point gas isnt enough, change the staring pos (indx here)
            if(gasAvail < 0){
                indx = i+1; //change starting point to the next station (i made a grave error here)
                gasAvail = 0; //reset gas tank to 0
            }
        }

        return indx;
        
    }
}
