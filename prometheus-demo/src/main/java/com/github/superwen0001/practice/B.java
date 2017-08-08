package com.github.superwen0001.practice;

import io.prometheus.client.Collector;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.PushGateway;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Enumeration;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by wenshiliang on 2017/4/11.
 */
public class B {
    public static CollectorRegistry registry = new CollectorRegistry();

    public static void main(String[] args) {
        Thread pushThread =new Thread(new PushThread(registry));
        Thread taskThread =new Thread(new TaskThread(registry));
        pushThread.start();
        taskThread.start();
    }
}

class PushThread implements  Runnable{

    private CollectorRegistry registry;
    PushGateway pg = new PushGateway("192.168.1.51:10141");

    public PushThread(CollectorRegistry registry) {
        this.registry = registry;
    }

    public void run() {
        while(true){
            try {
                TimeUnit.SECONDS.sleep(10);
//            registry.
                Enumeration<Collector.MetricFamilySamples> enumeration  = registry.metricFamilySamples();

                while (enumeration.hasMoreElements()){
                    System.out.println(enumeration.nextElement());
                }
                pg.push(registry, "wsl_test_job"+ ManagementFactory.getRuntimeMXBean().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

class TaskThread implements Runnable{

    private CollectorRegistry registry;
    private Gauge inprogressRequests;

    public TaskThread(CollectorRegistry registry) {
        this.registry = registry;
        inprogressRequests = Gauge.build().name("inprogress_requests").help("Inprogress requests.").labelNames("t1","t2").register(registry);
    }

    public void run() {
        while(true){
            inprogressRequests.labels("aaa","bbb").inc();
            inprogressRequests.labels("a2", "b2").inc(10);
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
