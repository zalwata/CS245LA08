import java.util.Arrays;

/**
 * - The goal of this assignment is to practice designing solutions using data structures from this course.
 *
 * - Background
 * -- In a town, there are N people. There is a rumor that one of these people is secretly the town judge.
 * -- If the town judge exists, then:
 * -- 1. the town judge trusts nobody
 * -- 2. everybody (except for the town judge) trusts the town judge.
 * -- 3. there is exactly one person that satisfies properties 1 and 2.
 * -- you are given trust - an array of pairs, trust[i] = [a, b]
 * -- representing that the person labelled 'a' trusts the person labelled 'b'.
 * -- note that the number of people in the town is always between 1 and 1000.
 * -- if the town judge exists and can be identified, return the label of the town judge.
 * -- otherwise, return -1
 *
 * -> hypothesis: make a digraph and if there is a node that does not point to anywhere else but others point to it,
 * that node is the town judge.
 */

public class Judge {

    public static int N = 1;
    int[][] trust;

    public Judge(int numOfPplInTown)
    {
        N = numOfPplInTown;
        trust = new int[N][N];
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                trust[i][j] = 0;
            }
        }
    }

    public int findJudge(int N, int [][] trust)
    {
        int judgeNum = 0;
        for (int i = 0; i < N ; i++)
        {
            for (int j = 0; j < N ; j++)
            {
                if(trust[i][j] == 1)
                {
                    judgeNum = verifyJudgeCandidate(j, trust) + 1;
                }
            }
        }
        return judgeNum;
    }

    public int verifyJudgeCandidate(int judgeCandidateNum, int [][]trust)
    {
        int counter = 1;
        for(int i = 0; i < N; i++)
        {
            if(trust[i][judgeCandidateNum] == 1)
            {
                counter++;
                if(counter == N && isJudge(judgeCandidateNum, trust))
                {
                    return judgeCandidateNum;
                }
            }
        }
        return -2;
    }

    public boolean isJudge(int judgeCandidateNum, int [][]trust)
    {
        for(int j = 0; j < N; j++)
        {
            if(trust[judgeCandidateNum][j] == 1)
            {
                return false;
            }
        }

        return true;
    }

    public void print()
    {
        //generate 2D table without brackets and comma
        System.out.println(Arrays.deepToString(trust)
                .replace("],", "\n")
                .replace(",", "\t|")
                .replaceAll("[\\[\\]]", ""));
    }

    public int[][] aTrustsB(int aPerson, int bPerson)
    {
        trust[aPerson - 1][bPerson - 1] = 1;
        return trust;
    }


    public static void main(String[] args)
    {
//        Judge judge = new Judge(2);
//        judge.print();
////        System.out.println("-----------------------------------------------------------------------------------------");
////        System.out.println("Example 1");
////        judge.trust = judge.aTrustsB(1,2);
////        judge.print();
////        System.out.println("label of the town judge : " + judge.findJudge(N, judge.trust));
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("Example 2");
//        Judge judge = new Judge(3);
//        judge.trust = judge.aTrustsB(1,3);
//        judge.trust = judge.aTrustsB(2,3);
//        judge.print();
//        System.out.println("label of the town judge : " + judge.findJudge(N, judge.trust));
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("Example 3");
//        Judge judge = new Judge(3);
//        judge.trust = judge.aTrustsB(1,3);
//        judge.trust = judge.aTrustsB(2,3);
//        judge.trust = judge.aTrustsB(3,1);
//        judge.print();
//        System.out.println("label of the town judge : " + judge.findJudge(N, judge.trust));
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("Example 4");
//        Judge judge = new Judge(3);
//        judge.trust = judge.aTrustsB(1,2);
//        judge.trust = judge.aTrustsB(2,3);
//        judge.print();
//        System.out.println("label of the town judge : " + judge.findJudge(N, judge.trust));
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Example 5");
        Judge judge = new Judge(4);
        judge.trust = judge.aTrustsB(1,3);
        judge.trust = judge.aTrustsB(1,4);
        judge.trust = judge.aTrustsB(2,3);
        judge.trust = judge.aTrustsB(2,4);
        judge.trust = judge.aTrustsB(4,3);
        judge.print();
        System.out.println("label of the town judge : " + judge.findJudge(N, judge.trust));

    }
}
