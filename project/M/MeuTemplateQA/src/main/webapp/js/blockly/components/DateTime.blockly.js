window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.components = window.blockly.js.blockly.components || {};
window.blockly.js.blockly.components.DateTime = window.blockly.js.blockly.components.DateTime || {};

/**
 * @function calendarProperty
 *
 *
 *
 * @param date
 *
 * @author Leandro Leonardo Assarice
 * @since 01/07/2024, 15:34:43
 *
 */
window.blockly.js.blockly.components.DateTime.calendarPropertyArgs = [{ description: 'date', id: '997ef5dc' }];
window.blockly.js.blockly.components.DateTime.calendarProperty = async function(date) {

  //
  formattedDate = this.cronapi.dateTime.newDate(date.slice(6, date.length), date.slice(3, 5), date.slice(0, 2), 0, 0, 0);
  return formattedDate;
}

/**
 * @function formattedSelectDates
 *
 *
 *
 * @param formatOption
 *
 * @author Leandro Leonardo Assarice
 * @since 01/07/2024, 15:34:43
 *
 */
window.blockly.js.blockly.components.DateTime.formattedSelectDatesArgs = [{ description: 'formatOption', id: 'c5245f65' }];
window.blockly.js.blockly.components.DateTime.formattedSelectDates = async function(formatOption) {

  //
  list = [ { valores : (await this.cronapi.client('cronapi.calendar.getCalendarSelectDates').run("calendar")) } ];
  //
  formattedList = [];
  //
  var date_list = this.cronapi.map.getMapValueByPath(list, 'valores');
  for (var date_index in date_list) {
    date = date_list[date_index];
    //
    formattedList = String(formattedList) + String(this.cronapi.dateTime.formatDateTime(date, String(', ') + String(formatOption)));
  }
  return formattedList.slice(2, formattedList.length);
}

/**
 * @function calendarEvent
 *
 *
 *
 *
 * @author Leandro Leonardo Assarice
 * @since 01/07/2024, 15:34:43
 *
 */
window.blockly.js.blockly.components.DateTime.calendarEventArgs = [];
window.blockly.js.blockly.components.DateTime.calendarEvent = async function() {

  //
  this.cronapi.screen.changeValueOfField("vars.valueCurrentDateCalendar", '');
  //
  (await this.cronapi.client('blockly.js.blockly.components.DateTime.getsCalendar').run('current'));
}

/**
 * @function getsCalendar
 *
 *
 *
 * @param action
 *
 * @author Leandro Leonardo Assarice
 * @since 01/07/2024, 15:34:43
 *
 */
window.blockly.js.blockly.components.DateTime.getsCalendarArgs = [{ description: 'action', id: '152f9edb' }];
window.blockly.js.blockly.components.DateTime.getsCalendar = async function(action) {

  //
  values = [ { current : ["vars.valueCurrentDateCalendar", (await this.cronapi.client('cronapi.calendar.getCalendarValue').run("calendar"))] } , { min : ["vars.valueMinDateCalendar", (await this.cronapi.client('cronapi.calendar.getCalendarMin').run("calendar"))] } , { max : ["vars.valueMaxDateCalendar", (await this.cronapi.client('cronapi.calendar.getCalendarMax').run("calendar"))] } , { dates : ["vars.valueSelectDatesCalendar", (await this.cronapi.client('blockly.js.blockly.components.DateTime.formattedSelectDates').run('DD/MM/YYYY'))] } , { results : ["vars.resultCalendar", (await this.cronapi.client('blockly.js.blockly.components.DateTime.formattedSelectDates').run('YYYY/M/D'))] } ];
  //
  for (var count = 0; count < 2; count++) {
    //
    this.cronapi.screen.changeValueOfField(this.cronapi.map.getMapValueByKey(values, action)[0], this.cronapi.map.getMapValueByKey(values, action).slice(-1)[0]);
    //
    action = 'results';
  }
}

/**
 * @function setsCalendar
 *
 *
 *
 * @param type
 * @param date
 * @param secondDate
 *
 * @author Leandro Leonardo Assarice
 * @since 01/07/2024, 15:34:43
 *
 */
window.blockly.js.blockly.components.DateTime.setsCalendarArgs = [{ description: 'type', id: 'ae4b60b3' }, { description: 'date', id: '2805771c' }, { description: 'secondDate', id: 'f6049db3' }];
window.blockly.js.blockly.components.DateTime.setsCalendar = async function(type, date, secondDate) {

  //
  formattedDate = this.cronapi.dateTime.newDate(this.cronapi.dateTime.getYear(date), this.cronapi.dateTime.getMonth(date), this.cronapi.dateTime.getDay(date), 0, 0, 0);
  //
  formattedSecondDate = this.cronapi.dateTime.newDate(this.cronapi.dateTime.getYear(secondDate), this.cronapi.dateTime.getMonth(secondDate), this.cronapi.dateTime.getDay(secondDate), 0, 0, 0);
  //
  if (type == 'current') {
    //
    (await this.cronapi.client('cronapi.calendar.setCalendarValue').run("calendar", this.cronapi.dateTime.getNow()));
    //
    this.cronapi.screen.changeValueOfField("vars.valueConfigCurrentDateCalendar", (await this.cronapi.client('cronapi.calendar.getCalendarValue').run("calendar")));
  } else if (type == 'max') {
    //
    (await this.cronapi.client('cronapi.calendar.setCalendarMax').run("calendar", formattedDate));
  } else if (type == 'min') {
    //
    (await this.cronapi.client('cronapi.calendar.setCalendarMin').run("calendar", formattedDate));
  } else if (type == 'dates') {
    //
    dates = [formattedDate, formattedSecondDate];
    //
    (await this.cronapi.client('cronapi.calendar.setCalendarSelectDates').run("calendar", dates));
  } else if (type == 'update') {
    //
    (await this.cronapi.client('cronapi.calendar.navigateCalendarTo').run("calendar", formattedDate, 'month'));
  }
}
