The Map interface collection  - key/value fature.
There are four general-purpose implementation of Map interface: 
	1) HashMap;
	2) Hashtable;
	3) TreeMap;
	4) LinkedHashMap.

Feature of Map:
 - is particular type of general type of symbolic table (associative array)
 - key-value pair adding/retriving collection; 
 - it models the mathematical function abstraction;
 - a map cannot contain duplicate keys.
 - elements of a Map are of type Map.Entry<K, V> interface

Feature of HashMap:
 - has unordered elements;
 - is not thread-safe;
 - is not synchronized but has better performance;
 - allows null values and one null keys;
 - provides constant-time performance for the basic operations (get() and put());
 - iteration performance (next()) is O(h/n), wehere h is the table capacity
 
Feature of LinkedHashMap:
 - like HashMap but allow ordering by insertion order (insertion-order);
 - as double linked list; 

Feature of TreeMap:
 - has ordered elements;
 - TreeMap class is based on a red-black tree,
 - where a red-black tree is a binary search tree that is empty or in which the root element is colored black;
 - provides guaranteed log(n) time cost for the:
 				containsKey();
 				get();
 				put();
 				remove();
 	operations

Feature of Hashtable:
 - is thread safe;
 - doesn't allow null key or values;
 - is synchronized but slower performance.

 When to use Map:
 1. If you store data in form of key and value than Map is the way to go.