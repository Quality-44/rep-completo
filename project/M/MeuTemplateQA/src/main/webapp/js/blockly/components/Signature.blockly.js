window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.components = window.blockly.js.blockly.components || {};
window.blockly.js.blockly.components.Signature = window.blockly.js.blockly.components.Signature || {};

/**
 * @function qrCode
 *
 *
 *
 *
 * @author Leandro Leonardo Assarice
 * @since 01/08/2024, 11:01:02
 *
 */
window.blockly.js.blockly.components.Signature.qrCodeArgs = [];
window.blockly.js.blockly.components.Signature.qrCode = async function() {

  //
  this.cronapi.screen.changeValueOfField("vars.QRcodeValue", 'QRcode validado!');
}

/**
 * @function validateSignature
 *
 *
 *
 *
 * @author Leandro Leonardo Assarice
 * @since 01/08/2024, 11:01:02
 *
 */
window.blockly.js.blockly.components.Signature.validateSignatureArgs = [];
window.blockly.js.blockly.components.Signature.validateSignature = async function() {

  //
  if (this.cronapi.screen.getValueOfField("vars.inputSignatureValue")) {
    //
    this.cronapi.screen.changeAttrValue("result-signature", 'src', String('data:image/png;base64,') + String(this.cronapi.screen.getValueOfField("vars.inputSignatureValue")));
  } else {
    //
    this.cronapi.screen.notify('warning','Por favor, adicione uma assinatura!');
  }
}
