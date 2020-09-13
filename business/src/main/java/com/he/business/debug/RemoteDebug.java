package com.he.business.debug;

import java.util.Map;

public class RemoteDebug {
    public static void main(String[] args) {
        System.out.println("------------------start------------------");

        System.out.println("get all the system environment");
        Map<String, String> envs = System.getenv();

        System.out.println("\nprint out the contains `HOME`");
        System.out.println("------env HOME------");
        envs.entrySet().stream()
                .filter(env -> env.getKey().contains("HOME"))
                .forEach(env -> {
                    System.out.println(env.getKey() + ":" + env.getValue());
                });

        System.out.println("------------------end------------------");
    }
}
