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

public class FindTheJudge {


    public static void main(String[] args) {

        System.out.println("works!");

    }
}
