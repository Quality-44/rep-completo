package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class DataBase {

public static final int TIMEOUT = 300;

/**
 *
 * @author Leandro Leonardo Assarice
 * @since 31/07/2024, 14:42:16
 *
 */
public static void clearAllSources() throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.database.Operations.beginTransaction(Var.valueOf("app"));
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.Event"),Var.valueOf("TRUNCATE TABLE EVENT;"));
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.Archive"),Var.valueOf("TRUNCATE TABLE ARCHIVE;"));
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.Image"),Var.valueOf("TRUNCATE TABLE IMAGE;"));
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.User"),Var.valueOf("DELETE FROM USER WHERE id <> \'1d4e5d7b-dca8-4a1d-90fd-72648cf5dc8d\';"));
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.Tree"),Var.valueOf("DELETE FROM TREE;"));
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.City"),Var.valueOf("TRUNCATE TABLE CITY;"));
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.State"),Var.valueOf("DELETE FROM State;"));
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.Scroll"),Var.valueOf("TRUNCATE TABLE SCROLL;"));
    cronapi.database.Operations.commitTransaction(Var.valueOf("app"));
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
    Var.valueOf("Dados deletados com sucesso!"));
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Leandro Leonardo Assarice
 * @since 31/07/2024, 14:42:16
 *
 */
public static void populateAllSources() throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    populateEventFont();
    populateScrollFont();
    populateStateCityFont();
    populateTreeFont();
    populateUserFont();
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Leandro Leonardo Assarice
 * @since 31/07/2024, 14:42:16
 *
 */
public static void populateEventFont() throws Exception {
  new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    cronapi.database.Operations.beginTransaction(Var.valueOf("app"));
    item =
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.Event"),Var.valueOf("TRUNCATE TABLE EVENT;\nINSERT INTO EVENT(ID, DATE, DETAILS, EVENT, ICON, POSITION)\nVALUES\n(\'2C588B3E-AF2F-4581-BDD5-3D9F5FEAB8F9\',\'2024-02-19 09:02:42\',\'Obrigado por fazer seu pedido conosco! Seu pedido foi confirmado e está em processo de preparação.\',\'Pedido Confirmado\', \'glyphicon-shopping-cart\', 1),\n(\'4B834F18-2E39-437D-9ACD-999D7C43A940\',\'2024-02-21 09:10:55\',\'Ótimas notícias! Seu pedido foi despachado e está a caminho do endereço de entrega. Aqui está o seu número de rastreamento: BRDFV1SZDFSQXC1\',\'Pedido Despachado\',\'glyphicon glyphicon-plane\',2),\n(\'58A6C253-273F-45ED-B3C7-305F2A67DDFA\',\'2024-02-23 09:13:19\',\'Seu pacote está em trânsito e a caminho do destino! Você pode acompanhar o progresso da entrega usando o número de rastreamento fornecido.\',\'Em Trânsito\',\'glyphicon glyphicon-road\',1),\n(\'DEE65116-5975-4E0D-AC3B-7201A0D4E8D3\',\'2024-02-24 09:08:13\',\'Seu pacote saiu para entrega! Nossa equipe de entregas está a caminho do seu endereço.\',\'Saiu para Entrega\',\'glyphicon glyphicon-send	\',2);"));
    cronapi.database.Operations.commitTransaction(Var.valueOf("app"));
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
    Var.valueOf("Dados populados com sucesso!"));
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Leandro Leonardo Assarice
 * @since 31/07/2024, 14:42:16
 *
 */
public static void populateScrollFont() throws Exception {
  new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    cronapi.database.Operations.beginTransaction(Var.valueOf("app"));
    item =
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.Scroll"),Var.valueOf("TRUNCATE TABLE SCROLL;\nINSERT INTO SCROLL (ID, NAME)\nSELECT\n    ROWNUM() AS ID,\n    \'Name \' || ROWNUM() AS NAME\nFROM\n    SYSTEM_RANGE(1, 1000);"));
    cronapi.database.Operations.commitTransaction(Var.valueOf("app"));
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
    Var.valueOf("Dados populados com sucesso!"));
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Leandro Leonardo Assarice
 * @since 31/07/2024, 14:42:16
 *
 */
public static void populateStateCityFont() throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.database.Operations.beginTransaction(Var.valueOf("app"));
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.City"),Var.valueOf("TRUNCATE TABLE CITY;"));
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.State"),Var.valueOf("DELETE FROM State;"));
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.State"),Var.valueOf("INSERT INTO state (id, name) \nVALUES (1, \'São Paulo\'),\n(2, \'Rio de Janeiro\'),\n(3, \'Minas Gerais\'),\n(4, \'Bahia\'),\n(5, \'Paraná\'),\n(6, \'Rio Grande do Sul\'),\n(7, \'Santa Catarina\'),\n(8, \'Pernambuco\'),\n(9, \'Ceará\'),\n(10, \'Amazonas\');"));
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.City"),Var.valueOf("INSERT INTO city (id, name, fk_state) \nVALUES \n(1, \'São Paulo\', 1),\n(2, \'Campinas\', 1),\n(3, \'Santos\', 1),\n(4, \'São José dos Campos\', 1),\n(5, \'Ribeirão Preto\', 1),\n(6, \'Rio de Janeiro\', 2),\n(7, \'Niterói\', 2),\n(8, \'Petrópolis\', 2),\n(9, \'Volta Redonda\', 2),\n(10, \'Duque de Caxias\', 2),\n(11, \'Belo Horizonte\', 3),\n(12, \'Uberlândia\', 3),\n(13, \'Contagem\', 3),\n(14, \'Juiz de Fora\', 3),\n(15, \'Betim\', 3),\n(16, \'Salvador\', 4),\n(17, \'Feira de Santana\', 4),\n(18, \'Vitória da Conquista\', 4),\n(19, \'Camaçari\', 4),\n(20, \'Juazeiro\', 4),\n(21, \'Curitiba\', 5),\n(22, \'Londrina\', 5),\n(23, \'Maringá\', 5),\n(24, \'Ponta Grossa\', 5),\n(25, \'Cascavel\', 5),\n(26, \'Porto Alegre\', 6),\n(27, \'Caxias do Sul\', 6),\n(28, \'Pelotas\', 6),\n(29, \'Santa Maria\', 6),\n(30, \'Canoas\', 6),\n(31, \'Florianópolis\', 7),\n(32, \'Joinville\', 7),\n(33, \'Blumenau\', 7),\n(34, \'São José\', 7),\n(35, \'Chapecó\', 7),\n(36, \'Recife\', 8),\n(37, \'Jaboatão dos Guararapes\', 8),\n(38, \'Olinda\', 8),\n(39, \'Caruaru\', 8),\n(40, \'Petrolina\', 8),\n(41, \'Fortaleza\', 9),\n(42, \'Caucaia\', 9),\n(43, \'Juazeiro do Norte\', 9),\n(44, \'Maracanaú\', 9),\n(45, \'Sobral\', 9),\n(46, \'Manaus\', 10),\n(47, \'Parintins\', 10),\n(48, \'Itacoatiara\', 10),\n(49, \'Manacapuru\', 10),\n(50, \'Coari\', 10);"));
    cronapi.database.Operations.commitTransaction(Var.valueOf("app"));
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
    Var.valueOf("Dados populados com sucesso!"));
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Leandro Leonardo Assarice
 * @since 31/07/2024, 14:42:16
 *
 */
public static void populateTreeFont() throws Exception {
  new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    cronapi.database.Operations.beginTransaction(Var.valueOf("app"));
    item =
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.Tree"),Var.valueOf("DELETE FROM TREE;\nINSERT INTO TREE(ID, CREW_MEMBER , FK_TREE_0)\nVALUES(\'60EC671A-5D93-4623-A79A-029F95E6A2D8\', \'Capitão-Jack-Sparrow\', null),\n(\'298C8086-C12A-484E-BE93-0F6CB0B8CB90\', \'Capitão-Nemo\', null),\n(\'C3A42C8C-5EB2-4047-B0FB-6553885F0424\', \'Oficial-Hook\', \'60EC671A-5D93-4623-A79A-029F95E6A2D8\'),\n(\'0248BB7D-72BA-4F80-A8FA-45914A108570\',\'Tripulante-Peter\',\'298C8086-C12A-484E-BE93-0F6CB0B8CB90\'),\n(\'2C74F5B3-45BC-4271-98E6-FD427DF14B9E\', \'Tripulante-Ahab\', \'C3A42C8C-5EB2-4047-B0FB-6553885F0424\'),\n(\'9C9C661E-CADC-4D6B-9B8A-44B10C3F9CC1\', \'Tripulante-Morgan\', \'298C8086-C12A-484E-BE93-0F6CB0B8CB90\');"));
    cronapi.database.Operations.commitTransaction(Var.valueOf("app"));
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
    Var.valueOf("Dados populados com sucesso!"));
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Leandro Leonardo Assarice
 * @since 31/07/2024, 14:42:16
 *
 */
public static void populateUserFont() throws Exception {
  new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    cronapi.database.Operations.beginTransaction(Var.valueOf("app"));
    item =
    cronapi.database.Operations.executeNativeQueryUpdate(Var.valueOf("app.entity.User"),Var.valueOf("DELETE FROM USER WHERE id <> \'1d4e5d7b-dca8-4a1d-90fd-72648cf5dc8d\';\nINSERT INTO USER (ID, ACCESS_FAILED_COUNT, EMAIL, EMAIL_CONFIRMED, LOCKOUT_ENABLED, LOCKOUT_END, NAME, NORMALIZED_EMAIL, NORMALIZED_USER_NAME, PASSWORD, PHONE_NUMBER, PHONE_NUMBER_CONFIRMED, PICTURE, SECURITY_STAMP, THEME, TWO_FACTOR_ENABLED, USER_NAME)\nVALUES \n(12345678923, 0, \'david@teste.io\', 1, 0, \'2016-09-06 14:41:05.0+00\', \'David Costa\', \'david@teste.io\', \'David\',\'123123\',\'\',1,\'\',\'123\',\'\',0,\'David Costa\'),\n(98765432112, 1, \'ana@teste.io\', 0, 1, \'2017-01-15 10:23:45.0+00\', \'Ana Silva\', \'ana@teste.io\', \'Ana\',\'456456\',\'\',0,\'\',\'456\',\'\',0,\'Ana Silva\'),\n(45678912345, 0, \'bruno@teste.io\', 1, 0, \'2018-03-21 16:54:32.0+00\', \'Bruno Santos\', \'bruno@teste.io\', \'Bruno\',\'789789\',\'\',1,\'\',\'789\',\'\',0,\'Bruno Santos\'),\n(65432198765, 1, \'carla@teste.io\', 0, 1, \'2019-05-12 12:34:56.0+00\', \'Carla Ferreira\', \'carla@teste.io\', \'Carla\',\'101010\',\'\',0,\'\',\'101\',\'\',0,\'Carla Ferreira\'),\n(32198765498, 0, \'diego@teste.io\', 1, 0, \'2020-07-04 18:45:21.0+00\', \'Diego Ribeiro\', \'diego@teste.io\', \'Diego\',\'121212\',\'\',1,\'\',\'121\',\'\',0,\'Diego Ribeiro\'),\n(78912345678, 1, \'eduarda@teste.io\', 0, 1, \'2021-08-25 14:15:37.0+00\', \'Eduarda Souza\', \'eduarda@teste.io\', \'Eduarda\',\'131313\',\'\',0,\'\',\'131\',\'\',0,\'Eduarda Souza\'),\n(14725836985, 0, \'fabio@teste.io\', 1, 0, \'2022-10-16 20:16:48.0+00\', \'Fabio Almeida\', \'fabio@teste.io\', \'Fabio\',\'141414\',\'\',1,\'\',\'141\',\'\',1,\'Fabio Almeida\'),\n(25836914736, 1, \'gabriela@teste.io\', 0, 1, \'2023-11-07 22:17:59.0+00\', \'Gabriela Lima\', \'gabriela@teste.io\', \'Gabriela\',\'151515\',\'\',0,\'\',\'151\',\'\',0,\'Gabriela Lima\'),\n(36914725847, 0, \'henrique@teste.io\', 1, 0, \'2024-12-29 23:18:10.0+00\', \'Henrique Gomes\', \'henrique@teste.io\', \'Henrique\',\'161616\',\'\',1,\'\',\'161\',\'\',0,\'Henrique Gomes\'),\n(74185296314, 1, \'isabela@teste.io\', 0, 1, \'2025-02-10 01:19:21.0+00\', \'Isabela Martins\', \'isabela@teste.io\', \'Isabela\',\'171717\',\'\',0,\'\',\'171\',\'\',0,\'Isabela Martins\'),\n(85296374125, 0, \'joao@teste.io\', 1, 0, \'2026-03-22 03:20:32.0+00\', \'Joao Pereira\', \'joao@teste.io\', \'Joao\',\'181818\',\'\',1,\'\',\'181\',\'\',1,\'Joao Pereira\'),\n(96374185236, 1, \'karina@teste.io\', 0, 1, \'2027-04-13 05:21:43.0+00\', \'Karina Oliveira\', \'karina@teste.io\', \'Karina\',\'191919\',\'\',0,\'\',\'191\',\'\',0,\'Karina Oliveira\'),\n(15935748624, 0, \'lucas@teste.io\', 1, 0, \'2028-05-25 07:22:54.0+00\', \'Lucas Costa\', \'lucas@teste.io\', \'Lucas\',\'202020\',\'\',1,\'\',\'202\',\'\',1,\'Lucas Costa\'),\n(35748615942, 1, \'mariana@teste.io\', 0, 1, \'2029-06-16 09:24:05.0+00\', \'Mariana Silva\', \'mariana@teste.io\', \'Mariana\',\'212121\',\'\',0,\'\',\'212\',\'\',1,\'Mariana Silva\'),\n(48615935753, 0, \'nelson@teste.io\', 1, 0, \'2030-07-28 11:25:16.0+00\', \'Nelson Santos\', \'nelson@teste.io\', \'Nelson\',\'222222\',\'\',1,\'\',\'222\',\'\',1,\'Nelson Santos\'),\n(95175382468, 1, \'olivia@teste.io\', 0, 1, \'2031-08-19 13:26:27.0+00\', \'Olivia Ferreira\', \'olivia@teste.io\', \'Olivia\',\'232323\',\'\',0,\'\',\'232\',\'\',0,\'Olivia Ferreira\'),\n(75382495179, 0, \'paulo@teste.io\', 1, 0, \'2032-09-30 15:27:38.0+00\', \'Paulo Ribeiro\', \'paulo@teste.io\', \'Paulo\',\'242424\',\'\',1,\'\',\'242\',\'\',0,\'Paulo Ribeiro\'),\n(82495175381, 1, \'renata@teste.io\', 0, 1, \'2033-10-22 17:28:49.0+00\', \'Renata Souza\', \'renata@teste.io\', \'Renata\',\'252525\',\'\',0,\'\',\'252\',\'\',1,\'Renata Souza\'),\n(35795124682, 0, \'sergio@teste.io\', 1, 0, \'2034-11-13 19:30:00.0+00\', \'Sergio Almeida\', \'sergio@teste.io\', \'Sergio\',\'262626\',\'\',1,\'\',\'262\',\'\',1,\'Sergio Almeida\'),\n(95135746823, 1, \'tatiana@teste.io\', 0, 1, \'2035-12-05 21:31:11.0+00\', \'Tatiana Lima\', \'tatiana@teste.io\', \'Tatiana\',\'272727\',\'\',0,\'\',\'272\',\'\',0,\'Tatiana Lima\'),\n(32131231231, 1, \'rafael.melo@teste.io\', 0, 1, \'2046-11-11 18:00:00.0+00\', \'Rafael Melo\', \'rafael.melo@teste.io\', \'Rafael\',\'383838\',\'\',0,\'\',\'383\',\'\',1,\'Rafael Melo\'),\n(23418293401, 1, \'beatriz.ferreira@teste.io\', 0, 1, \'2048-01-01 20:00:00.0+00\', \'Beatriz Ferreira\', \'beatriz.ferreira@teste.io\', \'Beatriz\',\'404040\',\'\',0,\'\',\'404\',\'\',1,\'Beatriz Ferreira\'),\n(03847261234, 1, \'pedro.alves@teste.io\', 0, 1, \'2050-03-03 22:00:00.0+00\', \'Pedro Alves\', \'pedro.alves@teste.io\', \'Pedro\',\'424242\',\'\',0,\'\',\'424\',\'\',0,\'Pedro Alves\'),\n(76475302132, 1, \'thiago.oliveira@teste.io\', 0, 1, \'2052-05-05 00:00:00.0+00\', \'Thiago Oliveira\', \'thiago.oliveira@teste.io\', \'Thiago\',\'444444\',\'\',0,\'\',\'444\',\'\',1,\'Thiago Oliveira\'),\n(53627849321, 0, \'amanda.moraes@teste.io\', 1, 0, \'2053-06-06 01:00:00.0+00\', \'Amanda Moraes\', \'amanda.moraes@teste.io\', \'Amanda\',\'454545\',\'\',1,\'\',\'454\',\'\',0,\'Amanda Moraes\'),\n(23435332123, 1, \'marcos.santana@teste.io\', 0, 1, \'2054-07-07 02:00:00.0+00\', \'Marcos Santana\', \'marcos.santana@teste.io\', \'Marcos\',\'464646\',\'\',0,\'\',\'464\',\'\',1,\'Marcos Santana\'),\n(65323423412, 0, \'isabella.silva@teste.io\', 1, 0, \'2055-08-08 03:00:00.0+00\', \'Isabella Silva\', \'isabella.silva@teste.io\', \'Isabella\',\'474747\',\'\',1,\'\',\'474\',\'\',0,\'Isabella Silva\'),\n(54332234234, 1, \'fernando.rocha@teste.io\', 0, 1, \'2056-09-09 04:00:00.0+00\', \'Fernando Rocha\', \'fernando.rocha@teste.io\', \'Fernando\',\'484848\',\'\',0,\'\',\'484\',\'\',0,\'Fernando Rocha\'),\n(42398594343, 0, \'julia.santos@teste.io\', 1, 0, \'2057-10-10 05:00:00.0+00\', \'Julia Santos\', \'julia.santos@teste.io\', \'Julia\',\'494949\',\'\',1,\'\',\'494\',\'\',1,\'Julia Santos\'),\n(42354237832, 1, \'guilherme.almeida@teste.io\', 0, 1, \'2058-11-11 06:00:00.0+00\', \'Guilherme Almeida\', \'guilherme.almeida@teste.io\', \'Guilherme\',\'505050\',\'\',0,\'\',\'505\',\'\',1,\'Guilherme Almeida\'),\n(93846374983, 1, \'rodrigo.oliveira@teste.io\', 0, 1, \'2060-01-01 08:00:00.0+00\', \'Rodrigo Oliveira\', \'rodrigo.oliveira@teste.io\', \'Rodrigo\',\'525252\',\'\',0,\'\',\'525\',\'\',1,\'Rodrigo Oliveira\'),\n(48372638432, 0, \'thais.rodrigues@teste.io\', 1, 0, \'2061-02-02 09:00:00.0+00\', \'Thais Rodrigues\', \'thais.rodrigues@teste.io\', \'Thais\',\'535353\',\'\',1,\'\',\'535\',\'\',0,\'Thais Rodrigues\'),\n(53432424233, 1, \'vinicius.souza@teste.io\', 0, 1, \'2062-03-03 10:00:00.0+00\', \'Vinicius Souza\', \'vinicius.souza@teste.io\', \'Vinicius\',\'545454\',\'\',0,\'\',\'545\',\'\',0,\'Vinicius Souza\'),\n(33213123123, 0, \'roberto.souza@teste.io\', 0, 1, \'2062-03-03 10:00:00.0+00\', \'Roberto Souza\', \'roberto.souza@teste.io\', \'Roberto\',\'717171\',\'\',0,\'\',\'563\',\'\',0,\'Roberto Souza\'),\n(32131241213, 0, \'fernanda.rodrigues@teste.io\', 1, 0, \'2061-02-02 09:00:00.0+00\', \'Fernanda Rodrigues\', \'fernanda.rodrigues@teste.io\', \'Fernanda\',\'535353\',\'\',1,\'\',\'535\',\'\',0,\'Fernanda Rodrigues\'),\n(19283648321, 1, \'leandro.lima@teste.io\', 0, 1, \'2035-12-05 21:31:11.0+00\', \'Leandro Lima\', \'leandro.lima@teste.io\', \'Leandro\',\'272727\',\'\',0,\'\',\'272\',\'\',0,\'Leandro Lima\'),\n(85296274125, 0, \'dinho.pereira@teste.io\', 1, 0, \'2026-03-22 03:20:32.0+00\', \'Dinho Pereira\', \'dinho.pinheiro@teste.io\', \'Dinho Pinheiro\',\'321421\',\'\',1,\'\',\'321\',\'\',0,\'Dinho Pereira\'),\n(12937472913, 0, \'nelson.pinheiro@teste.io\', 1, 0, \'2030-07-28 11:25:16.0+00\', \'Nelson Pinheiro\', \'nelson.pinheiro@teste.io\', \'Nelson Pinheiro\',\'282828\',\'\',1,\'\',\'273\',\'\',0,\'Nelson Pinheiro\'),\n(42354237831, 1, \'guilherme.santos@teste.io\', 0, 1, \'2058-11-11 06:00:00.0+00\', \'Guilherme Santos\', \'guilherme.santos@teste.io\', \'Guilherme Santos\',\'505050\',\'\',0,\'\',\'404\',\'\',0,\'Guilherme Santos\'),\n(36914225847, 0, \'roberto.henrique@teste.io\', 1, 0, \'2024-12-29 23:18:10.0+00\', \'Roberto Henrique\', \'roberto.henrique@teste.io\', \'Roberto Henrique\',\'151532\',\'\',1,\'\',\'234\',\'\',0,\'Henrique Gomes\'),\n(65432128765, 1, \'carla.santos@teste.io\', 0, 1, \'2019-05-12 12:34:56.0+00\', \'Carla Santos\', \'carla.santos@teste.io\', \'Carla Santos\',\'111010\',\'\',0,\'\',\'543\',\'\',0,\'Carla Ferreira\'),\n(96371185236, 1, \'karina.souza@teste.io\', 0, 1, \'2027-04-13 05:21:43.0+00\', \'Karina Souza\', \'karina.souza@teste.io\', \'Karina Souza\',\'111100\',\'\',0,\'\',\'555\',\'\',0,\'Karina Souza\'),\n(98712432112, 1, \'ana.almeira@teste.io\', 0, 1, \'2017-01-15 10:23:45.0+00\', \'Ana Almeida\', \'ana.almeida@teste.io\', \'Ana Almeida\',\'222200\',\'\',0,\'\',\'653\',\'\',0,\'Ana Almeida\'),\n(31198765498, 0, \'diego.mateus@teste.io\', 1, 0, \'2020-07-04 18:45:21.0+00\', \'Diego Mateus\', \'diego.mateus@teste.io\', \'Diego Mateus\',\'323232\',\'\',1,\'\',\'321\',\'\',1,\'Diego Mateus\');"));
    cronapi.database.Operations.commitTransaction(Var.valueOf("app"));
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
    Var.valueOf("Dados populados com sucesso!"));
   return Var.VAR_NULL;
   }
 }.call();
}

}

