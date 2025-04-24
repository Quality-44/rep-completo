window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.components = window.blockly.js.blockly.components || {};
window.blockly.js.blockly.components.Tab = window.blockly.js.blockly.components.Tab || {};

/**
 * @function validateHeader
 *
 *
 *
 *
 * @author Leandro Leonardo Assarice
 * @since 13/06/2024, 14:16:40
 *
 */
window.blockly.js.blockly.components.Tab.validateHeaderArgs = [];
window.blockly.js.blockly.components.Tab.validateHeader = async function() {

  //
  this.cronapi.screen.changeValueOfField("vars.ResultCMP4Value", 'Botão de cabeçalho validado!');
}

/**
 * @function validateFrame
 *
 *
 *
 *
 * @author Leandro Leonardo Assarice
 * @since 13/06/2024, 14:16:40
 *
 */
window.blockly.js.blockly.components.Tab.validateFrameArgs = [];
window.blockly.js.blockly.components.Tab.validateFrame = async function() {

  //
  this.cronapi.screen.notify('success','Check');
}

/**
 * @function generateGraphics
 *
 *
 *
 *
 * @author Leandro Leonardo Assarice
 * @since 13/06/2024, 14:16:40
 *
 */
window.blockly.js.blockly.components.Tab.generateGraphicsArgs = [];
window.blockly.js.blockly.components.Tab.generateGraphics = async function() {

  //
  this.cronapi.chart.createChart("chartCanvas", 'bar', ['Janeiro', 'Fevereiro', 'Março'], null, [this.cronapi.chart.createDataset('Chocolate', ['19050', '19235', '21470'], null), this.cronapi.chart.createDataset('Jujuba', ['18050', '20136', '21536'], null), this.cronapi.chart.createDataset('Bolo', ['11000', '10136', '31536'], null), this.cronapi.chart.createDataset('Pé de moleque', ['20000', '18000', '17000'], null), this.cronapi.chart.createDataset('Paçoca', ['29050', '14235', '11470'], null), this.cronapi.chart.createDataset('Bala', ['17050', '11235', '20470'], null)]);
}
