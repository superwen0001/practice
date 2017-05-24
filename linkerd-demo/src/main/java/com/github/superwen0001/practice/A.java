package com.github.superwen0001.practice;

/**
 * Created by wenshiliang on 2017/5/19.
 */
public class A {
    public static void main(String[] args) {
        String str = "{\"admin\":{\"port\":9990},\"telemetry\":[{\"kind\":\"io.l5d.prometheus\"}]," +
                "\"namers\":[{\"kind\":\"io.l5d.marathon\",\"host\":\"leader.mesos\",\"port\":8080,\"prefix\":\"/io" +
                ".l5d.marathon\",\"uriPrefix\":\"\"}],\"routers\":[{\"protocol\":\"http\"," +
                "\"servers\":[{\"port\":4140,\"ip\":\"0.0.0.0\"}],\"dtab\":\"/marathonId=>/#/io.l5d.marathon;" +
                "/svc=>/$/io.buoyant.http.domainToPathPfx/marathonId;\",\"label\":\"outgoing\"," +
                "\"interpreter\":{\"kind\":\"default\",\"transformers\":[{\"kind\":\"io.l5d.port\",\"port\":4141}]}}," +
                "{\"protocol\":\"http\",\"servers\":[{\"port\":4141,\"ip\":\"0.0.0.0\"}]," +
                "\"dtab\":\"/marathonId=>/#/io.l5d.marathon;/svc=>/$/io.buoyant.http.domainToPathPfx/marathonId;\"," +
                "\"label\":\"incoming\",\"interpreter\":{\"kind\":\"default\",\"transformers\":[{\"kind\":\"io.l5d" +
                ".localhost\"}]}}]}";

        System.out.println(str);

        str = "{\"admin\":{\"port\":9001},\"storage\":{\"kind\":\"io.l5d.zk\",\"zkAddrs\":[{\"host\":\"leader.mesos\",\"port\":2181}],\"pathPrefix\":\"/dtabs\",\"sessionTimeoutMs\":10000},\"namers\":[{\"kind\":\"io.l5d.marathon\",\"host\":\"marathon.mesos\",\"port\":8080}],\"interfaces\":[{\"kind\":\"io.l5d.thriftNameInterpreter\",\"ip\":\"0.0.0.0\",\"port\":4100},{\"kind\":\"io.l5d.httpController\",\"ip\":\"0.0.0.0\",\"port\":4180}]}";
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(str);


        str  = "\"{\\\"admin\\\":{\\\"port\\\":9990},\\\"telemetry\\\":[{\\\"kind\\\":\\\"io.l5d.prometheus\\\"}],\\\"routers\\\":[{\\\"protocol\\\":\\\"http\\\",\\\"servers\\\":[{\\\"port\\\":4140,\\\"ip\\\":\\\"0.0.0.0\\\"}],\\\"label\\\":\\\"linkerd_proxy\\\",\\\"interpreter\\\":{\\\"kind\\\":\\\"io.l5d.namerd\\\",\\\"dst\\\":\\\"/$/inet/namerd.marathon.mesos/4100\\\"}}]}\"";
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(str);

        str = "{\"admin\":{\"port\":9990},\"telemetry\":[{\"kind\":\"io.l5d.prometheus\"}]," +
                "\"routers\":[{\"protocol\":\"http\",\"servers\":[{\"port\":4140,\"ip\":\"0.0.0.0\"}]," +
                "\"label\":\"linkerd_proxy\",\"interpreter\":{\"kind\":\"io.l5d.namerd\",\"dst\":\"/$/inet/namerd" +
                ".marathon.mesos/4100\"}}]}";
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(str);

    }
}
