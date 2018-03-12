/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 *
 * @author jaguar
 */
public class ConUtil {

    public String getIP() {
        String ipAddress = null;
        Enumeration<NetworkInterface> net = null;
        try {
            net = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        while (net.hasMoreElements()) {
            NetworkInterface element = net.nextElement();
            Enumeration<InetAddress> addresses = element.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress ip = addresses.nextElement();

                if (ip.isSiteLocalAddress()) {
                    ipAddress = ip.getHostAddress();
                }
            }
        }

        String ipAux[] = ipAddress.split("\\.");

        ipAddress = "  " + ipAux[2] + "." + ipAux[3];

        return ipAddress;
    }

    public String getDateTime(int op) {
        DateFormat dateFormat;
        Date date = new Date();
        
        if (op == 0) {
             dateFormat = new SimpleDateFormat("dd/MM/yyyy");
             return dateFormat.format(date);
        } else if (op == 1) {
            dateFormat = new SimpleDateFormat("HH:mm:ss");
            return dateFormat.format(date);
        }
        
        return "";
    }

}
