/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14776
 * Date: 2022-05-31
 * Time: 11:33
 */
//进程(作业)类，包含作业的有关信息
public class Pcb {

    private int id;     //进程id
    private int state;  //进程状态 0为空闲 1为就绪 2为执行 3为阻塞
    private Hole hole;  //进程所对应的分区块

    public Pcb() {

    }

    public Pcb(int id, int state, Hole hole) {
        this.id = id;
        this.state = state;
        this.hole = hole;
    }

    @Override
    public String toString() {
        return "Pcb{" +
                "id=" + id +
                ", state=" + state +
                ", hole=" + hole.toString() +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Hole getHole() {
        return hole;
    }

    public void setHole(Hole hole) {
        this.hole = hole;
    }
}