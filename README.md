# bt_john_hw1
第一周作业的算法：

比如weights是0.3, 0.5, 0.2 （对应的item号码为0，1，2）

那么我们可以求running sum:  0.0, 0.3, 0.8, 1  （也就是三个区间0， 1， 2）

然后每次再产生 0-1 之间的随机数，再用Binary Search即可找到这个随机数落在第几个区间，也就是第几个item。

这样可以做n次，只要n足够大，每个item所产生的概率会趋近于0.3, 0.5, 0.2 （对应item 号码0,1,2）