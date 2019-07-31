// https://leetcode.com/problems/count-different-palindromic-subsequences/
// This solution cannot be pasted on leetcode directly

class Main {
  public static void main(String[] args) {
    String a = "aaa";
    Main main = new Main();
    int ans = main.countPalindromes(a);
    System.out.println(ans);
  }

  public int countPalindromes(String s) {
    // 0 represent not Palindromes
    // 1 represent has Palindromes
    int board[][] = new int[s.length()][s.length()];
    // fill in base case
    for (int i = 0; i < s.length(); i++)
      board[i][i] = 1;
    int count = s.length();
    //fill in base case 2
    for (int i = 1; i < s.length(); i++)
    {
      if (s.charAt(i) == s.charAt(i - 1)){
        board[i][i - 1] = 1;
        count++;
      }
      else
        board[i][i - 1] = 0;
    }

    //compute
    for (int j = 2; j < s.length(); j++)
    {
      for (int i = j; i < s.length(); i++)
      {
        if (s.charAt(i) == s.charAt(i - j) && board[i - 1][i - j + 1] == 1)
        {
          board[i][i - j] = 1;
          count++;
        }
        else
          board[i][i - j] = 0;
      }
    }

    return count;
  }

}
