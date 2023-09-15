package com.powernode.config.pk8;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@ConfigurationProperties
public class CollectionConfig {
    List<MyServer> servers;
    Map<String, User> users;
    String[] names;

    public List<MyServer> getServers() {
        return servers;
    }

    public void setServers(List<MyServer> servers) {
        this.servers = servers;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "CollectionConfig{" +
                "servers=" + servers +
                ", users=" + users +
                ", names=" + Arrays.toString(names) +
                '}';
    }
}
