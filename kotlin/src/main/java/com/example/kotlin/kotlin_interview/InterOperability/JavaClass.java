package com.example.kotlin.kotlin_interview.InterOperability;


import java.util.Date;

public class JavaClass {


    String result = Utils.doSomething();                      //@JvmStatic

    Events event = new Events("MindOrks");              //@JvmOverloads


//    Date date = event.getDate();                            //@JvmField
      Date date = event.date;


}
