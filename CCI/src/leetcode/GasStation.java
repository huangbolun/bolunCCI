package leetcode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // think about gas[i]-cost[i]
        // find that sum < 0 and the next element that > 0
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) return -1; // not possible at all
        sum = 0;
        int flag = 0;
        int rec = 0; // record the last first index found positive after sum < 0
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                flag = 1; // set flag to 1 so as to look at following index
                sum = 0;
            }
            if (flag == 1) {
                if (gas[i] - cost[i] > 0) {
                    rec = i;
                    flag = 0; // set this flag to zero!!!!
                }
            }
        }
        return rec;
    }
}