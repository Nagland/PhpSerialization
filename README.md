# PhpSerialization
PHP object serialize/unserialize to Java Object, still in development


## Unserialize


```java
String body = "a:7:{s:6:\"_token\";s:40:\"nLOlgJE3e1IwP8WimS4k44vMc8NVIC08N159pju4\";s:9:\"_previous\";a:1:{s:3:\"url\";s:29:\"http://example.com/test/home/index\";}s:5:\"flash\";a:2:{s:3:\"old\";a:0:{}s:3:\"new\";a:0:{}}s:9:\"auth_code\";s:32:\"9cee7bcf269a8edf5f313595eef919ce\";s:3:\"url\";a:1:{s:8:\"intended\";s:29:\"http://example.com/test/home/index\";}s:50:\"login_web_59ba36addc2b2f9401580f014c7f58ea4e30989d\";s:32:\"4d4eb6317e5e4871897fdd7165964d3a\";s:9:\"_sf2_meta\";a:3:{s:1:\"u\";i:1466043199;s:1:\"c\";i:1466042852;s:1:\"l\";s:1:\"0\";}}";
PhpDecoder decoder = PhpDecoder.newInstance(body);
JSONArray ret = decoder.decode();
```


## Serialize


waiting



