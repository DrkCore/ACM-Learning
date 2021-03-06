package core.acm.leetcode.cn

//「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
//
// 1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//
//
// 1 被读作 "one 1" ("一个一") , 即 11。
//11 被读作 "two 1s" ("两个一"）, 即 21。
//21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。
//
// 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
//
// 注意：整数序列中的每一项将表示为一个字符串。
//
//
//
// 示例 1:
//
// 输入: 1
//输出: "1"
//解释：这是一个基本样例。
//
// 示例 2:
//
// 输入: 4
//输出: "1211"
//解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似
//"1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Question_38 {

    fun countAndSay(n: Int): String {
        val curBuilder = StringBuilder("1")
        if (n > 1) {
            var i = 1;
            while (++i <= n) {
                say(curBuilder.toString(), curBuilder)
            }
        }
        return curBuilder.toString();
    }

    fun say(line: CharSequence, builder: StringBuilder) {
        var count = 0
        var cur: Char? = null

        builder.clear()
        for (c in line) {
            when {
                cur == null -> {
                    cur = c
                    count = 1
                }
                cur == c -> count++
                cur != c -> {
                    builder.append("$count$cur")
                    cur = c
                    count = 1
                }
            }
        }
        if (count > 0) {
            builder.append("$count$cur")
        }
    }

    //使用递归的方式实现，同时没有做优化，不过这里作为记录保留
    fun countAndSayRecursively(n: Int): String {
        if (n == 1) {
            return "1"
        }
        val prev = countAndSayRecursively(n - 1)

        var count = 0
        var cur: Char? = null

        var str = ""
        for (c in prev) {
            when {
                cur == null -> {
                    cur = c
                    count = 1
                }
                cur == c -> count++
                cur != c -> {
                    str += "$count$cur"
                    cur = c
                    count = 1
                }
            }
        }
        if (count > 0) {
            str += "$count$cur"
        }

        return str
    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
    val question = Question_38()
    for (i in 1..5) {
        println(question.countAndSay(i))
    }
}