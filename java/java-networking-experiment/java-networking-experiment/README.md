Java networking (java.net) APIs
===============================
The java.net package can be roughly divided in two sections:
 1. A Low Level API, which deals with the following abstractions:
    * Addresses, which are networking identifiers, like IP addresses.
    * Sockets, which are basic bidirectional data communication mechanisms.
    * Interfaces, which describe network interfaces.
 2. A High Level API, which deals with the following abstractions:
    * URIs, which represent Universal Resource Identifiers.
    * URLs, which represent Universal Resource Locators.
    * Connections, which represents connections to the resource pointed to by URLs.

### Addresses
Addresses are used throughout the java.net APIs as either host identifiers, or socket endpoint identifiers.
The InetAddress class is the abstraction representing an IP (Internet Protocol) address. It has two subclasses:
 * Inet4Address for IPv4 addresses.
 * Inet6Address for IPv6 addresses.
But, in most cases, there is no need to deal directly with the subclasses,
as the InetAddress abstraction should cover most of the needed functionality.

### Sockets
Sockets are means to establish a communication link between machines over the network.
The java.net package provides 4 kinds of Sockets:
 * `Socket` is a TCP client API, and will typically be used to connect to a remote host.
 * `ServerSocket` is a TCP server API, and will typically accept connections from client sockets.
 * `DatagramSocket` is a UDP endpoint API and is used to send and receive datagram packets.
 * `MulticastSocket` is a subclass of DatagramSocket used when dealing with multicast groups.
 
