package main.lockdemo

import java.util.concurrent.locks.ReentrantLock

/**
 * 使用ReentrantLock结合Condition进行线程的顺序执行调度
 */
class ConditionDemo {

    companion object{
        private var nextPrintWho = 1

        private val mReentrantLock = ReentrantLock()

        private val mConditionA = mReentrantLock.newCondition()
        private val mConditionB = mReentrantLock.newCondition()
        private val mConditionC = mReentrantLock.newCondition()

        @JvmStatic
        fun main(args: Array<String>) {
            val threadA = Thread {
                try {
                    mReentrantLock.lock()
                    while (nextPrintWho != 1) {
                        mConditionA.await()
                    }
                    for (i in 0 until 3) {
                        println("ThreadA ${i + 1}")
                    }
                    nextPrintWho = 2
                    mConditionB.signalAll()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    mReentrantLock.unlock()
                }
            }

            val threadB = Thread {
                try {
                    mReentrantLock.lock()
                    while (nextPrintWho != 2) {
                        mConditionB.await()
                    }
                    for (i in 0 until 3) {
                        println("ThreadB ${i + 1}")
                    }
                    nextPrintWho = 3
                    mConditionC.signalAll()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    mReentrantLock.unlock()
                }
            }

            val threadC = Thread {
                try {
                    mReentrantLock.lock()
                    while (nextPrintWho != 3) {
                        mConditionC.await()
                    }
                    for (i in 0 until 3) {
                        println("ThreadC ${i + 1}")
                    }
                    nextPrintWho = 1
                    mConditionA.signalAll()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    mReentrantLock.unlock()
                }
            }

            Thread(threadA).start()
            Thread(threadB).start()
            Thread(threadC).start()
        }
    }

}