/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-31
 * Time: 14:45
 */
//对内存的操作类
public class DoPcb {
    public Memory FirstCycle(Memory memory, int size) {//循环首次适应算法 memory是初始化的整个内存空间，size是你申请的空间大小
        Hole hole = memory.getHoles().get(memory.getLastFind());
        if (hole.isFree() && hole.getSize() >= size) {  //判断最后寻址的分区的大小是否足够
            return memory.getMemory(size, memory.getLastFind(), hole);
        }
        int length = memory.getHoles().size();
        int sum = 0;    //为区分与首次适应算法循环次数所设置
        //如果不够,则从下一个分区开始循环
        for (int i = (memory.getLastFind() + 1) % length; i != memory.getLastFind(); i = (i + 1) % length) {
            sum++;
            memory.setLastFind(i);
            hole = memory.getHoles().get(i);
            if (hole.isFree() && hole.getSize() >= size) {
                System.out.println("查找" + sum + "次");
                return memory.getMemory(size, i, hole);
            }
        }
        System.err.println("OUT OF MEMORY!");
        return memory;
    }

    public void showMemory(Memory memory) {
        System.out.println("------------------------------------");
        System.out.println("分区编号\t分区始址\t分区大小\t空闲状态\t");
        System.out.println("------------------------------------");
        for (int i = 0; i < memory.getHoles().size(); i++){
            Hole hole = memory.getHoles().get(i);
            System.out.println(i + "\t\t" + hole.getHead() + "\t\t" + hole.getSize() + "  \t" + hole.isFree());
        }
        System.out.println("------------------------------------");
    }

    public void showPcbs(Memory memory) {
        System.out.println("------------------------------------");
        System.out.println("进程编号\t进程状态\t进程起始地址\t进程大小\t");
        System.out.println("------------------------------------");
        if (memory.getPcbs().size() > 0) {
            for (int i = 0; i < memory.getPcbs().size(); i++) {
                Pcb pcb = memory.getPcbs().get(i);
                System.out.println(pcb.getId() + "  \t" + pcb.getState() + "\t\t" + pcb.getHole().getHead() + "\t\t\t" + pcb.getHole().getSize());
            }
        } else {
            System.err.println("\t\t\t暂无进程！");
        }
        System.out.println("------------------------------------");
    }
}
