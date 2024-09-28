package Tasks;
/*
 * Create a program that solves Sudoku puzzles automatically. 
 * The program should take an input grid representing an unsolved Sudoku puzzle 
 * and use an algorithm to fill in the missing numbers.
 */
public class Prob3
{
    static final int gs = 9;
    public static void main(String args[])
    {
        int board[][] = 
        {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println("Original Board : ");
        System.out.println();
        printBoard(board);
        System.out.println();
        if(solveBoard(board))
            System.out.println("Board solved successfully!");
        else
            System.out.println("Board cannot be solved");
        System.out.println();
        printBoard(board);
    }
    static void printBoard(int board[][])
    {
        for(int i=0;i<gs;i++)
        {
            if(i%3 == 0 && i!=0)
                System.out.println("-----------------------------");
            for(int j=0;j<gs;j++)
            {
                if(j%3 == 0 && j!=0)
                    System.out.print("|");
                System.out.print(" "+board[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean existsRow(int board[][], int num, int row)
    {
        for(int i=0;i<gs;i++)
        {
            if(board[row][i] == num)
                return true;
        }
        return false;
    }
    static boolean existsCol(int board[][], int num, int col)
    {
        for(int i=0;i<gs;i++)
        {
            if(board[i][col] == num)
                return true;
        }
        return false; 
    }
    static boolean existsGrid(int board[][], int num, int row, int col)
    {
        int grow = row - row % 3;
        int gcol = col - col % 3;
        for(int i=grow;i<grow+3;i++)
        {
            for(int j=gcol;j<gcol+3;j++)
            {
                if(board[i][j] == num)
                    return true;
            }
        }
        return false;
    }
    static boolean isValid(int board[][], int num, int row, int col)
    {
        return !existsRow(board, num, row) && !existsCol(board, num, col) && 
               !existsGrid(board, num, row, col);
    }
    static boolean solveBoard(int board[][])
    {
        for(int i=0;i<gs;i++)
        {
            for(int j=0;j<gs;j++)
            {
                if(board[i][j] == 0)
                {
                    for(int trynum=1;trynum<=gs;trynum++)
                    {
                        if(isValid(board,trynum,i,j))
                        {
                            board[i][j] = trynum;
                            if(solveBoard(board))
                                return true;
                            else
                                board[i][j] = 0;   
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}