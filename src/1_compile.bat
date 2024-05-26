javac compute/*.java
jar cvf compute.jar compute/*.class
javac -cp compute.jar server/*.java
javac -cp compute.jar client/*.java
javac NanoHTTPD/NanoHTTPD.java
copy compute.jar NanoHTTPD\RMI
copy client\ComputeTasks.class NanoHTTPD\RMI\client
copy client\ConstantE.class NanoHTTPD\RMI\client
copy client\Pi.class NanoHTTPD\RMI\client
pause