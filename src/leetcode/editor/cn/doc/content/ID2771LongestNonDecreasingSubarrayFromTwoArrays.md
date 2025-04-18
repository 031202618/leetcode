<p>给你两个下标从 <strong>0</strong> 开始的整数数组 <code>nums1</code> 和 <code>nums2</code> ，长度均为 <code>n</code> 。</p>

<p>让我们定义另一个下标从 <strong>0</strong> 开始、长度为 <code>n</code> 的整数数组，<code>nums3</code> 。对于范围&nbsp;<code>[0, n - 1]</code> 的每个下标 <code>i</code> ，你可以将 <code>nums1[i]</code> 或 <code>nums2[i]</code> 的值赋给 <code>nums3[i]</code> 。</p>

<p>你的任务是使用最优策略为 <code>nums3</code> 赋值，以最大化 <code>nums3</code> 中 <strong>最长非递减子数组</strong> 的长度。</p>

<p>以整数形式表示并返回 <code>nums3</code> 中 <strong>最长非递减</strong> 子数组的长度。</p>

<p><strong>注意：子数组</strong> 是数组中的一个连续非空元素序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>nums1 = [2,3,1], nums2 = [1,2,1]
<strong>输出：</strong>2
<strong>解释：</strong>构造 nums3 的方法之一是： 
nums3 = [nums1[0], nums2[1], nums2[2]] =&gt; [2,2,1]
从下标 0 开始到下标 1 结束，形成了一个长度为 2 的非递减子数组 [2,2] 。 
可以证明 2 是可达到的最大长度。</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>nums1 = [1,3,2,1], nums2 = [2,2,3,4]
<strong>输出：</strong>4
<strong>解释：</strong>构造 nums3 的方法之一是： 
nums3 = [nums1[0], nums2[1], nums2[2], nums2[3]] =&gt; [1,2,3,4]
整个数组形成了一个长度为 4 的非递减子数组，并且是可达到的最大长度。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>nums1 = [1,1], nums2 = [2,2]
<strong>输出：</strong>2
<strong>解释：</strong>构造 nums3 的方法之一是： 
nums3 = [nums1[0], nums1[1]] =&gt; [1,1] 
整个数组形成了一个长度为 2 的非递减子数组，并且是可达到的最大长度。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums1.length == nums2.length == n &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= nums1[i], nums2[i] &lt;= 10<sup>9</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 34</li><li>👎 0</li></div>