# KotlinArchitectureDemonstration
Kotlin architecture demo

This project aims to provide a sample that integrate the following of the techniques together and create a extensible Kotlin application for Android.
1. Dagger2
2. MVP
3. RxKotlin
4. Unit/UI test
5. Modularizing app

There is a lot of tutorials outside that teach you the skills separately. However, those tutorials seldom talk about the integration. But in real life, the projects require some of techniques, not just one, and integration becomes a part of issue.

Point 1-4 are basically some of famous techniques. There is a lot of aritcles to show you how can developer can benefit from them. Only point 5 need to explain.

The library/app is construct with 3 parts 
1. Library aims to provide features/journeys for the app
2. Contract aims to provide models, configuration and feature interface for abstraction from library (What should be exposed to host app)
3. Sample aims to show how to merge the library into host app. And it should also provides the demonstration of the features/journeys for the host app

To integrate the projects as a part of library, the files in the sample app are required to clone into the host app. Also, the methods in the sample app is already demostrate the usage of the library in the host app. User may just integrate them into a proper place

### Pros
Using this structure, developer can create a entensible, reusable and quality application. Changing data source, like endpoints, will be easy. 

This structure is also suitable for large scale team and large scale appliaction

### Cons
This structure will largely increase the development time and effort. 

Although Dagger2 provides inversion of control, it creates a lot of boilerplates. And the developers require to decouple the code to meet the MVP. Those efforts will increase the development time by 1-2 times

Unit test and UI test are used to ensure the quality of application. However, in real life, the requirements are changed frequently and your tests are also changed frequently. Also, the tests are complicated and fancy that require some time to develop. Those efforts will increase the development time by 2-3 times

In a fast changing mobile applicatoin world, only a few app can stay for 3 years. And after that, many of them will be either dead or revamped, only a few will stay. That makes it not so meaningful to small scale app 
