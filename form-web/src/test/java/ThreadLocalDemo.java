public class ThreadLocalDemo {
    //定义一个ThreadLocal类型的变量，该变量将是一个线程局部变量，每个线程都会保留该变量的一个副本
    private static final ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<Long>();

    public static void main(String[] args){
        startTimeThreadLocal.set(6666L);

        doBiz();//
        long beginTime = startTimeThreadLocal.get();

        long consumeTime = System.currentTimeMillis()-beginTime;
        System.out.println(String.format("业务执行耗时[%s]毫秒",consumeTime));

        //4.避免内存泄漏
        startTimeThreadLocal.remove();
    }
    private static void doBiz(){
        try{
            System.out.println(String.format("线程[%s]在处理业务，请求的时间为[%s]",
                    Thread.currentThread().getName(),startTimeThreadLocal.get()));
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 处理请求
     * @param begin便于方便看效果，而可以设置的开始时间
     */
    private static void doAction(long begin){
        new Thread(){
            @Override
            public void run(){
                //2.假装接收到请求，设置开始时间，线程绑定变量（该数据只有当前请求的线程可见）
                startTimeThreadLocal.set(begin);
                //假装在处理业务
                doBiz();
                long beginTime = startTimeThreadLocal.get();
                //业务处理消耗时间
                long consumeTime = System.currentTimeMillis()-beginTime;
                System.out.println(String.format("线程[%s]处理业务执行耗时[%s]毫秒",
                        Thread.currentThread().getName(),consumeTime));
                //4.避免内存泄漏
                startTimeThreadLocal.remove();
            }
        }.start();
    }



























}
