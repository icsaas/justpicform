import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class BizFlowStat extends Thread {
    private static FlowNo flowNo = new FlowNo();

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * 1.定义一个ThreadLocal类型的变量，该变量僵尸一个线程局部变量，每个线程都会保留该变量的一个副本
     *
     */
    private static final ThreadLocal<FlowNo> flowNoThreadLocal = new ThreadLocal<FlowNo>(){
        @Override
        protected FlowNo initialValue(){
            return flowNo;
        }
    };

    @Override
    public void run(){
        for(int i=0;i<5;i++){
            flowNoThreadLocal.get().setId(flowNoThreadLocal.get().getId()+1);
            System.out.println(String.format("线程[%s]-->开始执行流程[%d]",
                    Thread.currentThread().getName(),flowNoThreadLocal.get().getId()));
        }
    }


    public static void main(String[] args){
        new BizFlowStat().start();
        new BizFlowStat().start();
    }
}

class FlowNo{
    private Long id =1L;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
}
