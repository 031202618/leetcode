<p>给你一个长度为 <code>n</code>&nbsp;的二维整数数组&nbsp;<code>coordinates</code>&nbsp;和一个整数&nbsp;<code>k</code>&nbsp;，其中&nbsp;<code>0 &lt;= k &lt; n</code>&nbsp;。</p>

<p><code>coordinates[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>&nbsp;表示二维平面里一个点&nbsp;<code>(x<sub>i</sub>, y<sub>i</sub>)</code>&nbsp;。</p>

<p>如果一个点序列&nbsp;<code>(x<sub>1</sub>, y<sub>1</sub>)</code>, <code>(x<sub>2</sub>, y<sub>2</sub>)</code>, <code>(x<sub>3</sub>, y<sub>3</sub>)</code>, ..., <code>(x<sub>m</sub>, y<sub>m</sub>)</code>&nbsp;满足以下条件，那么我们称它是一个长度为 <code>m</code>&nbsp;的 <strong>上升序列</strong>&nbsp;：</p>

<ul> 
 <li>对于所有满足&nbsp;<code>1 &lt;= i &lt; m</code> 的&nbsp;<code>i</code>&nbsp;都有&nbsp;<code>x<sub>i</sub> &lt; x<sub>i + 1</sub></code>&nbsp;且&nbsp;<code>y<sub>i</sub> &lt; y<sub>i + 1</sub></code>&nbsp;。</li> 
 <li>对于所有&nbsp;<code>1 &lt;= i &lt;= m</code>&nbsp;的&nbsp;<code>i</code>&nbsp;对应的点&nbsp;<code>(x<sub>i</sub>, y<sub>i</sub>)</code>&nbsp;都在给定的坐标数组里。</li> 
</ul>

<p>请你返回包含坐标 <code>coordinates[k]</code>&nbsp;的 <strong>最长上升路径</strong>&nbsp;的长度。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block"> 
 <p><span class="example-io"><b>输入：</b>coordinates = [[3,1],[2,2],[4,1],[0,0],[5,3]], k = 1</span></p> 
</div>

<p><span class="example-io"><b>输出：</b>3</span></p>

<p><strong>解释：</strong></p>

<p><code>(0, 0)</code>&nbsp;，<code>(2, 2)</code>&nbsp;，<code>(5, 3)</code>
 <!-- notionvc: 082cee9e-4ce5-4ede-a09d-57001a72141d -->&nbsp;是包含坐标 <code>(2, 2)</code>&nbsp;的最长上升路径。</p>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block"> 
 <p><span class="example-io"><b>输入：</b>coordinates = [[2,1],[7,0],[5,6]], k = 2</span></p> 
</div>

<p><span class="example-io"><b>输出：</b>2</span></p>

<p><b>解释：</b></p>

<p><code>(2, 1)</code>&nbsp;，<code>(5, 6)</code>&nbsp;是包含坐标 <code>(5, 6)</code>&nbsp;的最长上升路径。</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n == coordinates.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>coordinates[i].length == 2</code></li> 
 <li><code>0 &lt;= coordinates[i][0], coordinates[i][1] &lt;= 10<sup>9</sup></code></li> 
 <li><code>coordinates</code>&nbsp;中的元素 <strong>互不相同</strong>&nbsp;。
  <!-- notionvc: 6e412fc2-f9dd-4ba2-b796-5e802a2b305a -->
  <!-- notionvc: c2cf5618-fe99-4909-9b4c-e6b068be22a6 --></li> 
 <li><code>0 &lt;= k &lt;= n - 1</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>排序</li></div></div><br><div><li>👍 8</li><li>👎 0</li></div>