/**
 * As alterações neste arquivo podem causar um comportamento incorreto e serão
 * perdidas se a IDE precisar atualizá-lo
 */
package app.jobs;

import cronapi.database.TransactionManager;
import cronapp.framework.scheduler.SchedulerConfigurer;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import cronapi.Var;

/**
 * Tarefa Agendada inserirdados
 *
 * 
 */
@Component
@DisallowConcurrentExecution
public class InserirdadosJob implements Job {

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    try {
      //inserirdados
      blockly.DataBase.populateAllSources();
      TransactionManager.commit();
    } catch (Exception e) {
      TransactionManager.rollback();
      throw new JobExecutionException(e);
    } finally {
      TransactionManager.close();
      TransactionManager.clear();
    }
  }

  @Bean(name = "inserirdadosJobDetail")
  public JobDetailFactoryBean inserirdadosJobDetail() {
    return SchedulerConfigurer.createJobDetail(this.getClass());
  }

  /**
   * teste1
   * A cada segundo, 10 minutos hora depois, somente segunda-feira e sexta-feira
   */
  @Bean(name = "inserirdadosJobTeste1Trigger")
  public CronTriggerFactoryBean inserirdadosJobTeste1Trigger(@Qualifier("inserirdadosJobDetail") JobDetail jobDetail) {

    return SchedulerConfigurer.createCronTrigger(jobDetail, "* 10 * ? * 1,5");
  }
}