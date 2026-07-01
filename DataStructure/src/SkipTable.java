import java.util.Random;

public class SkipTable {

    //跳表节点
    static class SkipListNode {
        int val;
        // 每层的后继指针
        SkipListNode[] next;

        public SkipListNode(int val,int level) {
            this.val = val;
            this.next = new SkipListNode[level + 1]; // 0~level层有 level+1个层级   //todo []里面的参数指 数组的存储长度
        }
    }

    //todo 1.静态方法（main） 不依赖任何对象实例，可以直接运行
    // 2.非静态内部类 必须依附外部类的对象才能创建，相当于它自带一个隐藏的 外部类.this引用
    // 3.静态内部类 不能访问非静态内部类
    //跳表
    public static class SkipList {
        //最大层数
        private static final int MAX_LEVEL = 16;
        //概率因子
        private static final double PROBABILITY = 0.5;

        //头节点  todo  头节点本质就是一个普通节点,它只是一个 “站在最左边、值为 -1、数组开得最大” 的节点而已！
        private final SkipListNode head;
        //当前跳表的最大层数
        private int currentLevel;

        private Random random;

        public SkipList() {
            this.currentLevel = 0;
            this.head = new SkipListNode(-1,MAX_LEVEL);
            this.random = new Random();
        }

        // 随机生成层数
        private int randomLevel() {
            int level = 0;
            while (random.nextDouble() < PROBABILITY && level <MAX_LEVEL) {
                level++;
            }
            return level;
        }

        //查找
        public boolean search(int val) {
            SkipListNode cur = head;

            //从最高层往下找
            for (int i = currentLevel; i >= 0; i--) {
                while (cur.next[i] != null && cur.next[i].val < val) {
                    cur = cur.next[i];
                }
            }

            // 到了最底层，判断下一个节点是不是目标
            cur = cur.next[0];
            return cur != null && cur.val == val;

        }

        //插入
        public void insert(int val) {
            // update 数组记录每一层最后一个 < val 的节点
            SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
            SkipListNode cur = head;
            //1. 找每一层的前驱
            for (int i = currentLevel; i >= 0; i--) {
                while (cur.next[i] != null && cur.next[i].val < val) {
                    cur = cur.next[i];
                }
                update[i] = cur;
            }
            // 2.随机层数
            int newLevel = randomLevel();
            // 3.如果新层数超过当前最大层
            if (newLevel > currentLevel) {
                for (int i = currentLevel + 1; i <= newLevel; i++) {
                    update[i] = head;
                }
                currentLevel = newLevel;
            }
            // 4.新建节点，逐层插入
            SkipListNode newNode = new SkipListNode(val,newLevel);
            for (int i = 0; i <= newLevel; i++) {
                newNode.next[i] = update[i].next[i];
                update[i].next[i] = newNode;
            }
        }
        // 删除
        public void delete(int val) {
            SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
            SkipListNode cur = head;
            // 找前驱
            for (int i = currentLevel; i >= 0; i--) {
                while (cur.next[i] != null && cur.next[i].val < val) {
                    cur = cur.next[i];
                }
                update[i] = cur;
            }
            cur = cur.next[0];
            //不存在
            if (cur == null || cur.val != val) return;
            // 逐层删除
            for (int i = 0; i <= currentLevel; i++) {
                if (update[i].next[i] != cur) break;
                update[i].next[i] = cur.next[i];
            }
            //更新最大层数
            while (currentLevel > 0 && head.next[currentLevel] == null) {
                currentLevel--;
            }
        }

        // 打印整个跳表 （每层输出）
        public void printSkipList () {
            for (int i = 0; i <= currentLevel; i++) {
                System.out.print("Level "+ i +": ");
                SkipListNode cur = head.next[i];
                while (cur != null) {
                    System.out.print(cur.val + " -> ");
                    cur = cur.next[i];
                }
                System.out.print("null");
                System.out.println();
            }
        }

        // 测试
        public static void main(String[] args) {
            SkipList skipList = new SkipList();
            skipList.insert(1);
            skipList.insert(3);
            skipList.insert(5);
            skipList.insert(7);
            skipList.insert(9);
            skipList.insert(11);
            System.out.println("====== 插入后的跳表 =====");
            skipList.printSkipList();

            System.out.print("\n====== 查找节点 =====");
            System.out.print("\n查找 5: " + skipList.search(5));
            System.out.print("\n查找 8: " + skipList.search(8));
            skipList.delete(5);
            System.out.println();
            System.out.println("\n====== 删除 5 后 =====");
            skipList.printSkipList();
        }

    }
}
