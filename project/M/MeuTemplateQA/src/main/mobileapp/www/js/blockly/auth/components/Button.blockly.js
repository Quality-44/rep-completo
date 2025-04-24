window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.auth = window.blockly.js.blockly.auth || {};
window.blockly.js.blockly.auth.components = window.blockly.js.blockly.auth.components || {};
window.blockly.js.blockly.auth.components.Button = window.blockly.js.blockly.auth.components.Button || {};

/**
 * @function Executar
 *
 *
 *
 * @param value
 *
 * @author Leandro Leonardo Assarice
 * @since 01/08/2024, 09:32:03
 *
 */
window.blockly.js.blockly.auth.components.Button.ExecutarArgs = [{ description: 'value', id: '6e059514' }];
window.blockly.js.blockly.auth.components.Button.Executar = async function(value) {

  //
  this.cronapi.screen.changeValueOfField("vars.btnResponse", value);
}
