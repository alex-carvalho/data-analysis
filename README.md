# Data Analysis
[![Build Status](https://travis-ci.org/alex-carvalho/data-analysis.svg?branch=master)](https://travis-ci.org/alex-carvalho/data-analysis)
[![codecov](https://codecov.io/gh/alex-carvalho/data-analysis/branch/master/graph/badge.svg)](https://codecov.io/gh/alex-carvalho/data-analysis)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=br.com.ac:data-analysis&metric=alert_status)](https://sonarcloud.io/dashboard/index/br.com.ac:data-analysis)

Spring boot app read and process file data.

Run at default interval of 10 seconds using Quartz Schedule, can be customized when to run app.

## Build
```
graldew build
```

## Test
```
graldew test
```
- JaCoCo Code Coverage report
```
gradlew jacocoTestReport

# output ${buildDir}/jacocoHtml/index.html
```

## Run
After executed build can execute the jar file in ${build}/libs/(app).jar

Properties can be passed how parameter on start app using -D
```
app.job.interval=10 #seconds
app.data.directory.in=${user.home}/data/in
app.data.directory.out=${user.home}/data/out
``` 
