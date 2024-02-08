package class38;

import java.util.Stack;

/**
 * ClassName: Algo_038_6_Sort_Stack_Recursion
 * Package: class38
 * CreateTime: 2024/2/8 15:13
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// 时间复杂度：O(n^2)
// 用递归函数排序栈
// 栈只提供push、pop、isEmpty三个方法
// 请完成无序栈的排序，要求排完序之后，从栈顶到栈底从小到大
// 只能使用栈提供的push、pop、isEmpty三个方法、以及递归函数
// 除此之外不能使用任何的容器，数组也不行
// 就是排序过程中只能用：
// 1) 栈提供的push、pop、isEmpty三个方法
// 2) 递归函数，并且返回值最多为单个整数
public class Algo_038_6_Sort_Stack_Recursion {

    // 为了测试
    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.add(1);
        test.add(5);
        test.add(4);
        test.add(5);
        test.add(3);
        test.add(2);
        test.add(3);
        test.add(1);
        test.add(4);
        test.add(2);
        sort(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

        // 随机测试
        int N = 20;
        int V = 20;
        int testTimes = 20000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int n = (int) (Math.random() * N);
            Stack<Integer> stack = randomStack(n, V);
            sort(stack);
            if (!isSorted(stack)) {
                System.out.println("出错了!");
                break;
            }
        }
        System.out.println("测试结束");
    }

    // 检测栈是不是从顶到底依次有序
    public static boolean isSorted(Stack<Integer> stack) {
        int step = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            if (step > stack.peek()) {
                return false;
            }
            step = stack.pop();
        }
        return true;
    }

    // 生成随机栈
    public static Stack<Integer> randomStack(int n, int v) {
        Stack<Integer> ans = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            ans.add((int) (Math.random() * v));
        }
        return ans;
    }

    public static void sort(Stack<Integer> stack) {
        int depth = deep(stack);
        while (depth > 0) {
            int max = max(stack, depth);
            int k = times(stack, depth, max);
            down(stack, depth, max, k);
            depth -= k;
        }
    }

    // 使用递归函数，统计栈的深度
    public static int deep(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return 0;
        }
        int num = stack.pop();
        int depth = deep(stack) + 1;
        stack.push(num);
        return depth;
    }

    // 从栈当前的顶部开始，往下数deep层，返回这deep层里的最大值
    public static int max(Stack<Integer> stack, int deep) {
        if (deep == 0) {
            return Integer.MIN_VALUE;
        }
        int num = stack.pop();
        int restMax = max(stack, deep - 1);
        int max = Math.max(num, restMax);
        stack.push(num);
        return max;
    }

    // 从栈当前的顶部开始，往下数deep层，已知最大值是max了
    // 返回，max出现了几次，不改变栈的数据状况
    public static int times(Stack<Integer> stack, int deep, int max) {
        if (deep == 0) {
            return 0;
        }
        int num = stack.pop();
        int restTimes = times(stack, deep - 1, max);
        int times = restTimes + (num == max ? 1 : 0);
        stack.push(num);
        return times;
    }

    // 从栈当前的顶部开始，往下数deep层，已知最大值是max，出现了k次
    // 请把这k个最大值沉底，剩下的数据状况不变
    public static void down(Stack<Integer> stack, int deep, int max, int k) {
        if (deep == 0) {
            for (int i = 0; i < k; i++) {
                stack.push(max);
            }
            return;
        }
        int num = stack.pop();
        down(stack, deep - 1, max, k);
        if (num != max) {
            stack.push(num);
        }
    }
}
