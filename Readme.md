# money-transfer-undertow-jee-hibernate-jaxrs-json
Test application of JEE Application + CDI + Embedded Servlet Container with Undertow + REST + JSON

  To run the jar:
  
    mvn clean install
    java -jar target/embedded-app/money-transfer.jar


  After the run, test in your browser and curl:
    
    http://localhost:8080/money-transfer/api/finance/account?id=100010 
    curl -H "Content-Type: application/json" -X POST http://localhost:8080/money-transfer/api/finance/transfermoney -d {\"accFrom\":{\"id\":100010},\"accTo\":{\"id\":100011},\"money\":{\"amount\":700000,\"currency\":{\"id\":100000,\"isoCurrencyCode\":\"RUB\"}}}}

