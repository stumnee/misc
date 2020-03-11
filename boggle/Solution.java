package com.tumnee.boggle;

// The board:
//
//      A   B   C   D
//     ---------------
//  1 | p | z | z | z |
//    |---|---|---|---|
//  2 | p | z | z | z |
//    |---|---|---|---|
//  3 | a | z | l | z |
//    |---|---|---|---|
//  4 | n | p | p | e |
//     ---------------
//
// Inputs:
//   - a board of n rows and columns
//   - a word list L of length l
// Output:
//   Your choice, either:
//     - a count of the words in L which are present on the board
//     - a set of the words in L which are present on the board

// ["apple", "banana"] -> 1 OR {"apple"}
// "boggle"


import java.util.HashSet;

public class Solution {

    public int boggle(char[][] board, String[] words) {
        int count = 0;

        for (String word : words) {
            HashSet prevCoord = new HashSet();
            if (boggleWord(board, word, -1, -1, prevCoord)) {
                count++;
            }

        }

        return count;
    }

    boolean boggleWord(char[][] board, String word, int prevX, int prevY, HashSet prevCoord) {

        if (word.length() == 0) {
            return true;
        }

        int[][] nearBy = {
                {-1,-1},{-1,0},{-1,1},
                {0,-1},  {0,1},
                {1,-1},{1,0},{1,1}
        };


        char ch = word.charAt(0);
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board.length; x++) {
                if (board[y][x] == ch && !prevCoord.contains(y * board.length + x)) {

                    if (prevX > -1) { // skip check for the first letter
                        boolean neighbour = false;
                        for (int[] offset : nearBy) {
                            if (x == prevX + offset[1] && y == prevY + offset[0]) {
                                neighbour = true;
                            }
                        }

                        if (!neighbour) {
                            continue;
                        }
                    }

                    prevCoord.add(y * board.length + x);

                    word = word.substring(1);
                    if (boggleWord(board, word,  x, y, prevCoord)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public static void main(String args[] ) throws Exception {
        char[][] board = {{'p','z','z','z'},
                          {'p','z','z','f'},
                          {'a','z','l','z'},
                          {'n','p','p','e'}};
        String[] words = {"apple"};
        System.out.println(new Solution().boggle(board, words));
    }
}
