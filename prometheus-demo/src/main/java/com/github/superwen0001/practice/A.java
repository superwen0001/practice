package com.github.superwen0001.practice;


import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Gauge;
import io.prometheus.client.exporter.PushGateway;

import java.util.concurrent.TimeUnit;

/**
 * Created by wenshiliang on 2017/4/10.
 */
public class A {


    public static void main(String[] args) throws Exception {
        System.out.println(args.length);
        executeBatchJob();
    }

    static void executeBatchJob() throws Exception {
        CollectorRegistry registry = new CollectorRegistry();
        Gauge duration = Gauge.build()
                .name("my_batch_job_duration_seconds")
                .help("Duration of my batch job in seconds.")
                .register(registry);
        Gauge.Timer durationTimer = duration.startTimer();

//        Counter requests = Counter.build()
//                .name("requests_total").help("Total requests.").register();
        try {
            // Your code here.

            TimeUnit.SECONDS.sleep(20);
            // This is only added to the registry after success,
            // so that a previous success in the Pushgateway is not overwritten on failure.
            Gauge lastSuccess = Gauge.build()
                    .name("my_batch_job_last_success_unixtime")
                    .help("Last time my batch job succeeded, in unixtime.")
                    .register(registry);
            lastSuccess.setToCurrentTime();

        } finally {
            durationTimer.setDuration();
//            PushGateway pg = new PushGateway("127.0.0.1:9091");
            PushGateway pg = new PushGateway("192.168.1.51:10141");
//            PushGateway pg = new PushGateway("192.168.1.80:24934");
            pg.pushAdd(registry, "my_batch_job1");
        }
    }
}



