<p>给你一个大小为 4 的整数数组 <code>a</code> 和一个大小 <strong>至少</strong>为 4 的整数数组 <code>b</code>。</p>

<p>你需要从数组 <code>b</code> 中选择四个下标 <code>i<sub>0</sub></code>, <code>i<sub>1</sub></code>, <code>i<sub>2</sub></code>, 和 <code>i<sub>3</sub></code>，并满足 <code>i<sub>0</sub> &lt; i<sub>1</sub> &lt; i<sub>2</sub> &lt; i<sub>3</sub></code>。你的得分将是 <code>a[0] * b[i<sub>0</sub>] + a[1] * b[i<sub>1</sub>] + a[2] * b[i<sub>2</sub>] + a[3] * b[i<sub>3</sub>]</code> 的值。</p>

<p>返回你能够获得的 <strong>最大 </strong>得分。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong> <span class="example-io">a = [3,2,5,6], b = [2,-6,4,-5,-3,2,-7]</span></p> 
</div>

<p><strong>输出：</strong> <span class="example-io">26</span></p>

<p><strong>解释：</strong><br /> 选择下标 0, 1, 2 和 5。得分为 <code>3 * 2 + 2 * (-6) + 5 * 4 + 6 * 2 = 26</code>。</p>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong> <span class="example-io">a = [-1,4,5,-2], b = [-5,-1,-3,-2,-4]</span></p> 
</div>

<p><strong>输出：</strong> <span class="example-io">-1</span></p>

<p><strong>解释：</strong><br /> 选择下标 0, 1, 3 和 4。得分为 <code>(-1) * (-5) + 4 * (-1) + 5 * (-2) + (-2) * (-4) = -1</code>。</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>a.length == 4</code></li> 
 <li><code>4 &lt;= b.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>5</sup> &lt;= a[i], b[i] &lt;= 10<sup>5</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 12</li><li>👎 0</li></div>