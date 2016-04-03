Compile with:

```
./gradlew clean build
```

Run Node 1: 
```
java -Dswarm.bind.address=192.168.0.1 -Djava.net.preferIPv4Stack=true -jar build/libs/swarmdemo5-swarm.jar
```

Run Node 2: 
```
java -Dswarm.bind.address=192.168.0.1 -Dswarm.port.offset=100 -Djava.net.preferIPv4Stack=true -jar build/libs/swarmdemo5-swarm.jar
```

where 192.168.0.1 is your local IP address. Note that using 127.0.0.1 seems
to not work properly in my tests.