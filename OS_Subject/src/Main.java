import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-31
 * Time: 14:44
 */
public class Main {
    public static void main(String[] args) {
        DoPcb doPcb = new DoPcb();
        Scanner scan = new Scanner(System.in);
        System.out.println("初始化内存大小:");
        Memory memory = new Memory(scan.nextInt());
        System.out.println("初始化成功!");
        while (true) {
            System.out.print("请输入操作数(0、结束进程\t1、申请内存\t2、释放内存):");
            switch (scan.nextInt()) {
                case 0:
                    System.exit(0);//系统退出函数
                    break;
                case 1:
                    System.out.print("请输入申请大小:");
                    int size = scan.nextInt();
                    memory = doPcb.FirstCycle(memory, size);
                    doPcb.showPcbs(memory);
                    doPcb.showMemory(memory);
                    break;
                case 2:
                    System.out.print("请输入需要释放的分区id或进程id:");
                    int id = scan.nextInt();
                    System.out.println();
                    memory = memory.releaseMemory(id);
                    doPcb.showPcbs(memory);
                    doPcb.showMemory(memory);
                    break;
                default:
                    System.err.println("未知标识符");
                    break;
            }
        }
    }
}
