# *******Cordova : Get IP Address of your Device*********** #

By using this plugin you can get the ip address of your devices, or you can get all the ip address for your device.  EG: ipv4, ipv6 this should include all your VPN ip address.

## Install this plugin using:

```
cordova plugin add github:the7erm/cordova_get_ip_address
```

## Remove Plugins :

```
cordova plugin remove github:the7erm/cordova_get_ip_address
```

## Put the below code in your javascript code to get the ip address: 

### Get the ip address.
```javascript
getdeviceip.get_ip(
	function(ipaddress)
	{
            console.log(ipaddress);
        },
	function(error)
	{
            console.log(error);
        }
    );
```

### Get ALL the ip address.
```javascript
getdeviceip.get_all_ip(
	function(ipaddress)
	{
            console.log(ipaddress);
        },
	function(error)
	{
            console.log(error);
        }
    );
```

Original project - just get the "last" ip.
> GitHub URL: https://github.com/jaypratapsingh/cordova_get_ip_address

This project - gets all of them.
> GitHub URL: https://github.com/the7erm/cordova_get_ip_address
