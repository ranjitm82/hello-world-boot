package com.example.demo.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DeadlockDetector {

    public String detectDeadlocks() {
    	
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreadIds = threadMXBean.findDeadlockedThreads();

        if (deadlockedThreadIds != null && deadlockedThreadIds.length > 0) {
        	
            ThreadInfo[] infos = threadMXBean.getThreadInfo(deadlockedThreadIds);
            StringBuilder result = new StringBuilder("Deadlock detected!\n");
            
            for (ThreadInfo info : infos) {
            	
                
            	result.append("Thread ").append(info.getThreadName())
                
                	  .append(" is blocked at ").append(new Date(info.getBlockedTime()))
                      .append(" is waiting on ").append(info.getLockName())
                      .append(" held by ").append(info.getLockOwnerName()).append("\n");
            }
            return result.toString();
        } else {
            return "No deadlocks detected.";
        }
    }
}
