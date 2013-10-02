package ctci.Chapter9;

public class CtCI_9_1{
    // We can have two methods, recursion and Dynamic Programming

    // 1. Rucursion
    public int stepWays(int stairNum)
    {
        // 1. Base case
        if(stairNum < 0)
        {
            return 0;
        }

        if(stairNum == 0)
        {
            return 1;
        }

        // 2. Recursive step: the reason why we do not consider the 1, 2 and 3, is we have the situation (stairNum < 0) and (stairNum == 0)
        return stepWays(stairNum - 1) + stepWays(stairNum - 2) + stepWays(stairNum - 3);
    }

    // 2. Dynamic Programming
// You have to have a global variable to store the intermediate result.
    int[] stepNum;
//    public int stepWays1(int stairNum)
//    {
//        // 1. Initialize the global array: all are set to be -1 at first.
//        stepNum = new int[stairNum + 1];
//        for(int i = 0; i <= stairNum; i++)
//        {
//            stepNum[i] = -1;
//        }
//
//        return _stepWays1(stairNum);
//    }

    public int _stepWays(int stairNum)
    {
        if(stairNum < 0)
        {
            return 0;
        }

        if(stairNum == 0)
        {
            stepNum[0] = 1;
            return 1;
        }

        if(stepNum[stairNum] != -1)
        {
            return stepNum[stairNum];
        }

        stepNum[stairNum] = _stepWays(stairNum - 1) + _stepWays(stairNum - 2) + _stepWays(stairNum - 3);
        return stepNum[stairNum];
    }

}
