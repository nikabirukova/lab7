java -cp compute.jar;. -Djava.rmi.server.codebase="http://localhost:80/RMI/ http://localhost:80/RMI/compute.jar" -Djava.rmi.server.hostname=localhost -Djava.security.policy=program.policy server.Server
pause