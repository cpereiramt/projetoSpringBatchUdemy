package com.claytonpereira.bin;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory; // 1 - Criador do JOB
    @Autowired
    private StepBuilderFactory stepBuilderFactory; // 5 - Criando as etapas
    @Bean
    public Job imprimeOlaJob() {
         return jobBuilderFactory
                 .get("imprimeOlaJob") // 2 - Settando o nome do JOB
                 .start(imprimeOlaStep()) // 3 - declarando as etapas do JOB do tipo Flow
                 .build(); // 4 - Construindo o JOB de fato.

    }

    public Step imprimeOlaStep() {
      return stepBuilderFactory
              .get("imprimeOlaStep") // 6 - Settando nome da Etapa
              .tasklet(new Tasklet() { // 7 -  para tarefas simples usamos a interface tasklet
                  @Override
                  public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                     System.out.println("Olá mundo"); // 8 - implementação da tarefa
                      return RepeatStatus.FINISHED;  // 9 - retorno do Status
                  }
              })
              .build();
    }
}
