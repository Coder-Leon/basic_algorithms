## 一些基础算法
### 包括常见的排序算法和常见数据结构的应用。
### 同时给每个算法编写了大样本测试用例和对数器，从而验证了算法的正确性。

- 01 冒泡排序，时间复杂度 O(N²)，空间复杂度 O(1)，稳定，基本被弃用。

- 02 选择排序，时间复杂度 O(N²)，空间复杂度 O(1)，不稳定，基本被弃用。

- 03 插入排序，时间复杂度 O(N) ~ O(N²)，空间复杂度 O(1)，稳定。

- 04 **归并排序**，时间复杂度 O(NlogN)，空间复杂度 O(N)，稳定。

- 05 小和问题。

- 06 逆序对。

- 07 **荷兰国旗问题**。

- 08 利用荷兰国旗问题改进的**随机快速排序**，时间复杂度 O(NlogN)，空间复杂度 O(logN)，不稳定。

- 09 **堆排序**，时间复杂度 O(NlogN)，空间复杂度 O(1)，不稳定。

- 10 Java中比较器的实现。

- 11 非比较排序：桶排序之计数排序 (参与排序的数字必须是非负数)。

- 12 相邻数最大差值问题：

  > 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用基于比较的排序。

- 13 利用数组实现栈结构。

- 14 利用数组实现队列结构。

- 15 求栈的最小值，时间复杂度O(1)。问题描述：
  > 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
  要求：1．pop、push、getMin操作的时间复杂度都是O(1)。2．设计的栈类型可以使用现成的栈结构。
  
- 16 利用两个栈实现队列结构。

- 17 利用两个队列实现栈结构。

- 18 猫狗队列问题。问题描述：
  > 用户可以调用add方法将cat类或dog类的实例放入队列中；
  > pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
  > pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
  > pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
  > isEmpty方法，检查队列中是否还有dog或cat的实例； 
  > isDogEmpty方法，检查队列中是否有dog类的实例；
  > isCatEmpty方法，检查队列中是否有cat类的实例。