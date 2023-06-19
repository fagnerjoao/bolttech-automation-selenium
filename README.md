## Selenium


# Setup PC
- JDK 8 ou superior
- IDE: IntelliJ
- Configurar as variáveis de ambiente (ex: JAVA_HOME) de acordo com SO
- Certifique-se de que o ChromeDriver/FirefoxDriver está instalado corretamente (de acordo com a versão do browser) e configurado no PATH do seu sistema operacional


# Setup Prjeto (Maven dependencies)
- cucumber-java 7.12.1 (https://mvnrepository.com/artifact/io.cucumber/cucumber-java )
- junit-jupiter-api 5.9.2 (https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api2)
- cucumber-junit 7.12.1 (https://mvnrepository.com/artifact/io.cucumber/cucumber-junit)
- selenium-java 4.10.0 (mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)

# Cenários back-end
| Nome dos Cenários              | Tags | 
|--------------------------------|------|
| Access Form | @signup @access-form | 
| reate user      |@signup @create-user | 
| Add product to card   |@cart @add-product-success| 
| Check if the product is in the cart          |@cart @verify-product| 


# Execução dos Cenário na IDE:
- Os testes devem ser executados como 'Junit Test'
- A execução pode ser feita individualmente nas classe Runner informando a ou tags dos cenários que se deseja executar. Ex: tags = "@verify-product"

# Executando através da linha de comando
- Abra o terminal ou prompt de comando 
- Navegue até o diretório raiz do projeto
- Execute o seguinte comando para executar todos os testes:
  - Para gerar relatório "formated-reports" -> mvn test -Dtest=**/*Runner cluecumber-report:reporting 
  - Para executar informando tag especofícias -> mvn test -Dcucumber.options="--tags @tagDesejada.


# Resources
##### [Selenium](https://www.selenium.dev/)
##### [Junit](https://junit.org/)
