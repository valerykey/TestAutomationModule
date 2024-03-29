package com.listeners;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlSuite;

public class TestReporter implements IReporter {

    static final Logger logger = LogManager.getLogger("");

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {

        for(ISuite iSuite : suites) {
            //Get a map of result of a single suite at a time

            Map<String, ISuiteResult> results = iSuite.getResults();

            //Get the key of the result map

            Set<String> keys = results.keySet();

            //Go to each map value one by one

            for (String key : keys) {

                //The Context object of current result

                ITestContext context = results.get(key).getTestContext();

                //Print Suite detail in Console

                logSuiteDetails(context);

                logFailedTestsList(context);
            }
        }
    }
    private void logSuiteDetails(ITestContext context){
        //Print Suite detail in Console

        logger.info("Suite Name->" + context.getName()

                + "::Report output Ditectory->" + context.getOutputDirectory()

                + "::Suite Name->" + context.getSuite().getName()

                + "\n     Start Date Time for execution->" + context.getStartDate()

                + "::End Date Time for execution->" + context.getEndDate());
    }

    private void logFailedTestsList(ITestContext context) {
        if(context.getFailedTests().size()>0) {
            Collection<ITestNGMethod> failedMethods = context.getFailedTests().getAllMethods();

            //Loop one by one in all failed methods

            logger.info("--------FAILED TEST CASE---------");

            for (ITestNGMethod iTestNGMethod : failedMethods) {

                //Print failed test cases detail

                logger.info("TESTCASE NAME->" + iTestNGMethod.getMethodName()

                        + "\nDescription->" + iTestNGMethod.getDescription()

                        + "\nPriority->" + iTestNGMethod.getPriority()

                        + "\n:Date->" + new Date(iTestNGMethod.getDate()));

            }
        }
    }
}