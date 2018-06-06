/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memcached.ui.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import net.spy.memcached.MemcachedClient;

/**
 *
 * @author aruna
 */
public class MemcachedNBClient {

    public static String getMemcachedValue(List<String> ipList, String key) {

        try {

            List<InetSocketAddress> inetSocketAddressList = new ArrayList<>();

            for (String ipAddress : ipList) {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(ipAddress, 11211);
                inetSocketAddressList.add(inetSocketAddress);
            }

            MemcachedClient mcc = new MemcachedClient(inetSocketAddressList);
            return (String) mcc.get(key);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error while retrieving value.";
        }
    }

}
