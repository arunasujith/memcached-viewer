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

        MemcachedClient mcc = null;
        
        try {

            List<InetSocketAddress> inetSocketAddressList = new ArrayList<>();

            for (String ipAddress : ipList) {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(ipAddress, 11211);
                inetSocketAddressList.add(inetSocketAddress);
            }

            mcc = new MemcachedClient(inetSocketAddressList);
            String result = (String) mcc.get(key);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error while retrieving value.";
        } finally {
            if (mcc != null) {
                mcc.shutdown();
            }
        }
    }

}
