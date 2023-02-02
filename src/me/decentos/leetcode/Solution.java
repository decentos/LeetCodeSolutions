package me.decentos.leetcode;

import me.decentos.leetcode.hard.H220ContainsDuplicate3;

class Solution {
    public static void main(String[] args) {
//        RomanToInt.romanToInt("MCDLXXXVIII");
//        Palindrome.isPalindrome(32233);
//        AnagramGroup.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
//        TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
//        SetMismatch.findErrorNums(new int[]{2,2});
//        FizzBuzz.fizzBuzz(15);
//        RunningSum.runningSum(new int[]{3, 1, 2, 10, 1});
//        ValidParentheses.isValid("(]");
//        CommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"});
//        SquaresArray.sortedSquares2(new int[]{-5,-3,-2,-1});
//        LengthLastWord.lengthOfLastWord("   fly me   to   the moon  ");
//        ValidPalindrome.isPalindrome2("a.,");
//        PalindromeList.isPalindrome2(head);
//        ToeplitzMatrix.isToeplitzMatrix(new int[][]{{1,2,3,4}, {5,1,2,3}, {9,5,1,3}});
//        ReverseVowels.reverseVowels("hello");
//        PivotIndex.pivotIndex(new int[]{-1,-1,-1,-1,-1,0});
//        IsomorphicStrings.isIsomorphic("bar", "add");
//        Subsequence.isSubsequence("abc", "ahbgdc");
//        StringGreat.makeGood("leEeetcode");
//        BestTimeStock.maxProfit2(new int[]{7,1,5,3,6,4});
//        RemoveAdjacentDuplicates.removeDuplicates2("abbaca");
//        BinarySearch.firstBadVersion(5, 4);
//        RemoveDuplicates.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
//        FloodFill.floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 1, 0, 2));
//        NumberOfIslands.numIslands(new char[][]{
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}
//        });
//        NumberOfIslands.numIslands(new char[][]{
//                {'1', '1', '0', '1'},
//                {'1', '0', '1', '0'}
//        });
//        Fibonacci.fib(0);
//        ClimbingStairs.climbStairs2(44);
//        MinCostClimbing.minCostClimbingStairs(new int[]{0,2,3,2});
//        M62UniquePaths.uniquePaths2(3, 7);
//        M63UniquePaths2.uniquePathsWithObstacles(new int[][]{{0,1}});
//        H980UniquePaths3.uniquePathsIII(new int[][]{{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}});
//        FindAllAnagrams.findAnagrams3("cbaebabacd", "abc");
//        M424LongestRepeating.characterReplacement("AABABBA", 1);
//        M299BullsCows.getHint("1122", "1222");
//        E844BackspaceString.backspaceCompare("y#fo##f", "y#f#o##f");
//        M394DecodeString.decodeString("3[a]");
//        E1046LastStoneWeight.lastStoneWeight(new int[]{2,7,4,1,8,1});
//        M692TopKFrequent.topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2);
//        E1337KWeakestRows.kWeakestRows(new int[][]{{1,1,0,0,0}, {1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0}, {1,1,1,1,1}}, 3);
//        E35SearchInsert.searchInsert(new int[]{1, 3, 5, 6}, 7);
//        E349Intersection.intersect(new int[]{1, 2, 2,1}, new int[]{2, 2});
//        E367ValidSquare.isPerfectSquare(42);
//        M1657CloseStrings.closeStrings("cabbba", "abbccc");
//        E1213ThreeArrays.arraysIntersection2(new int[]{1,2,3,4,5}, new int[]{1,2,5,7,9}, new int[]{1,3,4,5,8});
//        M2256MinimumAverage.minimumAverageDifference(new int[]{2,5,3,9,5,3});
//        H4MedianArrays.findMedianSortedArrays(new int[]{1,3}, new int[]{2,7});
//        M33SearchRotatedArray.search(new int[]{4,5,6,7,8,1,2,3}, 8);
//        M931MinimumPathSum.minFallingPathSum(new int[][]{{2,1,3}, {6,5,4}, {7,8,9}});
//        M198HouseRobber.rob3(new int[]{2,8,1,2,3,4});
//        M1143LongestSubsequence.longestCommonSubsequence("ylqpejqbalahwr", "yrkzavgdmdgtqpg");
//        M658ClosestElements.findClosestElements(new int[]{1,2,3,4,5}, 4, 3);
//        M162FindPeak.findPeakElement(new int[]{1,2});
//        M1901FindPeak2.findPeakGrid(new int[][]{{10,30,40,50,20}, {1,3,2,500,4}});
//        M150ReversePolishNotation.evalRPN(new String[]{"4","13","5","/","+"});
//        M739DailyTemperatures.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
//        E744SmallestLetter.nextGreatestLetter(new char[]{'e', 'e', 'g', 'g'}, 'g');
//        E1971PathExistsGraph.validPath(3, new int[][]{{0,1}, {1,2}, {2,0}}, 0 , 2);
//        M841KeysRooms.canVisitAllRooms(List.of(List.of(2), Collections.emptyList(), List.of(1)));
//        M886PossibleBipartition.possibleBipartition(3, new int[][]{{1,2}, {1,3}, {2,3}});
//        M50Pow.myPow(2.0, -2147483647);
//        H834SumDistances.sumOfDistancesInTree2(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}});
//        M122BestTimeStock2.maxProfit(new int[]{7,1,5,6,3,6,4});
//        M309BestTimeStockCooldown.maxProfit(new int[]{1,2,3,0,2});
//        M309BestTimeStockCooldown.maxProfit2(new int[]{1,2,3,0,2});
//        E2389LongestSubsequence.answerQueries2(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21});
//        M1834SingleThreadedCPU.getOrder(new int[][]{{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}});
//        M797AllPaths.allPathsSourceTarget(new int[][]{{2}, {}, {1}});
//        E290WordPattern.wordPattern("abba", "dog cat cat dog");
//        M430FlattenDoublyList.flatten(head);
//        M189RotateArray.rotate3(new int[]{1,2,3,4,5,6,7}, 3);
//        E1572MatrixDiagonalSum.diagonalSum(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
//        E67AddBinary.addBinary("11", "1");
//        M209MinimumSubarray.minSubArrayLen(105, new int[]{100,1,1,1,1,1,5,1,100});
//        M215KLargestElement.findKthLargest(new int[]{7, 3, 2, 5, 6, 10, 9, 8, 1, 4, 0}, 2);
//        M39CombinationSum m39 = new M39CombinationSum();
//        m39.combinationSum(new int[]{2,3,6,7}, 7);
//        E1200MinDifference e1200 = new E1200MinDifference();
//        e1200.minimumAbsDifference2(new int[]{4,2,1,3});
//        M2343KthSmallestTrimmed m2343 = new M2343KthSmallestTrimmed();
//        m2343.smallestTrimmedNumbers(new String[]{"111","111","111"}, new int[][]{{1,1},{2,2},{3,3}});
//        M347TopFrequentElements m347 = new M347TopFrequentElements();
//        m347.topKFrequent2(new int[]{4,1,-1,2,-1,2,3}, 2);
//        M3LongestSubstring m3 = new M3LongestSubstring();
//        m3.lengthOfLongestSubstring("pwwkew");
//        M253MeetingRooms2 m253 = new M253MeetingRooms2();
//        m253.minMeetingRooms(new int[][]{{0,30}, {5,10}, {15,20}});
//        m253.minMeetingRooms(new int[][]{{7,10}, {2,4}});
//        M48RotateImage m48 = new M48RotateImage();
//        m48.rotate(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
//        m48.rotate(new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}});
//        E219ContainsDuplicate2 e219 = new E219ContainsDuplicate2();
//        e219.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);
        H220ContainsDuplicate3 h220 = new H220ContainsDuplicate3();
        h220.containsNearbyAlmostDuplicate2(new int[]{1,5,9,1,5,9}, 2, 3);
    }
}
