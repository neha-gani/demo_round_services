package com.interview.service1.command;

public abstract class Command {


   public abstract Command nextStep();

   public abstract CommandResponse process(Object person);

   public abstract String revert();
}
