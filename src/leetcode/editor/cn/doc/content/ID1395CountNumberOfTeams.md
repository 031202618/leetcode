<p>&nbsp;<code>n</code> 名士兵站成一排。每个士兵都有一个 <strong>独一无二</strong> 的评分 <code>rating</code> 。</p>

<p>从中选出 <strong>3</strong> 个士兵组成一个作战单位，规则如下：</p>

<ul> 
 <li>从队伍中选出下标分别为 <code>i</code>、<code>j</code>、<code>k</code> 的 3 名士兵，他们的评分分别为 <code>rating[i]</code>、<code>rating[j]</code>、<code>rating[k]</code></li> 
 <li>作战单位需满足： <code>rating[i] &lt; rating[j] &lt; rating[k]</code> 或者 <code>rating[i] &gt; rating[j] &gt; rating[k]</code> ，其中&nbsp; <code>0&nbsp;&lt;= i &lt;&nbsp;j &lt;&nbsp;k &lt;&nbsp;n</code></li> 
</ul>

<p>请你返回按上述条件组建的作战单位的方案数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>rating = [2,5,3,4,1]
<strong>输出：</strong>3
<strong>解释：</strong>我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>rating = [2,1,3]
<strong>输出：</strong>0
<strong>解释：</strong>根据题目条件，我们无法组建作战单位。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>rating = [1,2,3,4]
<strong>输出：</strong>4
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == rating.length</code></li> 
 <li><code>3 &lt;= n &lt;= 1000</code></li> 
 <li><code>1 &lt;= rating[i] &lt;= 10^5</code></li> 
 <li><code>rating</code>&nbsp;中的元素都是唯一的</li> 
</ul>

<div><div>Related Topics</div><div><li>树状数组</li><li>线段树</li><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 159</li><li>👎 0</li></div>