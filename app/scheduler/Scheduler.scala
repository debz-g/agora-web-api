package scheduler

import org.quartz.CronScheduleBuilder._
import org.quartz.JobBuilder.newJob
import org.quartz.TriggerBuilder._
import org.quartz.impl.StdSchedulerFactory

object Scheduler {
  val scheduler = StdSchedulerFactory.getDefaultScheduler()

  def CountVotesDaily() {
    val job = newJob(classOf[CountVotes]).build()
    val trigger = newTrigger().withSchedule(cronSchedule("0/10 * * * * ?")).build()
    scheduler.scheduleJob(job, trigger)
  }
}
