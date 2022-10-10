/*
Class Name  : RankTeamsByVotes
Description : This class consists of the solution for RankTeamsByVotes.
Date        : Oct 10, 2022
Author      : Chandra Sekhar Reddy Muthumula
Website Link: https://leetcode.com/problems/rank-teams-by-votes/submissions/

Modification Log: 
Date				Name                                            Description
Oct 10, 2022			Chandra Sekhar Reddy Muthumula					Added Class RankTeamsByVotes 
Oct 10, 2022			Chandra Sekhar Reddy Muthumula					Added rankTeams
Oct 10, 2022			Chandra Sekhar Reddy Muthumula					Added check
Oct 10, 2022			Chandra Sekhar Reddy Muthumula					Added swap
--------------------------------------------------------------------------------------------------
1366. Rank Teams by Votes

In a special ranking system, each voter gives a rank from highest to lowest to all teams participated in the competition.

The ordering of teams is decided by who received the most position-one votes. 
If two or more teams tie in the first position, we consider the second position to resolve the conflict, 
if they tie again, we continue this process until the ties are resolved.
If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.

Given an array of strings votes which is the votes of all voters in the ranking systems.
 Sort all teams according to the ranking system described above.

Return a string of all teams sorted by the ranking system.


Example 1:

Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
Output: "ACB"
Explanation: Team A was ranked first place by 5 voters. No other team was voted as first place so team A is the first team.
Team B was ranked second by 2 voters and was ranked third by 3 voters.
Team C was ranked second by 3 voters and was ranked third by 2 voters.
As most of the voters ranked C second, team C is the second team and team B is the third.

Example 2:

Input: votes = ["WXYZ","XYZW"]
Output: "XWYZ"
Explanation: X is the winner due to tie-breaking rule. X has same votes as W for the first position 
but X has one vote as second position while W doesn't have any votes as second position. 
Example 3:

Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
Explanation: Only one voter so his votes are used for the ranking.
 

Constraints:

1 <= votes.length <= 1000
1 <= votes[i].length <= 26
votes[i].length == votes[j].length for 0 <= i, j < votes.length.
votes[i][j] is an English uppercase letter.
All characters of votes[i] are unique.
All the characters that occur in votes[0] also occur in votes[j] where 1 <= j < votes.length.
-------------------------------------------------------------------------------------------
*/
package Problems.RankTeamsByVotes;

public class RankTeamsByVotes {
    /*
     * This is the most stupidest approach
    */
    // public String rankTeams(String[] votes) {
    //     int noOfvoters = votes.length;
    //     if(noOfvoters == 1) return votes[0];
        
    //     int noOfParties = votes[0].length();
    //     int[] positionValues = new int[noOfParties];
    //     for(int i=0; i<noOfParties; i++) {
    //         positionValues[noOfParties- 1 - i] = i + 1;
    //     }
    //     // System.out.println("positionValues : " + Arrays.toString(positionValues));
    //     HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
    //     for(int i=0; i<noOfParties; i++) {
    //         map.put(votes[0].charAt(i), 0);
    //     }
        
    //     System.out.println("Map : " + map);
        
    //     for(int i=0; i<noOfvoters; i++) {
    //         for (int j=0; j<noOfParties; j++) {
    //             map.put(votes[i].charAt(j), map.get(votes[i].charAt(j)) + positionValues[j]);
    //             // map.put(votes[i].charAt(j), map.get(votes[i].charAt(j)) + 1);
    //         }
    //     }
    //     System.out.println("Map : " + map);
        
    //     char[] keys = new char[noOfParties];
    //     int[] values = new int[noOfParties];
        
    //     int index = 0;
    //     for(Character key : map.keySet()) {
    //         keys[index] = key;
    //         values[index++] = map.get(key);
    //     }
    //     // System.out.println("keys : " + Arrays.toString(keys));
    //     // System.out.println("values : " + Arrays.toString(values));
        
    //     // Selection sort
        
    //     for(int i=0; i<noOfParties-1; i++) {
            
    //         int maxVotesIndex = i;
    //         int maxVotes = values[i];
    //         for(int j=i+1; j<noOfParties; j++) {
    //             if(maxVotes < values[j]) {
    //                 maxVotes =  values[j];
    //                 maxVotesIndex = j;
    //             }
    //         }
            
    //         if(!(maxVotesIndex == i )) {
    //             if(values[maxVotesIndex] == values[i]) {
    //                 if(keys[maxVotesIndex] > keys[i]) {
    //                     keys[i] ^= keys[maxVotesIndex];
    //                     keys[maxVotesIndex] ^= keys[i];
    //                     keys[i] ^= keys[maxVotesIndex];
                        
    //                     values[i] ^= values[maxVotesIndex];
    //                     values[maxVotesIndex] ^= values[i];
    //                     values[i] ^= values[maxVotesIndex];
    //                 }
    //             } else {
    //                 keys[i] ^= keys[maxVotesIndex];
    //                 keys[maxVotesIndex] ^= keys[i];
    //                 keys[i] ^= keys[maxVotesIndex];
                    
    //                 values[i] ^= values[maxVotesIndex];
    //                 values[maxVotesIndex] ^= values[i];
    //                 values[i] ^= values[maxVotesIndex];
    //             }
    //         }
            
    //     }
    //     System.out.println("keys : " + Arrays.toString(keys));
    //     System.out.println("values : " + Arrays.toString(values));
    //     return new String(keys);   
    // }

    public String rankTeams(String[] votes) {
        int noOfVotes = votes.length;
        int noOfParties = votes[0].length();
        
        int[][] voteCount = new int[26][noOfParties];
        
        for(String vote : votes) {
            int len = vote.length();
            for(int i=0; i<len; i++) {
                voteCount[vote.charAt(i) - 'A'][i]++;
            }
        }
        
        String ans = votes[0];
        for (int i=0; i<noOfParties-1; i++) {
            int maxIndex = i;
            char maxParty = ans.charAt(i);
            
            for(int j=i+1; j<noOfParties; j++) {
                if(ans.charAt(j) != maxParty) {
                   if(check(voteCount, ans.charAt(j), maxParty )) {
                        maxParty = ans.charAt(j);
                        maxIndex = j;
                    } 
                }
            }
            ans = swap(ans, i, maxIndex);
        }
       return ans;
    }
    
    public boolean check(int[][] voteCount, char c1, char c2) {
        int a = c1 - 'A';
        int b = c2 - 'A';
        int len = voteCount[0].length;
        for (int i=0; i<len; i++) {
            if(voteCount[a][i] > voteCount[b][i]) {
                return true;
            } else if(voteCount[a][i] < voteCount[b][i])  {
                return false;
            }
        }
        return a<b;
    }
    
    public String swap(String ans, int i, int j) {
        char[] ch = ans.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }
}