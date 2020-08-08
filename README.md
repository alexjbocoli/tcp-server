# tcp-server
Servidor TCP desenvolvido em Java com integração ao banco de dados H2

Obs.: o executável .jar não está incluso neste repositório pois seu tamanho excedeu o tamanho máximo permitido pelo GitHub.

Instruções:
1) Abrir o Spring Tool Suite 4, ir em File > Import > Maven > Existing Maven Projects > Next
2) Selecionar o projeto por meio do botão "Browse" e "Finish"
3) A execução do projeto pode ser feita clicando com o botão direito do mouse sobre o projeto, Run As > Java Application ou Spring Boot App
4) Quando executado, é necessário informar a porta no qual o servidor irá operar

-> Criação do .jar do projeto:
1) Com o botão direito do mouse sobre o projeto, Run As > Maven build...
2) No campo "Goals", informar "package" e clicar no botão "Run"
3) O .jar é criado no diretório "target" do projeto
4) Para executá-lo, execute cmd.exe, vá até o diretório onde o .jar está localizado e digite "java -jar nome_do_executavel.jar"
5) Quando executado, é necessário informar a porta no qual o servidor irá operar

-> Acessando o banco de dados H2:
1) Após executar o projeto ou o .jar, acessar o link http://localhost:8080/h2-console
2) Em JDBC URL, informar "jdbc:h2:mem:testdb"
3) User name: sa; Password: 123456

-> Considerações
1) O projeto cria a tabela TIMEZONE e insere 16 registros (16 fusos horários brasileiros) automaticamente por meio do arquivo "schema.sql" contido no diretório "\src\main\resources"
2) As demais tabelas são criadas a partir das classes modelo por meio do Hibernate
3) O arquivo de log LOG_SERVER.txt é criado no diretório raiz do projeto ou no diretório onde se localiza o executável .jar
