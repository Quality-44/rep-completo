package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.lang.Math;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class File {

public static final int TIMEOUT = 300;

/**
 *
 * @param date
 *
 * @author Leandro Leonardo Assarice
 * @since 01/08/2024, 11:30:47
 *
 */
public static void addFile(@ParamMetaData(description = "date", id = "aaac475e") Var date) throws Exception {
  new Callable<Var>() {

   private Var info = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    if (
    cronapi.logic.Operations.isNullOrEmpty(date).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("warning"),
        Var.valueOf("Por favor, adicione um arquivo!"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
        Var.valueOf("vars.resultValue"),
        Var.valueOf(""));
    } else {
        info =
        cronapi.json.Operations.toJson(date);
        item =
        Var.valueOf(
        cronapi.io.Operations.fileAppReclycleDir().getObjectAsString() +
        cronapi.io.Operations.fileSeparator().getObjectAsString() +
        cronapi.json.Operations.getJsonOrMapField(info,
        Var.valueOf("path")).getObjectAsString());
        cronapi.database.Operations.insert(Var.valueOf("app.entity.Archive"),Var.valueOf("file",item),Var.valueOf("contentType",
        cronapi.json.Operations.getJsonOrMapField(info,
        Var.valueOf("contentType"))),Var.valueOf("fileExtension",
        cronapi.json.Operations.getJsonOrMapField(info,
        Var.valueOf("fileExtension"))),Var.valueOf("name",
        Var.valueOf(
        cronapi.json.Operations.getJsonOrMapField(info,
        Var.valueOf("name")).getObjectAsString() +
        cronapi.json.Operations.getJsonOrMapField(info,
        Var.valueOf("fileExtension")).getObjectAsString())));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
        Var.valueOf("vars.resultValue"),
        Var.valueOf(
        cronapi.json.Operations.getJsonOrMapField(info,
        Var.valueOf("name")).getObjectAsString() +
        cronapi.json.Operations.getJsonOrMapField(info,
        Var.valueOf("fileExtension")).getObjectAsString()));
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
        Var.valueOf("Arquivo adicionado com sucesso!"));
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param Image
 *
 * @author Leandro Leonardo Assarice
 * @since 01/08/2024, 11:30:47
 *
 */
public static void addImage(@ParamMetaData(description = "Image", id = "5f8ad2d9") Var Image) throws Exception {
  new Callable<Var>() {

   private Var imageName = Var.VAR_NULL;

   public Var call() throws Exception {
    if (
    cronapi.logic.Operations.isNullOrEmpty(Image).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("warning"),
        Var.valueOf("Por favor, adicione uma imagem!"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
        Var.valueOf("vars.resultValue"),
        Var.valueOf(""));
    } else {
        imageName =
        Var.valueOf(
        Var.valueOf("Image_").getObjectAsString() +
        cronapi.math.Operations.randomInt(
        Var.valueOf(1),
        Var.valueOf(500)).getObjectAsString());
        cronapi.database.Operations.insert(Var.valueOf("app.entity.Image"),Var.valueOf("name",imageName),Var.valueOf("image",Image));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeAttrValue"),
        Var.valueOf("image"),
        Var.valueOf("src"),
        Var.valueOf(
        Var.valueOf("data:image/png;base64,").getObjectAsString() +
        cronapi.screen.Operations.getValueOfField(
        Var.valueOf("Image.active.image")).getObjectAsString()));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
        Var.valueOf("vars.resultValue"), imageName);
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
        Var.valueOf("Imagem adicionada com sucesso!"));
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author Leandro Leonardo Assarice
 * @since 01/08/2024, 11:30:47
 *
 */
public static void serverValidateBlock() throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("vars.resultValue"),
    Var.valueOf("Bloco servidor validado!"));
   return Var.VAR_NULL;
   }
 }.call();
}

}

