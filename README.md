## Dynamic Programing ##

Dynamic programming (DP) is a very powerful technique to solve a particular class of problems. It demand very elegant formuation of the approach and simple thinking and the coding part is very easy.

The idea is very simple. If you have solved a problem with a given input then save the result for future reference, so as to avoid solving the same problem again. (Shortly rememver your past!)

If the given problem can be broken up in to smaller sub-problems and these smaller subproblems are in turn divided on to still-smaller ones, and in this processs, __if you observe some over-lapping subproblems, then its a big hint for DP.__ Also, the optimal solutions to the subproblems contribuet to the optimal solution of the given problem(referred to as the Optimal Substructure property).

There are two ways of doing this.

1) Top-Down : Start solving the given problem by breaking it down. If you see that problem has been solved already, then just return the saved answer. If it has not been solved, solve it and save the answer. This is usually easy to think of and very intuitive. This is referred to as __Memoization__.

2) Bottom-Up : Analyze the problem and see the order in which the sub-problems are solved and start solving from the trivial subproblem, up towards the given problem. In this process, it is guaranteed that the subproblems are solved before solving the problem. This is referred to as __Dynamic Programming__.

Note that divide and conquer is slightly a different technique. In that, we divide the problem in to non-overlapping subproblems and solve them independently, like in mergesort and quick sort.

Complementary to Dynamic Programming are Greedy Algorithms which make a decision once and for all every time they need to make a choice, in such a way that it leads to a near-optimal soultion. A Dynamic Programming solution is based on the principal of Mathmatical Induction greedy algorithms require other kinds of proof.


### Examples ###

* Fibonacci with DP
* LCS
* Minimum Step To One
* 0-1 Knapsack Problem
* Laserfiche Warmingup Interview Problem (Variation of Coin DP) "Solved"