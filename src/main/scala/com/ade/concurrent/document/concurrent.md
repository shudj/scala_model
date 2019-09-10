#重点知识
##定义
JVM：java虚拟机模型
JMM：java内存模型（Java Memory Model），主要是为了规定了线程和内存之间的一些关系
##如何减少上下文切换
1.无锁并发编程：多线程竞争锁时，会引起上下文切换，所以多线程处理数据时，可以用一些办法来避免使用锁，如将数据的ID按照Hash算法取模分段，不同线程处理不同段的数据  
2.CAS算法：Java的Atomic包使用CAS算法来更新数据，而不需要加锁  
3.使用最少线程：避免创建不需要的线程，比如人物很少，但是创建了很多线程来处理，这样会造成大量线程处于等待状态  
4.协程：在单线程里直线多任务的调度，并在单线程里维持多个任务间的切换  
##锁的4种状态  
从低到高一次是：无锁状态、偏向锁状态、轻量级锁状态和重量级锁状态；这几个状态会随着竞争情况逐渐升级；锁可以升级但不能降级  
偏向锁：在Java6和Java7是默认启用的，但是它在程序启动几秒钟之后才激活；关闭延迟用：-XX:BiasedLockingStartupDelay=0；如果确定应用程序里所有的锁通常情况下处于竞争状态，可以通过：-XX:UseBiasedLocking=false来关闭偏向锁，则程序默认进入轻量级锁
##避免死锁的方法
1.避免一个线程同时获取多个锁  
2.避免一个线程在锁内同时占用多个资源，尽量保证每个锁只占用一个资源  
3.尝试使用定时锁，使用lock.tryLock(timeout)来替代使用内部锁机制  
4.对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败的情况  
##volatitle
当写一个volatile变量时，JMM会把该线程对应的本地内存中的共享变量值刷新到主内存  
当读一个volatile变量时，JMM会把该线程对应的本地内存置为无效，线程接下来将从主内存中读取共享变量  
##happens-before
1.程序顺序规则：一个线程中的每个操作，happens-before于该线程中的任意后续操作  
2.监视器锁规则：对一个锁的解锁，happens-before于随后对这个锁的加锁  
3.volatile变量规则：对一个volatile域的写，happens-before于任意后续对这个volatile域的读  
4.传递性：如果A happens-before B，且B happens-before C，那么A happens-before C
5.start()规则：如果线程A执行操作ThreadB.start()（启动线程B），那么A线程的ThreadB.start()操作happens-before于线程B中的任意操作  
6.join()规则：如果线程A执行操作ThreadB.join()并成功返回，那么线程B中的任意操作happens-before于线程A从ThreadB.join()操作成功返回
