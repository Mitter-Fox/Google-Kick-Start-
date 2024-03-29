# Google Kick Start
## Round E, 25th August, 2019
**Problem: Cherries Mesh**

### Problem
Your friend is recently done with cooking class and now he wants to boast in front of his school friends by making a nice dessert. He has come up with an amazing dessert called Cherries Mesh. To make the dish, he has already collected cherries numbered **1** to **N**. He has also decided to connect each distinct and unordered pair of cherries with a sweet strand, made of sugar. Sweet strands are either red or black, depending on the sugar content in them. Each black strand contains one units of sugar, and each red strand contains two units of sugar.

But it turns out that the dessert is now too sweet, and these days his school friends are dieting and they usually like dishes with less sugar. He is really confused now and comes to your rescue. Can you help him find out which all sweet strands he should remove such that each pair of cherries is connected directly or indirectly via a sugar strand, and the dish has the minimum possible sugar content?

### Input
The first line of input gives the number of test cases, **T**.

Each test case begins with a line containing two integers **N** and **M**, the number of cherries and the number of black sweet strands, respectively.

Then M lines follow, each describing a pair of cherries connected to a black strand. The **i**-th line contains cherries numbered **Ci** and **Di**, it indicates that **Ci** and **Di** cherry are connected with a black strand of sugar.

Note: Any other pair of cherries not present in the input means that they are connected by a red strand.

### Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is minimum possible sugar content.

### Limits
Time limit: 15 seconds per test set.<br />
Memory limit: 1GB.<br />
1 ≤ **T** ≤ 100<br />
**M ≤ N\*(N-1)/2**<br />
1 ≤ **Ci ≤ N**, for all i<br />
1 ≤ **Di ≤ N**, for all i.<br />
**Ci ≠ Di**, for all i.<br /> 
Every **{Ci, Di}** is distinct.<br />

### Test set 1 (Visible)
1 ≤ **N** ≤ 100.<br />
0 ≤ **M** ≤ 100.<br />

### Test set 2 (Hidden)
For at least 90% of the test cases:<br />
1 ≤ **N** ≤ 1000.<br />
0 ≤ **M** ≤ 1000.<br />

### For all test cases:
1 ≤ **N** ≤ 10^5.<br />
0 ≤ **M** ≤ 10^5.<br />

### Sample

##### Input 
 
2<br />
2 1<br />
1 2<br />
3 1<br />
2 3<br />

##### Output 
  
Case #1: 1<br />
Case #2: 3<br />

### Explanation
In the first sample case, there are two cherries and they are connected with a black strand. Removing any of the strand causes cherries to get disconnected. Hence, the minimum sugar content is 1.<br />
In the second sample case, we can keep the black strand between cherry numbered 2 and cherry numbered 3, and remove any of the red strands, which leads to a minimum sugar content of 3.
