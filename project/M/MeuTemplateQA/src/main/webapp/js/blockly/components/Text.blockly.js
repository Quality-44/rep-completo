window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.components = window.blockly.js.blockly.components || {};
window.blockly.js.blockly.components.Text = window.blockly.js.blockly.components.Text || {};

/**
 * @function validateText
 *
 *
 *
 * @param field
 *
 * @author Leandro Leonardo Assarice
 * @since 06/06/2024, 11:26:57
 *
 */
window.blockly.js.blockly.components.Text.validateTextArgs = [{ description: 'field', id: '84bea4bc' }];
window.blockly.js.blockly.components.Text.validateText = async function(field) {

  //
  this.cronapi.screen.changeValueOfField(this.cronapi.conversion.toString("vars.result"), field);
  //
  field = '';
}

/**
 * @function validateMultipleCombobox
 *
 *
 *
 *
 * @author Leandro Leonardo Assarice
 * @since 06/06/2024, 11:26:57
 *
 */
window.blockly.js.blockly.components.Text.validateMultipleComboboxArgs = [];
window.blockly.js.blockly.components.Text.validateMultipleCombobox = async function() {
 var field;
  //
  this.cronapi.screen.changeValueOfField("vars.result", '');
  //
  users = ' ';
  //
  item = '';
  //
  var j_list = this.cronapi.screen.getValueOfField("vars.multipleComboboxValue");
  for (var j_index in j_list) {
    j = j_list[j_index];
    //
    users = (users + item + this.cronapi.json.getProperty(j, 'name'));
    //
    item = ', ';
  }
  //
  this.cronapi.screen.changeValueOfField("vars.result", users);
}
