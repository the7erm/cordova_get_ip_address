
//Plugins created by Jay Pratap Singh

package com.jp.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Intent;
import android.provider.ContactsContract;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;


public class Get_IP_Address extends CordovaPlugin {

    String ipAddress = "";
    String ip = "";

    public boolean execute(String args, JSONArray jsonarray, CallbackContext callbackContext )
    {
        if(args.equalsIgnoreCase("get_ip_address")) {

            try {
                ipAddress = "";
                for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                    NetworkInterface intf = en.nextElement();
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            ipAddress = inetAddress.getHostAddress().toString();
                        }
                    }
                }

            }
            catch(Exception e) {
                e.printStackTrace();
            }

            callbackContext.success(ipAddress);
            return true;
        } else if(args.equalsIgnoreCase("get_all_ip_address")) {
            try {
                ipAddress = "";
                for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                    NetworkInterface intf = en.nextElement();
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            ip = inetAddress.getHostAddress().toString();

                            if (!ipAddress.isEmpty()) {
                                ipAddress = ipAddress.concat(" ");
                            }
                            ipAddress = ipAddress.concat(ip);
                        }
                    }
                }

            }
            catch(Exception e) {
                e.printStackTrace();
            }

            callbackContext.success(ipAddress);
            return true;
        } else {
            callbackContext.error("Invalid Selection "+args);
            return false;
        }


    }

}
