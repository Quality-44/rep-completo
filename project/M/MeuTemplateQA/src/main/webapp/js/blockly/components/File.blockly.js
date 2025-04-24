window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.components = window.blockly.js.blockly.components || {};
window.blockly.js.blockly.components.File = window.blockly.js.blockly.components.File || {};

/**
 * @function webValidateBlock
 *
 *
 *
 *
 * @author Leandro Leonardo Assarice
 * @since 11/06/2024, 10:04:02
 *
 */
window.blockly.js.blockly.components.File.webValidateBlockArgs = [];
window.blockly.js.blockly.components.File.webValidateBlock = async function() {

  //
  (await this.cronapi.client('blockly.js.blockly.components.File.validate').run('Bloco web validado!'));
}

/**
 * @function validateCheckImg
 *
 *
 *
 * @param date
 *
 * @author Leandro Leonardo Assarice
 * @since 11/06/2024, 10:04:02
 *
 */
window.blockly.js.blockly.components.File.validateCheckImgArgs = [{ description: 'date', id: 'e112f887' }];
window.blockly.js.blockly.components.File.validateCheckImg = async function(date) {

  //
  (await this.cronapi.client('blockly.js.blockly.components.File.validate').run(this.cronapi.json.getProperty(this.cronapi.json.createObjectFromString(date), 'contentType')));
}

/**
 * @function validateCheckBox
 *
 *
 *
 * @param option
 *
 * @author Leandro Leonardo Assarice
 * @since 11/06/2024, 10:04:02
 *
 */
window.blockly.js.blockly.components.File.validateCheckBoxArgs = [{ description: 'option', id: '9a9a3128' }];
window.blockly.js.blockly.components.File.validateCheckBox = async function(option) {

  //
  (await this.cronapi.client('blockly.js.blockly.components.File.validate').run(date));
}

/**
 * @function validate
 *
 *
 *
 * @param date
 *
 * @author Leandro Leonardo Assarice
 * @since 11/06/2024, 10:04:02
 *
 */
window.blockly.js.blockly.components.File.validateArgs = [{ description: 'date', id: 'e112f887' }];
window.blockly.js.blockly.components.File.validate = async function(date) {

  //
  this.cronapi.screen.changeValueOfField("vars.resultValue", date);
}
